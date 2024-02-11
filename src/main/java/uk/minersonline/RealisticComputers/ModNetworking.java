package uk.minersonline.RealisticComputers;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import uk.minersonline.RealisticComputers.utils.KeyUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class ModNetworking {
	public static Map<ServerPlayerEntity, BlockPos> openScreens = new HashMap<>();
	public static Map<ServerPlayerEntity, VNCSession> openSessions = new HashMap<>();
	public static final Identifier VNC_SCREEN_OPEN = new Identifier(MOD_ID, "vnc_screen_open");
	public static final Identifier VNC_SCREEN_CLOSE = new Identifier(MOD_ID, "vnc_screen_close");
	public static final Identifier VNC_SCREEN_DATA = new Identifier(MOD_ID, "vnc_screen_data");
	public static final Identifier VNC_MOUSE_MOVE = new Identifier(MOD_ID, "vnc_mouse_move");
	public static final Identifier VNC_MOUSE_CLICK = new Identifier(MOD_ID, "vnc_mouse_click");
	public static final Identifier VNC_KEY = new Identifier(MOD_ID, "vnc_key");

	public static void serverInit() {
		ServerPlayNetworking.registerGlobalReceiver(VNC_SCREEN_CLOSE, (server, player, handler, buf, responseSender) -> {
			VNCSession session = openSessions.get(player);
			session.end();
			try {
				session.join();
			} catch (InterruptedException e) {
				RealisticComputers.LOGGER.error("An error occurred whilst closing VNC session.", e);
			}
			openSessions.put(player, null);

			BlockPos terminalPosition = buf.readBlockPos();
			openScreens.put(player, null);
			RealisticComputers.LOGGER.info(player.getDisplayName().getString() + " has closed the vnc terminal at " + terminalPosition);
		});

		ServerPlayNetworking.registerGlobalReceiver(VNC_MOUSE_MOVE, (server, player, handler, buf, responseSender) -> {
			VNCSession session = openSessions.get(player);
			if (session != null) {
				int x = buf.readInt();
				int y = buf.readInt();
				session.sendMousePos(x, y);
			}
		});

		ServerPlayNetworking.registerGlobalReceiver(VNC_MOUSE_CLICK, (server, player, handler, buf, responseSender) -> {
			VNCSession session = openSessions.get(player);
			if (session != null) {
				int x = buf.readInt();
				int y = buf.readInt();
				int btn = buf.readInt();
				boolean pressed = buf.readBoolean();
				session.sendMouseClick(x, y, btn, pressed);
			}
		});

		ServerPlayNetworking.registerGlobalReceiver(VNC_KEY, (server, player, handler, buf, responseSender) -> {
			VNCSession session = openSessions.get(player);
			if (session != null) {
				int key = buf.readInt();
				int glfwModifiers = buf.readInt();
				boolean pressed = buf.readBoolean();

				KeyEvent keyPressEvent;
				boolean isChar = KeyUtils.isCharacterKey(key);
				int modifiers = KeyUtils.getModifiers(glfwModifiers);
				char type = KeyEvent.CHAR_UNDEFINED;
				if (isChar) {
					type = KeyUtils.getCharacterFromKeyCode(key, (glfwModifiers & GLFW.GLFW_MOD_SHIFT) != 0);
				}
				Component source = new Component() {};
				if (pressed) {
					keyPressEvent = new KeyEvent(
							source,
							KeyEvent.KEY_PRESSED,
							System.currentTimeMillis(),
							modifiers,
							KeyUtils.convertKey(key),
							type
					);
				} else {
					keyPressEvent = new KeyEvent(
							source,
							KeyEvent.KEY_RELEASED,
							System.currentTimeMillis(),
							modifiers,
							KeyUtils.convertKey(key),
							type
					);
				}
				session.handleKey(keyPressEvent);
			}
		});
	}
}

package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.ColorHelper;
import uk.minersonline.RealisticComputers.ModNetworking;


public class VNCScreenWidget extends WWidget {
	private Texture image = null;

	@Override
	public void paint(DrawContext context, int x, int y, int mouseX, int mouseY) {
		int color = ColorHelper.Argb.getArgb(255, 0, 0, 0);
		if (image != null) {
			ScreenDrawing.texturedRect(context, x, y, getWidth(), getHeight(), image, 0xFFFFFFFF);
		} else {
			ScreenDrawing.coloredRect(context, x, y, width, height, color);
		}
	}

	@Override
	public boolean canResize() {
		return true;
	}

	@Override
	public boolean canFocus() {
		return true;
	}

	public void setImage(Texture image) {
		if (this.image != null) {
			MinecraftClient.getInstance().getTextureManager().destroyTexture(this.image.image());
		}
		this.image = image;
	}

	@Override
	public InputResult onKeyPressed(int ch, int key, int modifiers) {
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(ch);
		buf.writeInt(modifiers);
		buf.writeBoolean(true);
		ClientPlayNetworking.send(ModNetworking.VNC_KEY, buf);
		return super.onKeyPressed(ch, key, modifiers);
	}

	@Override
	public InputResult onKeyReleased(int ch, int key, int modifiers) {
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(ch);
		buf.writeInt(modifiers);
		buf.writeBoolean(false);
		ClientPlayNetworking.send(ModNetworking.VNC_KEY, buf);
		return super.onKeyReleased(ch, key, modifiers);
	}

	@Override
	public InputResult onMouseMove(int x, int y) {
		requestFocus();
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(x);
		buf.writeInt(y);
		ClientPlayNetworking.send(ModNetworking.VNC_MOUSE_MOVE, buf);
		return super.onMouseMove(x, y);
	}

	@Override
	public InputResult onMouseUp(int x, int y, int button) {
		requestFocus();
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(x);
		buf.writeInt(y);
		if (button == 0) {
			buf.writeInt(1);
		} else if (button == 1) {
			buf.writeInt(3);
		} else {
			buf.writeInt(2);
		}
		buf.writeBoolean(false);
		ClientPlayNetworking.send(ModNetworking.VNC_MOUSE_MOVE, buf);
		return super.onMouseUp(x, y, button);
	}

	@Override
	public InputResult onMouseDown(int x, int y, int button) {
		requestFocus();
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(x);
		buf.writeInt(y);
		if (button == 0) {
			buf.writeInt(1);
		} else if (button == 1) {
			buf.writeInt(3);
		} else {
			buf.writeInt(2);
		}
		buf.writeBoolean(true);
		ClientPlayNetworking.send(ModNetworking.VNC_MOUSE_MOVE, buf);
		return super.onMouseDown(x, y, button);
	}
}

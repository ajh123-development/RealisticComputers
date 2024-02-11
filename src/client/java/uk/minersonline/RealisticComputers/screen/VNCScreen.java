package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import uk.minersonline.RealisticComputers.ModNetworking;

public class VNCScreen extends CottonClientScreen {
	private final Screen parent;
	private final BlockPos terminalPosition;


	public VNCScreen(Screen parent, BlockPos terminalPosition) {
		super(new VNCScreenLayout());
		this.parent = parent;
		this.terminalPosition = terminalPosition;
	}

	@Override
	public void close() {
		if (this.client != null) {
			this.client.setScreen(this.parent);
			PacketByteBuf buf = PacketByteBufs.create();
			buf.writeBlockPos(this.terminalPosition);
			ClientPlayNetworking.send(ModNetworking.VNC_SCREEN_CLOSE, buf);
		}
	}

	@Override
	public VNCScreenLayout getDescription() {
		return (VNCScreenLayout) this.description;
	}
}
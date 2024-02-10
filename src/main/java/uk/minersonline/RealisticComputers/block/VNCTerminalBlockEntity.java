package uk.minersonline.RealisticComputers.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import uk.minersonline.RealisticComputers.ModBlocks;

public class VNCTerminalBlockEntity extends BlockEntity {
	public VNCTerminalBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlocks.VNC_TERMINAL_BLOCK_ENTITY, pos, state);
	}
}

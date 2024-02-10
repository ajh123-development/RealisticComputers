package uk.minersonline.RealisticComputers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import uk.minersonline.RealisticComputers.block.VNCTerminal;
import uk.minersonline.RealisticComputers.block.VNCTerminalBlockEntity;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class ModBlocks {
	public static final Block VNC_TERMINAL = new VNCTerminal(FabricBlockSettings.create().strength(4.0f).nonOpaque());
	public static final BlockItem VNC_TERMINAL_ITEM = new BlockItem(VNC_TERMINAL, new FabricItemSettings());

	public static final BlockEntityType<VNCTerminalBlockEntity> VNC_TERMINAL_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(MOD_ID, "vnc_terminal"),
			FabricBlockEntityTypeBuilder.create(VNCTerminalBlockEntity::new, VNC_TERMINAL).build()
	);

	public static void init() {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "vnc_terminal"), VNC_TERMINAL);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "vnc_terminal"), VNC_TERMINAL_ITEM);
	}
}

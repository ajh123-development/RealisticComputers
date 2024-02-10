package uk.minersonline.RealisticComputers;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealisticComputers implements ModInitializer {
	public static final String MOD_ID = "realistic_computers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModBlocks.VNC_TERMINAL_ITEM))
			.displayName(Text.translatable(MOD_ID+".main_group"))
			.entries((context, entries) -> {
				entries.add(ModBlocks.VNC_TERMINAL_ITEM);
			})
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModBlocks.init();
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "main_group"), ITEM_GROUP);
	}
}
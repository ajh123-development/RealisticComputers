package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class VNCScreen extends LightweightGuiDescription {
	public VNCScreen(Screen parent, BlockPos terminalPosition) {
		WGridPanel root = new WGridPanel();
		setRootPanel(root);
		root.setSize(256, 176);
		root.setInsets(Insets.ROOT_PANEL);

		WImageWidget image = new WImageWidget();
		root.add(image, 0, 0, 16, 12);

		root.validate(this);
	}
}

package uk.minersonline.RealisticComputers.screen;

import com.shinyhut.vernacular.client.VernacularClient;
import com.shinyhut.vernacular.client.VernacularConfig;
import com.shinyhut.vernacular.client.rendering.ColorDepth;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VNCScreen extends LightweightGuiDescription {
	private final VernacularConfig config = new VernacularConfig();
	private final VernacularClient client = new VernacularClient(config);

	public VNCScreen(Screen parent, BlockPos terminalPosition) {
		WGridPanel root = new WGridPanel();
		setRootPanel(root);
		root.setSize(272, 176);
		root.setInsets(Insets.ROOT_PANEL);

		WImageWidget image = new WImageWidget();
		root.add(image, 0, 0, 18, 12);

		root.validate(this);

		config.setColorDepth(ColorDepth.BPP_24_TRUE);
		config.setEnableCopyrectEncoding(true);

		config.setScreenUpdateListener(image::setImage);

		client.start("10.0.0.97", 5900);
	}
}

package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

public class VNCScreenLayout extends LightweightGuiDescription {
	private final WImageWidget image;

	public VNCScreenLayout() {
		WGridPanel root = new WGridPanel();
		setRootPanel(root);
		root.setSize(288, 176);
		root.setInsets(Insets.ROOT_PANEL);

		image = new WImageWidget();
		root.add(image, 0, 0, 19, 12);

		root.validate(this);
	}

	public WImageWidget getImage() {
		return image;
	}
}

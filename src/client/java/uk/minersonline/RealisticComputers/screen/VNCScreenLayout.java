package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

public class VNCScreenLayout extends LightweightGuiDescription {
	private final VNCScreenWidget screenWidget;

	public VNCScreenLayout() {
		WGridPanel root = new WGridPanel();
		setRootPanel(root);
		root.setSize(288, 176);
		root.setInsets(Insets.ROOT_PANEL);

		screenWidget = new VNCScreenWidget();
		root.add(screenWidget, 0, 0, 19, 12);

		root.validate(this);
	}

	public VNCScreenWidget getImage() {
		return screenWidget;
	}
}

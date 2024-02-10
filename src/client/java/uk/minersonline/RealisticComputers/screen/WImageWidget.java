package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.ColorHelper;

public class WImageWidget extends WWidget {
	@Override
	public void paint(DrawContext context, int x, int y, int mouseX, int mouseY) {
		int color = ColorHelper.Argb.getArgb(255, 0, 0, 0);
		ScreenDrawing.coloredRect(context, x, y, width, height, color);
	}

	@Override
	public boolean canResize() {
		return true;
	}
}

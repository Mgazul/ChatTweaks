package net.blay09.mods.chattweaks.gui.widget;

import net.blay09.mods.chattweaks.gui.FormattedFontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.text.TextFormatting;

public class FormattedTextFieldWidget extends TextFieldWidget {

	protected final FormattedFontRenderer fontRenderer;
	private String displayTextWhenEmpty = "";
	private String emptyText = "";

	public FormattedTextFieldWidget(FormattedFontRenderer fontRenderer, int x, int y, int width, int height) {
		super(fontRenderer, x, y, width, height);
		this.fontRenderer = fontRenderer;
		setMaxStringLength(Integer.MAX_VALUE);
	}

	public void setDisplayTextWhenEmpty(String displayTextWhenEmpty) {
		this.displayTextWhenEmpty = displayTextWhenEmpty;
	}

	public void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
	}

	@Override
	public void drawTextBox() {
		if (!getVisible()) {
			return;
		}

		boolean isEmpty = getText().isEmpty() || getText().equals(emptyText);
		if(!isFocused() && isEmpty) {
			fontRenderer.setVisible(false);
		} else {
			fontRenderer.setVisible(true);
		}

		super.drawTextBox();

		if (!isFocused() && isEmpty) {
			fontRenderer.getBaseFontRenderer().drawStringWithShadow(TextFormatting.GRAY + displayTextWhenEmpty, x + 4, y + (height - 8) / 2f, 0xE0E0E0);
		}
	}

}

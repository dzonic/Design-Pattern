package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class AreaShape extends Shape{
	private Color clrInnerColor = Color.WHITE;
	
	public abstract void fill(Graphics g);

	public Color getClrInnerColor() {
		return clrInnerColor;
	}

	public void setClrInnerColor(Color clrInnerColor) {
		this.clrInnerColor = clrInnerColor;
    }

}

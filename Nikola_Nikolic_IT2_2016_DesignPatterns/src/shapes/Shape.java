package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable, Comparable{
	private String strColor = "black";
	private Color borderColor = Color.BLACK; 
	private boolean selected;
	
	public Shape() {
		
	}
	public Shape(String color){
		this.strColor = color;
	}
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	
	public static String toHexString(Color color)
	{
		return "#"+Integer.toHexString(color.getRGB()).substring(2);
	}
	
	public String getColor() {
		return strColor;
	}

	public void setColor(String color) {
		this.strColor = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	
}


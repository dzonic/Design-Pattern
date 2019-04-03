package hexagon;

import java.awt.Color;
import java.awt.Graphics;

import shapes.AreaShape;
import shapes.Moveable;
import shapes.Shape;

public class HexagonAdapter extends AreaShape implements Moveable, Cloneable {

	private Hexagon hexagon;

	public HexagonAdapter() {

	}

	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	public HexagonAdapter(Hexagon hexagon, Color color) {
		this(hexagon);
		setBorderColor(color);
	}

	public HexagonAdapter(Hexagon hexagon, Color borderColor, Color innerColor) {
		this(hexagon, borderColor);
		setClrInnerColor(innerColor);
	}

	public HexagonAdapter(int x, int y, int r, Color borderColor, Color innerColor) {
		hexagon = new Hexagon(x, y, r);
		hexagon.setAreaColor(innerColor);
		hexagon.setBorderColor(borderColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon helper = ((HexagonAdapter) obj).getHexagon();
			return hexagon.getX() == helper.getX() && hexagon.getY() == helper.getY()
					&& hexagon.getR() == helper.getR();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Hexagon: (" + this.hexagon.getX() + "," + this.hexagon.getY() + "); radius: " + hexagon.getR()
				+ "; border color: " + toHexString(getBorderColor()) + "; inner color: "
				+ toHexString(getClrInnerColor());
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

	@Override
	public void selected(Graphics g) {

	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);

	}

	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
		super.setSelected(selected);
	}

	@Override
	public void moveBy(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	@Override
	public void setClrInnerColor(Color innerColor) {
		hexagon.setAreaColor(innerColor);
		super.setClrInnerColor(innerColor);
	}

	@Override
	public Color getClrInnerColor() {
		return hexagon.getAreaColor();
	}

	@Override
	public void setBorderColor(Color color) {
		hexagon.setBorderColor(color);
		super.setBorderColor(color);
	}

	@Override
	public Color getBorderColor() {
		return hexagon.getBorderColor();
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof HexagonAdapter) {
			return hexagon.getR() - ((HexagonAdapter) o).getHexagon().getR(); 
		}
		return 0;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	@Override
	public void fill(Graphics g) {

	}

	public HexagonAdapter clone() {
		HexagonAdapter h = new HexagonAdapter(new Hexagon(hexagon.getX(), hexagon.getY(), hexagon.getR()),
				getBorderColor(), getClrInnerColor());

		h.setSelected(isSelected());

		return h;

	}

}

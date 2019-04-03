package square;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import shapes.AreaShape;
import shapes.Moveable;
import line.Line;
import point.Point;

public class Square extends AreaShape implements Moveable, Serializable{
	protected Point upperLeft;
	protected int sideLength;
	

	public Square() {

	}

	public Square(Point upperLeft, int sideLength) {
		this.upperLeft = upperLeft;
		this.sideLength = sideLength;
	}

	public Square(Point upperLeft, int sideLength, String color) {
		this(upperLeft, sideLength);
		setColor(color);
	}
	public Square(Point upperLeft, int sideLength, Color borderColor, Color clrInnerColor) {
		this(upperLeft, sideLength);
		setBorderColor(borderColor);
		setClrInnerColor(clrInnerColor);
	}
	public Line diagonal(){
		return new Line(upperLeft, new Point(upperLeft.getX() + sideLength,upperLeft.getY() + sideLength));
	}

	public Point center(){
		return diagonal().midpoint();
	}
	public String toString() {
		return "Square: (" + this.upperLeft.getX() + "," + this.upperLeft.getY() + "); lengthSide: " + this.sideLength + "; border color: " +   toHexString(getBorderColor()) + "; inner color: " +   toHexString(getClrInnerColor());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square helper = (Square) obj;
			if (this.upperLeft.equals(helper.upperLeft) && this.sideLength == helper.sideLength)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public void moveTo(int x, int y) {
		upperLeft.setX(x);
		upperLeft.setY(y);
	}

	public void moveBy(int x, int y) {
		upperLeft.setX(upperLeft.getX() + x);
		upperLeft.setY(upperLeft.getY() + y);
	}

	public int perimeter() {
		return 4*sideLength;
	}

	public int area() {
		return sideLength * sideLength;
	}
	public boolean contains(int x, int y) {
		if(this.getUpperLeft().getX()<=x 
				&& x<=(this.getUpperLeft().getX() + sideLength)
				&& this.getUpperLeft().getY()<=y 
				&& y<=(this.getUpperLeft().getY() + sideLength))
			return true;
		else 
			return false;
	}
	public void selected(Graphics g) {
		
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX()+sideLength, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY()+sideLength)).selected(g);
		new Line(new Point(getUpperLeft().getX()+sideLength, getUpperLeft().getY()), diagonal().getpEnd()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY()+sideLength), diagonal().getpEnd()).selected(g);

	}
	public void draw(Graphics g){
		g.setColor(getBorderColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), sideLength, sideLength);
		this.fill(g);
		if(isSelected()) selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getClrInnerColor());
		g.fillRect(upperLeft.getX()+1, upperLeft.getY()+1, sideLength-1, sideLength-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Square){
			Square helper  = (Square) o;
			return this.area() - helper.area();
		}
		else 
			return 0;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public Square clone()
	{
		Square s = new Square(upperLeft.clone(),getSideLength(),getBorderColor(),getClrInnerColor());
		return s;
	}

}


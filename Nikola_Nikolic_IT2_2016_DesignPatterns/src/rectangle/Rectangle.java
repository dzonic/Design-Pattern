package rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import line.Line;
import point.Point;
import square.Square;

public class Rectangle extends Square implements Serializable{
	
	private int width;

	public Rectangle(){

	}
	public Rectangle(Point upperLeft, int height, int width){
		super(upperLeft, height);
		this.width = width;
	}
	public Rectangle(Point upperLeft, int height, int width, String color){
		this(upperLeft, height, width);
		setColor(color);
	}
	
	public Rectangle(Point upperLeft, int height, int width, Color borderColor, Color clrInnerColor){
		this(upperLeft, height, width);
		setBorderColor(borderColor);
		setClrInnerColor(clrInnerColor);
	}
	
	public Line diagonal(){
		return new Line(upperLeft, new Point(upperLeft.getX() + getSideLength(),upperLeft.getY() + width));
	}
	public Point center(){
		return diagonal().midpoint();
	}
	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle helper=(Rectangle) obj;
			if(this.upperLeft.equals(helper.upperLeft) && this.width==helper.width && this.getSideLength()==helper.getSideLength())
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public String toString()
	{
		return "Rectangle: (" + this.upperLeft.getX() + "," + this.upperLeft.getY() + "); width: " + this.sideLength + "; height: " + this.width + "; border color: " +   toHexString(getBorderColor()) + "; inner color: " +   toHexString(getClrInnerColor());
	}

	public int perimeter(){
		return 2 * (width + getSideLength());
	}
	public int area(){
		return width * getSideLength();
	}
	public boolean contains(int x, int y) {
		if(this.getUpperLeft().getX()<=x 
				&& x<=(this.getUpperLeft().getX() + width)
				&& this.getUpperLeft().getY()<=y 
				&& y<=(this.getUpperLeft().getY() + sideLength))
			return true;
		else 
			return false;
	}
	public void selected(Graphics g) {
		
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX()+getSideLength(), getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY()+width)).selected(g);
		new Line(new Point(getUpperLeft().getX()+getSideLength(), getUpperLeft().getY()), diagonal().getpEnd()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY()+width), diagonal().getpEnd()).selected(g);
	}
	public void draw(Graphics g){
		g.setColor(getBorderColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), getSideLength(), width);
		this.fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getClrInnerColor());
		g.fillRect(upperLeft.getX()+1, upperLeft.getY()+1, getSideLength()-1,  width-1);
		
	}

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public Rectangle clone()
	{
		Rectangle r = new Rectangle(upperLeft.clone(),getSideLength(),width,getBorderColor(),getClrInnerColor());
		r.setSelected(isSelected());
		return r;
	}

}

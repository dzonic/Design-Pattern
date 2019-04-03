package point;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import shapes.Moveable;
import shapes.Shape;

public class Point extends Shape implements Moveable,Cloneable, Serializable{
	private int x;
	private int y;


	public Point()
	{

	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	
	public Point(int x, int y, Color color)
	{
		this(x,y);
		setBorderColor(color);
	}

	public String toString()
	{
		return "Point: (" + this.x + "," + this.y + "); color: "  + toHexString(getBorderColor());			
	}


	public boolean equals(Object obj)
	{
		if(obj instanceof Point){
			Point helper=(Point)obj;
			if(this.x==helper.getX() && this.y==helper.getY())
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public void moveTo(int newX, int newY)
	{
		setX(newX);
		setY(newY);
	}
	
	public void moveBy(int newX, int newY)
	{
		x += newX;
		y += newY;
	}
	public double distance(Point t2)
	{
		double dx = x - t2.getX();
		double dy = y - t2.y;
		return Math.sqrt(dx*dx + dy*dy);
		
	}
	public boolean contains(int x, int y)
	{
		
		if(new Point(x, y).distance(this)<=2)
			return true;
		else
			return false;
	}
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}
	public void draw(Graphics g)
	{
		g.setColor(getBorderColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected()) 
			selected(g);
	}
	
	public int compareTo(Object o)
	{
		Point zero= new Point(0,0);
		Point other  = (Point) o;
		return (int) (this.distance(zero) - other.distance(zero));
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public Point clone()
	{
		Point p = new Point(x,y,getBorderColor());
		
		p.setSelected(isSelected());
		
		return p;
	}
}

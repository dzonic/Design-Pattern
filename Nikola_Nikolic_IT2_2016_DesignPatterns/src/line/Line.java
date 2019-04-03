package line;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import shapes.Shape;
import point.Point;

public class Line extends Shape implements Serializable,Cloneable{
	private Point pStart;
	private Point pEnd;


	public Line()
	{

	}
	public Line(Point pStart, Point pEnd)
	{
		this.pStart = pStart;
		this.pEnd = pEnd;
	}
	public Line(Point pStart, Point pEnd,String color)
	{
	
		this(pStart, pEnd);
		setColor(color);

	}
	
	public Line(Point pStart, Point pEnd,Color color)
	{
	
		this(pStart, pEnd);
		setBorderColor(color);

	}
	
	public Point midpoint()
	{
		
		return new Point((pStart.getX() + pEnd.getX()) / 2, (pStart.getY() + pEnd.getY()) / 2);
	}
	
	public String toString(){
		return "Line: (" + this.pStart.getX() + "," + this.pStart.getY() + "); ("  + this.pEnd.getX() + "," + this.pEnd.getY() + "); color: "   + toHexString(getBorderColor());
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof Line){
			Line helper=(Line)obj;
			if(this.pStart.equals(helper.pStart) && this.pEnd.equals(helper.pEnd))
				return true;
			else
				return false;
		}
		else
			return false;
	}


	public double length()
	{
		return pStart.distance(pEnd);
	}


	public boolean contains(int x, int y)
	{
		Point clickPoint = new Point(x, y);
		if(clickPoint.distance(pStart)+clickPoint.distance(pEnd)-this.length()<=0.5)
			return true;
		 else 
			return false;		
	}
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		pStart.selected(g);
		pEnd.selected(g);
		midpoint().selected(g);
	}
	public void draw(Graphics g)
	{
		g.setColor(getBorderColor());
		g.drawLine(pStart.getX(), pStart.getY(), pEnd.getX(), pEnd.getY());
		if(isSelected())
			selected(g);
	}
	public void moveBy(int x, int y){
		pStart.setX(pStart.getX()+x);
		pStart.setY(pStart.getY()+y);
		pEnd.setX(pEnd.getX()+x);
		pEnd.setY(pEnd.getY()+y);
	}

	public int compareTo(Object o)
	{
		if(o instanceof Line){
			Line helper = (Line) o;
			return (int)this.length() - (int)helper.length();
		}
		else
			return 0;
	}
	public Point getpStart() {
		return pStart;
	}
	public void setpStart(Point pStart) {
		this.pStart = pStart;
	}
	public Point getpEnd() {
		return pEnd;
	}
	public void setpEnd(Point pEnd) {
		this.pEnd = pEnd;
	}
    public Line clone()
    {
    	Line l = new Line(pStart.clone(),pEnd.clone(),getBorderColor());
    	
    	l.setSelected(isSelected());
    	
    	return l;
    }
}

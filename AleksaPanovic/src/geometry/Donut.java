package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	
private int innerRadius;
	
	
	public Donut() {
		super(); 
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius); 
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius,  boolean selected) {
		this(center, radius, innerRadius);
		this.setSelected(selected);
		
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) { 
		this(center, radius, innerRadius, selected);
		setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) { 
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}
	public int getInnerRadius() {
		return this.innerRadius;
	}
	
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area() {
		return super.area() - Math.PI*this.innerRadius*this.innerRadius;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut d = (Donut)obj;
			if(super.equals(d) && this.innerRadius == d.innerRadius) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + ", innerRadius = "+ this.innerRadius;
	}
	
	public boolean contains(int x, int y) {
		double d = this.getCenter().distance(x, y);
		if (d > this.innerRadius && super.contains(x, y)) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point p) {
		return super.contains(p) && this.getCenter().distance(p.getX(), p.getY()) >= this.innerRadius;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.BLACK);
		g.fillOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
	}
	
	@Override
	public int compareTo(Object ob) {
		if (ob instanceof Donut) {
			return (int) (this.area() - ((Donut) ob).area());
		}
		return 0;
	}

}

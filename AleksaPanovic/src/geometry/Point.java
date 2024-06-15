package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	public static final int  maxX = 200;
	
	public Point () {
		
	}
	
	public Point (int x, int y) {
		
		this.x=x;
		this.y=y;
	}
	
	public Point (int x, int y, boolean selected) {
		
		this(x,y);
		this.selected = selected;
	}
	
	public Point (int x, int y, boolean selected, Color color) {
		
		this(x,y,selected);
		setColor (color);
	}
	
	
	public int getX() {
		return this.x;
	}
	
	
	public void setX(int x_koordinata) {
		if (x_koordinata > 0) {
			x = x_koordinata;
		}else {
			System.out.println("Vrednost x koordinate mora da bude vece od 0");
		}
	}
	
	public static void point_static_method() {
		System.out.println("Ovo je staticka metoda");
	}
	
	public int getY() {
		return y;
	}
	
	
	public void setY(int y_coord) {
		y = y_coord;
	}
	
	
	public  double distance(int x2, int y2) {
		
		double dx = x2 - this.x;
		double dy = y2 - this.y;
		double d= Math.sqrt(dx*dx-dy*dy);
		return d;
	}
	
	@Override
	public String toString() {
		
		return "("+this.x+","+this.y+")";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point)obj;
			if(this.x == p.x && this.y == p.y) {
				return true;
			}else{
				return false;
			}
			
		}
		return false;
	}
	
	public static void staticMethod() {
		System.out.println("Pozivamo staticku metodu.");
	}
	
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public void draw (Graphics g) {
		
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y , this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		
		if (isSelected()) {
			g.setColor(Color.GREEN);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
		
	}
	
	
	public void moveBy(int x, int y) {
		this.x += x;
		this.y = this.y + y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point)obj).distance(0, 0));
		}else {
			return 0;
		}
	}

	@Override
	public boolean contains(Point point) {
		return false;
	}
}

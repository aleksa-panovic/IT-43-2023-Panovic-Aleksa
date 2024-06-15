package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperleftpoint;
	private int height;
	private int width;
	
	 public Rectangle () {
		 this.upperleftpoint = new Point(height, height);
	 }
	 
	public Rectangle(Point upperleftpoint, int height, int width)  {
		this.upperleftpoint = upperleftpoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperleftpoint, int height, int width, boolean selected) {
		this(upperleftpoint, height, width);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color) {
		this(upperLeftPoint, height, width, selected);
		setColor(color);
	}
	
	public Rectangle(Point upperleftpoint, int height, int width, boolean selected, Color color, Color innerColor) {
		this(upperleftpoint, height, width, selected, color);
		setInnerColor(innerColor);
	}
	
	public double area() {
		return (this.height * this.width);
	}
	
	public double circumference() {
		return 2*(this.height + this.width);
	}

	public Point getUpperleftpoint() {
		return this.upperleftpoint;
	}

	public void setUpperleftPoint(Point upperleftpoint) {
		this.upperleftpoint = upperleftpoint;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	@Override
	public String toString() {
	
		return "Upper left point: " + this.upperleftpoint + ", width = "+ this.width + ", height = "+ this.height;
	}
	
	@Override
	public boolean equals(Object ob) {
		if (ob instanceof Rectangle) {
			Rectangle re = (Rectangle)ob;
			return (re.getUpperleftpoint().equals(this.upperleftpoint) &&
					re.getHeight() == this.height && re.getWidth() == this.width);
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if(x > this.upperleftpoint.getX() && x < this.upperleftpoint.getX() + width
				&& y > this.upperleftpoint.getY() && y < this.getUpperleftpoint().getY() + height) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point point) {
		if(point.getX() > this.upperleftpoint.getX() && point.getX() < this.upperleftpoint.getX() + width
				&& point.getY()> this.upperleftpoint.getY() && point.getY() < this.getUpperleftpoint().getY() + height) {
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.upperleftpoint.getX(), this.upperleftpoint.getY(), this.width, this.height);
		
		this.fill(g);
		
		if (isSelected()) {
			g.setColor(Color.GREEN);
			g.drawRect(getUpperleftpoint().getX() - 3, getUpperleftpoint().getY() - 3, 6, 6);
			g.drawRect(getUpperleftpoint().getX() + getWidth() - 3, getUpperleftpoint().getY() - 3, 6, 6);
			g.drawRect(getUpperleftpoint().getX() - 3, getUpperleftpoint().getY() + getHeight() - 3, 6, 6);
			g.drawRect(getUpperleftpoint().getX() + getWidth() - 3, getUpperleftpoint().getY() + getHeight() - 3, 6, 6);
		}
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperleftpoint.getX()+1, this.getUpperleftpoint().getY()+1, width-1, height-1);
	}
	
	public void moveBy(int byX, int byY) {
		this.upperleftpoint.moveBy(byX, byY);
	}
	
	public void moveTo(int x, int y) {
		this.upperleftpoint.moveTo(x, y);
	}
	
	public int compareTo(Object ob) {
		if (ob instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) ob).area());
		}
		return 0;
	}
}

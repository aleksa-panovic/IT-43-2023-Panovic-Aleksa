package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startpoint;
	private Point endpoint;
	
	public Line() {
	
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startpoint = startPoint;
		this.endpoint = endPoint;
	}

	public Line(Point startpoint, Point endpoint, boolean selected) {
		this(startpoint, endpoint);
		this.selected = selected;	
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setColor(color);
	}
	
	
	public double length() {
		return this.endpoint.distance(this.startpoint.getX(), this.endpoint.getY());
	}
	
	
	public Point getStartpoint() {
		return this.startpoint;
	}

	public void setStartpoint(Point startpoint) {
		this.startpoint = startpoint;
	}

	public Point getEndpoint() {
		return this.endpoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endpoint = endpoint;
	}
	
	@Override
	public String toString() {
		return this.startpoint + "-->" + this.endpoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line l = (Line)obj;
			if(this.getStartpoint().equals(l.getStartpoint()) && this.getEndpoint().equals(l.getEndpoint())) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double d = this.getStartpoint().distance(x, y) + this.getEndpoint().distance(x, y);
		return d - this.length() <= 2;
	}
	
	public boolean contains(Point point) {
		double d = this.getStartpoint().distance(point.getX(), point.getY()) + this.getEndpoint().distance(point.getX(), point.getY());
		return d - this.length() <= 2;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.startpoint.getX(), this.startpoint.getY(), this.endpoint.getX(), this.endpoint.getY());
		
		if (isSelected()) {
			g.setColor(Color.GREEN);
			g.drawRect(this.startpoint.getX() - 3, this.startpoint.getY() - 3, 6, 6);
			g.drawRect(this.endpoint.getX() - 3, this.endpoint.getY() - 3, 6, 6);
		}
		
	}
	
	public void moveTo(int x, int y) {
		this.startpoint.moveTo(x, y);
		this.endpoint.moveTo(x, y);
	}
	
	public void moveBy(int byX, int byY) {
		this.startpoint.moveBy(byX, byY);
		this.endpoint.moveBy(byX, byY);
	}
	
	public int compareTo(Object ob) {
		if(ob instanceof Line) {
			return (int)(this.length()-((Line)ob).length());
		}
		return 0;
	}
	
}
	
	

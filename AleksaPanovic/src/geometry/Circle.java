package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
		private int radius;
		private Point center;
		
		public Circle() {
			
		}
		
		public Circle(Point center, int radius) {
			this.radius = radius;
			this.center = center;
		}
		public Circle(Point center, int radius, boolean selected) {
			this(center, radius);
			setSelected(selected);
		}
		
		public Circle(Point center, int radius, boolean selected, Color color) {
			this(center, radius, selected);
			setColor(color);
		}
		
		public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
			this(center, radius, selected, color);
			setInnerColor(innerColor);
		} 
		
		public double area() {
			return this.radius*this.radius*Math.PI;
		}
		
		public double circumference() {
			return 2*this.radius*Math.PI;
		}

		public int getRadius() {
			return this.radius;
		}

		public void setRadius(int radius) throws Exception{
			if(radius < 0) {
				throw new Exception("The radius can't be less than 0.");
			}
			this.radius = radius;
		}

		public Point getCenter() {
			return this.center;
		}

		public void setCenter(Point center) {
			this.center = center;
		}
		
		public String toString() {
			return "center = " + this.center.toString() + ", radius = " + this.radius;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Circle) {
				Circle c = (Circle)obj;
				if(this.getCenter().equals(c.getCenter()) && this.getRadius() == c.getRadius()) {
					return true;
				}
				return false;
			}
			return false;
		}
		
		public boolean contains(int x, int y) {
			return this.getCenter().distance(x, y) <= this.radius;
		}
		
		public boolean contains(Point point) {
			return this.getCenter().distance(point.getX(), point.getY()) <= this.radius;
		}
		
		public void fill(Graphics g) {
			g.setColor(getInnerColor());
			g.fillOval(this.center.getX() - radius	 + 1, this.center.getY() - radius + 1, radius*2 - 2, radius*2 - 2);
		}

		public void draw(Graphics g) {
			g.setColor(getColor());
			g.drawOval(this.center.getX() - radius	, this.center.getY() - radius, radius*2, radius*2); 
			this.fill(g);
			if (isSelected()) {
				g.setColor(Color.GREEN);
				g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
				g.drawRect(this.center.getX() - radius - 3, this.center.getY() - 3, 6, 6);
				g.drawRect(this.center.getX() + radius - 3, this.center.getY() - 3, 6, 6);
				g.drawRect(this.center.getX() - 3, this.center.getY() - radius - 3, 6, 6);
				g.drawRect(this.center.getX() - 3, this.center.getY() + radius - 3, 6, 6);
			}
			
		}
		
		public void moveTo(int x, int y) {
			this.center.moveTo(x, y);
		}
		
		public void moveBy(int byX, int byY) {
			this.center.moveBy(byX, byY);
		}
		
		public int compareTo(Object ob) {
			if (ob instanceof Circle) {
				return (int) (this.area() - ((Circle) ob).area());
			}
			return 0;
		}

}

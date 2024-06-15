package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{
	
	protected boolean selected;
	protected Color color;
	protected Color innerColor;
	
	public Shape () {
		
	}
	
	public Shape (boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected (boolean selected) {
		
		this.selected=selected;
	}
	
	public void setColor(Color color) {	
		this.color = color;;
	}
	public Color getColor() {
		return this.color;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	public Color getInnerColor() {
		return innerColor;
	}
	
	
	public abstract void draw(Graphics g);
	public abstract boolean contains(int x, int y);
	public abstract boolean contains(Point point);

	public void fill(Graphics g) {
		
		
	}
}

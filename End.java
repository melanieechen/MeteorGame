package game;

import java.awt.Graphics;

/**
 * This class extends Polygon. It represents the white box the losing/winning dialogue is centered in.
 * 
 * @author Melanie Chen
 */

public class End extends Polygon {
	
	/**
	 * Defines the End dialogue box. It relies on the super class constructor to create a
	 * polygon with the given points, position, and rotation.
	 * 
	 * @param pointArray
	 * @param position
	 * @param rotation
	 */
	public End(Point[] pointArray, Point position, double rotation) {
		super(pointArray, position, rotation);
	}
	
	/**
	 * Paints the End dialogue polygon. Gets each x and y point from the pointArray
	 * and store it into respective arrays for processing by the fillPolygon method.
	 * 
	 * @param brush
	 */
	public void paint(Graphics brush) {
		int[] xPoints = new int[this.getPoints().length];
		int[] yPoints = new int[this.getPoints().length];
		
		int xIndex = 0;
		for(Point point : this.getPoints()) {
			xPoints[xIndex] = (int) point.getX();
			xIndex++; 
		}
		
		int yIndex = 0;
		for(Point point : this.getPoints()) {
			yPoints[yIndex] = (int) point.getY();
			yIndex++; 
		}
		
		brush.drawPolygon(xPoints, yPoints, 4);
		brush.fillPolygon(xPoints, yPoints, 4);
	}
}

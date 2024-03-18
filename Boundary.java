package game;
import java.awt.*;

/**
 * This class extends Polygon. It represents the finish line the ship must reach to complete the game.
 * 
 * @author Melanie Chen
 */

public class Boundary extends Polygon {
	/**
	 * Defines a Boundary. It relies on the super class constructor to create a
	 * polygon with the given points, position, and rotation.
	 * 
	 * @param pointArray
	 * @param position
	 * @param rotation
	 */
	public Boundary(Point[] pointArray, Point position, double rotation) {
		super(pointArray, position, rotation);
	}	
	
	/**
	 * Paints the boundary polygon. Gets each x and y point from the pointArray
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
		
		brush.fillPolygon(xPoints, yPoints, 4);
	}
}
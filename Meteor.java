package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class extends Polygon and implements Motion and KeyListener.
 * It represents the Meteor element of the game.
 * 
 * @author Melanie Chen 
 */

public class Meteor extends Polygon implements Motion, KeyListener {
	private Difficulty difficulty;

	/**
	 * Defines a Element. It relies on the super class constructor to create a
	 * polygon with the given points, position, and rotation.
	 * 
	 * @param pointArray
	 * @param position
	 * @param rotation
	 */
	public Meteor(Point[] pointArray, Point position, double rotation) {
		super(pointArray, position, rotation);
		difficulty = new Difficulty();
	}

	/**
	 * Rotates the meteor. The default rotation is 2 degrees per tenth second to the left.
	 * When, the player uses a speed boost by pressing the Space key, the difficulty will increase.
	 * Every increase in difficulty results in the rotation becoming faster.
	 */
	public void move() {
		rotate(-2 * difficulty.getDifficulty());
	}

	/**
	 * Paints the meteor polygon. Gets each x and y point from the pointArray
	 * and store it into respective arrays for processing by the fillPolygon method.
	 * 
	 * @param brush
	 */
	public void paint(Graphics brush) {
		int[] xPoints = new int[this.getPoints().length];
		int[] yPoints = new int[this.getPoints().length];

		int xIndex = 0;
		for (Point point : this.getPoints()) {
			xPoints[xIndex] = (int) point.getX();
			xIndex++;
		}

		int yIndex = 0;
		for (Point point : this.getPoints()) {
			yPoints[yIndex] = (int) point.getY();
			yIndex++;
		}
		brush.fillPolygon(xPoints, yPoints, 6);
	}

	/**
	 * Checks if the Space key is pressed. If it is, then the difficulty (rotation of the meteor)
	 * is increased.
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			difficulty.increaseDifficulty(1);
		}
	}
	
	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}
	
	/**
	 * This class is an inner class of Meteor. It represents the Difficulty of the game.
	 * Difficulty is increased when the player uses a speed boost.
	 * 
	 */
	public class Difficulty {
		private int speed;
		private int speedIncreaseCounter;
		
		/**
		 * Defines the starting difficulty of the game. The initial speed is set to 1.
		 * The difficulty counter is initialized to 0. The max is 3. 
		 * 
		 */
		public Difficulty() {
			this.speed = 1;
			this.speedIncreaseCounter = 0;
		}
		
		/**
		 * Increases the speed by the parameter amount. Then, it increments the counter.
		 * This occurs until the difficulty counter is at 3 (the max).
		 * 
		 * @param amount
		 */
		public void increaseDifficulty(int amount) {
			if (speedIncreaseCounter < 3) {
				speed += amount;
				speedIncreaseCounter++;
			}
		}
		
		/**
		 * Returns the current speed.
		 * 
		 */
		public int getDifficulty() {
			return speed;
		}
	}
}
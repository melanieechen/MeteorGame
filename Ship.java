package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class extends Polygon and implements Motion and KeyListener.
 * It represents the Ship element of the game.
 * 
 * @author Melanie Chen
 */

public class Ship extends Polygon implements KeyListener, Motion {
	public boolean endGame;
	private boolean forward;
	private boolean left;
	private boolean right;
	private Point position;
	public double xPosition;
	public double yPosition;
	private Booster booster;

	/**
	 * Defines a Ship. It relies on the super class constructor to create a
	 * polygon with the given points, position, and rotation.
	 * 
	 * @param pointArray
	 * @param position
	 * @param rotation
	 */
	public Ship(Point[] pointArray, Point position, double rotation) {
		super(pointArray, position, rotation);
		this.position = position;
		booster = new Booster();
	}

	/**
	 * When the forward key is pressed, the ship moves forward in the direction it is facing by the amount stepSize.
	 * When the left key is pressed, the ship rotates left. When the right key is pressed, the ship rotates right.
	 * The stepSize is dependent on the speed of the booster. The speed is increased when the user pressed Space.
	 */
	public void move() {
		double stepSize = booster.getSpeed();
		xPosition = position.getX();
		yPosition = position.getY();

		if (forward == true) {
			double newXPosition = xPosition - Math.cos(Math.toRadians(rotation - 90)) * stepSize;
			double newYPosition = yPosition - Math.sin(Math.toRadians(rotation - 90)) * stepSize;
			position.setX(newXPosition);
			position.setY(newYPosition);
		}

		if (left == true) {
			rotate(-2);
		}

		if (right == true) {
			rotate(2);
		}
	}

	/**
	 * Paints the ship polygon. Gets each x and y point from the pointArray
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

		brush.fillPolygon(xPoints, yPoints, 3);
	}

	public void keyTyped(KeyEvent e) {

	}

	/**
	 * If the Up, Left, or Right keys are pressed, then it sets their respective instance variables to true.
	 * If the Space key is pressed, then it increases the speed by 0.5. All conditions are dependent upon the game not being ended yet.
	 * If the game has ended, then the key pressing does not register.
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && !endGame) {
			forward = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT && !endGame) {
			left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !endGame) {
			right = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && !endGame) {
			booster.increaseSpeed(0.5);
		}
	}

	/**
	 * If the Up, Left, or Right keys are released, then it sets their respective instance variables to false.
	 * This stops the ship from moving in that direction.
	 * 
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			forward = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}

	/**
	 * This class is an inner class of Ship. It represents the Booster of the ship.
	 * The booster increases the speed of the ship if the Space key is pressed.
	 * 
	 */
	public class Booster {
		private double speed;
		private int speedIncreaseCounter;
		
		/**
		 * Defines the Booster. The initial speed is set to 1.
		 * The counter is initialized to 0. The max is 3. 
		 * 
		 */
		public Booster() {
			this.speed = 1;
			this.speedIncreaseCounter = 0;
		}

		/**
		 * Increases the speed by the parameter amount. Then, it increments the counter.
		 * This occurs until the speed counter is at 3 (the max).
		 * 
		 * @param amount
		 */
		public void increaseSpeed(double amount) {
			if (speedIncreaseCounter < 3) {
				speed += amount;
				speedIncreaseCounter++;
			}
		}

		/**
		 * Returns the current speed.
		 * 
		 */
		public double getSpeed() {
			return speed;
		}
	}
}
package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the logic of the entire game and utilizes the different elements from the other classes.
 * 
 * @author Melanie Chen
 */

class MeteorGame extends Game {
	static int counter = 0;
	ArrayList<Polygon> elementsArray;

	// Elements
	Boundary boundary;
	Ship ship;
	Meteor meteor;
	Meteor meteorTwo;
	Meteor meteorThree;
	Meteor meteorFour;
	Meteor meteorFive;
	Meteor meteorSix;
	Meteor meteorSeven;
	Meteor meteorEight;
	Meteor meteorNine;
	Background background;

	// End message
	End endMessage;

	/**
	 * Initializes all of the elements with their corresponding points, position, and rotation.
	 * Adds the keyListeners for the elements that depend on it.
	 * 
	 */
	public MeteorGame() {
		super("Meteor Game", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		elementsArray = new ArrayList<Polygon>();

		// boundary instantiation
		Point[] boundaryPoints = { new Point(0, 0), new Point(1300, 0), new Point(1300, 50), new Point(0, 50) };
		boundary = new Boundary(boundaryPoints, new Point(0, 0), 0) {
		};

		// ship instantiation
		Point[] shipPoints = { new Point(0, 0), new Point(30, 30), new Point(60, 0) };
		ship = new Ship(shipPoints, new Point(390, 500), 180) {
		};
		this.addKeyListener(ship);

		// meteor instantiation
		Point[] meteorPoints = { new Point(30, 0), new Point(0, 30), new Point(30, 60), new Point(60, 60),
				new Point(90, 30), new Point(60, 0) };
		
		meteor = new Meteor(meteorPoints, new Point(200, 300), 0) {
			public void move() {
				rotate(2);
			}
		};
		elementsArray.add(meteor);

		meteorTwo = new Meteor(meteorPoints, new Point(300, 200), 0);
		elementsArray.add(meteorTwo);
		this.addKeyListener(meteorTwo);

		meteorThree = new Meteor(meteorPoints, new Point(400, 300), 0) {
			public void move() {
				rotate(2);
			}
		};
		elementsArray.add(meteorThree);

		meteorFour = new Meteor(meteorPoints, new Point(500, 200), 0);
		elementsArray.add(meteorFour);
		this.addKeyListener(meteorFour);

		meteorFive = new Meteor(meteorPoints, new Point(100, 200), 0);
		elementsArray.add(meteorFive);
		this.addKeyListener(meteorFive);

		meteorSix = new Meteor(meteorPoints, new Point(600, 300), 0) {
			public void move() {
				rotate(2);
			}
		};
		elementsArray.add(meteorSix);

		meteorSeven = new Meteor(meteorPoints, new Point(700, 200), 0);
		elementsArray.add(meteorSeven);
		this.addKeyListener(meteorSeven);

		meteorEight = new Meteor(meteorPoints, new Point(0, 300), 0) {
			public void move() {
				rotate(2);
			}
		};
		elementsArray.add(meteorEight);

		meteorNine = new Meteor(meteorPoints, new Point(800, 300), 0) {
			public void move() {
				rotate(2);
			}
		};
		elementsArray.add(meteorNine);

		// background instantiation
		background = new Background();

		// end message instantiation
		Point[] endPoints = { new Point(0, 0), new Point(200, 0), new Point(200, 100), new Point(0, 100) };
		endMessage = new End(endPoints, new Point(360, 240), 0);
	}

	/**
	 * Calls the paint method of every element in order to display it in the game.
	 * Also contains the logic and display for when the player loses/wins the game.
	 * 
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);

		// background
		background.paint(brush);

		// boundary
		brush.setColor(Color.pink);
		boundary.paint(brush);

		ship.move();
		// ship
		brush.setColor(Color.blue);
		ship.paint(brush);

		// meteor
		brush.setColor(Color.gray);
		meteor.paint(brush);

		// meteor two
		meteorTwo.paint(brush);

		// meteor three
		meteorThree.paint(brush);

		// meteor four
		meteorFour.paint(brush);

		// meteor five
		meteorFive.paint(brush);

		// meteor six
		meteorSix.paint(brush);

		// meteor seven
		meteorSeven.paint(brush);

		// meteor eight
		meteorEight.paint(brush);

		// meteor nine
		meteorNine.paint(brush);

		meteor.move();
		meteorTwo.move();
		meteorThree.move();
		meteorFour.move();
		meteorFive.move();
		meteorSix.move();
		meteorSeven.move();
		meteorEight.move();
		meteorNine.move();

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.blue);
		brush.drawString("Counter is " + counter, 20, 20);

		elementsArray.forEach((Polygon element) -> {
			if (ship.collides(element)) {
				brush.setColor(Color.white);
				endMessage.paint(brush);
				ship.endGame = true;
				brush.setColor(Color.red);
				brush.drawString("Wow, you lose!", 360, 270);
			}
        });

		if (ship.yPosition < 20) {
			brush.setColor(Color.white);
			endMessage.paint(brush);
			ship.endGame = true;
			brush.setColor(Color.green);
			brush.drawString("Wow, you win!", 360, 270);
			ship.endGame = true;
		}

	}

	public static void main(String[] args) {
		MeteorGame a = new MeteorGame();
		a.repaint();
	}
}
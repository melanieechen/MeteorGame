package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * This class is the background of the game. It is set as an image of space to make the game look better.
 * 
 * @author Melanie Chen
 */

public class Background {
	private Image img; 
	
	/**
	 * Defines the background and sets the image to an image of space.
	 * 
	 */
	public Background() {
		img = Toolkit.getDefaultToolkit().createImage("img/space4.jpg");
	}
	
	/**
	 * Draws the image to the background.
	 * @param brush
	 */
	public void paint (Graphics brush) {
		brush.drawImage(img, 10, 10, null);
	}
}
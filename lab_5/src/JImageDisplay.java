import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends javax.swing.JComponent {
	/**
	 * Manages an image whose content can be written.
	 **/
	private final BufferedImage image;

	/**
	 * Initialization constructor.
	 **/
	public JImageDisplay(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		setPreferredSize(new Dimension(width, height));
	}

	/**
	 * Returning a BufferedImage instance
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Component rendering
	 **/
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
	}

	/**
	 * Sets a pixel of a specific color.
	 **/
	public void drawPixel(int x, int y, int rgbColor) {
		image.setRGB(x, y, rgbColor);
	}

	/**
	 * Sets all pixels of the image to black.
	 **/
	public void clearImage() {
		for (int y = 0; y < image.getHeight(); ++y) {
			for (int x = 0; x < image.getWidth(); ++x) {
				image.setRGB(x, y, 0);
			}
		}
	}
}

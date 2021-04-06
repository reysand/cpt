import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
	private final int screenSize;

	private JImageDisplay jImageDisplay;

	private final FractalGenerator fractalGenerator;

	private final Rectangle2D.Double range;

	public FractalExplorer(int screenSize) {
		this.screenSize = screenSize;
		this.fractalGenerator = new Mandelbrot();
		this.range = new Rectangle2D.Double(0, 0, 0, 0);
		fractalGenerator.getInitialRange(this.range);
	}

	public void createAndShowGUI() {
		JFrame jFrame = new JFrame("Fractal Explorer");

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jImageDisplay = new JImageDisplay(screenSize, screenSize);
		JButton jButton = new JButton("Reset Fractal");
		jButton.addActionListener(e -> {
			jImageDisplay.clearImage();
			fractalGenerator.getInitialRange(range);
			drawFractal();
		});
		jImageDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double x = FractalGenerator.getCoord(range.x,
						range.x + range.width, screenSize, e.getX());
				double y = FractalGenerator.getCoord(range.y,
						range.y + range.height, screenSize, e.getY());
				fractalGenerator.recenterAndZoomRange(range, x, y, 0.5);
				drawFractal();
			}
		});
		jFrame.setLayout(new BorderLayout());
		jFrame.add(jImageDisplay, BorderLayout.CENTER);
		jFrame.add(jButton, BorderLayout.SOUTH);
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setResizable(false);
	}

	private void drawFractal() {
		for (int y = 0; y < this.screenSize; ++y) {
			for (int x = 0; x < this.screenSize; ++x) {
				double xCoord = FractalGenerator.getCoord(this.range.x,
						this.range.x + this.range.width, this.screenSize, x);
				double yCoord = FractalGenerator.getCoord(this.range.y,
						this.range.y + this.range.height, this.screenSize, y);
				int numIters = fractalGenerator.numIterations(xCoord, yCoord);
				if (numIters == -1) {
					jImageDisplay.drawPixel(x, y, 0);
				}
				else {
					float hue = 0.7f + (float) numIters / 200f;
					int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
					jImageDisplay.drawPixel(x, y, rgbColor);
				}
			}
		}
		jImageDisplay.repaint();
	}

	public static void main(String[] args) {
		FractalExplorer fractalExplorer = new FractalExplorer(800);
		fractalExplorer.createAndShowGUI();
		fractalExplorer.drawFractal();
	}
}

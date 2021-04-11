import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class FractalExplorer {
	/**
	 * Width and height in pixels
	 */
	private int screenSize;

	private JImageDisplay jImageDisplay;

	private FractalGenerator fractalGenerator;

	/**
	 * The range of the complex plane that is displayed
	 */
	private Rectangle2D.Double range;

	/**
	 * Initialization constructor
	 */
	public FractalExplorer(int screenSize) {
		this.screenSize = screenSize;
		setFractalGenerator(new Mandelbrot());
		this.range = new Rectangle2D.Double();
		fractalGenerator.getInitialRange(this.range);
	}

	/**
	 * Setting the FractalGenerator object
	 */
	public final void setFractalGenerator(final FractalGenerator generator) {
		this.fractalGenerator = generator;
	}

	/**
	 * Initializes a Swing GUI: a JFrame containing a JImageDisplay object,
	 * JPane with two JButtons and JPane with JLabel and JComboBox
	 */
	public void createAndShowGUI() {
		JFrame jFrame = new JFrame("Fractal Explorer");
		jImageDisplay = new JImageDisplay(screenSize, screenSize);
		JPanel jPanelButtons = new JPanel();
		JButton jButtonSave = new JButton("Save Image");
		JButton jButtonReset = new JButton("Reset Fractal");
		JPanel jPanelSwitch = new JPanel();
		JLabel jLabel = new JLabel("Fractal:");
		JComboBox<Object> jComboBox = new JComboBox<>();

		jButtonSave.addActionListener(e -> {
			JFileChooser jFileChooser = new JFileChooser();
			FileFilter fileFilter = new FileNameExtensionFilter("PNG Images",
					"png");
			jFileChooser.setFileFilter(fileFilter);
			jFileChooser.setAcceptAllFileFilterUsed(false);

			if (jFileChooser.showSaveDialog(jImageDisplay) ==
					JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				try {
					ImageIO.write(jImageDisplay.getImage(), "png", file);
					JOptionPane.showMessageDialog(jImageDisplay, "Complete",
							"Saving . . .", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ioException) {
					JOptionPane.showMessageDialog(jImageDisplay,
							ioException.getMessage(), "Cannot Save Image",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jButtonReset.addActionListener(e -> {
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
		jPanelButtons.add(jButtonSave);
		jPanelButtons.add(jButtonReset);

		jComboBox.addItem(new Mandelbrot());
		jComboBox.addItem(new Tricorn());
		jComboBox.addItem(new BurningShip());
		jPanelSwitch.add(jLabel);
		jPanelSwitch.add(jComboBox);
		jComboBox.addActionListener(e -> {
			FractalExplorer.this.setFractalGenerator((FractalGenerator)
					jComboBox.getSelectedItem());
			fractalGenerator.getInitialRange(range);
			drawFractal();
		});

		jFrame.setLayout(new BorderLayout());
		jFrame.add(jImageDisplay, BorderLayout.CENTER);
		jFrame.add(jPanelButtons, BorderLayout.SOUTH);
		jFrame.add(jPanelSwitch, BorderLayout.NORTH);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setResizable(false);
	}

	/**
	 * Drawing a fractal in JImageDisplay
	 */
	private void drawFractal() {
		for (int y = 0; y < this.screenSize; ++y) {
			for (int x = 0; x < this.screenSize; ++x) {
				double xCoord = FractalGenerator.getCoord(this.range.x,
						this.range.x + this.range.width, this.screenSize, x);
				double yCoord = FractalGenerator.getCoord(this.range.y,
						this.range.y + this.range.height, this.screenSize, y);
				int numIters = fractalGenerator.numIterations(xCoord, yCoord);
				int	rgbColor = 0;

				if (numIters != -1) {
					float hue = 0.7f + (float)numIters / 200f;
					rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
				}
				jImageDisplay.drawPixel(x, y, rgbColor);
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

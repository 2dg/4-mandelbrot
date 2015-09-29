import javax.swing.*;
import java.awt.*;

public class Mandelbrot extends JPanel {
	public static final int TRACE_LIMIT = 60;
	public static final Color color = Color.decode("#17396d");

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (double x = -2; x < 2; x += .01) {
			for (double y = -2; y < 2; y += .01) {
				int c = count(new Complex(x, y));

				if (c == TRACE_LIMIT) {
					g.setColor(Color.BLACK);
				}
				else {
					g.setColor(new Color(
						c * color.getRed() % 0xff,
						c * color.getGreen() % 0xff,
						c * color.getBlue() % 0xff
					));
				}

				g.drawRect((int)(x * 100) + 200, (int)(y * 100) + 200, 1, 1);
			}
		}
	}

	/**
	 * Approximates the Mandelbrot set value of the Complex number.
	 * @param c
	 * @return set value
	 */
	protected static int count(Complex c) {
		Complex z = new Complex();

		for (int i = 0; i < TRACE_LIMIT; i++) {
			z = z.times(z).plus(c);
			if (z.abs() > 2) {
				return i;
			}
		}

		return TRACE_LIMIT;
	}
}

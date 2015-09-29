import javax.swing.*;
import java.awt.*;

public class Index {
	public static void main(String[] args) {
		JFrame f = new JFrame("Mandelbrot Fractal");
		f.add(new Mandelbrot());
		f.getContentPane().setPreferredSize(new Dimension(400, 400));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

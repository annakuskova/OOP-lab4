import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int size;
    private JImageDisplay Display;
    private FractalGenerator generator;
    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        this.size = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double();
        generator.getInitialRange(range);
        Display = new JImageDisplay(size, size);
    }

    public void createAndShowGUI() {
        Display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");
        frame.add(Display, BorderLayout.CENTER);
        JButton resetButton = new JButton("Reset Display");
        Resetter handler = new Resetter();
        resetButton.addActionListener(handler);
        frame.add(resetButton, BorderLayout.SOUTH);
        Clicker click = new Clicker();
        Display.addMouseListener(click);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
       
    }

    private void drawFractal() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);

                int numIter = generator.numIterations(xCoord, yCoord);
                if (numIter == -1) {
                    Display.drawPixel(x, y, 0);
                } else {
                    float hue = 0.5f + (float) numIter / 50;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    Display.drawPixel(x, y, rgbColor);
                }
            }
        }

        Display.repaint();
    }

    private class Resetter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            generator.getInitialRange(range);
            drawFractal();
        }
    }

    private class Clicker extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, size, x);

            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.height, size, y);

            generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args) {
        FractalExplorer fe = new FractalExplorer(400);
        fe.createAndShowGUI();
        fe.drawFractal();
    }

}

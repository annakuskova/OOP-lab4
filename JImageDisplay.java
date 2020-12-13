import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;


public class JImageDisplay extends JComponent {
    private final BufferedImage image;

    public JImageDisplay(int width, int height) {
        if (width <= 0)
            throw new IllegalArgumentException("width must be > 0; got " + width);

        if (height <= 0)
            throw new IllegalArgumentException("height must be > 0; got " + height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(width, height);

        super.setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage() {
        Graphics2D imageGraphics = image.createGraphics();
        imageGraphics.setColor(new Color(0,0,0));
        imageGraphics.fillRect(0,0,image.getWidth(), image.getHeight());
        
    }

    public void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }

   


}



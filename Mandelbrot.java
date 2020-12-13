import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    /*static Complex mandelbrotFunction(Complex compl, int n) {
        if (n == 0) {
            return new Complex(0, 0);
        } else {
            return mandelbrotFunction(compl, n - 1).multiple(mandelbrotFunction(compl, n - 1)).plus(compl);
        }
    }*/

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int count = 0;
        Complex c = new Complex(0, 0);

        while (count < MAX_ITERATIONS && c.getSquaredModule() < 4){
            c.SquaredInPoint(x, y);
            count++;
        }

        if (count == MAX_ITERATIONS) return -1;
        return count;
        /*for (int i = 0; i < MAX_ITERATIONS; i++) {
            Complex z = mandelbrotFunction(c, i);
            if (z.abs() * z.abs() > 4) {
                count = i;
                break;
            }
        }

        if (count == 0) {
            return -1;
        } else return count;*/
    }
}

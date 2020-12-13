public class Complex {
    double re;
    double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getSquaredModule(){
        return (this.re*this.re + this.im*this.im);
    }
    public void SquaredInPoint(double x, double y){
        double real = (re*re) - (im*im) + x;
        double imagine = 2 * re * im + y;
        re = real;
        im = imagine;
    }



    /*

                                  // Complex summa = z.plus(new Complex(1, 2));  (summa == 2 + i*3.43)
    Complex plus(Complex z) {     // Complex z = new Complex(1, 1.43);
        return new Complex(this.re + z.re, this.im + z.im);
    }

    Complex minus(Complex z) {
        return new Complex(this.re - z.re, this.im - z.im);
    }

    Complex multiple(Complex z) {
        return new Complex(this.re * z.re - this.im * z.im, this.re * z.im + z.re * this.im);
    }

    Complex divideBy(Complex z) {
        return new Complex((this.re * z.re + this.im * z.im)/(z.re*z.re + z.im*z.im), (z.re*this.im - this.re*z.im)/(z.re*z.re + z.im*z.im));
    }

    double abs() {          // double module = z.abs();     if (z.abs() > 2)
        return Math.sqrt(this.re*this.re + this.im*this.im);
    }*/
}

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

}

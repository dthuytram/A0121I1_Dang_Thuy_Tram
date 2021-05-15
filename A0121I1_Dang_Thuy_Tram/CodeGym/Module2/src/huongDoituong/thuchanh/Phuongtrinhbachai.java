package huongdoituong.thuchanh;

public class Phuongtrinhbachai {
    private double a, b, c;

    public Phuongtrinhbachai(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminal(double a, double b, double c) {
        return ((b * b) - (4 * a * c));
    }

    public double getRoot1(double a, double b, double c) {
        return ((-b/Math.sqrt(this.getDiscriminal(a,b,c)))/(2*a));
    }
    public double getRoot2(double a, double b, double c) {
        return ((-b/Math.sqrt(b*b))/(2*a));
    }
}


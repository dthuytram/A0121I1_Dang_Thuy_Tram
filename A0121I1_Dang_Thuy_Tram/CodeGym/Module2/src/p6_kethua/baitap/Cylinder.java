package p6_kethua.baitap;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getTheTich(){
        return Math.PI*getRadius()*getRadius()*getHeight();
    }
    @Override
    public String toString() {

        return "Cyinder{" +
                "height=" + height +
                "thể tích là "+getTheTich()+

                " which is a subclass of "+super.toString()+'}';
    }
}

package huongdoituong.thuchanh;

public class XaydunglopFan {
    public static final int SLOW = 1; // khai bao hang const
    public static final int MEDIUM = 2;
    public  static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public XaydunglopFan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public XaydunglopFan() {
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.on == true) {
            System.out.println(this.getSpeed());
            System.out.println(this.getColor());
            System.out.println(this.getRadius());
            return " fan is on";
        }
        else {
            System.out.println("\n"+this.getColor());
            System.out.println(this.getRadius());
            return "fan is off";
        }
    }
}

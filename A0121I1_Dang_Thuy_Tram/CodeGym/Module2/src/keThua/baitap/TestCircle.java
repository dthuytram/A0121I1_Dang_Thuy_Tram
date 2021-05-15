package keThua.baitap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle =new Circle(2,"red");
        System.out.println(circle.toString());
        Cylinder cylinder =new Cylinder(3,"red",2);
        System.out.println(cylinder.toString());
    }
}
package access_modifier.baitap;

public class TestArea {
    public static void main(String[] args) {
        Circle c= new Circle(1.3);
        Circle c1= new Circle(4.6);
        System.out.println(c.getArea());
        System.out.println(c1.getArea());

    }
}

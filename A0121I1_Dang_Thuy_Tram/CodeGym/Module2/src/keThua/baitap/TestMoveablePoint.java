package keThua.baitap;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint=new MoveablePoint(2,3,4,2);
        System.out.println(moveablePoint.toString());
        System.out.println("sau khi di chuyen");
        System.out.println(moveablePoint.move());

    }
}

package p6_kethua.baitap;

public class TestPoint2D_3D {
    public static void main(String[] args) {
        Point2D point2D =new Point2D(2,3);
        System.out.println(point2D.toString()+")");
        Point3D point3D =new Point3D(2,5,2);
        System.out.println(point3D.toString());
        System.out.println(point2D.getXY()[0]);
    }
}

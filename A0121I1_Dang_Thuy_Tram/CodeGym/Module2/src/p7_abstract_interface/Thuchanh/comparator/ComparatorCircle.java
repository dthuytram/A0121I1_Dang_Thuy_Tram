package p7_abstract_interface.Thuchanh.comparator;

import p6_kethua.thuchanh.Circle;

import java.util.Comparator;
public class ComparatorCircle implements Comparator<Circle> {

//
//    public ComparatorCircle() {
//    }
//
//    public ComparatorCircle(double radius) {
//        super(radius);
//    }
//
//    public ComparatorCircle(double radius, String color, boolean filled) {
//        super(radius, color, filled);
//    }
        @Override
        public int compare(Circle c1, Circle c2) {
            if (c1.getRadius() > c2.getRadius()) return 1;
            else if (c1.getRadius() < c2.getRadius()) return -1;
            else return 0;
        }
}
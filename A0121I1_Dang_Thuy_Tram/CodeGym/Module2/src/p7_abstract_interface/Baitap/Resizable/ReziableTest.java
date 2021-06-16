package p7_abstract_interface.Baitap.Resizable;

import p6_kethua.thuchanh.Circle;
import p6_kethua.thuchanh.Rectangle;
import p6_kethua.thuchanh.Shape;
import p6_kethua.thuchanh.Square;

public class ReziableTest {
    public static void main(String[] args) {
        int x = (int)Math.floor(Math.random() * 10.0D);
        Shape[] shapes = new Shape[]{new Circle((double)x, "yellow", false), new Rectangle((double)x, (double)x, "infinity", true), new Square((double)x, "melinda", true)};
        Shape[] var3 = shapes;
        int var4 = shapes.length;

        int var5;
        Shape a;
        for(var5 = 0; var5 < var4; ++var5) {
            a = var3[var5];
            System.out.println(a);
        }

        var3 = shapes;
        var4 = shapes.length;

        for(var5 = 0; var5 < var4; ++var5) {
            a = var3[var5];
            a.resize(Math.random() * 1000.0D);
        }


    }
}

package p6_kethua.thuchanh;

import p7_abstract_interface.Baitap.Colorable.Colorable;
import p7_abstract_interface.Baitap.Resizable.Resiable;

public class Shape implements Resiable, Colorable {
    private String color ="blue";
    private boolean filled = true;
    public Shape(){

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString(){
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    public void resize(double v) {

    }
    public static void printShape(Shape[] shape) {
        Shape[] var1 = shape;
        int var2 = shape.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Shape x = var1[var3];
            System.out.println(x.toString());
        }
    }
    public void howToColor() {
        System.out.println("Color all four sides...");
    }

}

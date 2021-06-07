package huongdoituong.thuchanh;

public class Retangle {
    double width, height;
    public Retangle(){

    }

    public Retangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea()
    {
        return this.width* this.height;
    }
    public double getPerimeters(){
        return ( this.width + this.height)*2;
    }
    public String display(){
        return "Retangle{" + "width= "+ width + ",height="+ height+ "}";
    }

}

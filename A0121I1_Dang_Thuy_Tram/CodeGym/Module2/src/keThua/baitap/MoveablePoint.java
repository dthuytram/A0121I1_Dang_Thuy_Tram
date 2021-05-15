package keThua.baitap;

public class MoveablePoint extends Point {
    private float xSpeed =0.0f;
    private float ySpeed =0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed ){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed() {
        float[]arr=new float[2];
        arr[0]=xSpeed;
        arr[1]=ySpeed;
        return arr;
    }

    @Override
    public String toString() {
        return super.toString()+" ,speed=( "+xSpeed+" ,"+ySpeed+" )";
    }
    public MoveablePoint move(){
        super.setX(xSpeed+super.getX());
        super.setY(ySpeed+super.getY());
        return this;
    }
}

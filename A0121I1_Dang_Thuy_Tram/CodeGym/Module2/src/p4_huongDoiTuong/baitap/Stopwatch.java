package huongdoituong.baitap;

public class Stopwatch {
    private long startTime;
    private long stopTime;

    Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    public Stopwatch(long startTime, long stopTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;
    }
    public void stop (){
        this.stopTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.stopTime - this.startTime;
    }

}

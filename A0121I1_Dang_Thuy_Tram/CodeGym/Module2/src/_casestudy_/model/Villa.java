package _casestudy_.model;

public class Villa {
    private String roomStandards;
    private String otherDescription;
    private int poolArea;
    private int floorNumber;

    public Villa(String roomStandards, String otherDescription, int poolArea, int floorNumber) {
        this.roomStandards = roomStandards;
        this.otherDescription = otherDescription;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa() {

    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}

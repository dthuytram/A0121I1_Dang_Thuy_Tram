package _casestudy_.model;

public class House {
    private String roomStandards;
    private String otherDescription;
    private int floorNumber;

    public House() {
    }

    public House(String roomStandards, String otherDescription, int floorNumber) {
        this.roomStandards = roomStandards;
        this.otherDescription = otherDescription;
        this.floorNumber = floorNumber;
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

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}

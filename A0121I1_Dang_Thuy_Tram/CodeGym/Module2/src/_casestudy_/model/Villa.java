package _casestudy_.model;

public class Villa extends Service {
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

    public Villa(String nameService, int usedArea, int cost, int maxMember, String rentType, String id, String plusServices, String roomStandard, String facilitiesDes, int floorNumber, int poolArea) {
        super(nameService, usedArea, cost, maxMember, rentType, id, plusServices);
        this.roomStandards = roomStandard;
        this.otherDescription = facilitiesDes;
        this.floorNumber = floorNumber;
        this.poolArea = poolArea;
    }

    public Villa(String nameService, String s, int cost, int maxMember, String rentType, String id, String plusServices, String roomStandard, String facilitiesDes, int floorNumber, int poolArea) {

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

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandards + "\n" +
                ", facilitiesDes='" + otherDescription + "\n" +
                ", floors=" + floorNumber + "\n" +
                ", poolArea=" + poolArea + "\n" +
                "nameService='" + getNameService() + "\n" +
                ", usedArea=" + getUsedArea() + "\n" +
                ", cost=" + getCostRent() + "\n" +
                ", maxMember=" + getMaxMember() + "\n" +
                ", rentType='" + getRentType() + "\n" +
                ", id='" + getId() + "\n" +
                ", plusServices='" + getPlusService() + "\n" +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}

package _casestudy_.model;

public class House extends Service {
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
    public House(String nameService, int usedArea, int cost, int maxMember, String rentType, String id, String plusServices, String roomStandard, String facilitiesDes, int floors) {
        super(nameService, usedArea, cost, maxMember, rentType, id, plusServices);
        this.roomStandards = roomStandard;
        this.otherDescription = facilitiesDes;
        this.floorNumber = floors;
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
    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandards + '\'' +
                ", facilitiesDes='" + otherDescription + '\'' +
                ", floors=" + floorNumber +
                "nameService='" + getNameService() + '\'' +
                ", usedArea=" + getUsedArea() +
                ", cost=" + getCostRent() +
                ", maxMember=" + getMaxMember() +
                ", rentType='" + getRentType() + '\'' +
                ", id='" + getId() + '\'' +
                ", plusServices='" + getPlusService() + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

}

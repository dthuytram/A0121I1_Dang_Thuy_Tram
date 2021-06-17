package _casestudy_.model;

public class Room extends Service{
    private String freeServices;  //Dich vu mien phi di kem

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }
    public Room(String nameService, int usedArea, int cost, int maxMember, String rentType, String id, String plusServices, String freeService) {
        super(nameService, usedArea, cost, maxMember, rentType, id, plusServices);
        this.freeServices = freeService;
    }
    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeServices + '\'' +
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


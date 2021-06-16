package _casestudy_.model;

public class Room {
    private String freeServices;  //Dich vu mien phi di kem

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
}


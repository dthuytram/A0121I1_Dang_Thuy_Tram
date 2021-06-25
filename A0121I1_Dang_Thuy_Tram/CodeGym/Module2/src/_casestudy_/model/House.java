package ab.model;

public class House extends Services {
    private String roomType;
    private String compService;
    private int floor;

    public House() {
    }

    public House(String roomType, String compService, int floor) {
        this.roomType = roomType;
        this.compService = compService;
        this.floor = floor;
    }

    public House(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String roomType, String compService, int floor) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.roomType = roomType;
        this.compService = compService;
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCompService() {
        return compService;
    }

    public void setCompService(String compService) {
        this.compService = compService;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String showInfo() {
        return "House \n" +
                "id='" + getId() + "'\n" +
                "serviceName='" + getServiceName() + "'\n" +
                "area=" + getArea() + "'\n" +
                "rate=" + getRate() + "'\n" +
                "maxCapacity=" + getMaxCapacity() + "'\n" +
                "rentType='" + getRentType() + "'\n" +
                "roomType='" + roomType + "'\n" +
                "compService='" + compService + "'\n" +
                "floor=" + floor;
    }

    public String writeToCSV() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + roomType +
                "," + compService +
                "," + floor;
    }

    public String getHeader() {
        return "House Id,Service Name,Area,Rate,Max Capacity,Rent Type,Room Type,Comp Service,floor";
    }

    @Override
    public String toString() {
        return "House: \n" +
                "id='" + getId() + "'\n" +
                "serviceName='" + getServiceName() + "'\n" +
                "area=" + getArea() + "'\n" +
                "rate=" + getRate() + "'\n" +
                "maxCapacity=" + getMaxCapacity() + "'\n" +
                "rentType='" + getRentType() + "'\n" +
                "roomType='" + roomType + "'\n" +
                "compService='" + compService + "'\n" +
                "floor=" + floor + "'\n" ;
    }
}

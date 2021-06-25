package ab.model;

public class Villa extends Services{
    private String roomType;
    private String otherService;
    private double poolArea;
    private int floorNumber;

    public Villa() {
    }

    public Villa(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String roomType, String compService, double poolArea, int floor) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.roomType = roomType;
        this.otherService = compService;
        this.poolArea = poolArea;
        this.floorNumber = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String showInfo() {
        return "Villa: \n" +
                "id='" + getId() + "'\n" +
                "serviceName='" + getServiceName() + "'\n" +
                "area=" + getArea() + "'\n" +
                "rate=" + getRate() + "'\n" +
                "maxCapacity=" + getMaxCapacity() +"'\n" +
                "rentType='" + getRentType() + "'\n" +
                "roomType='" + roomType + "'\n" +
                "compService='" + otherService + "'\n" +
                "poolArea=" + poolArea + "'\n" +
                "floor=" + floorNumber + "'\n";
    }

    @Override
    public String writeToCSV() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + roomType +
                "," + otherService +
                "," + poolArea +
                "," + floorNumber;
    }


    public String getHeader() {
        return "Villa Id,Service Name,Area,Rate,Max Capacity,Rent Type,Room Type,Comp Service,Pool Area,floor";
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\'' +
                ", roomType='" + roomType + '\'' +
                ", compService='" + otherService + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floorNumber +
                '}';
    }
}

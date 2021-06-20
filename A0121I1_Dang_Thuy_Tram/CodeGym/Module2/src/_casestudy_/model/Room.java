package _casestudy_.model;

public class Room extends Services {
    private String otherService;

    public Room() {
    }

    public Room(String compServices) {
        this.otherService = compServices;
    }

    public Room(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String compServices) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.otherService = compServices;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    @Override
    public String showInfo() {
        return  "Room: \n" +
                "id='" + getId() + "'\n" +
                "serviceName='" + getServiceName() + "'\n" +
                "area=" + getArea() + "'\n" +
                "rate=" + getRate() + "'\n" +
                "maxCapacity=" + getMaxCapacity() + "'\n" +
                "rentType='" + getRentType() + "'\n" +
                "compServices='" + otherService + "'\n" ;
    }



    public String writeToCSV() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + otherService;
    }

    public String getHeader() {
        return "Room Id,Service Name,Area,Rate,Max Capacity,Rent Type,Comp Services";
    }

    @Override
    public String toString() {
        return  "Room{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\''+
                ", compServices='" + otherService + '\''+
                '}';
    }
}

package _casestudy_.model;

public class Service {
    private String nameService;
    private int usedArea;
    private int costRent;
    private int maxMember;
    private String rentType;
    private String id;
    private String plusService; //dich vu di kem

    public Service() {
    }

    public Service(String nameService, int usedArea, int costRent, int maxMember, String rentType, String id, String plusServices) {
        this.nameService = nameService;
        this.usedArea = usedArea;
        this.costRent = costRent;
        this.maxMember = maxMember;
        this.rentType = rentType;
        this.id = id;
        this.plusService = plusServices;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(int usedArea) {
        this.usedArea = usedArea;
    }

    public int getCostRent() {
        return costRent;
    }

    public void setCostRent(int costRent) {
        this.costRent = costRent;
    }

    public int getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(int maxMember) {
        this.maxMember = maxMember;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlusService() {
        return plusService;
    }

    public void setPlusService(String plusService) {
        this.plusService = plusService;
    }

}

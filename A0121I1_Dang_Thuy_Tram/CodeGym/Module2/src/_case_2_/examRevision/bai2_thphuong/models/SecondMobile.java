package _case_2_.examRevision.bai2_thphuong.models;

public class SecondMobile extends Mobile {
    private String fromNation;
    private String status;

    public SecondMobile(int id, String name, int price, int quantity, String brand, String fromNation, String status) {
        super(id, name, price, quantity, brand);
        this.fromNation = fromNation;
        this.status = status;
    }

    public String getFromNation() {
        return fromNation;
    }

    public void setFromNation(String fromNation) {
        this.fromNation = fromNation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "SecondMobile{" +
                "id=" + super.getId() + '\'' +
                ", name='" +super.getName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", quantity=" + super.getQuantity() +'\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", fromNation='" + fromNation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

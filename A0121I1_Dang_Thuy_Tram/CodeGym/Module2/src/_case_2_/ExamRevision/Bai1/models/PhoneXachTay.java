package _case_2_.ExamRevision.Bai1.models;

public class PhoneXachTay extends SmartPhone{
    private String quocGia;
    private String trangThai;

    public PhoneXachTay(int id, String ten, int gia, int soLuong, String nhaSanXuat, String quocGia, String trangThai) {
        super(id, ten, gia, soLuong, nhaSanXuat);
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public PhoneXachTay() {
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PhoneXachTay{" +
                "id=" + super.getId() + '\'' +
                ", name='" +super.getTen() + '\'' +
                ", price=" + super.getGia() + '\'' +
                ", quantity=" + super.getSoLuong() +'\'' +
                ", brand='" + super.getNhaSanXuat() + '\'' +
                ", fromNation='" + quocGia + '\'' +
                ", status='" + trangThai + '\'' +
                '}';
    }
}

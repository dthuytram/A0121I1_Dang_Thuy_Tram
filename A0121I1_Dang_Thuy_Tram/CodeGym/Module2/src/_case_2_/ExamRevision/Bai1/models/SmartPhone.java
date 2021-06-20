package _case_2_.ExamRevision.Bai1.models;

public abstract class SmartPhone {
    private int id;
    private String ten;
    private int gia;
    private int soLuong;
    private String nhaSanXuat;

    public SmartPhone() {
    }

    public SmartPhone(int id, String ten, int gia, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract void showInfor();

    @Override
    public String toString(){
        return "SmartPhone{" +
                "id=" + id +
                ", name='" + ten + '\'' +
                ", value=" + gia +
                ", soLuong=" + soLuong +
                ", nhaSX='" + nhaSanXuat + '\'' +
                '}';
    }
}

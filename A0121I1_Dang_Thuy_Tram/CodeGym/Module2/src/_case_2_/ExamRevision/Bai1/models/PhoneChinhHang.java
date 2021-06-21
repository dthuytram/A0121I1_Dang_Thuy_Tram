package _case_2_.ExamRevision.Bai1.models;

public class PhoneChinhHang extends SmartPhone{
    private int thoigianBaoHanh;
    private String phamviBaoHanh;

    public PhoneChinhHang(int id, String ten, int gia, int soLuong, String nhaSanXuat, int thoigianBaoHanh, String phamviBaoHanh) {
        super(id, ten, gia, soLuong, nhaSanXuat);
        this.thoigianBaoHanh = thoigianBaoHanh;
        this.phamviBaoHanh = phamviBaoHanh;
    }

    public int getThoigianBaoHanh() {
        return thoigianBaoHanh;
    }

    public void setThoigianBaoHanh(int thoigianBaoHanh) {
        this.thoigianBaoHanh = thoigianBaoHanh;
    }

    public String getPhamviBaoHanh() {
        return phamviBaoHanh;
    }

    public void setPhamviBaoHanh(String phamviBaoHanh) {
        this.phamviBaoHanh = phamviBaoHanh;
    }
    @Override
    public String toString() {
        return "BrandMobile{" +
                "id=" + super.getId() + '\'' +
                ", name='" +super.getTen() + '\'' +
                ", price=" + super.getGia() + '\'' +
                ", quantity=" + super.getSoLuong() +'\'' +
                ", brand='" + super.getNhaSanXuat() + '\'' +
                ", timeGuarantee=" + thoigianBaoHanh +'\'' +
                ", rangeGuarante='" + phamviBaoHanh + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}



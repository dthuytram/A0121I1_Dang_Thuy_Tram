package _case_2_.examRevision.bai1_mxduy.models;

public class SoTietKiemDaiHan extends SoTietKiem {
    private String kyHan;
    private String uuDai;

    public SoTietKiemDaiHan() {
        super();
    }

    public SoTietKiemDaiHan(String maSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, String soTienGui, String laiSuat) {
        super(maSo, maKhachHang, ngayMoSo, thoiGianBatDauGui, soTienGui, laiSuat);
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return super.toString() + "," + kyHan + "," + uuDai;
    }

}

package _case_2_.examRevision.bai1_mxduy.models;

public abstract class SoTietKiem {
    private String maSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoigianBatDauGui;
    private String soTienGui;
    private String laiSuat;

    public SoTietKiem() {
    }

    public SoTietKiem(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat) {
        this.maSo = maso;
        this.maKhachHang = maKH;
        this.ngayMoSo = ngaymoso;
        this.thoigianBatDauGui = ngaybatdau;
        this.soTienGui = sotiengui;
        this.laiSuat = laisuat;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoigianBatDauGui() {
        return thoigianBatDauGui;
    }

    public void setThoigianBatDauGui(String thoigianBatDauGui) {
        this.thoigianBatDauGui = thoigianBatDauGui;
    }


    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }


    @Override
    public String toString() {
        return "stk_daihan{" +
                "maso='" + maSo + '\'' +
                ", maKH='" + maKhachHang + '\'' +
                ", ngaymoso='" + ngayMoSo + '\'' +
                ", ngaybatdau='" + thoigianBatDauGui + '\'' +
                ", sotiengui='" + soTienGui + '\'' +
                ", laisuat='" + laiSuat + '\'' +
                '}';
    }
}

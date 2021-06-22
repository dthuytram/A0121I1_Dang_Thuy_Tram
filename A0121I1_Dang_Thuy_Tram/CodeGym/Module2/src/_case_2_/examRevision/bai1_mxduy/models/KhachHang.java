package _case_2_.examRevision.bai1_mxduy.models;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String diaChi;

    public KhachHang(String maKH, String tenKH, String ngaysinh, String gioitinh, String sdt, String diachi) {
        this.maKhachHang = maKH;
        this.tenKhachHang = tenKH;
        this.ngaySinh = ngaysinh;
        this.gioiTinh = gioitinh;
        this.soDienThoai = sdt;
        this.diaChi = diachi;
    }

    public KhachHang() {

    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "khachhang{" +
                "maKH='" + maKhachHang + '\'' +
                ", tenKH='" + tenKhachHang + '\'' +
                ", ngaysinh='" + ngaySinh + '\'' +
                ", gioitinh='" + gioiTinh + '\'' +
                ", sdt='" + soDienThoai + '\'' +
                ", diachi='" + diaChi + '\'' +
                '}';
    }
}

package bean;

public class ThongTinTiecCuoi {
    private int id;
    private String ngayToChuc;
    private String tenCoDau;
    private String tenChuRe;
    private int soLuongBan;
    private int donGia;
    private int dichVuDiKem;
    private int tenNoDatCoc;
    private int tienNoThanhToan;
    private String ngayDatCoc;
    private String ngayThanhToan;
    private String ghiChu;
    private String trangThai;

    public ThongTinTiecCuoi(String ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tenNoDatCoc, int tienNoThanhToan, String ngayDatCoc, String ngayThanhToan, String ghiChu, String trangThai) {
        this.ngayToChuc = ngayToChuc;
        this.tenCoDau = tenCoDau;
        this.tenChuRe = tenChuRe;
        this.soLuongBan = soLuongBan;
        this.donGia = donGia;
        this.dichVuDiKem = dichVuDiKem;
        this.tenNoDatCoc = tenNoDatCoc;
        this.tienNoThanhToan = tienNoThanhToan;
        this.ngayDatCoc = ngayDatCoc;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public ThongTinTiecCuoi(int id, String ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tenNoDatCoc, int tienNoThanhToan, String ngayDatCoc, String ngayThanhToan, String ghiChu, String trangThai) {
        this.id = id;
        this.ngayToChuc = ngayToChuc;
        this.tenCoDau = tenCoDau;
        this.tenChuRe = tenChuRe;
        this.soLuongBan = soLuongBan;
        this.donGia = donGia;
        this.dichVuDiKem = dichVuDiKem;
        this.tenNoDatCoc = tenNoDatCoc;
        this.tienNoThanhToan = tienNoThanhToan;
        this.ngayDatCoc = ngayDatCoc;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public String getTenCoDau() {
        return tenCoDau;
    }

    public void setTenCoDau(String tenCoDau) {
        this.tenCoDau = tenCoDau;
    }

    @Override
    public String toString() {
        return "ThongtinTiecCuoi{" +
                "id=" + id +
                ", NgayToChuc='" + ngayToChuc + '\'' +
                ", tenCoDau='" + tenCoDau + '\'' +
                ", tenChuRe='" + tenChuRe + '\'' +
                ", soLuongBan=" + soLuongBan +
                ", donGia=" + donGia +
                ", dichVuDiKem=" + dichVuDiKem +
                ", tenNoDatCoc=" + tenNoDatCoc +
                ", TienNoThanhToan=" + tienNoThanhToan +
                ", ngayDatCoc='" + ngayDatCoc + '\'' +
                ", NgayThanhToan='" + ngayThanhToan + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

    public String getTenChuRe() {
        return tenChuRe;
    }

    public void setTenChuRe(String tenChuRe) {
        this.tenChuRe = tenChuRe;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(int dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public int getTenNoDatCoc() {
        return tenNoDatCoc;
    }

    public void setTenNoDatCoc(int tenNoDatCoc) {
        this.tenNoDatCoc = tenNoDatCoc;
    }

    public int getTienNoThanhToan() {
        return tienNoThanhToan;
    }

    public void setTienNoThanhToan(int tienNoThanhToan) {
        this.tienNoThanhToan = tienNoThanhToan;
    }

    public String getNgayDatCoc() {
        return ngayDatCoc;
    }

    public void setNgayDatCoc(String ngayDatCoc) {
        this.ngayDatCoc = ngayDatCoc;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

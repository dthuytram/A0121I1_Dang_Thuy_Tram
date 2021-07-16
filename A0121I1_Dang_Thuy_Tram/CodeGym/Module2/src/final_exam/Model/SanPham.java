package final_exam.Model;

public abstract class SanPham {
    private String idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private String giaBan;
    private String soLuong;
    private String nhaSanXuat;

    public SanPham(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat) {
        this.idSanPham = id;
        this.maSanPham = masp;
        this.tenSanPham = ten;
        this.giaBan = giaban;
        this.soLuong = soluong;
        this.nhaSanXuat = nhasanxuat;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}

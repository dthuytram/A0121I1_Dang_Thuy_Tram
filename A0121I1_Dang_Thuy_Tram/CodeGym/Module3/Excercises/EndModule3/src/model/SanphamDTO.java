package model;

public class SanphamDTO {
    private String id_sanpham;
    private String ten_sanpham;
    private float gia;
    private int soluong;
    private String mausac;
    private String mota;
    private String id_loai;
    private String ten_loai;

    public SanphamDTO() {
    }

    public SanphamDTO(String id_sanpham, String ten_sanpham, float gia, int soluong, String mausac, String mota, String id_loai, String ten_loai) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.gia = gia;
        this.soluong = soluong;
        this.mausac = mausac;
        this.mota = mota;
        this.id_loai = id_loai;
        this.ten_loai = ten_loai;
    }

    public String getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(String id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public void setTen_sanpham(String ten_sanpham) {
        this.ten_sanpham = ten_sanpham;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getId_loai() {
        return id_loai;
    }

    public void setId_loai(String id_loai) {
        this.id_loai = id_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
}

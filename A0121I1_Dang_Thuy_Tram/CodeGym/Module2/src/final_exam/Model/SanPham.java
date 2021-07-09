package final_exam.Model;

public abstract class SanPham {
    private String id;
    private String masp;
    private String ten;
    private String giaban;
    private String soluong;
    private String nhasanxuat;

    public SanPham(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat) {
        this.id = id;
        this.masp = masp;
        this.ten = ten;
        this.giaban = giaban;
        this.soluong = soluong;
        this.nhasanxuat = nhasanxuat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }
}

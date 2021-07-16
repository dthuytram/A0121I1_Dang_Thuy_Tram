package final_exam.Model;

public class SanPhamNhapKhau extends SanPham {
    private String giaNhapKhau;
    private String tinhThanhNhap;
    private String thueNhapKhau;

    public SanPhamNhapKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat) {
        super(id, masp, ten, giaban, soluong, nhasanxuat);
    }

    public SanPhamNhapKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat, String giaNhapKhau, String tinhThanhNhap, String thueNhapKhau) {
        super(id, masp, ten, giaban, soluong, nhasanxuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }



    public String getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(String giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public String getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(String thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return getIdSanPham()+","+ getMaSanPham()+","+ getTenSanPham()+","+ getGiaBan()+","+ getSoLuong()+","+ getNhaSanXuat()+","
                +getGiaNhapKhau()+","+getTinhThanhNhap()+","+getThueNhapKhau();
    }
}

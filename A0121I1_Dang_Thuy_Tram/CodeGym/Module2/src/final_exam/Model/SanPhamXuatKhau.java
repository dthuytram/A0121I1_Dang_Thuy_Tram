package final_exam.Model;

public class SanPhamXuatKhau extends SanPham{
  private String giaXuatKhau;
  private String quocGiaNhap;
  public SanPhamXuatKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat) {
    super(id, masp, ten, giaban, soluong, nhasanxuat);
  }

  public SanPhamXuatKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat, String giaXuatKhau, String quocGia) {
    super(id, masp, ten, giaban, soluong, nhasanxuat);
    this.giaXuatKhau = giaXuatKhau;
    this.quocGiaNhap = quocGia;
  }

  public String getGiaXuatKhau() {
    return giaXuatKhau;
  }

  public void setGiaXuatKhau(String giaXuatKhau) {
    this.giaXuatKhau = giaXuatKhau;
  }

  public String getQuocGiaNhap() {
    return quocGiaNhap;
  }

  public void setQuocGiaNhap(String quocGiaNhap) {
    this.quocGiaNhap = quocGiaNhap;
  }

  @Override
  public String toString() {
    return getIdSanPham()+","+ getMaSanPham()+","+ getTenSanPham()+","+ getGiaBan()+","+ getSoLuong()+","+ getNhaSanXuat()+","
            +getGiaXuatKhau()+","+ getQuocGiaNhap();
  }
}

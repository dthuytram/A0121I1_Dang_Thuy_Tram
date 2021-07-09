package final_exam.Model;

public class SPXuatKhau  extends SanPham{
  private String giaXuatKhau;
  private String quocGia;
  public SPXuatKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat) {
    super(id, masp, ten, giaban, soluong, nhasanxuat);
  }

  public SPXuatKhau(String id, String masp, String ten, String giaban, String soluong, String nhasanxuat, String giaXuatKhau, String quocGia) {
    super(id, masp, ten, giaban, soluong, nhasanxuat);
    this.giaXuatKhau = giaXuatKhau;
    this.quocGia = quocGia;
  }

  public String getGiaXuatKhau() {
    return giaXuatKhau;
  }

  public void setGiaXuatKhau(String giaXuatKhau) {
    this.giaXuatKhau = giaXuatKhau;
  }

  public String getQuocGia() {
    return quocGia;
  }

  public void setQuocGia(String quocGia) {
    this.quocGia = quocGia;
  }

  @Override
  public String toString() {
    return getId()+","+getMasp()+","+getTen()+","+getGiaban()+","+getSoluong()+","+getNhasanxuat()+","
            +getGiaXuatKhau()+","+getQuocGia();
  }
}

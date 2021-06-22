package _case_2_.examRevision.bai1_mxduy.models;

public class SoTietKiemVoThoiHan extends SoTietKiem {

    public SoTietKiemVoThoiHan() {
    }

    public SoTietKiemVoThoiHan(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat) {
        super(maso, maKH, ngaymoso, ngaybatdau, sotiengui, laisuat);
    }

    @Override
    public String toString() {
        return "stk_nganhan_vothoihan{ " + super.toString();
    }
}

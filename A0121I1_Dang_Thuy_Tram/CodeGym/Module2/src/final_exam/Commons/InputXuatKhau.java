package final_exam.Commons;

import final_exam.Model.SanPhamXuatKhau;
import final_exam.exception.NotFoundProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputXuatKhau {
    private Validator regex;
    private Scanner sc;
    private ReadWriteFile readWriteFile;
    private String XUATKHAULINK = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\final_exam\\data\\XuatKhau.csv";
    private List<SanPhamXuatKhau> xuatkhauList;
    private InputSanPham commonService;

    public InputXuatKhau() {
        regex = new Validator();
        sc = new Scanner(System.in);
        readWriteFile = new ReadWriteFile();
        xuatkhauList = new ArrayList<>();
        commonService = new InputSanPham();
        getListXuatKhau();
    }

    public List<SanPhamXuatKhau> getListXuatKhau() {
        String[] nhapKhauList = new String[0];
        nhapKhauList = readWriteFile.readFile(XUATKHAULINK).split("\n");
        for (int i = 0; i < nhapKhauList.length; i++) {
            String[] temp = nhapKhauList[i].split(",");
            xuatkhauList.add(new SanPhamXuatKhau(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]));
        }
        return xuatkhauList;
    }

    public void showXuatKhau() {
        xuatkhauList.forEach(x -> System.out.println(x.toString()));
    }

    public List<SanPhamXuatKhau> getXuatkhauList() {
        return xuatkhauList;
    }

    public void capNhatXuatKhau() {
        String data = "";
        for (int i = 0; i < xuatkhauList.size(); i++) {
            xuatkhauList.get(i).setIdSanPham((i + 1) + "");
            data += xuatkhauList.get(i).toString() + "\n";
        }
        readWriteFile.writeFile(XUATKHAULINK, data, false);
    }

    public void inputNewXuatKhau() {
        System.out.println("Welcome xuat");
        String giaXuatKhau;
        String quocGia;

        System.out.println("-------------------------------------------------");
        System.out.println("Thêm sản phẩm Nhập Khẩu  : ");
        SanPhamXuatKhau newXuatKhau = (SanPhamXuatKhau) commonService.inputSanPham(2);
        System.out.println("Nhap gia xuat khau");
        giaXuatKhau = sc.nextLine();
        while (!regex.validateNumber(giaXuatKhau)) {
            System.out.println("Vui long nhap lai");
            giaXuatKhau = (sc.nextLine());
        }
        ;

        System.out.println("Nhap quoc gia san pham");
        quocGia = sc.nextLine();
        newXuatKhau.setGiaXuatKhau(giaXuatKhau);
        newXuatKhau.setQuocGiaNhap(quocGia);
        newXuatKhau.setIdSanPham(xuatkhauList.size() + 1 + "");
        newXuatKhau.setMaSanPham("XK0000" + xuatkhauList.size() + 1 + "");
        readWriteFile.writeFile(XUATKHAULINK, newXuatKhau.toString(), true);

    }

    public void searchXuatKhau() throws NotFoundProduct {
        List<SanPhamXuatKhau> ListResult = new ArrayList<>();
        System.out.println("Id muon tim la: ");
        String key = sc.nextLine();
        for (SanPhamXuatKhau nhapkhau : xuatkhauList) {
            if (nhapkhau.getMaSanPham().contains(key)) {
                ListResult.add(nhapkhau);
            }
            else
            {   System.out.println("Not found");}
        }
        ListResult.forEach(x -> System.out.println(x.toString()));
    }

    public void deleteXuatKhau() throws NotFoundProduct {
        System.out.println("NHAP Ma san pham can xoa");
        String maSP = sc.nextLine();
        for (int i = 0; i < xuatkhauList.size(); i++) {
            if (xuatkhauList.get(i).getMaSanPham().equals(maSP)) {

                System.out.println("Muon xoa san pham khong");
                System.out.println("co hoac khong");
                String option = sc.nextLine();
                if (option.equals("co")) {
                    xuatkhauList.remove(i);
                    capNhatXuatKhau();
                    System.out.println("Danh sach sau khi xoa: ");
                    showXuatKhau();
                }
            }
            else {
                System.out.println("Not found");
            }
        }
    }
}

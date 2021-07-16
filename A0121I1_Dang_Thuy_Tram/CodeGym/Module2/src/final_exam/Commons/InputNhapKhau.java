package final_exam.Commons;

import final_exam.Model.SanPhamNhapKhau;
import final_exam.exception.NotFoundProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputNhapKhau {
    private Validator validator;
    private Scanner sc;
    private ReadWriteFile readWriteFile;
    private final String NHAPKHAU_PATH = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\final_exam\\data\\NhapKhau.csv";
    private List<SanPhamNhapKhau> nhapKhauList;
    private InputSanPham input;

    public InputNhapKhau() {
        validator = new Validator();
        sc = new Scanner(System.in);
        readWriteFile = new ReadWriteFile();
        nhapKhauList = new ArrayList<>();
        input = new InputSanPham();
        getListNhapKhau();
    }

    public List<SanPhamNhapKhau> getListNhapKhau() {
        String[] nhapKhauList = new String[0];
        nhapKhauList = readWriteFile.readFile(NHAPKHAU_PATH).split("\n");
        for (int i = 0; i < nhapKhauList.length; i++) {
            String[] temp = nhapKhauList[i].split(",");
            this.nhapKhauList.add(new SanPhamNhapKhau(temp[0], temp[1], temp[2], temp[3],
                    temp[4], temp[5], temp[6], temp[7], temp[8]));
        }
        return this.nhapKhauList;
    }

    public void showNhapKhau() {
        nhapKhauList.forEach(x -> System.out.println(x.toString()));
    }

    public List<SanPhamNhapKhau> getNhapKhauList() {
        return nhapKhauList;
    }

    public void inputNewNhapKhau() {
        System.out.println("Welcome nhap");
        showNhapKhau();
        String giaNhapKhau;
        String tinhThanhNhap;
        String thueNhapKhau;

        System.out.println("-------------------------------------------------");
        System.out.println("Thêm sản phẩm Nhập Khẩu moi  : ");
        SanPhamNhapKhau nhapKhauMoi = (SanPhamNhapKhau) input.inputSanPham(1);
        System.out.println("Nhap gia nhap khau");
        giaNhapKhau = sc.nextLine();
        while (!validator.validateNumber(giaNhapKhau)) {
            System.out.println("Vui long nhap lai");
            giaNhapKhau = (sc.nextLine());
        }
        System.out.println("Nhap tinh thành nhập");
        tinhThanhNhap = sc.nextLine();
        System.out.println("Nhập thuế nhập khẩu");
        thueNhapKhau = sc.nextLine();
        while (!validator.validateNumber(thueNhapKhau)) {
            System.out.println("Vui long nhap lai");
            thueNhapKhau = (sc.nextLine());
        }
        nhapKhauMoi.setGiaNhapKhau(giaNhapKhau);
        nhapKhauMoi.setTinhThanhNhap(tinhThanhNhap);
        nhapKhauMoi.setThueNhapKhau(thueNhapKhau);
        nhapKhauMoi.setIdSanPham(nhapKhauList.size() + 1 + "");
        nhapKhauMoi.setMaSanPham("SP000" + nhapKhauList.size() + 1 + "");
        readWriteFile.writeFile(NHAPKHAU_PATH, nhapKhauMoi.toString(), true);

    }

    public void updateData() {
        String data = "";
        for (int i = 0; i < nhapKhauList.size(); i++) {
            nhapKhauList.get(i).setIdSanPham((i + 1) + "");
            data += nhapKhauList.get(i).toString() + "\n";
        }
        readWriteFile.writeFile(NHAPKHAU_PATH, data, false);
    }

    public void searchNhapKhau() throws NotFoundProduct {
        List<SanPhamNhapKhau> ListResult = new ArrayList<>();
        System.out.println("Input key you want to search ");
        String key = sc.nextLine();
        for (SanPhamNhapKhau nhapkhau : nhapKhauList) {
            if (nhapkhau.getMaSanPham().contains(key)) {
                ListResult.add(nhapkhau);
            } else {
                System.out.println("Not found");

            }
        }
        ListResult.forEach(x -> System.out.println(x.toString()));
    }

    public void deleteNhapKhau() throws NotFoundProduct {
        System.out.println("NHAP Ma san pham can xoa");
        String maSP = sc.nextLine();
        boolean isFound = false;
        for (int i = 0; i < nhapKhauList.size(); i++) {

            if (nhapKhauList.get(i).getMaSanPham().equals(maSP)) {
                isFound = true;
                System.out.println("Co san pham");
                System.out.println("yes or no");
                String option = sc.nextLine();
                if (option.equals("yes")) {
                    nhapKhauList.remove(i);
                    updateData();
                    showNhapKhau();
                }
            }

            }
        if(!isFound){
            throw new NotFoundProduct("Not Found");
        }
    }
}

package final_exam.Commons;

import final_exam.Model.SanPhamNhapKhau;
import final_exam.Model.SanPhamXuatKhau;
import final_exam.Model.SanPham;

import java.util.List;
import java.util.Scanner;

public class InputSanPham {
    private static Validator validator;
    private List<SanPhamNhapKhau> nhapKhauList;
    static {
        validator = new Validator();
    }


    public SanPham inputSanPham(int loai) {
        System.out.println("Welcome san");
        String id = null;
        String maSanPham = null;
        String tenSanPham;
        String giaBan;
        String soLuong;
        String nhaSanXuat;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tenSanPham: ");
        tenSanPham = sc.nextLine();

        System.out.println("Nhap gia ban: ");
        giaBan = sc.nextLine();
        while (!validator.validateNumber(giaBan)) {
            System.out.println("Vui long nhap lai");
            giaBan = (sc.nextLine());
        }
        ;
        System.out.println("Nhap soLuong: ");
        soLuong = sc.nextLine();

        while (!validator.validateNumber(soLuong)) {
            System.out.println("Vui long nhap lai");
            soLuong = (sc.nextLine());
        }
        ;
        System.out.println("Nhap nha san xuat: ");
        nhaSanXuat = sc.nextLine();
        switch (loai) {
            case 1:
                return new SanPhamNhapKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
            case 2:
                return new SanPhamXuatKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        }
        return null;
    }

    ;


}

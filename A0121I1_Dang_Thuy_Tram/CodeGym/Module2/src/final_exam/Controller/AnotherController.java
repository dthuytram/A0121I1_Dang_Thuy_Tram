package final_exam.Controller;

import final_exam.exception.NotFoundProduct;

import java.util.Scanner;

import static final_exam.Controller.MainController.inputNhapKhau;
import static final_exam.Controller.MainController.inputXuatKhau;

public class AnotherController {
    static Scanner sc = new Scanner(System.in);
    public static void themMoiSanPham(){
        System.out.println(
                "1. Them san pham Nhap Khau\n" +
                        "2. Them san xuat Xuat Khau\n" +
                        "Moi nhap lua chon: \n");
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                inputNhapKhau.inputNewNhapKhau();
                break;
            case 2:
                inputXuatKhau.inputNewXuatKhau();
        }
    }

    public static void xoaSanPham(){
        System.out.println(
                "1. Xoa san pham Nhap Khau\n" +
                        "2. Xoa san xuat Xuat Khau\n" +
                        "Moi nhap lua chon: \n");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                try {
                    inputNhapKhau.deleteNhapKhau();
                } catch (NotFoundProduct notFoundProduct) {
                    notFoundProduct.printStackTrace();
                }
                break;
            case 2:
                try {
                    inputXuatKhau.deleteXuatKhau();
                } catch (NotFoundProduct notFoundProduct) {
                    notFoundProduct.printStackTrace();
                }
                break;
        }
    }
    public static void timkiemSanPham(){
        System.out.println(
                "1. Tim san pham nhap khau\n" +
                        "2. Tim san xuat khau\n" +
                        "Moi nhap lua chon: \n");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                try {
                    inputNhapKhau.searchNhapKhau();
                } catch (NotFoundProduct notFoundProduct) {
                    notFoundProduct.printStackTrace();
                }
                break;
            case 2:
                try {
                    inputXuatKhau.searchXuatKhau();
                } catch (NotFoundProduct notFoundProduct) {
                    notFoundProduct.printStackTrace();
                }
        }
    }
    public static void xemSanPham(){
        System.out.println(
                "1. Xem san pham Nhap Khau\n" +
                        "2. Xem san pham Xuat Khau\n" +
                        "Moi nhap lua chon: \n");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                inputNhapKhau.showNhapKhau();
                break;
            case 2:
                inputXuatKhau.showXuatKhau();
        }
    }
}

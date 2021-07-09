package abab.examRevision.bai1_mxduy.controller;

import abab.examRevision.bai1_mxduy.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static List<SoTietKiem> listSotietKiemDaiHan = new ArrayList<>();
    static List<SoTietKiem> ListSotietKiemVoThoiHan = new ArrayList<>();
    static List<KhachHang> khachHangList = new ArrayList<>();

    public static void displayMainMenu() {
        System.out.println("=========== MAIN MENU ===========");
        System.out.println("1. Them moi so tiet kiem");
        System.out.println("2. Xoa so tiet kiem");
        System.out.println("3. Xem danh sach so tiet kiem");
        System.out.println("4. Xem thong tin khach hang");
        System.out.println("5. Tim kiem so tiet kiem");
        System.out.println("6. Exit");
        System.out.println("=================================");
        System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {
                Num1_ThemMoiSoTietKiem.themMoiSoTietKiem();
                break;
            }
            case "2": {
                Num2_XoaSoTietKiem.xoaSoTietKiem();
                break;
            }
            case "3": {
                Num3_DanhSachSoTietKiem.danhSachSoTietKiem();
                break;
            }
            case "4": {
                Num4_XemThongTinKhach.xemThongtinKhachHang();
                break;
            }
            case "5": {
                Num5_TimKiemSoTietKiem.timKiemSotietKiem();
                break;
            }
            case "6": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                input.nextLine();
                displayMainMenu();
            }
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}

package final_exam.Controller;

import final_exam.Commons.*;

import java.util.Scanner;

import static final_exam.Controller.AnotherController.*;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    public static InputNhapKhau inputNhapKhau;
    public static InputXuatKhau inputXuatKhau;
    static int choice ;
    static {
        inputNhapKhau = new InputNhapKhau();
        inputXuatKhau = new InputXuatKhau();
    }

    public static void main(String[] args) {
        displayMenu();

    }

    public static void displayMenu() {
        System.out.println(choice);
        while (choice <= 4) {
            System.out.println(
                    " ------------ CHUONG TRINH QUAN LI SAN PHAM --------------------\n" +
                            "Chon chuc nang theo so (de tiep tuc): \n" +
                            "1. Thêm mới\n" +
                            "2. Xóa\n" +
                            "3. Xem danh sách sản phẩm\n" +
                            "4. Tìm kiếm\n" +
                            "5. Thoát\n");

            Scanner sc = new Scanner(System.in);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    themMoiSanPham();
                    displayMenu();
                    break;
                case 2:
                    xoaSanPham();
                    displayMenu();
                    break;
                case 3:
                    xemSanPham();
                    break;
                case 4:
                    timkiemSanPham();
                    displayMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }
}

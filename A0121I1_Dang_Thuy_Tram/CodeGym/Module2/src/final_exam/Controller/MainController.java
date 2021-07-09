package final_exam.Controller;

import final_exam.Service.NhapKhauService;
import final_exam.Service.XuatKhauService;

import java.util.Scanner;

public class MainController {
    private static NhapKhauService nhapKhauService;
    private static XuatKhauService xuatKhauService;
    static{
        nhapKhauService = new NhapKhauService();
        xuatKhauService = new XuatKhauService();

    }
    public static void main(String[] args) {
        displayMenu();
    }
    private static void addNew(){
        System.out.println(
                "1. Them san pham nhap khau\n" +
                        "2. them san xuat khau\n" );
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                nhapKhauService.inputNewNhapKhau();
                break;
            case 2:
                xuatKhauService.inputNewXuatKhau();
        }
    }

    private static void delete(){
        System.out.println(
                "1. xoa san pham nhap khau\n" +
                        "2. xoasan xuat khau\n" );
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                nhapKhauService.deleteNhapKhau();
                break;
            case 2:
                xuatKhauService.deleteXuatKhau();
        }
    }
    private static void search(){
        System.out.println(
                "1. tim san pham nhap khau\n" +
                        "2. tim san xuat khau\n" );
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                nhapKhauService.searchNhapKhau();
                break;
            case 2:
                xuatKhauService.deleteXuatKhau();
        }
    }
    private static void view(){
        System.out.println(
                "1. tim san pham nhap khau\n" +
                        "2. tim san xuat khau\n" );
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                nhapKhauService.view();
                break;
            case 2:
                xuatKhauService.view();
        }
    }
    private static void displayMenu()  {

        System.out.println(
                "!-----------MENU----------!\n"+
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách sản phẩm\n" +
                        "4. Tìm kiếm\n" +
                        "5. Thoát\n" );

        Scanner sc = new Scanner(System.in);
        int choice =Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                addNew();
                displayMenu();
                break;
            case 2:
               delete();
               displayMenu();
                break;
            case 3:
                view();
                break;
            case 4:
                search();
                displayMenu();

                break;
            case 5:
//                addNewBooking();

                break;


        }

    }
}

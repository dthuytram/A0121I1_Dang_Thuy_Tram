package _case_2_.ExamRevision.Bai1.controllers;

import _case_2_.ExamRevision.Bai1.models.PhoneChinhHang;
import _case_2_.ExamRevision.Bai1.models.PhoneXachTay;

import java.util.Scanner;

import static _case_2_.ExamRevision.Bai1.commons.FileUtils.*;

public class MainController {
    public static void main(String[] args) {
        int id = 0;
        String name;
        int price;
        int quantity;
        String brand;
        int timeGuarantee;
        String rangeGuarante;
        PhoneChinhHang brandMobile;
        PhoneXachTay secondMobile;
        String fromNation;
        String status;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("--CHUONG TRINH QUAN LY DIEN THOAI--");
            System.out.println("1. Them moi");
            System.out.println("2. Xoa");
            System.out.println("3. Xem danh sach dien thoai");
            System.out.println("4. Tim kiem");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang (main): ");
            int mainchoice = scanner.nextInt();
            switch (mainchoice) {
                case 1:
                    do {
                        System.out.println("1. Them moi dien thoai chinh hang");
                        System.out.println("2. Them moi dien thoai xach tay");
                        System.out.println("3. Tro ve menu chinh");
                        System.out.print("Chon chuc nang: ");
                        int subchoice = scanner.nextInt();
                        if (subchoice == 1) {
                            id = getIdLastBrandMobile() + 1;
                        } else if (subchoice == 2) {
                            id = getIdLastSecondMobile() + 1;
                        }
                        if ((subchoice == 1) || (subchoice == 2)) {
                            //System.out.println("Nhap id");
                            //id = scanner.nextInt();
                            System.out.print("Nhap ten dien thoai: ");
                            scanner.nextLine();
                            name = scanner.nextLine();
                            System.out.print("Nhap gia dien thoai:");
                            price = scanner.nextInt();
                            System.out.print("Nhap so luong: ");
                            quantity = scanner.nextInt();
                            System.out.print("Nhap hang: ");
                            scanner.nextLine();
                            brand = scanner.nextLine();
                            if (subchoice == 1) {
                                System.out.print("Nhap thoi gian bao hanh: ");
                                timeGuarantee = scanner.nextInt();
                                System.out.print("Nhap pham vi bao hanh: ");
                                scanner.nextLine();
                                rangeGuarante = scanner.nextLine();
                                brandMobile = new PhoneChinhHang(id, name, price, quantity, brand, timeGuarantee, rangeGuarante);
                                //Ghi file
                                writeBrandMobile(brandMobile);
                            } else {
                                System.out.print("Nhap quoc gia xach tay: ");
                                fromNation = scanner.nextLine();
                                System.out.print("Nhap trang thai: ");
                                status = scanner.nextLine();
                                secondMobile = new PhoneXachTay(id, name, price, quantity, brand, fromNation, status);
                                //Ghi file
                                writeSecondMobile(secondMobile);
                            }
                        } else if (subchoice == 3) {
                            break;
                        }
                    } while (true);

                    break;
                case 2:
                    do {
                        System.out.println("1. Xoa dien thoai chinh hang theo id");
                        System.out.println("2. Xoa dien thoai xach tay theo id");
                        System.out.println("3. Tro ve menu chinh");
                        System.out.print("Chon chuc nang: ");
                        int subchoice = scanner.nextInt();
                        if (subchoice == 1) {
                            readBrandMobile();
                            System.out.print("Nhap vao id can xoa: ");
                            int idDelete = scanner.nextInt();
                            deleteBrandMobile(idDelete);
                            readBrandMobile();
                        } else if (subchoice == 2) {
                            readSecondMobile();
                            System.out.print("Nhap vao id can xoa: ");
                            int idDelete = scanner.nextInt();
                            deleteSecondMobile(idDelete);
                            readSecondMobile();
                        } else {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    do {
                        System.out.println("1. Xem danh sach dien thoai chinh hang");
                        System.out.println("2. Xem danh sach dien thoai xach tay");
                        System.out.println("3. Tro ve menu chinh");
                        System.out.print("Chon chuc nang: ");
                        int subchoice = scanner.nextInt();
                        if (subchoice == 1) {
                            readBrandMobile();
                        } else if (subchoice == 2) {
                            readSecondMobile();
                        } else
                            break;
                    } while (true);
                    break;
                case 4:
                    do {
                        System.out.println("1. Tim kiem dien thoai chinh hang theo ten");
                        System.out.println("2. Tim kiem dien thoai xach tay theo ten");
                        System.out.println("3. Tro ve menu chinh");
                        System.out.print("Chon chuc nang: ");
                        int subchoice = scanner.nextInt();
                        if (subchoice == 1) {
                            System.out.print("Nhap ten dien thoai muon tim: ");
                            scanner.nextLine();
                            String nameFound = scanner.nextLine();
                            searchNameBrandMobile(nameFound);
                        } else if (subchoice == 2) {
                            System.out.print("Nhap ten dien thoai muon tim: ");
                            scanner.nextLine();
                            String nameFound = scanner.nextLine();
                            searchNameSecondMobile(nameFound);
                        } else if(subchoice==3){
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);


    }
}

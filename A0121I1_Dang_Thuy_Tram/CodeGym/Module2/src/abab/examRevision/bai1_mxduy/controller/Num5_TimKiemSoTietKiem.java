package abab.examRevision.bai1_mxduy.controller;

import abab.examRevision.bai1_mxduy.exception.MaSoTietKiemException;
import abab.examRevision.bai1_mxduy.models.SoTietKiem;

import java.util.Scanner;

import static abab.examRevision.bai1_mxduy.controller.MainController.*;

public class Num5_TimKiemSoTietKiem {
    static Scanner input = new Scanner(System.in);

    public static void timKiemSotietKiem() {
        System.out.println("1. Dai Han");
        System.out.println("2. Ngan Han");
        System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {
                String maSo;
                do {
                    System.out.print("Nhap ma so muon xoa: ");
                    maSo = input.nextLine();
                } while (!MaSoTietKiemException.checkMaSo(maSo));

                boolean flag = false;
                for (SoTietKiem soTietKiem : listSotietKiemDaiHan) {
                    if (maSo.equals(soTietKiem.getMaSo())) {
                        System.out.println(soTietKiem.toString());
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Ma So Ban Nhap Khong Co Trong He Thong");
                    displayMainMenu();
                }
                break;
            }
            case "2": {
                String maSo;
                do {
                    System.out.print("Nhap ma so muon xoa: ");
                    maSo = input.nextLine();
                } while (!MaSoTietKiemException.checkMaSo(maSo));

                boolean flag = false;
                for (SoTietKiem soTietKiem : ListSotietKiemVoThoiHan) {
                    if (maSo.equals(soTietKiem.getMaSo())) {
                        System.out.println(soTietKiem.toString());
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Ma So Ban Nhap Khong Co Trong He Thong");
                    displayMainMenu();
                }
                break;
            }
            default: {
                System.out.println("Fail! Enter to continue");
                input.nextLine();
                timKiemSotietKiem();
            }
        }
        displayMainMenu();
    }
}

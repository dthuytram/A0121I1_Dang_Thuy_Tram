package _case_2_.examRevision.bai1_mxduy.controller;

import _case_2_.examRevision.bai1_mxduy.commons.DocGhiFile;
import _case_2_.examRevision.bai1_mxduy.exception.MaSoTietKiemException;
import _case_2_.examRevision.bai1_mxduy.models.SoTietKiem;

import java.util.Scanner;

import static _case_2_.examRevision.bai1_mxduy.controller.MainController.*;

public class Num2_XoaSoTietKiem {
    static Scanner input = new Scanner(System.in);
    public static void xoaSoTietKiem() {

        System.out.println("1. Dai Han");
        System.out.println("2. Ngan Han");
        System.out.print("Your choose: ");
        String choose = input.nextLine();
        switch (choose) {
            case "1": {
                for (SoTietKiem soTietKiem : listSotietKiemDaiHan) {
                    System.out.println(soTietKiem.toString());
                }

                String maSo;
                do {
                    System.out.print("Nhap ma so muon xoa: ");
                    maSo = input.nextLine();
                } while (!MaSoTietKiemException.checkMaSo(maSo));

                boolean flag = false;
                for (SoTietKiem soTietKiem : listSotietKiemDaiHan) {
                    if (maSo.equals(soTietKiem.getMaSo())) {
                        listSotietKiemDaiHan.remove(soTietKiem);
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
                for (SoTietKiem soTietKiem : ListSotietKiemVoThoiHan) {
                    System.out.println(soTietKiem.toString());
                }

                String maSo;
                do {
                    System.out.print("Nhap ma so muon xoa: ");
                    maSo = input.nextLine();
                } while (!MaSoTietKiemException.checkMaSo(maSo));

                boolean flag = false;
                for (SoTietKiem soTietKiem : ListSotietKiemVoThoiHan) {
                    if (maSo.equals(soTietKiem.getMaSo())) {
                        ListSotietKiemVoThoiHan.remove(soTietKiem);
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
                System.out.println("Fail!! Enter to continue");
                input.nextLine();
                xoaSoTietKiem();
            }
        }

        DocGhiFile.writeFileSoTietKiemDaiHan(listSotietKiemDaiHan);
        displayMainMenu();
    }

}

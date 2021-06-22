package _case_2_.examRevision.bai1_mxduy.controller;

import _case_2_.examRevision.bai1_mxduy.models.SoTietKiem;

import static _case_2_.examRevision.bai1_mxduy.controller.MainController.*;

public class Num3_DanhSachSoTietKiem {

    public static void danhSachSoTietKiem() {
        System.out.println("1. Dai han");
        System.out.println("2. Ngan han");
        System.out.print("Your choose: ");
        String choose = input.nextLine();
        switch (choose) {
            case "1": {
                for (SoTietKiem soTietKiem : listSotietKiemDaiHan) {
                    System.out.println(soTietKiem.toString());
                }
                break;
            }
            case "2": {
                for (SoTietKiem soTietKiem : ListSotietKiemVoThoiHan) {
                    System.out.println(soTietKiem.toString());
                }
                break;
            }
            default: {
                System.out.println("Fail Enter to continue");
                input.nextLine();
                danhSachSoTietKiem();
            }
        }

        displayMainMenu();
    }
}

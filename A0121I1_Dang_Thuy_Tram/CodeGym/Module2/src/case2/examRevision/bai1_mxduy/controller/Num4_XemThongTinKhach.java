package abab.examRevision.bai1_mxduy.controller;

import abab.examRevision.bai1_mxduy.commons.CustomerComparator;
import abab.examRevision.bai1_mxduy.models.KhachHang;

import java.util.Collections;
import java.util.Comparator;

import static abab.examRevision.bai1_mxduy.controller.MainController.displayMainMenu;
import static abab.examRevision.bai1_mxduy.controller.MainController.khachHangList;

public class Num4_XemThongTinKhach {
    public static void xemThongtinKhachHang() {
        Comparator<KhachHang> customerComparator = new CustomerComparator();
        Collections.sort(khachHangList, customerComparator);
        for (KhachHang customer : khachHangList) {
            System.out.println(customer.toString());
        }
        displayMainMenu();
    }
}

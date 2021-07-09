package abab.examRevision.bai1_mxduy.controller;

import abab.examRevision.bai1_mxduy.commons.DocGhiFile;
import abab.examRevision.bai1_mxduy.commons.Validate;
import abab.examRevision.bai1_mxduy.models.SoTietKiemDaiHan;
import abab.examRevision.bai1_mxduy.models.SoTietKiemVoThoiHan;

import java.util.Scanner;

import static abab.examRevision.bai1_mxduy.controller.MainController.*;

public class Num1_ThemMoiSoTietKiem {
    static Scanner input = new Scanner(System.in);
    public static void themMoiSoTietKiem() {
        System.out.println("1. Dai Han");
        System.out.println("2. Ngan Han");
        System.out.print("Your choose: ");
        String choose = input.nextLine();
        switch (choose) {
            case "1": {
                themDaiHan();
                break;
            }
            case "2": {
                themVoThoiHan();
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                input.nextLine();
                themMoiSoTietKiem();
            }
        }
    }

    private static void themDaiHan() {
        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan();

        String maSo;
        do {
            System.out.print("Ma so tiet kiem: ");
            maSo = input.nextLine();
        } while (!Validate.checkMaSoTietKiem(maSo));
        soTietKiemDaiHan.setMaSo(maSo);

        String maKhachHang;
        do {
            System.out.print("Ma khach hang (KV-XXX XXX XXX)): ");
            maKhachHang = input.nextLine();
        } while (!Validate.checkMaKhachHang(maKhachHang));
        soTietKiemDaiHan.setMaKhachHang(maKhachHang);

        String soNgay;
        do {
            System.out.print("So ngay mo so: ");
            soNgay = input.nextLine();
        } while (!Validate.checkSoNgay(soNgay));
        soTietKiemDaiHan.setNgayMoSo(soNgay);

        String thoiGian;
        do {
            System.out.print("Thoi gian gui: ");
            thoiGian = input.nextLine();
        } while (!Validate.checkSoNgay(thoiGian));
        soTietKiemDaiHan.setThoigianBatDauGui(thoiGian);

        String soTienGui;
        do {
            System.out.print("So Tien: ");
            soTienGui = input.nextLine();
        } while (!Validate.checkSoTienGui(soTienGui));
        soTietKiemDaiHan.setSoTienGui(soTienGui);

        String kyHan;
        do {
            System.out.print("Ky Han: ");
            kyHan = input.nextLine();
        } while (!Validate.checkKyHan(kyHan));
        soTietKiemDaiHan.setKyHan(kyHan);

        String laiSuat;
        do {
            System.out.print("lai suat: ");
            laiSuat = input.nextLine();
        } while (!Validate.checkLaiSuat(laiSuat));
        soTietKiemDaiHan.setLaiSuat(laiSuat);

        System.out.print("Uu Dai: ");
        String uuDai = input.nextLine();
        soTietKiemDaiHan.setUuDai(uuDai);

        listSotietKiemDaiHan.add(soTietKiemDaiHan);
        DocGhiFile.writeFileSoTietKiemDaiHan(listSotietKiemDaiHan);
        displayMainMenu();
    }

    private static void themVoThoiHan() {
        SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan();

        String maSo;
        do {
            System.out.print("Ma so tiet kiem: ");
            maSo = input.nextLine();
        } while (!Validate.checkMaSoTietKiem(maSo));
        soTietKiemVoThoiHan.setMaSo(maSo);

        String maKhachHang;
        do {
            System.out.print("Ma khach hang (KV-XXX XXX XXX)): ");
            maKhachHang = input.nextLine();
        } while (!Validate.checkMaKhachHang(maKhachHang));
        soTietKiemVoThoiHan.setMaKhachHang(maKhachHang);

        String soNgay;
        do {
            System.out.print("Ngay mo so: ");
            soNgay = input.nextLine();
        } while (!Validate.checkSoNgay(soNgay));
        soTietKiemVoThoiHan.setNgayMoSo(soNgay);

        String soTienGui;
        do {
            System.out.print("So Tien: ");
            soTienGui = input.nextLine();
        } while (!Validate.checkSoTienGui(soTienGui));
        soTietKiemVoThoiHan.setSoTienGui(soTienGui);

        String laiSuat;
        do {
            System.out.print("Lai Suat: ");
            laiSuat = input.nextLine();
        } while (!Validate.checkLaiSuat(laiSuat));
        soTietKiemVoThoiHan.setLaiSuat(laiSuat);

        ListSotietKiemVoThoiHan.add(soTietKiemVoThoiHan);
        DocGhiFile.writeFileSoTietKiemVoThoiGian(ListSotietKiemVoThoiHan);
        displayMainMenu();
    }

}

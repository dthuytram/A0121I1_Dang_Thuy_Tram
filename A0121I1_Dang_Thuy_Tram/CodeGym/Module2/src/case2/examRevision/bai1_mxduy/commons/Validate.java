package abab.examRevision.bai1_mxduy.commons;

public class Validate {
    private static String regex = "";

    public static boolean checkMaSoTietKiem(String str) {
        regex = "^STK-[0-9]{4}$";
        return str.matches(regex);
    }

    public static boolean checkSoNgay(String str) {
        regex = "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";
        return str.matches(regex);
    }

    public static boolean checkKyHan(String str) {
        regex = "^(1nam)|(3nam)|(5nam)|(10nam)$";
        return str.matches(regex);
    }

    public static boolean checkLaiSuat(String str) {
        regex = "^\\d+%$";
        return str.matches(regex);
    }
    public static boolean checkMaKhachHang(String str) {
        regex = "^KV-\\d{3}\\s\\d{3}\\s\\d{3}$";
        return str.matches(regex);
    }

    public static boolean checkSoTienGui(String soTienGui) {
        double soTien;
        try {
            soTien = Double.parseDouble(soTienGui);
            return soTien > 1000000;
        } catch (Exception Ex) {
            return false;
        }
    }
}

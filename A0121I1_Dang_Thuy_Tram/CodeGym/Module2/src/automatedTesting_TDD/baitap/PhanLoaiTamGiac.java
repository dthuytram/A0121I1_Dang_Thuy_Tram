package automatedTesting_TDD.baitap;

public class PhanLoaiTamGiac {

    public static final String CAN = "Can";
    public static final String DEU = "Deu";
    public static final String VUONG = "Vuong";
    public static final String THUONG = "Thuong";
    public static final String KHONG = "NO";

    public static String getLoaiTamGiac(int a, int b, int c) {

        boolean isDuong = a <= 0 || b <= 0 || c <= 0;
        boolean isTamGiac = (a + b < c) || (a + c < b) || (b + c < a);
        boolean isCan = (a == b) || (a == c) || (b == c);
        boolean isDeu = (a == b) && (a == c) && (b == c);
        boolean vuongOne = Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2);
        boolean vuongTwo = Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2);
        boolean vuongThree = Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
        boolean isVuong = vuongOne || vuongTwo || vuongThree;

        if (isDuong || isTamGiac)
            return KHONG;
        else {
            if (isDeu) return DEU;
            else if (isCan) return CAN;
            else {

                if (isVuong) return VUONG;
                else return THUONG;
            }
        }

    }
}


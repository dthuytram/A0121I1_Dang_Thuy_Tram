package abab.examRevision.bai1_mxduy.exception;

public class MaSoTietKiemException extends Exception{
    public MaSoTietKiemException(String message) {
        super(message);
    }

    public static boolean checkMaSo(String maSo) {
        String regex =  "^STK-[0-9]{4}$";
        boolean check = maSo.matches(regex);
        try {
            if (!check) {
                throw new MaSoTietKiemException("Ban Da Nhap Sai Ma So");
            }
        } catch (MaSoTietKiemException ex) {
            System.out.println(ex.getMessage());
        }
        return check;
    }
}

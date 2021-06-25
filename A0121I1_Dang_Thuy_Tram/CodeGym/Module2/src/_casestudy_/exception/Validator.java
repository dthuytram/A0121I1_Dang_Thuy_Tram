package ab.exception;

import java.net.BindException;
import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Check the input data
 * Hàm thực hiện Task 4:
 * Viết hàm kiểm tra dữ liệu đầu vào khi người dùng thực hiện thêm mới một dịch vụ (add new Services) cho thuê. Yêu cầu kiểm tra được hợp lệ của các thuộc tính: (sử dụng regular expression)
 * Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
 * Nếu là Villa thì XX sẽ là VL
 * Nếu là House thì XX sẽ là HO
 * Nếu Room thì XX sẽ là RO
 * <p>
 * Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường
 * Diện tích sử dụng và diện tích hồ bơi phải là số thực lớn hơn 30m2
 * Chi phí thuê phải là số dương
 * <p>
 * Số lượng người tối đa phải >0 và nhỏ hơn <20
 * Dịch vụ đi kèm phải là các giá trị: massage, karaoke, food, drink, car
 * Số tầng phải là số nguyên dương.
 * <p>
 * Kiểu thuê, Tiêu chuẩn phòng chuẩn hóa dữ liệu giống tên dịch v
 * Ngày sinh phải nhỏ hơn ngày hiện tại 18 năm và phải đúng định dạng dd/mm/YYYY
 * Trong trường hợp bị lỗi phải thông báo lỗi và bắt người dùng nhập lại cho tới khi thỏa mãn yêu cầu.
 */
public class Validator {
    public static final String MADICHVU = "[A-Z][a-z]*";
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String IDKHACH = "[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String DICHVUDIKEM = "(massage|karaoke|food|drink|car)";
    public static final String NGAYSINH = "[\\d]{2}/[\\d]{2}/[\\d]{4}";

    public static boolean isValidService(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("     " +
                    "     * Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:\n" +
                    "     * Nếu là Villa thì XX sẽ là VL\n" +
                    "     * Nếu là House thì XX sẽ là HO\n" +
                    "     * Nếu Room thì XX sẽ là RO\n");
        }
        return flag;
    }


    public static boolean isDienTich(int number) {
        double number2 = 30;
        boolean flag = number2 < number;
        if (!flag) {
            System.out.println("* Diện tích sử dụng và diện tích hồ bơi phải là số thực lớn hơn 30m2");
        }
        return flag;
    }

    public static boolean isSoNguoi(int number) {
        int number2 = 0;
        int number3 = 20;
        boolean flag = number2 < number && number < number3;
        if (!flag) {
            System.out.println(" Số lượng người tối đa phải >0 và nhỏ hơn < 20 ");
        }
        return flag;
    }

    public static boolean isChiPhi(double number) {
        boolean flag = 0 < number;
        if (!flag) {
            System.out.println(" Chi phí thuê phải là số dương");
        }
        return flag;
    }


    public static boolean isDichVu(String str) {
        pattern = Pattern.compile(DICHVUDIKEM);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("* Dịch vụ đi kèm phải là các giá trị: " +
                    "massage, karaoke, food, drink, car\n");
        }
        return flag;
    }

    public static boolean is_Email(String str) {
        pattern = Pattern.compile(EMAIL);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println(" Bạn hãy nhập lại cho đúng định dang");
        }
        return flag;
    }


    public static boolean isTang(double number, double number2) {
        boolean flag = number > number2;
        if (!flag) {
            System.out.println(" Bạn hãy nhập lại cho đúng định dang");
        }
        return flag;
    }

    public static void isTenKh(String name) throws NameException {
        String[] fullName = name.split(" ");
        // Nếu ko phải chữ thường
        for (String element : fullName) {
            if (Character.isLowerCase(element.charAt(0))) {
                throw new NameException();
            }
        }
        // tránh thừa khoảng thắng
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == ' ' && name.charAt(i + 1) == ' ') {
                throw new NameException();
            }
        }
    }

    public static void isEmail(String email) throws EmailException {
        int aCong = email.indexOf("@");
        int dot = email.indexOf(".");
        if (aCong <= 0 || dot >= 2) {
            throw new EmailException();
        }
        int countA = 0;
        int countDot = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                countA++;
            } else if (email.charAt(i) == '.') {
                countDot++;
            }
        }
        if (countA >= 2) {
            throw new EmailException();
        }

        if (countDot == 0) {
            throw new EmailException();
        }


    }

    public static void isGioiTinh(String gioitinh) throws GenderException {
        String[] list = {"nam", "nu", "thu3"};
        // nếu list ko chứa gioi tinh cho viết thường
        if (!Arrays.asList(list).contains(gioitinh.toLowerCase())) {
            throw new GenderException();
        }
    }

    public static boolean isIDKHACH(String str) {
        pattern = Pattern.compile(IDKHACH);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println(" Bạn hãy nhập lại cho đúng định dang");
        }
        return flag;
    }

    public static void isNgaySinh(String isNgaysinh) throws BindException {
        if (isValidService(isNgaysinh, NGAYSINH)) {
            int birthYear = Integer.parseInt(isNgaysinh.split("/")[2]);
            int currentYear = Year.now().getValue(); // lấy năm năm hiện tại
            if (birthYear <= 1900 || currentYear - birthYear < 18) {
                throw new BindException();
            }
        } else
            throw new BindException();
    }
}

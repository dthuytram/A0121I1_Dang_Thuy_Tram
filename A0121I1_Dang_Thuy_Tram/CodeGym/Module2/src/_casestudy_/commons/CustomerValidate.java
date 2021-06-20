package _casestudy_.commons;

import _casestudy_.exception.*;

import java.time.LocalDate;
import java.time.Period;

/** Lưu ý: File này kết hợp Exception để xử lí
 * Task 5:
 * Tạo user Exception để valid các trường hợp sau:
 * Tạo NameException để kiếm tra Name Customer phải có định dạng in hoa ký tự đầu tiên và không cho phép kí tự khoảng trống thừa. Ví dụ “Nguyễn Kiên” là đúng còn “Nguyễn kIÊn” là sai. Nếu không hợp lệ thì sẽ hiển thị thông báo “Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ”.
 * Tạo EmailException để kiểm tra, Email phải nhập đúng kiểu dữ liệu của email ở mức độ tương đối. Email bao gồm duy nhất chữ @ và tối thiểu 1 dấu . , có thể suy nghĩ và phát triển thêm. Nếu không hợp lệ thì sẽ hiển thị thông báo “Email phải đúng định dạng abc@abc.abc”.
 * Tạo GenderException để  bắt buộc người dùng phải nhập vào Male, Female hoặc Unknow. Trong trường hợp người dùng nhập sai in hoa hoặc in thường vẫn chấp nhận nhưng phải chuẩn hóa dữ liệu đúng trước khi lưu vào file.

     * Ví dụ: uNKNOW, maLE vẫn chấp nhận và chuẩn hóa dữ liệu thành Unknow và Male sau đó lưu vào File.
     * Tạo IdCardException kiểm tra Id Card phải gồm có 9 chữ số theo định dạng XXX XXX XXX. Nếu sai thì hiển thị thông báo “Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX”.
     * Tạo BirthdayException để kiểm tra Birthday phải có định dạng đúng ngày sinh theo kiểu dd/MM/yyyy và có năm sinh >1900 và nhỏ hơn ngày hiện tại là 18 năm. Nếu sai thì hiển thị thông báo lỗi “Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy”.
 */
public class CustomerValidate {
    public static boolean checkName(String str) {
        String regex = "^[A-Z][a-z]{0,}([\\s]{1}[A-Z][a-z]{0,})*$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ, khong co ki tu thua" +
                        "\n Vd: Nguyen Kien");
            }
        } catch (NameException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkBirthday(String str) {
        String regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean check = str.matches(regex);
        try {
            if (check) {
                int day = Integer.parseInt(str.substring(0, 2));
                int month = Integer.parseInt(str.substring(3, 5));
                int year = Integer.parseInt(str.substring(6, 10));
                LocalDate today = LocalDate.now(); // Định dạng ngày hôm nay
                System.out.println("Today is: " + today);
                LocalDate birthday;
                try {
                    birthday = LocalDate.of(year, month, day); //Format day
                    System.out.println("Birthday is: " + birthday);
                } catch (Exception e) {
                    throw new BirthdayException("Ngày sinh trồng. VUI LÒNG NHẬP LẠI!!!");
                }
                if (year <= 1900) {
                    throw new BirthdayException("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm");
                }
                if (Period.between(birthday, today).getYears() < 18) {
                    throw new BirthdayException("Không cho phép thành viên dưới 18 tuổi. Sorry");
                }
            } else {
                throw new BirthdayException("Phải đúng định dạng:  dd/mm/yyyy");
            }
        } catch (BirthdayException e) {
            System.out.println(e.getMessage());
            check = false;
        }
        return check;
    }
    //---------Other Description (for checkBirthday)

    /**
     *  public static final String NGAYSINH = "[\\d]{2}/[\\d]{2}/[\\d]{4}";
     *
     *  public static boolean isValidService(String str, String regex) {
     *         pattern = Pattern.compile(regex);
     *         matcher = pattern.matcher(str);
     *         boolean flag = matcher.matches();
     *         if (!flag) {
     *             System.out.println(" Bạn hãy nhập lại cho đúng định dang");
     *         }
     *         return flag;
     *     }
     *   public  static void isNgaySinh(String isngaysinh) throws BindException {
     *        if(isValidService(isngaysinh,NGAYSINH )) {
     *            int birthYear = Integer.parseInt(isngaysinh.split("/")[2]);
     *            int curYear = Year.now().getValue(); // get NowYear
     *            if(birthYear <= 1900 ||curYear  - birthYear  <18)
     *            { throw new BindException();
     *            }
     *        }
     *        else
     *            throw new BindException();
     *     }
     *
     */

    public static boolean checkGender(String str) {
        String regex = "^male|female|unknown$";
        boolean check = (str.toLowerCase()).matches(regex);
        try {
            if (!check) {
                throw new GenderException("Thông tin sai. Nên nhập: Male | Female | Unknown");
            }
        } catch (GenderException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkId(String str) {
        String regex = "^[\\d]{3}[\\s]{1}[\\d]{3}[\\s]{1}[\\d]{3}$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new IdCardException("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            }
        } catch (IdCardException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkPhoneNumber(String str) {
        String regex = "^[0]{1}[1-9]{1}[\\d]{8}$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new PhoneException("Invalid phone number. Please input again.");
            }
        } catch (PhoneException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkEmail(String str) {
        String regex = "^[\\w\\d-_.]{3,20}@[\\w]{3,15}(.[\\w]{2,8}){1,3}$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new EmailException("Thông tin sai. Nên nhập: abc@xyz.com");
            }
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkCustomerType(String str) {
        String regex = "^Platinum|Gold|Silver|Member$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new CustomerTypeException("Thông tin sai. Chỉ nhập: Platinum, Gold, Silver or Member");
            }
        } catch (CustomerTypeException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}

package p17_string_regex.baitap.validateClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [Bài tập] Validate tên của lớp học

 * Mục tiêu
 * Luyện tập sử dụng RegularExpression.
 *

 * Mô tả
 * Viết phương thức để kiểm tra tính hợp lệ của tên một lớp học.
 *
 * Tên một lớp học hợp lệ cần đạt các yêu cầu sau:
 *
 * Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
 *
 * Không chứa các ký tự đặc biệt
 *
 * Theo sau ký tự bắt đầu là 4 ký tự số
 *
 * Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
 *
 * Ví dụ tên lớp hợp lệ: C0318G
 *
 * Ví dụ tên lớp không hợp lệ: M0318G, P0323A
 */
public class ValidateClassName {
    private static final String CLASSNAME_REGEX = "^[CAP][\\d]{4}[GHIKM]$";

    public ValidateClassName() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASSNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

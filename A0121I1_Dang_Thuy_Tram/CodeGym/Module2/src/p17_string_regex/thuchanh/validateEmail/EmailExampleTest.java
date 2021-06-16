package p17_string_regex.thuchanh.validateEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Link tải tài liệu: https://docs.google.com/document/d/18qEOjtT3VsLIbVO7W6yqRN8bT55nmv17-EKe9iWfsW0/edit?usp=sharing
 *
 */
public class EmailExampleTest {
    /**
     * Chúng ta có Email Regular Expression Pattern như sau:
     *
     * ^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$;

     **  Giải thích chuỗi:
     * ^                  : Bắt đầu chuỗi String hoặc 1 dòng
     * [A-Za-z0-9]+       : Email address phải bắt đầu với “[A-Za-z0-9]+” và có ít nhất một ký tự
     * [A-Za-z0-9]*@      : Tùy chọn theo "[A-Za-z0-9]", và kết thúc bằng một ký hiệu "@"
     * [A-Za-z0-9]        : Domain phải sau @ và ký tự phải nằm trong [A-Za-z0-9]
     * \\.[A-Za-z0-9]     : Sau domain là phần mở rộng của domain sau dấu chấm, ví dụ: (.com, .net, .org)
     * $                  : Kết thúc chuỗi String hoặc kết thúc dòng
     */
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailExampleTest() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

package p17_string_regex.baitap.validateTelNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelNumber {
    private static final String TELNUMBER_REGEX = "[\\d]{2}-[\\d]{10}";

    public TelNumber() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(TELNUMBER_REGEX );
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

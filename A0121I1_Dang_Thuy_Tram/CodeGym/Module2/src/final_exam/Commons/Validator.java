package final_exam.Commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEX = "^[1-9]\\d*$";
    private static Pattern pattern;
    private Matcher matcher;
    public boolean validateNumber(String number) {
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
}

package p17_string_regex.baitap.validateTelNumber;

public class Test {
    private static TelNumber telNumber;
    public static final String[] validTelNumber = new String[] { "84-0978489648" };
    public static final String[] invalidTelNumber = new String[] { "28-2222222222" };

    public static void main(String[] args) {
        telNumber = new TelNumber();
        for (String telnumber : validTelNumber) {
            boolean isvalid = telNumber.validate(telnumber);
            System.out.println("TelNumber is " + telnumber +" is valid: "+ isvalid);
        }
        for (String telnumber : invalidTelNumber) {
            boolean isvalid = telNumber.validate(telnumber);
            System.out.println("TelNumber is " + telnumber +" is valid: "+ isvalid);
        }
    }
}

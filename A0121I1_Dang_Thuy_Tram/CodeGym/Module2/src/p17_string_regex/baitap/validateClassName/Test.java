package p17_string_regex.baitap.validateClassName;

public class Test {
    private static ValidateClassName className;
    public static final String[] validClassName = new String[] { "C0318G" };
    public static final String[] invalidClassName = new String[] { "M0318G", "P0323A", };

    public static void main(String args[]) {
        className = new ValidateClassName();
        for (String classname : validClassName) {
            boolean isvalid = className.validate(classname);
            System.out.println("ClassName is " + classname +" is valid: "+ isvalid);
        }
        for (String classname : invalidClassName) {
            boolean isvalid = className.validate(classname);
            System.out.println("ClassName is " + classname +" is valid: "+ isvalid);
        }
    }
}

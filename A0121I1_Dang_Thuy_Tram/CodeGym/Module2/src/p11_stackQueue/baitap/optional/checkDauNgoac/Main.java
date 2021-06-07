package p11_stackQueue.baitap.optional.checkDauNgoac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String str = sc.nextLine();

        Check checkStr = new Check();

        System.out.println( "Bracket equal in string: " + checkStr.checkBrackets(str));

    }
}

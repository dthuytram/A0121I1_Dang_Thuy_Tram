package stack_queue.baitap.optional.chuoiPalindrome;

import arrayList.thuchanh.Check;

import java.util.Scanner;

public class CheckMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String str = sc.nextLine();

        CheckPalindrome checkStr = new CheckPalindrome(str);

        System.out.println( "Palindrome string: " + checkStr.checkPalindrome());


    }
}

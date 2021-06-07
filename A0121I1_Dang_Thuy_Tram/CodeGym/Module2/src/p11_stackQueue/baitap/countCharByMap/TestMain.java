package p11_stackQueue.baitap.countCharByMap;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        System.out.print("Enter long string: ");
        String str = new Scanner(System.in).nextLine();

        CountManage countManage = new CountManage(str);
        countManage.displayMap();
    }
}

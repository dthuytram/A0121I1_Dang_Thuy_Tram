package p11_stack_queue.baitap.countCharByMap;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        System.out.print("Nhập vào chuỗi: ");
        String str = new Scanner(System.in).nextLine();

        CountManage countManage = new CountManage(str);
        countManage.displayMap();
    }
}

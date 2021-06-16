package p11_stack_queue.baitap.daoChuSoNguoc;

import java.util.Scanner;

public class GenericStackClient {
    public static int demChuSo(int n) {
        int dem = 1;
        while (n >= 10) {
            n /= 10;
            dem++;
        }
        return dem;
    }

//    private static void stackOfIntegers() {
//        MyGenericStack<Integer> stack = new MyGenericStack();
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("độ dài của num: ");
//        int num = sc.nextInt();
//
////        System.out.println("1.1 Size of array before push operations: " + array.length);
//        int size = demChuSo(num);
//        System.out.println(size);
//        int[] array = new int[size + 1];
//        while (num != 0 && (size != 0)) {
//            int c = num % 10;
//            num /= 10;
//            array[size--] = c;
//
//        }
//        System.out.println("1.1 Size of stack before  push operations: " + stack.size());
//        for (int j = 0; j < array.length - 1; j++) {
//            System.out.println("j: " + array[j]);
//            stack.push(j);
//        }
//        System.out.println("1.1 Size of stack after push operations: " + stack.size());
//        System.out.printf("1.2. Pop elements from stack : ");
//        while (!stack.isEmpty()) {
//            System.out.printf(" %d", stack.pop());
//        }
//    }

    private static void stackOfCharacters() {
        MyGenericStack<Character> stack = new MyGenericStack();

        Scanner sc = new Scanner(System.in);
        System.out.println("độ dài của num: ");
        String string = sc.nextLine();
        string.toLowerCase();
        string.split(" ");
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
            stack.push(string.charAt(i));
        }
        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.printf("1.2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfCharacters();
//        System.out.println("\n2. Stack of Strings");
//        stackOfIStrings();
    }


}


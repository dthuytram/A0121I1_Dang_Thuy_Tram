package p14_sort_algorithm.thuchanh.bubbleSort;

import java.util.Scanner;

/**
 * Mục đích
 * Luyện tập cài đặt thuật toán sắp xếp nổi bọt.
 *
 * Mô tả
 * Viết một chương trình cho phép quan sát các bước thực hiện của thuật toán sắp xếp nổi bọt.
 *
 * Chương trình cho phép định nghĩa một mảng các số nguyên, hiển thị lần lượt các bước của thuật toán sắp xếp nổi bọt.
 * 
 * ĐỘ PHỨC TẠP:
 * (Edit needing)
 */
public class BubbleSort {
    /**
     * Bước 1: Tạo lớp BubbleSortByStep, cài đặt hàm main cho phép nhập và hiển thị một mảng số nguyên
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }

        /**
         * Bước 3: Bổ sung câu lệnh gọi phương thức bubbleSortByStep (list)  vào hàm main
         */
        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(list);
    }
    /**
     * Bước 2: Cài đặt phương thức BubbleSortByStep (int[] list) để thực hiện và hiển thị các bước của thuật toán sắp xếp nổi bọt
     */
    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            /* Array may be sorted and next pass not needed */
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            /* Show the list after sort */
            System.out.print("List after the  " + k + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }

}

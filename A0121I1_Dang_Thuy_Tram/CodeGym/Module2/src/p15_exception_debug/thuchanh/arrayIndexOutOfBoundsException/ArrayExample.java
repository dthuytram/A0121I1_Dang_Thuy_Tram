package p15_exception_debug.thuchanh.arrayIndexOutOfBoundsException;

import java.util.Random;
import java.util.Scanner;

/**
 * [Thực hành] Sử dụng lớp ArrayIndexOutOfBoundsException
 * Mục tiêu
     * Luyện tập sử dụng try-catch và các lớp Exception có sẵn.
     *
     * Mô tả
     * Viết một chương trình cho phép tạo ra một mảng 100 số nguyên ngẫu nhiên. Cho phép người dùng nhập vào chỉ số của một phần tử và hiển thị giá trị của phần tử đó.
     *
     * Sử dụng try-catch để hiển thị thông báo nếu người dùng nhập vào chỉ số không hợp lệ (index < 0 hoặc index >= 100)
 */
public class ArrayExample {
    /**
     * Bước 1: Tạo lớp ArrayExample
     *
     * Tạo phương thức createRandom Trả về mảng số nguyễn ngẫu nhiên từ 0 đến 100.
     */
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
    /**
     * Bước 2: Tạo hàm main cho phép người dùng nhập vào chỉ số của một phần tử bất kỳ đồng thời tìm kiếm giá trị phần tử theo chỉ số đó dựa trên mảng vừa tạo
     */
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        Integer[] arr = arrExample.createRandom();

        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scaner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số 5" + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }


}

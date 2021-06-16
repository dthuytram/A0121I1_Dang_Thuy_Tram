package p13_search_algorithm.optional.thuchanh;

import java.util.Scanner;

/**
 * [Optional] [Thực hành] Tính độ phức tạp của thuật toán
 * Mục đích
 * Luyện tập tính độ phức tạp của thuật toán.
 * <p>
 * Mô tả
 * Viết một chương trình cho phép xác định ký tự xuất hiện nhiều nhất trong một chuỗi.
 * <p>
 * Chương trình cho phép nhập vào một chuỗi và hiển thị ký tự có số lần xuất hiện nhiều nhất trong chuỗi đó.
 * <p>
 * Tính độ phức tạp của thuật toán vừa triển khai.
 * <p>
 * Hướng dẫn
 * Bước 1: Tạo lớp AlgorithmComplexityTest, viết hàm main cho phép nhập vào một chuỗi ký tự
 */
public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        /**
         * Bước 2: Tính tần suất xuất hiện của các ký tự trong chuỗi vừa nhập
         *
         * Ta biết rằng mỗi ký tự tương ứng với 1 số nguyên trong bảng mã ASCII  gồm 255 ký tự. Vì thế, ta sẽ tạo ra một mảng số nguyên có 255 phần tử, mỗi  vị trí  trong mảng  đại diện cho một  ký tự trong bảng ASCII,  giá trị tại đó biểu diễn tần suất xuất hiện của ký tự. Bạn đầu đặt tất cả các phần tử bằng không.
         * Sử dụng vòng lặp duyệt qua các kí tự của chuỗi vừa nhập và tính tần suất xuất hiện của các ký tự
         */
        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            /* Tìm vị trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;
        }
        /**
         * Bước 3:  Tìm ký tự có tần suất xuất hiện nhiều nhất
         */
        int max = 0;


    }
}

package p15_exception_debug.thuchanh.numberFormatException;

import java.util.Scanner;

/**
 * [Thực hành] Sử dụng lớp NumberFormatException
 * Mục tiêu
 * Luyện tập sử dụng try-catch để xử lý ngoại lệ.
 *
 * Mô tả
 * Viết một ứng dụng máy tính đơn giản, cho phép thực hiện các phép Cộng, Trừ, Nhân, Chia.
 *
 * Ứng dụng hiển thị thông báo nếu người dùng nhập số bất hợp lệ.
 *
 * Hướng dẫn
 * Bước 1: Tạo lớp CalculationExample
 *
 * Tạo phương thức calc với đầu vào là 2 số nguyên x và y. In ra kết quả Cộng, Trừ, Nhân, Chia.
 *
 * Khi y = 0 hoặc x=y=0 sẽ xuất hiện thông báo lỗi ngoại lệ.
 */
public class NumberFormatException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = scanner.nextInt();
        System.out.println("Hãy nhập y: ");
        int y = scanner.nextInt();
        NumberFormatException calc = new NumberFormatException();
        calc.calculate(x, y);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}
/**
 * Bước 2: Xây dựng mẫu account hợp lệ
 *
 * x=5, y=5;
 * x=0, y=1
 * Bước 3: Xây dựng mẫu account không hợp lệ
 *
 * y=0;
 * x=0, y=0;
 * Bước 4: Chạy chương trình và kiểm tra kết quả
 *
 * ※Với x= 5, y=5;
 *
 * Tổng x + y = 10
 *
 * Hiệu x - y = 0
 *
 * Tích x * y = 25
 *
 * Thương x / y = 1
 *
 * ※ Với x = 0, y = 1;
 *
 * Tổng x + y = 1
 *
 * Hiệu x - y = -1
 *
 * Tích x * y = 0
 *
 * Thương x / y = 0
 *
 * ※ Với y = 0 hoặc x=y=0;
 *
 * Xảy ra ngoại lệ: / by zero
 */
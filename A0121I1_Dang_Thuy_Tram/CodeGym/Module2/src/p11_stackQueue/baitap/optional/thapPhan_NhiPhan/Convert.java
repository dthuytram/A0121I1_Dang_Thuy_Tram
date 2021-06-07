package p11_stackQueue.baitap.optional.thapPhan_NhiPhan;

import java.util.Stack;

/**
 * Reference:
 * from02_06
 * <p>
 * public class Nhi_thap {
 * public Nhi_thap() {
 * }
 * <p>
 * public static void main(String[] args) {
 * Scanner scanner = new Scanner(System.in);
 * System.out.println("Nhap vao mot so nguyen (He nhi phan):");
 * int numner = scanner.nextInt();
 * <p>
 * Stack stack;
 * for(stack = new Stack(); numner != 0; numner /= 2) {
 * stack.push(numner % 2);
 * }
 * <p>
 * System.out.println("Sang he thap phan la: ");
 * int size = stack.size();
 * <p>
 * for(int i = 0; i < size; ++i) {
 * System.out.print(stack.pop());
 * }
 * <p>
 * }
 * }
 */
public class Convert {
    Stack<Integer> stack = new Stack<>();
    StringBuilder str = new StringBuilder();

    public String convertDecToX(int dec, int coso) {
        stack.clear();
        str.setLength(0);  // xóa string
        System.out.println("str sau khi xoa: " + str);
        System.out.println("Phan tu sau khi xoa: " + stack);
        while (dec != 0) {
            stack.push(dec % coso);
            dec /= coso;
        }
        System.out.println("Phan tu: " + stack);
        while (!stack.isEmpty()) {
            str.append(stack.pop());
            // Tạo str thêm các phần tử của stack đã được binary ra
        }
        return String.valueOf(str);
    }

    public String convertBinToDecimal(int bin) {
        while (bin > 0) {
            stack.push(bin % 10);
            bin /= 10;
        }

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return String.valueOf(str);
    }
}

package p13_search_algorithm.baitap.chuoiTangDan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Mục đích
 * Luyện tập thuật toán tìm kiếm
 *
 * Mô tả
 * Viết chương trình nhắc nhở người dùng nhập một chuỗi và hiển thị chuỗi ký tự phụ được sắp xếp có độ dài lớn nhất.
 * Phân tích sự phức tạp về thời gian của chương trình.
 */
public class ChuoiTangDan {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        // Find the maximum increasingly ordered subsequence
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }

/*********************************************************************************
 * 	Analyze the time complexity of your program:                                  *
 * 	1 outerloop = n;                                                              *
 * 	1 innerloop = n - 1;                                                          *
 *  1 simple statement = 1                                                        *
 * 	1 single loop * 1 simple statement = 1;                                       *
 *  T(n) = (n * (n - 1)) + (1 + 1);                                               *
 *  T(n) = O(n^2) + O(n);                                                         *
 * 	T(n) = O(n^2) Quadratic time;                                                 *
 *********************************************************************************/
}


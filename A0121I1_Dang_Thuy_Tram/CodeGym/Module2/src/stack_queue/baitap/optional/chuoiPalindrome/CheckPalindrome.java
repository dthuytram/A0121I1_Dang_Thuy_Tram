package stack_queue.baitap.optional.chuoiPalindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Optional] [Bài tập] Kiểm tra chuỗi Palindrome sử dụng Queue
 * Mục đích
    * Luyện tập sử dụng Queue
 *
 * Mô tả
     * Kiểm tra chuỗi Palindrome sử dụng Queue.
 *
 * Khái niệm: Một chuỗi được gọi là Palindrome nếu như đọc xuôi giống đọc ngược.
 *
    * Bài toán: Cho trước một chuỗi, kiểm tra xem chuỗi đó có phải là chuỗi palindrome hay không?
 *
    * Ví dụ về chuỗi palindrome: Able was I ere I saw Elba
 *
    * Hướng dẫn nộp bài:

 * Giải pháp:
 *
     * Để tránh ảnh hưởng tới chuỗi ban đầu, đọc chuỗi nói trên vào stack và queue.
     *
     * So sánh từng phần tử của stack và queue, nếu giống nhau từng cặp thì đó là chuỗi Palindrome, ngược lại thì chuỗi trên không phải là chuỗi Palindrome.
 */
public class CheckPalindrome {
    private String str;

    public CheckPalindrome(String str) {
        this.str = str;
    }

    public boolean checkPalindrome() {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        str = str.toLowerCase();

        System.out.println("String: " + str);
        char[] charArr = str.toCharArray();

        System.out.println("charArr: " + str);
        for (char c : charArr) {
            stack.push(c);
            queue.add(c);
        }
        System.out.println("stack: " + stack);
        System.out.println("queue: " + queue);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println(queue.poll());
        }

        return true;
    }


}

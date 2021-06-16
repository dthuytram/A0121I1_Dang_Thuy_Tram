package p11_stack_queue.baitap.optional.demergingQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Manage {
    private List<Student> output = new ArrayList<>();

    public boolean isFemale(Student student){
        return student.getSex().equals("Female");
    }

    public List<Student> demerging(List<Student> list){
        Queue<Student> female = new LinkedList<>();
        Queue<Student> male = new LinkedList<>();
        /**
         * [1] Sử dụng forEach cho List
         * Ví dụ:
         *  public static void main(String[] args) {
         *         List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
         *
         *         System.out.println("1. Iterating by passing lambda expression: ");
         *         languages.forEach(lang -> System.out.println(lang));
         *
         *         System.out.println("2. Iterating by passing method reference: ");
         *         languages.forEach(System.out::println);
         *  }
         => Output của chương trình trên:
             1. Iterating by passing lambda expression:
                 Java
                 C#
                 C++
                 PHP
                 Javascript
             2. Iterating by passing method reference:
                 Java
                 C#
                 C++
                 PHP
                 Javascript
         *
         *
         * Mục đích sử dụng: In ra tất cả các phần tử của list
         */
        list.forEach(sv ->{
            if (isFemale(sv)){
                female.add(sv);
            }else {
                male.add(sv);
            }
        });

        while (!female.isEmpty()){
            output.add(female.poll());
        }

        while (!male.isEmpty()){
            output.add(male.poll());
        }

        return output;
    }

    public void display(){
//        output.forEach(Student::show);
        /**
         * Cách viết thứ 1:  output.forEach(Student::show);
         *               2:  output.forEach(Student -> Student.show());
         *
         */
        output.forEach(Student -> Student.show());
    }
    /**
     * [2]: " Method References"  là gì?

     * Java cung cấp một tính năng mới gọi là Method References (phương thức tham chiếu) trong Java 8.

     * Method References là một tính năng khá hay và liên quan đến việc sử dụng Lambda Expression. Nó cung cấp các cú pháp (syntax) hữu ích để truy cập trực tiếp tới các constructor hoặc method đã tồn tại của các lớp hoặc đối tượng trong Java mà không cần thực thi chúng. Nó làm cho việc viết code của chúng ta trở nên đơn giản hơn rất nhiều và nhìn chúng đẹp hơn.

     * Method References là cú pháp viết tắt của biểu thức Lambda để gọi phương thức. Ví dụ, nếu biểu thức Lamda được viết như sau:

        * str -> System.out.println(str)

     * Chúng ta có thể viết lại theo cách của Method references như sau:

        * System.out::println

     *) Tham chiếu đến một static method

        Cú pháp:    Class::staticMethod

     *) Ví dụ:

             * package com.gpcoder.method_reference;
             *
             * @FunctionalInterface
             * interface ExecuteFunction {
             *     public int execute(int a, int b);
             * }
             *
             * class MathUtils {
             *     public static int sum(int a, int b) {
             *         return a + b;
             *     }
             *
             *     public static int minus(int a, int b) {
             *         return a - b;
             *     }
             * }
             *
             * public class DemoMethodReference1 {
             *     public static void main(String[] args) {
             *         int a = 10;
             *         int b = 7;
             *
             *         int sum = doAction(a, b, MathUtils::sum);
     *         |                                                                    |
     *         |        MathUtils::sum : đại diện cho MathUtils -> MathUtils.sum()  |
     *         |                                                                    |
             *         System.out.println(a + " + " + b + " = " + sum); // 10 + 7 = 17
             *
             *         int minus = doAction(a, b, MathUtils::minus);
             *         System.out.println(a + " - " + b + " = " + minus); // 10 - 7 = 3
             *     }
             *
             *     public static int doAction(int a, int b, ExecuteFunction func) {
             *         return func.execute(a, b);
             *     }
             * }
     */
}

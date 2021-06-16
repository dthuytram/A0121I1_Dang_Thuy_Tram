package p11_stack_queue.baitap.optional.demergingQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckMain {
    public static void main(String[] args) {
        Student sv1 = new Student("Hoang","Male", "30-11-2000");
        Student sv2 = new Student("Nga","Female","02-11-2000");
        Student sv3 = new Student("Uyen","Female","10-09-2000");


        List<Student> list = new ArrayList<>();

        list.add(sv1);
        list.add(sv2);
        list.add(sv3);

        Collections.sort(list);
        /**
         * Lưu ý: Muốn sort List thì List phải có " dạng List<T> "
         * Để có dạng như v:
         * class Student implements Comparable<Student>
         * Override hàm compareTo
         */
        /**
         * Ví dụ:
                 * // Java program to demonstrate working of Comparator
                 * // interface and Collections.sort() to sort according
                 * // to user defined criteria.
                 * import java.util.*;
                 * import java.lang.*;
                 * import java.io.*;
                 *
                 * // A class to represent a student.
                 * class Student
                 * {
                 *     int rollno;
                 *     String name, address;
                 *
                 *     // Constructor
                 *     public Student(int rollno, String name,
                 *                                String address)
                 *     {
                 *         this.rollno = rollno;
                 *         this.name = name;
                 *         this.address = address;
                 *     }
                 *
                 *     // Used to print student details in main()
                 *     public String toString()
                 *     {
                 *         return this.rollno + " " + this.name +
                 *                            " " + this.address;
                 *     }
                 * }
                 *
                 * class Sortbyroll implements Comparator<Student>
                 * {
                 *     // Used for sorting in ascending order of
                 *     // roll number
                 *     public int compare(Student a, Student b)
                 *     {
                 *         return a.rollno - b.rollno;
                 *     }
                 * }
                 *
                 * // Driver class
                 * class Main
                 * {
                 *     public static void main (String[] args)
                 *     {
                 *         ArrayList<Student> ar = new ArrayList<Student>();
                 *         ar.add(new Student(111, "bbbb", "london"));
                 *         ar.add(new Student(131, "aaaa", "nyc"));
                 *         ar.add(new Student(121, "cccc", "jaipur"));
                 *
                 *         System.out.println("Unsorted");
                 *         for (int i=0; i<ar.size(); i++)
                 *             System.out.println(ar.get(i));
                 *
                 *         Collections.sort(ar, new Sortbyroll());
                 *
                 *         System.out.println("\nSorted by rollno");
                 *         for (int i=0; i<ar.size(); i++)
                 *             System.out.println(ar.get(i));
                 *     }
                 * }
             * Output :
             *
             * Unsorted
             * 111 bbbb london
             * 131 aaaa nyc
             * 121 cccc jaipur
             *
             * Sorted by rollno
             * 111 bbbb london
             * 121 cccc jaipur
             * 131 aaaa nyc
         */
        Manage manage = new Manage();

        manage.demerging(list);
        manage.display();
    }
}

package p14_sort_algorithm.thuchanh.selectionSort;

import java.util.Arrays;

public class Check {
    public static void main(String[] args) {
        int[] a = {6, 23, 13, 1, 13, 45};
        insertionSort(a);
        display(a);
    }

    static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
            Arrays.stream(a).forEach(System.out::println);
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * Ví dụ selectionSort
     [12, 11, 13, 5, 6]
     *
     * Hãy để chúng ta lặp lại i = 1 (phần tử thứ hai của mảng) đến 4 (phần tử cuối cùng của mảng)
     *
     * i = 1. Vì 11 nhỏ hơn 12 nên di chuyển 12 và chèn 11 vào trước 12
     *
     * 11, 12, 13, 5, 6
     *
     * i = 2. 13 sẽ vẫn ở vị trí của nó vì tất cả các phần tử trong A [0..I-1] đều nhỏ hơn 13
     *
     * 11, 12, 13, 5, 6
     *
     * i = 3. 5 sẽ di chuyển về đầu và tất cả các phần tử khác từ 11 đến 13 sẽ di chuyển trước một vị trí so với vị trí hiện tại của chúng.
     *
     * 5, 11, 12, 13, 6
     *
     * i = 4. 6 sẽ chuyển đến vị trí sau 5, và các phần tử từ 11 đến 13 sẽ di chuyển trước một vị trí so với vị trí hiện tại của chúng.
     *
     => [5, 6, 11, 12, 13]
     */
    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertion = array[i];
            int j = i - 1;

            // array[j] > insertion: số nào lớn hơn key -> di chuyển vị trí key thay thế bằng số đó
            // lặp lại đến khi nào a[j] < insertion -> lúc đó j giảm bằng -1
            // thoát vòng lặp a[0] = key
            for (; j >= 0 && array[j] > insertion; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = insertion;
        }
    }
}

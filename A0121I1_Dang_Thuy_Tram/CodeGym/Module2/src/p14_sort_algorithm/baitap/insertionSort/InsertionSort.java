package p14_sort_algorithm.baitap.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            System.out.println("Insert " + arr[j + 1] + " into " + key);
            arr[j + 1] = key;
        }
    }

    // In các phần tử của mảng
    public static void printArray(int arr[]) {
        int n = arr.length;
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println("Mảng ban đầu:");
        printArray(arr);
        InsertionSort selectionSort = new InsertionSort();
        selectionSort.sort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }
}

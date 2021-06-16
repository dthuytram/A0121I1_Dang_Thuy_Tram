package p14_sort_algorithm.baitap.insertionSort;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.util.Scanner;

public class InsertionSortByStep {
    public InsertionSortByStep() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");

        int i;
        for(i = 0; i < list.length; ++i) {
            list[i] = scanner.nextInt();
        }

        System.out.print("Your input list: ");

        for(i = 0; i < list.length; ++i) {
            System.out.print(list[i] + "\t");
        }

        System.out.println("\nBegin sort processing...");
        insertSortByStep(list);
    }

    public static void insertSortByStep(int[] list) {
        for(int i = 1; i < list.length; ++i) {
            int key = list[i];

            int j;
            for(j = i - 1; j >= 0 && list[j] > key; --j) {
                list[j + 1] = list[j];
            }

            System.out.println("Insert " + key + " into " + list[j + 1]);
            list[j + 1] = key;
            System.out.print("List after the  " + i + "' sort: ");

            for(int k = 0; k < list.length; ++k) {
                System.out.print(list[k] + "\t");
            }

            System.out.println();
        }

    }
}

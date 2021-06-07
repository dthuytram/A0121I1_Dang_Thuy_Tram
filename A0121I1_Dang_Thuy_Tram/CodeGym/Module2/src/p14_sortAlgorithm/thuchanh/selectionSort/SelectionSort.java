package p14_sortAlgorithm.thuchanh.selectionSort;

/**
 * Mục đích
 * Luyện tập cài đặt thuật toán sắp xếp chọn.
 *
 * Mô tả
 * Viết phương thức selectionSort(int[] list) để sắp xếp các số trong một mảng theo trật tự giảm dần.
 */
public class SelectionSort {
//    Bước 1: Tạo lớp SelectionSort, khai báo một mảng số thực chưa được sắp xếp.

    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
        // codes below here


//    Bước 2: Cài đặt phương thức selectionSort(int[] list).
//
//    Giải thuật sắp xếp chọn (Selection Sort) là một giải thuật đơn giản. Giải thuật sắp xếp này là một giải thuật dựa trên việc so sánh in-place, trong đó danh sách được chia thành hai phần, phần được sắp xếp (sorted list) ở bên trái và phần chưa được sắp xếp (unsorted list) ở bên phải. Ban đầu, phần được sắp xếp là trống và phần chưa được sắp xếp là toàn bộ danh sách ban đầu.
//
//    Phần tử nhỏ nhất được lựa chọn từ mảng chưa được sắp xếp và được tráo đổi với phần bên trái nhất và phần tử đó trở thành phần tử của mảng được sắp xếp. Tiến trình này tiếp tục cho tới khi toàn bộ từng phần tử trong mảng chưa được sắp xếp đều được di chuyển sang mảng đã được sắp xếp.

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            /* Find the minimum in the list[i..list.length-1] */
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            /* Swap list[i] with list[currentMinIndex] if necessary */
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
//    Bước 3: Cài đặt phương thức main để thực thi ứng dụng.

    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}

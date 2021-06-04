package searchAlgorithm.thuchanh.binarySearch;

/**
 * Binary Search chỉ dùng cho list đã sắp xếp sẵn
 * Để lựa chọn giá trị giữa
 */
public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    /**
     * Binary Search tìm kiếm một phần tử cụ thể
     * bằng cách so sánh phần tử tại vị trí giữa nhất của tập dữ liệu.
     * Nếu tìm thấy kết nối thì chỉ mục của phần tử được trả về.
     * Nếu phần tử cần tìm là lớn hơn giá trị phần tử giữa thì phần tử cần tìm được tìm trong mảng con nằm ở bên phải phần tử giữa;
     * nếu không thì sẽ tìm ở trong mảng con nằm ở bên trái phần tử giữa.
     * Tiến trình sẽ tiếp tục như vậy trên mảng con cho tới khi tìm hết mọi phần tử trên mảng con này.
     */
    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            // chia list thành bên trái và phải
            int mid = (low + high) / 2;

            //nếu key nhỏ hơn giá trị giữa -> chọn nhánh bên trái
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])   // nếu lớn hơn -> chọn nhánh bên phải
                return mid;
            else
                low = mid + 1;
        }
        return -1; /* Now high < low, key not found */
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));  /* 0 */
        System.out.println(binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }

}

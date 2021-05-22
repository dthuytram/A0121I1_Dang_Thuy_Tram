package arrayList.thuchanh;

import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10; // so phan tu toi da trong danh sach mac dinh
    private Object elements[]; // mang doi tuong element chua cac phan tu trong dsach

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    // Tăng gấp đôi kích thước mảng chứa các phần tử
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    /**Mục đích: thêm một phần tử vào cuối của danh sách
     Tham số đầu vào: phần tử cần thêm vào danh sách
     **/
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
  /**  Mục đích: Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.

    Tham số đầu vào: số nguyên chứa vị trí cần truy cập đến phần tử trong danh sách

   **/
  public E get(int i) {
      if (i>= size || i <0) {
          throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
      }
      return (E) elements[i];
  }

  
}

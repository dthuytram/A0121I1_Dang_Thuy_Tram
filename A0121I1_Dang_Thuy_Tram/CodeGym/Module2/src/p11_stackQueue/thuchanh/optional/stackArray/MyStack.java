package p11_stackQueue.thuchanh.optional.stackArray;

/**
 * Miêu tả bài tập
 * Lớp MyStack bao gồm các thành phần sau:
 *
 * Thuộc tính
 *
 * -       size có kiểu số nguyên, lưu số phần tử trong stack
 *
 * -       arr có kiểu mảng số nguyên, lưu danh sách các phần tử trong stack
 *
 * -       index có kiểu số nguyên, mặc định gán giá trị 0, xác định vị trí của từng phần tử trong stack
 *
 * Phương thức khởi tạo:
 *
 * MyStack(int): khởi tạo số phần tử trong stack
 *
 * Phương thức
 *
     * push(): chèn phần tử mới vào stack
     *
     * pop(): xoá phần tử khỏi stack
     *
     * size(): trả về số phần tử hiện tại của stack
     *
     * isEmpty(): kiểm tra xem stack có rỗng không
     *
     * isFull(): kiểm tra xêm stack có đầy không
 *
 * Lớp StackClient chứa phương thức main() để thực thi ứng dụng.
 */
public class MyStack {
        private int arr[];
        private int size;
        private int index = 0;

        public MyStack(int size) {
            this.size = size;
            arr = new int[size];
        }
        // Phuong thuc push
        public void push(int element){
            if (isFull()) {
                throw new StackOverflowError("Stack is full");
            }
            arr[index] = element;
            index++;
        }

        // Phuong thuc pop
        public int pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("Stack is null");
            }
            return arr[--index];
        }

        //Phuong thuc size
        public int size() {
            return index;
        }


        public boolean isEmpty() {
            if (index == 0) {
                return true;
            }
            return false;
        }


        public boolean isFull() {
            if (index == size) {
                return true;
            }
            return false;
        }
}

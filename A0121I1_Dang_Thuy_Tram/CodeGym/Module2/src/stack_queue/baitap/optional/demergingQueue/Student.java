package stack_queue.baitap.optional.demergingQueue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * [Optional] [Bài tập] Tổ chức dữ liệu hợp lý - Demerging sử dụng Queue
 * Mục đích
    * Luyện tập sử dụng Queue

 * Mô tả
    * Giả sử, với một hệ thống quản lý nhân sự. Các bản ghi được lưu trên file.
    * Mỗi bản ghi gồm các trường: Họ tên, giới tính, ngày tháng năm sinh, ...
    * Dữ liệu trên đã được sắp theo ngày tháng năm sinh.
    * Cần tổ chức lại dữ liệu sao cho nữ được liệt kê trước nam nhưng vẫn giữ được tính đã sắp theo ngày tháng năm sinh.

 * Cách giải quyết:

 * Ý tưởng không hiệu quả:
     * Sử dụng thuật toán sắp xếp.
     * Độ phức tạp của thuật toán O(n log n) trong trường hợp tốt nhất.

 * Ý tưởng hiệu quả hơn:
     * Sử dụng giải thuật demerging.
     * Độ phức tạp của giải thuật này là O(n).

 * Giải thuật Demerging:
     * 1. Tạo 2 queue rỗng, có tên lần lượt là NU và NAM.

     * 2. Với mỗi bản ghi p, xem xét:
         * Nếu p có giới tính nữ, đưa vào queue NU.
         * Nếu p có giới tính nam, đưa vào queue NAM.

     * 3. Xét queue NU, khi queue chưa rỗng:
         * Lấy từng phần tử trong queue này.
         * Ghi vào file output nào đó.

     * 4. Xét queue NAM, khi queue chưa rỗng:
         * Lấy từng phần tử trong queue này.
         * Ghi tiếp vào file output trên.

     * 5. Kết thúc giải thuật.
 */
public class Student implements Comparable<Student>{
    private String name;
    private String sex;
    private Date birthday;

    public Student() {
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Student(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // format ngay theo dang
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.printf("Name: %-10s - Sex: %-12s - Birthday: %tF \n",name,sex,birthday);
    }

    @Override
    public int compareTo(Student o) {
        return this.birthday.compareTo(o.birthday);
    }
}

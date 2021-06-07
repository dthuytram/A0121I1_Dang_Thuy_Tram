package p11_stackQueue.baitap.optional.thapPhan_NhiPhan;

import java.util.Scanner;

/**
 * [Optional] [Bài tập] Chuyển đổi từ hệ thập phân sang hệ nhị phân
 * Mục đích
    * Luyện tập sử dụng Stack
 *
 * Mô tả
    * Chuyển đổi từ hệ thập phân sang hệ chị phân. Các hệ số hay sử dụng: hệ thập phân (Decimal); hệ nhị phân (Binary); hệ 16 (Hexadecimal). Con người thường sử dụng hệ thập phân. Đối với máy tính, thường sử dụng hệ nhị phân. Hệ 16 là hệ trung gian giữa hệ thập phân và hệ nhị phân.
    * VD: 111 = (01101111)B = (6F)H

 * Việc chuyển đổi giữa các hệ số thường xét:

     * Chuyển đổi từ hệ thập phân sang hệ nhị phân.
     * Chuyển đổi từ hệ nhị phân sang hệ thập phân.
     * Chuyển đổi từ hệ thập phân sang hệ 16.
     * Chuyển đổi từ hệ 16 sang hệ thập phân.

 * Hướng dẫn
 * Ý tưởng:
 *
 * VD: Chuyển đổi từ hệ thập phân sang hệ nhị phân sử dụng Stack:
 *
     * 1. Khởi tạo một Stack rỗng.
     *
     * 2. Chuyển đổi số từ dạng thập phân sang nhị phân bằng phép chia lấy dư cho 2.
     *
     * 3. Kết quả của phép chia được đưa vào Stack.
     *
     * 4. Đọc từ Stack cho đến hết, kết quả được nối với nhau để tạo thành chuỗi.
     *
     * 5. Kết thúc giải thuật.

 * Hãy xây dựng chương trình chuyển đổi hệ thập phân sang hệ chị phân sử dụng Stack
 */
public class ConvertMain {
    public static void main(String[] args) {
        Convert a = new Convert();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số thập phân: ");
        System.out.println("Số chuyển thành nhị phân:" + a.convertDecToX((sc.nextInt()),2));
        System.out.println("Số chuyển thành hexa:" + a.convertDecToX((sc.nextInt()),16));

//        System.out.println("Nhập vào số nhị phân: ");
//        System.out.println("Số chuyển thành thập phân:" + a.convertBinToDecimal(sc.nextInt()));
    }
}

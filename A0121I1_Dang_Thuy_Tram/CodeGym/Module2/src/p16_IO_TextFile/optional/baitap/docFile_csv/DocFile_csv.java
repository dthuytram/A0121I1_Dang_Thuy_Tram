package p16_IO_TextFile.optional.baitap.docFile_csv;
/**
 * [Optional] [Bài tập] Đọc file .csv
 * Mục đích
 * Luyện tập đọc/ghi file text
 *
 * Mô tả bài toán
 * Cho một file csv lưu danh sách các quốc gia. Hãy thực hiện đọc file và hiển thị danh sách các quốc gia.
 *
 * "1.0.0.0","1.0.0.255","16777216","16777471","AU","Australia"
 * "1.0.1.0","1.0.3.255","16777472","16778239","CN","China"
 * "1.0.4.0","1.0.7.255","16778240","16779263","AU","Australia"
 * "1.0.8.0","1.0.15.255","16779264","16781311","CN","China"
 * "1.0.16.0","1.0.31.255","16781312","16785407","JP","Japan"
 * "1.0.32.0","1.0.63.255","16785408","16793599","CN","China"
 * "1.0.64.0","1.0.127.255","16793600","16809983","JP","Japan"
 * "1.0.128.0","1.0.255.255","16809984","16842751","TH","Thailand"
 * Gợi ý:
 * Có thể sử dụngn phương thức split() của lớp String để cắt chuỗi.
 *
 * Tham khảo hướng dẫn tại đây: https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DocFile_csv {
    public static void main(String[] args)
    {
        String line = "";
        String splitBy = ",";
        try
        {
        //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\p16_IO_TextFile\\optional\\baitap\\docFile_csv\\text.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
                System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

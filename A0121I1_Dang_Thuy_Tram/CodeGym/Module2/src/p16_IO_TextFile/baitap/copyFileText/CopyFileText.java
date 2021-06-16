package p16_IO_TextFile.baitap.copyFileText;

import java.io.*;

public class CopyFileText {

    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\p16_IO_TextFile\\baitap\\copyFileText\\SourceFile.txt"));
            outStream = new FileOutputStream(new File("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\p16_IO_TextFile\\baitap\\copyFileText\\TargetFile.txt"));
            byte[] buffer = new byte[1024];

            int length;
            while((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            System.out.println("Copy thanh cong");
        } catch (IOException exception) {
            System.out.println("File khong ton tai hoac co loi!");
        } finally {
            inStream.close();
            outStream.close();
        }

    }
}

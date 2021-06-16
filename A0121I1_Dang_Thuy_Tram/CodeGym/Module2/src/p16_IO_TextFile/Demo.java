package p16_IO_TextFile;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * PropertiesOfFile
         */
//        File f = new File("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2");
//        System.out.println(" Is exist: " + f.exists());
////        System.out.println(" Is folder: "+f.isDirectory());
//        for(String item:f.list()){
//            System.out.println(item);
//        }
//        System.out.println("Absolute path: "+f.getAbsolutePath());
//        System.out.println("Is hidden: "+ f.isHidden());

        /**
         * WriteFile
         */
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\p16_IO_TextFile\\baitap\\copyFileText\\SourceFile.txt");
//            writer.write("Hello");
//            writer.close();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }finally {
//
//        }
        /**
         * writeFileWothStream
         */
//        try {
//            FileWriter writer = new FileWriter("D:\\\\A0121I1_Dang_Thuy_Tram(1)\\\\A0121I1_Dang_Thuy_Tram\\\\CodeGym\\\\Module2\\\\src\\\\p16_IO_TextFile\\\\baitap\\\\copyFileText\\\\SourceFile.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            bufferedWriter.write("helloCodegym");
//            bufferedWriter.newLine();
//            // ghi du lieu tu buffer sang file
//            bufferedWriter.flush();
//            // bufferedWriter.close();
//            // bao gom lenh flush
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
        /**
         * readerFileWithBuffer
         */
//        try {
//            FileReader fileReader = new FileReader("D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\p16_IO_TextFile\\baitap\\copyFileText\\SourceFile.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            int line = -1;
//            while ((line = bufferedReader.read()) != -1) {
//                System.out.println(line);
//            }
//            bufferedReader.close();
//            fileReader.close();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
    }
}

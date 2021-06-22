package _case_2_.examRevision.bai1_mxduy.commons;

import _case_2_.examRevision.bai1_mxduy.models.KhachHang;
import _case_2_.examRevision.bai1_mxduy.models.SoTietKiem;
import _case_2_.examRevision.bai1_mxduy.models.SoTietKiemDaiHan;
import _case_2_.examRevision.bai1_mxduy.models.SoTietKiemVoThoiHan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DocGhiFile {
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String HEADER_DAI_HAN = "MaSo,maKhachHang,NgayMoSo,ThoiGainBatDau,SoTieuGui,LaiSuat,KyHan,UuDai";
    private static final String HEADER_VO_THOI_HAN = "MsSo,maKhachHang,NgayMoSo,SoTieuGui,LaiSuat";

    private static final String FILE_DAI_HAN = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_case_2_\\examRevision\\bai1_mxduy\\data\\stkdaihan.csv";
    private static final String FILE_VO_THOI_HAN = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_case_2_\\examRevision\\bai1_mxduy\\data\\stknganhan.csv";
    private static final String FILE_CUSTOMER = "D:\\A0121I1_Dang_Thuy_Tram(1)\\A0121I1_Dang_Thuy_Tram\\CodeGym\\Module2\\src\\_case_2_\\examRevision\\bai1_mxduy\\data\\khachhang.csv";

    public static void writeFileSoTietKiemDaiHan(List<SoTietKiem> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_DAI_HAN);
            fileWriter.append(HEADER_DAI_HAN);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (SoTietKiem soTietKiem : list) {
                fileWriter.append(soTietKiem.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("ERROR IN WRITE CUSTOMER TO FILE CSV");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("ERROR WHEN FLUSH OR CLOSE FILE CSV");
            }
        }
    }

    public static List<SoTietKiem> readFileDaiHan() {
        BufferedReader brRead = null;
        List<SoTietKiem> list = new ArrayList<>();
        Path path = Paths.get(FILE_DAI_HAN);

        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(FILE_DAI_HAN);
            } catch (Exception ex) {
                System.out.println("ABC");
            }
        }

        try {
            brRead = new BufferedReader(new FileReader(FILE_DAI_HAN));
            String line;
            while ((line = brRead.readLine()) != null) {
                String[] splitDta = line.split(",");
                if (splitDta[0].equals("MaSo")) {
                    continue;
                }
                SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan();
                soTietKiemDaiHan.setMaSo(splitDta[0]);
                soTietKiemDaiHan.setMaKhachHang(splitDta[1]);
                soTietKiemDaiHan.setNgayMoSo(splitDta[0]);
                soTietKiemDaiHan.setThoigianBatDauGui(splitDta[2]);
                soTietKiemDaiHan.setSoTienGui(splitDta[3]);
                soTietKiemDaiHan.setLaiSuat(splitDta[4]);
                soTietKiemDaiHan.setKyHan(splitDta[5]);
                soTietKiemDaiHan.setUuDai(splitDta[6]);
                list.add(soTietKiemDaiHan);
            }
        } catch (Exception ex) {
        } finally {
            try {
                brRead.close();
            } catch (Exception ex)  {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }


    public static void writeFileSoTietKiemVoThoiGian(List<SoTietKiem> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_VO_THOI_HAN);
            fileWriter.append(HEADER_VO_THOI_HAN);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (SoTietKiem soTietKiem : list) {
                fileWriter.append(soTietKiem.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("ERROR IN WRITE CUSTOMER TO FILE CSV");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("ERROR WHEN FLUSH OR CLOSE FILE CSV");
            }
        }
    }

    public static List<SoTietKiem> readFileVoThoiHan() {
        BufferedReader brRead = null;
        List<SoTietKiem> list = new ArrayList<>();
        Path path = Paths.get(FILE_DAI_HAN);

        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(FILE_VO_THOI_HAN);
            } catch (Exception ex) {
                System.out.println("ABC");
            }
        }

        try {
            brRead = new BufferedReader(new FileReader(FILE_VO_THOI_HAN));
            String line;
            while ((line = brRead.readLine()) != null) {
                String[] splitDta = line.split(",");
                if (splitDta[0].equals("MaSo")) {
                    continue;
                }
                SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan();
                soTietKiemVoThoiHan.setMaSo(splitDta[0]);
                soTietKiemVoThoiHan.setMaKhachHang(splitDta[1]);
                soTietKiemVoThoiHan.setNgayMoSo(splitDta[2]);
                soTietKiemVoThoiHan.setSoTienGui(splitDta[3]);
                soTietKiemVoThoiHan.setLaiSuat(splitDta[4]);
                list.add(soTietKiemVoThoiHan);
            }
        } catch (Exception ex) {
        } finally {
            try {
                brRead.close();
            } catch (Exception ex)  {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }


    //-----------
    //Read File customer
    public static void writeFileCustomerToCSV(List<KhachHang> listCustomer) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FILE_CUSTOMER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (KhachHang customer : listCustomer) {
                fileWriter.append(customer.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("ERROR IN WRITE CUSTOMER TO FILE CSV");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("ERROR WHEN FLUSH OR CLOSE FILE CSV");
            }
        }
    }


    public static Map<String, KhachHang> readFileKhachhang() {
        BufferedReader brReader = null;
        Map<String, KhachHang> khachhangMap = new LinkedHashMap<>();
        Path path = Paths.get(FILE_CUSTOMER);

        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(FILE_CUSTOMER);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            brReader = new BufferedReader(new FileReader(FILE_CUSTOMER));
            String line;
            while ((line = brReader.readLine()) != null) {
                String[] splitdata = line.split(",");
                if (splitdata[0].equals("Name")) {
                    continue;
                }
                KhachHang khachhang = new KhachHang();
                khachhang.setMaKhachHang(splitdata[0]);
                khachhang.setTenKhachHang(splitdata[1]);
                khachhang.setNgaySinh(splitdata[2]);
                khachhang.setGioiTinh(splitdata[3]);
                khachhang.setSoDienThoai(splitdata[4]);
                khachhang.setDiaChi(splitdata[5]);
                String makhachhang = String.format("%d", khachhangMap.size() + 1);
                khachhangMap.put(makhachhang, khachhang);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                brReader.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return khachhangMap;
    }
}

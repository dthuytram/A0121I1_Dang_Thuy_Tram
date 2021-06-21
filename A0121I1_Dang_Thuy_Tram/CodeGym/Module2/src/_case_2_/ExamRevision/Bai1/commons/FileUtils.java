package _case_2_.ExamRevision.Bai1.commons;

import _case_2_.ExamRevision.Bai1.models.PhoneChinhHang;
import _case_2_.ExamRevision.Bai1.models.PhoneXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

        public static void writeBrandMobile(PhoneChinhHang brandMobile) {
            FileUtils file = new FileUtils("brandmobile.csv");
            BufferedWriter bufferedWriter = null;
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(brandMobile.getId() + "," + brandMobile.getTen() + "," + brandMobile.getGia() + "," +
                        brandMobile.getSoLuong() + "," + brandMobile.getNhaSanXuat() + "," +
                        brandMobile.getThoigianBaoHanh() + "," + brandMobile.getPhamviBaoHanh() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void writeSecondMobile(PhoneXachTay secondMobile) {
            FileUtils file = new FileUtils("secondmobile.csv");
            BufferedWriter bufferedWriter = null;
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(secondMobile.getId() + "," + secondMobile.getTen() + "," +
                        secondMobile.getGia() + "," + secondMobile.getSoLuong()
                        + "," + secondMobile.getNhaSanXuat() + "," + secondMobile.getQuocGia() +
                        "," + secondMobile.getTrangThai() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static List<PhoneChinhHang> getListBrandMobile() {
            List<PhoneChinhHang> brandMobileList = new ArrayList<>();
            FileUtils file = new FileUtils("brandmobile.csv");
            BufferedReader bufferedReader = null;
            String line;
            PhoneChinhHang brandMobile;
            String[] temp;
            try {
                FileReader fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    temp = line.split(",");
                    brandMobile = new PhoneChinhHang(Integer.parseInt(temp[0]), temp[1],
                            Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4],
                            Integer.parseInt(temp[5]), temp[6]);
                    brandMobileList.add(brandMobile);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return brandMobileList;
        }

        public static void readBrandMobile() {
            List<PhoneChinhHang> brandMobileList;
            brandMobileList = getListBrandMobile();
            for (PhoneChinhHang element : brandMobileList) {
                element.showInfor();
            }
        }

        public static int getIdLastBrandMobile() {
            List<PhoneChinhHang> brandMobileList;
            brandMobileList = getListBrandMobile();
            int lastIndex = brandMobileList.size() - 1;
            if (brandMobileList.size() == 0) {
                return 0;
            } else {
                return brandMobileList.get(lastIndex).getId();
            }
        }

        public static void searchNameBrandMobile(String myString) {
            List<PhoneChinhHang> brandMobileList;
            List<PhoneChinhHang> foundList = new ArrayList<>();
            brandMobileList = getListBrandMobile();
            for (int i = 0; i < brandMobileList.size(); i++) {
                if (brandMobileList.get(i).getTen().contains(myString)) {
                    foundList.add(brandMobileList.get(i));
                }
            }
            if (foundList.size() == 0) {
                System.out.println("Khong tim thay");
            } else {
                for (PhoneChinhHang element : foundList) {
                    element.showInfor();
                }
            }

        }

        public static List<PhoneXachTay> getListSecondMobile() {
            List<PhoneXachTay> secondMobileList = new ArrayList<>();
            FileUtils file = new FileUtils("secondmobile.csv");
            BufferedReader bufferedReader = null;
            String line;
            PhoneXachTay secondMobile;
            String[] temp;
            try {
                FileReader fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    temp = line.split(",");
                    secondMobile = new PhoneXachTay(Integer.parseInt(temp[0]), temp[1],
                            Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], temp[6]);
                    secondMobileList.add(secondMobile);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return secondMobileList;
        }


        public static void readSecondMobile() {
            List<PhoneXachTay> secondMobileList;
            secondMobileList = getListSecondMobile();
            for (PhoneXachTay element : secondMobileList) {
                element.showInfor();
            }
        }

        public static int getIdLastSecondMobile() {
            List<PhoneXachTay> secondMobileList;
            secondMobileList = getListSecondMobile();
            int lastIndex = secondMobileList.size() - 1;
            if (secondMobileList.size() == 0) {
                return 0;
            } else {
                return secondMobileList.get(lastIndex).getId();
            }
        }

        public static void searchNameSecondMobile(String myString) {
            List<PhoneXachTay> secondMobileList;
            List<PhoneXachTay> foundSecondMobileList = new ArrayList<>();
            secondMobileList = getListSecondMobile();
            for (int i = 0; i < secondMobileList.size(); i++) {
                if (secondMobileList.get(i).getTen().contains(myString)) {
                    foundSecondMobileList.add(secondMobileList.get(i));
                }
            }
            if (foundSecondMobileList.size() == 0) {
                System.out.println("Khong tim thay");
            } else {
                for (PhoneXachTay element : foundSecondMobileList) {
                    element.showInfor();
                }
            }
        }

        public static void deleteBrandMobile(int id) {
            List<PhoneChinhHang> brandMobileList;
            brandMobileList = getListBrandMobile();

            for (int i = 0; i < brandMobileList.size(); i++) {
                if (id == brandMobileList.get(i).getId()) {
                    brandMobileList.remove(i);
                }
            }
            FileUtils file = new FileUtils("brandmobile.csv");
            BufferedWriter bufferedWriter = null;
            try {
                FileWriter fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < brandMobileList.size(); i++) {
                    bufferedWriter.write(brandMobileList.get(i).getId() + "," + brandMobileList.get(i).getName() + "," + brandMobileList.get(i).getPrice() + "," + brandMobileList.get(i).getQuantity() + "," + brandMobileList.get(i).getBrand() + "," + brandMobileList.get(i).getTimeGuarantee() + "," + brandMobileList.get(i).getRangeGuarante() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void deleteSecondMobile(int id) {

            List<PhoneXachTay> secondMobileList;
            secondMobileList = getListSecondMobile();

            for (int i = 0; i < secondMobileList.size(); i++) {
                if (id == secondMobileList.get(i).getId()) {
                    secondMobileList.remove(i);
                }
            }
            FileUtils file = new FileUtils("secondmobile.csv");
            BufferedWriter bufferedWriter = null;
            try {
                FileWriter fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < secondMobileList.size(); i++) {
                    bufferedWriter.write(secondMobileList.get(i).getId() + "," + secondMobileList.get(i).getName() + "," + secondMobileList.get(i).getPrice() + "," + secondMobileList.get(i).getQuantity() + "," + secondMobileList.get(i).getBrand() + "," + secondMobileList.get(i).getFromNation() + "," + secondMobileList.get(i).getStatus() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



package _case_2_.ExamRevision.Bai1.controllers;

public class ManagerSmartPhone {
    Scanner scanner = new Scanner(System.in);
    public final String P = ",";
    public final String LINK_CH = "data.csv";
    public final String LINK_XT = "mobiles.csv";

    public int exceptionInputNumber() {
        int temp = 0;
        boolean checkException;
        do {
            try {
                temp = Integer.parseInt(scanner.nextLine());
                checkException = false;
            } catch (NumberFormatException n) {
                System.out.println("Number false ! ! !");
                System.out.print("Re-enter number: ");
                checkException = true;
            }
        } while (checkException);
        return temp;
    }

    public void menu() {
        do {
            System.out.print("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI - \n" +
                    "Chọn chức năng theo số ( để tiếp tục): \n" +
                    "1. Thêm mới \n" +
                    "2. Xóa \n" +
                    "3. Xem danh sách điện thoại \n" +
                    "4. Tìm kiếm \n" +
                    "5. Thoát \n" +
                    "Chọn chức năng:");
            int choice = exceptionInputNumber();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    show();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Re-enter the number: ");
            }
        } while (true);
    }

    private void show() {
        do {
            System.out.print("1. Xem danh sách điện thoại chính hãng: \n" +
                    "2. Xem danh sách điện thoại xách tay: \n" +
                    "3. Exit" +
                    "enter the choice: ");

            int choice = exceptionInputNumber();
            switch (choice) {
                case 1:
                    System.out.println(readCH());
                    break;
                case 2:
                    System.out.println(readIdXT());
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("En-ter the choice: ");

            }
        } while (true);
    }

    private void remove() {
        System.out.print("1. Xóa điện thoại chính hãng theo ID\n" +
                "2. Xóa điện thoại xách tay theo ID\n" +
                "Enter the choice: ");
        do {
            int choice = exceptionInputNumber();
            switch (choice) {
                case 1:
                    removeCH();
                    break;
                case 2:
                    removeXT();
                    break;
                default:
                    System.out.println("Choice false");
            }
        } while (true);
    }

    private void removeXT() {
        System.out.print("Nhập id muốn xóa: ");
        int id = exceptionInputNumber();
        List<PhoneXachTay> list = new ArrayList<>();

        for (int i = 0; i < readXT().size(); i++) {
            if (readXT().get(i).getId() == id) {
                continue;
            }
            list.add(readXT().get(i));
        }
        File file = new File(LINK_XT);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).getId() + P + list.get(i).getName() + P + list.get(i).getValue() +
                        P + list.get(i).getSoLuong() + P + list.get(i).getNhaSX() + P + list.get(i).getQuocGia() +
                        P + list.get(i).getTrangThai() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void removeCH() {
        System.out.print("Nhập id muốn xóa: ");
        int id = exceptionInputNumber();
        List<PhoneChinhHang> list = new ArrayList<>();

        for (int i = 0; i < readCH().size(); i++) {
            if (readCH().get(i).getId() == id) {
                continue;
            }
            list.add(readCH().get(i));
        }
        File file = new File(LINK_CH);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).getId() + P + list.get(i).getName() + P + list.get(i).getValue() +
                        P + list.get(i).getSoLuong() + P + list.get(i).getNhaSX() + P + list.get(i).getTime() +
                        P + list.get(i).getPhamViBaoHanh() + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewCH(PhoneChinhHang phoneChinhHang) {
        File file = new File(LINK_CH);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(phoneChinhHang.getId() + P + phoneChinhHang.getName() + P + phoneChinhHang.getValue() + P + phoneChinhHang.getSoLuong()
                    + P + phoneChinhHang.getNhaSX() + P + phoneChinhHang.getTime() + P + phoneChinhHang.getPhamViBaoHanh() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewXT(PhoneXachTay phoneXachTay) {
        File file = new File(LINK_XT);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(phoneXachTay.getId() + P + phoneXachTay.getName() + P + phoneXachTay.getValue() + P + phoneXachTay.getSoLuong()
                    + P + phoneXachTay.getNhaSX() + P + phoneXachTay.getQuocGia() + P + phoneXachTay.getTrangThai() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int readIdCH() {
        int id = 0;
        File file = new File(LINK_CH);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                id = Integer.parseInt(temp[0]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int readIdXT() {
        int id = 0;
        File file = new File(LINK_XT);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                id = Integer.parseInt(temp[0]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void add() {
        System.out.print("1. Thêm mới điện thoại chính hãng \n" +
                "2. Thêm mới điện thoại xách tay \n" +
                "Enter the choice: ");
        int choiceAdd = exceptionInputNumber();
        System.out.print("Enter the infor: \n name:  ");
        String name = scanner.nextLine();
        System.out.print("value= ");
        int value = exceptionInputNumber();
        System.out.print("soLuong:");
        int soLuong = exceptionInputNumber();
        System.out.print("nhaSX: ");
        String nhaSX = scanner.nextLine();
        switch (choiceAdd) {
            case 1:
                int idCH = readIdCH();
                idCH++;
                int time;
                do {
                    System.out.print("date (ngày) = ");
                    time = exceptionInputNumber();
                } while (time < 0 || time > 730);

                String phamViBaoHanh;
                do {
                    System.out.print("Phạm vi bảo hành ( Trong nước or quốc tế) : ");
                    phamViBaoHanh = scanner.nextLine();
                } while (!phamViBaoHanh.equals("Toan Quoc") && !phamViBaoHanh.equals("Quoc Te"));

                PhoneChinhHang phoneChinhHang = new PhoneChinhHang(idCH, name, value, soLuong, nhaSX, time, phamViBaoHanh);
                addNewCH(phoneChinhHang);
                break;
            case 2:
                int idXT = readIdXT();
                idXT++;
                String quocGiaXT;
                do {
                    System.out.print("Quốc gia XT: ");
                    quocGiaXT = scanner.nextLine();
                } while (quocGiaXT.equals("Viet Nam"));

                String trangThai;
                do {
                    System.out.print("Trạng thái: ");
                    trangThai = scanner.nextLine();
                } while (!trangThai.equals("Da sua chua") && !trangThai.equals("Chua sua chua"));

                PhoneXachTay phoneXachTay = new PhoneXachTay(idXT, name, value, soLuong, nhaSX, quocGiaXT, trangThai);
                addNewXT(phoneXachTay);
                break;

            default:
                System.out.print("Choice false!! ");
        }
    }

    public List<PhoneChinhHang> readCH() {
        List<PhoneChinhHang> list = new ArrayList<>();
        File file = new File(LINK_CH);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            PhoneChinhHang phoneChinhHang;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                phoneChinhHang = new PhoneChinhHang(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], Integer.parseInt(temp[5]), temp[6]);
                list.add(phoneChinhHang);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PhoneXachTay> readXT() {
        List<PhoneXachTay> list = new ArrayList<>();
        File file = new File(LINK_XT);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            PhoneXachTay phoneXachTay;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                phoneXachTay = new PhoneXachTay(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], temp[5], temp[6]);
                list.add(phoneXachTay);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        ManagerSmartPhone phone = new ManagerSmartPhone();
        phone.menu();
    }
}

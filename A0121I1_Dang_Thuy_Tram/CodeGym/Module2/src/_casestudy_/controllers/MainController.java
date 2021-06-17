package _casestudy_.controllers;

import _casestudy_.model.House;
import _casestudy_.model.Room;
import _casestudy_.model.Service;
import _casestudy_.model.Villa;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainController {
    static int choice;
    static Scanner scanner = new Scanner(System.in);
    IO_Services io_services = new IO_Services();
    public static String nameServices, rentalType, id, dvPlus;
    public static int area, money, peopleMax;
    /**
     * Kiểm tra số nhập vào là số không
     * @return number
     */
    public static int checkInputNumber() {
        int temp = 0;
        boolean checkException = false;
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

    /**
     * Menu chính
     */
    public void displayMainMenu() throws IOException {
        while (true) {
            System.out.println(
                    "1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            System.out.print("Enter the choice: ");
            // Đáng lẽ là:
            // " choice = checkInputNumber();
            //   switch(choice)
            // "
            // => Ghi tắt thành:
            //switch (checkInputNumber())
            switch (checkInputNumber()) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:

                case 7:
                    System.out.println("Exit.......");
                    System.exit(0);
            }
        }
    }

    /**
     * Học viên tạo phương thức có tên là " addNewServies()"  để thực hiện
     * nhập thông tin cho một dịch vụ cho thuê bất kỳ (Villa, House hoặc Room).
     * Bao gồm trình đơn:
         * Add New Villa
         * Add New House
         * Add New Room
         * Back to menu
         * Exit
     * Khi người dùng chọn chức năng số 1 thì chương trình sẽ cho phép
     * nhập các thuộc tính của  Villa và sau đó ghi vào file data/Villa.csv

     * Khi người dùng chọn chức năng số 2 thì chương trình sẽ cho phép
     * nhập các thuộc tính của House và sau đó ghi vào file data/House.csv

     * Khi người dùng chọn chức năng số 3 thì chương trình sẽ cho phép
     * nhập các thuộc tính của Room và sau đó ghi vào file data/Room.csv

     * 	Ghi chú: Học viên tạo class có để thực hiện đọc/ghi file csv
     */
    public void addNewServices() throws IOException {

        while (true) {
            System.out.println("---------\n" +
                    "1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to menu\n" +
                    "5. Exit");
            System.out.print("Enter the choice: ");
            choice = checkInputNumber();
            if (choice == 1 || choice == 2 || choice == 3) {
                generalInput();
                switch (choice) {
                    case 1:
                        addNewVilla();
                        break;
                    case 2:
                        addNewHouse();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                }
            } else if (choice == 4) {
                displayMainMenu();
            } else if (choice == 5) {
                System.exit(0);
            } else System.out.println("Number choice fails !!! ");
        }
    }
    public static void generalInput() {
        System.out.print("nameServices: ");
        nameServices = scanner.nextLine();
        System.out.print("area= ");
        area = checkInputNumber();
        System.out.print("money= ");
        money = checkInputNumber();
        System.out.print("peopleMax= ");
        peopleMax = checkInputNumber();
        System.out.print("rentalType: ");
        rentalType = scanner.nextLine();
        System.out.print("id= ");
        id = scanner.nextLine();
        System.out.print("dvPlus: ");
        dvPlus = scanner.nextLine();
    }

    private void addNewRoom() {
        System.out.print("dvFree: ");
        String dvFree = scanner.nextLine();
        Room room = new Room(nameServices, area, money, peopleMax, rentalType, id, dvPlus, dvFree);
        io_services.writeRoom(room);
    }

    private void addNewHouse() {
        System.out.print("tieuchuanPhong: ");
        String tieuChuanPhong = scanner.nextLine();
        System.out.print("paintedTienNghi: ");
        String paintedTienNghi = scanner.nextLine();
        System.out.print("soTang= " + "\n");
        int soTang = checkInputNumber();
        House house = new House(nameServices, area, money, peopleMax, rentalType,
                id, dvPlus, tieuChuanPhong, paintedTienNghi, soTang);
        io_services.writeHouse(house);
    }


    private void addNewVilla() {
        System.out.print("tieuchuanPhong: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Facilities Description: ");
        String facilitiesDes = scanner.nextLine();
        System.out.println("Floors: ");
        int floors = checkInputNumber();
        System.out.println("Pool Area: ");
        int poolArea = checkInputNumber();
        Villa villa = new Villa(nameServices, area , money, peopleMax, rentalType, id, dvPlus, roomStandard, facilitiesDes, floors, poolArea);
        io_services.writeVilla(villa);
    }

    /**
     * Task 3:
     * Học viên xây dựng phương thức showServices() hiển thị trình đơn bao gồm:
     *
         * Show all Villa
         * Show all House
         * Show all Room
         * Show All Name Villa Not Duplicate
         * Show All Name House Not Duplicate
         * Show All Name Name Not Duplicate
         * Back to menu
         * Exit
     *
     * Chọn chức năng 1 Show all Villa thì chương trình sẽ hiển thị danh sách tất cả các Villa
     * Chọn chức năng 2 Show all House thì chương trình sẽ hiển thị danh sách tất cả các House
     * Chọn chức năng 3 Show all Room thì chương trình sẽ hiển thị danh sách tất cả các Room
     * Chọn chức năng 4 Show all name Villa not duplicate thì chương trình sẽ hiển thị danh sách tên tất cả các Villa có trong hệ thống được mô tả ở Task 8
     * Chọn chức năng 5 Show all name House not duplicate thì chương trình sẽ hiển thị danh sách tên tất cả các House có trong hệ thống được mô tả ở Task 8
     * Chọn chức năng 6 Show all name Room not duplicate thì chương trình sẽ hiển thị danh sách tên tất cả các Room có trong hệ thống được mô tả ở Task 8
     * Chọn chức năng 7 Back to menu thì chương trình sẽ hiển thị trình đơn được xử lý ở displayMainMenu()
     * Chọn chức năng 8, thoát khỏi chương trình

         * Lưu ý: Sử dụng ArrayList để lấy dữ liệu tương ứng từ File CSV tương ứng của từng mục, sau đó sử dụng foreach để duyệt arraylist kèm theo
         * phương thức showInfor() của mỗi đối tượng đã được tạo ở bài trước để show thông tin ra màn hình.
     */
    public void showServices() throws IOException {
        while (true) {
            System.out.println("---------\n" +
                    "1. Show all Villa\n" +
                    "2. Show all House\n" +
                    "3. Show all Room\n" +
                    "4. Show All Name Villa Not Duplicate (khong trung nhau)\n" +
                    "5. Show All Name House Not Duplicate (khong trung nhau)\n" +
                    "6. Show All Name Name Not Duplicate (khong trung nhau)\n" +
                    "7. Back to menu\n" +
                    "8. Exit");
            System.out.print("Enter the choice: ");
            choice = checkInputNumber();
            switch (choice) {
                case 1:
                    System.out.println(io_services.readVilla());
                    break;
                case 2:
                    System.out.println(io_services.readHouse());
                    break;
                case 3:
                    System.out.println(io_services.readRoom());
                    break;
                case 4:
                    showNameVilla();
                    break;
                case 5:
                    showNameHouse();
                    break;
                case 6:
                    showNameRoom();
                    break;
                case 7:
                    System.out.println("Quay lai menu........... ");
                    displayMainMenu();
                    break;
                case 8:
                    System.out.println("Exit............");
                    System.exit(0);
                default:
                    System.out.println("The choice false !! ");
            }
        }
    }
    public void showNameVilla() throws IOException {
        TreeSet<String> listVilla = new TreeSet<>();
        for (Villa each : io_services.readVilla()) {
            listVilla.add(each.getNameService());
        }
        System.out.println(listVilla);
    }

    public void showNameHouse() throws IOException {
        TreeSet<String> listHouse = new TreeSet<>();
        for (House each : io_services.readHouse()) {
            listHouse.add(each.getNameService());
        }

        System.out.println(listHouse);
    }

    public void showNameRoom() throws IOException {
        TreeSet<String> listRoom = new TreeSet<>();
        for (Room each : io_services.readRoom()) {
            System.out.println(each.getNameService());
            listRoom.add(each.getNameService());
        }
        System.out.println(listRoom);
    }

    public static void main(String[] args) throws IOException {
        MainController main = new MainController();
        main.displayMainMenu();
    }
}

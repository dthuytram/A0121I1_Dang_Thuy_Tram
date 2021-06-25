package ab.commons;

import ab.model.*;
import java.util.*;

import static ab.commons.CustomerValidate.*;
import static ab.main.MainView.*;

public class Input {
    static Room room;
    static House house;
    static Villa villa;
    static Customer customer;
    static String input;
    static Scanner scanner = new Scanner(System.in);

    public static Villa villa() {
        villa = new Villa();
        System.out.println(" ---------------VILLA INFORMATION:");
        generalInput();
        villaInput();
        return villa;
    }
    public static House house() {
        house = new House();
        System.out.println("---------------HOUSE INFORMATION:");
        generalInput();
        houseInput();
        return house;
    }
    public static Room room() {
        room = new Room();
        System.out.println("---------------ROOM INFORMATION:");
        generalInput();
        roomInput();
        return room;
    }
    public static Customer customer() {
        customer = new Customer();
        System.out.println("---------------CUSTOMER INFORMATION:");
        customerInput();
        return customer;
    }


    // Each Villa, House, Room input
    public static void villaInput() {
        do {
            System.out.print("7. Room Type: ");
            input = scanner.nextLine();
        } while (!ServiceValidator.checkServiceName(input));
        villa.setRoomType(input);
        do {
            System.out.print("8. Comp Service (Massage,Karaoke,Food,Drink,Car): ");
            input = scanner.nextLine();
        } while (!ServiceValidator.checkCompService(input));
        villa.setOtherService(input);
        do {
            System.out.print("9. Pool Area (lớn hơn 30m^2): ");
            input = scanner.nextLine();
        } while (!ServiceValidator.checkArea(input));
        villa.setPoolArea(Double.parseDouble(input));
        do {
            System.out.print("10. Floor: ");
            input = scanner.nextLine();
        } while (!ServiceValidator.checkFloor(input));
        villa.setFloorNumber(Integer.parseInt(input));
    }

    public static void houseInput() {
        do {
            System.out.print("7. Room Type: ");
            input  = scanner.nextLine();
        } while (!ServiceValidator.checkServiceName(input ));
        house.setRoomType(input );
        do {
            System.out.print("8. OtherService (Massage,Karaoke,Food,Drink,Car): ");
            input  = scanner.nextLine();
        } while (!ServiceValidator.checkCompService(input ));
        house.setCompService(input);
        do {
            System.out.print("9. Floor: ");
            input  = scanner.nextLine();
        } while (!ServiceValidator.checkFloor(input ));
        house.setFloor(Integer.parseInt(input ));
    }

    public static void roomInput() {
        String input;
        do {
            System.out.print("7. Comp Services (Massage,Karaoke,Food,Drink,Car): ");
            input = scanner.nextLine();
        } while (!ServiceValidator.checkCompService(input));
        room.setOtherService(input);
    }

    // Common Input for 3 services
    private static void generalInput() {
        String inputTemp;
        do {
            System.out.print("1. ID: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkRoomId(inputTemp) || !ServiceValidator.checkDuplicateId(inputTemp, roomList));
        room.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkServiceName(inputTemp));
        room.setServiceName(inputTemp);
        do {
            System.out.print("3. Area (lớn hơn 30m^2): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkArea(inputTemp));
        room.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkRate(inputTemp));
        room.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity (nhỏ hơn 20 người): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkMaxCapacity(inputTemp));
        room.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type (Year,Month,Week,Day): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidator.checkRentType(inputTemp));
        room.setRentType(inputTemp);
    }

    public static void customerInput() {
        do {
            System.out.print("1. Name: ");
            input = scanner.nextLine();
        } while (!checkName(input));
        customer.setName(input);
        do {
            System.out.print("2. Birthday: ");
            input = scanner.nextLine();
        } while (!checkBirthday(input));
        customer.setBirthday(input);
        do {
            System.out.print("3. Gender: ");
            input = scanner.nextLine();
        } while (!checkGender(input));
        //Format gender data (Male, Female, Unknown)
        String gender = "";
        gender = gender.concat(String.valueOf(Character.toUpperCase(input.charAt(0))));
        for (int i = 1; i < input.length(); i++) {
            gender = gender.concat(String.valueOf(Character.toLowerCase(input.charAt(i))));
        }
        customer.setGender(gender);
        do {
            System.out.print("4. ID: ");
            input = scanner.nextLine();
        } while (!checkId(input));
        customer.setId(input);
        do {
            System.out.print("5. Phone Number: ");
            input = scanner.nextLine();
        } while (!checkPhoneNumber(input));
        customer.setPhoneNumber(input);
        do {
            System.out.print("6. Email: ");
            input = scanner.nextLine();
        } while (!checkEmail(input));
        customer.setEmail(input);
        do {
            System.out.print("7. Customer Class: ");
            input = scanner.nextLine();
        } while (!checkCustomerType(input));
        customer.setCustomerType(input);
        System.out.print("8. Address: ");
        customer.setAddress(scanner.nextLine());
        customer.setServices(null);
    }

    // Mục đích: để chọn element trong list
    public static <T> T selectElementInList(List<T> list) {
        int index;
        // Bước 1: in tất cả các phần tử của danh sách với đánh số theo chỉ số của phần tử + 1
        for (T element : list) {
            System.out.println((list.indexOf(element) + 1) + ". " + element.toString());
        }
        // Bước 2: Chọn phần tử theo số nhập từ bàn phím. Chỉ số của phần tử = numberInput - 1
        // thử lại nếu chỉ mục nằm ngoài giới hạn của danh sách
        do {
            System.out.print("CHỌN ELEMENT: ");
            index = Integer.parseInt(scanner.nextLine()) - 1;
            IndexOutOfBoundException(list, index);
        } while (index < 0 || index >= list.size());
        return list.get(index);
    }

    private static <T> void IndexOutOfBoundException(List<T> list, int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Nhập index sai. VUI LÒNG NHẬP LẠI !!!");
            scanner.nextLine();
        }
    }
}

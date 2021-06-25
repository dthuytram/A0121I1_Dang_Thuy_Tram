package ab.controllers;

import ab.commons.*;
import ab.model.*;
import java.util.*;

import static ab.controllers.MainController.displayMainMenu;
import static ab.main.MainView.*;

public class ServiceController {
    static Villa villa;
    static House house;
    static Room room;
    public static void addNewServices() {
        System.out.print("---------------\nSERVICES: \n" +
                "1. Add new villa\n" +
                "2. Add new house\n" +
                "3. Add new room\n" +
                "4. Back to menu\n" +
                "5. Exit\n" +
                "Please enter your choose: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1": {
                villa = Input.villa();
                villaList.add(villa);
                FileCSV.writeServicesToCSV(villaList, VILLA_LINK);
                System.out.println("Thêm " + villa.showInfo() + " thành công");
                System.out.println("Nhập ENTER");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "2": {
                house = Input.house();
                houseList.add(house);
                FileCSV.writeServicesToCSV(houseList, HOUSE_LINK);
                System.out.println("Thêm " + house.showInfo() + " thành công");
                System.out.println("Nhập ENTER");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "3": {
                room = Input.room();
                roomList.add(room);
                FileCSV.writeServicesToCSV(roomList, ROOM_LINK);
                System.out.println("Thêm " + house.showInfo() + " thành công");
                System.out.println("Nhập ENTER");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "4":{
                displayMainMenu();
                break;
            }
            case "5":
                System.exit(0);
            default: {
                System.out.println("Nhập sai. Vui lòng ENTER để nhập lại !!!");
                scanner.nextLine();
                addNewServices();
            }
        }
    }

    public static void showServices() {
        System.out.println("---------------");
        System.out.print("SHOW ALL SERVICES\n" +
                "1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show all name of villa not duplicate\n" +
                "5. Show all name of house not duplicate\n" +
                "6. Show all name of room not duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit\n" +
                "Please choose the function: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1": {
                for (Services services : villaList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Nhấn ENTER để tiếp tục");
                scanner.nextLine();
                showServices();
                break;
            }
            case "2": {
                for (Services services : houseList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Nhấn ENTER để tiếp tục");
                scanner.nextLine();
                showServices();
                break;
            }
            case "3": {
                for (Services services : roomList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Nhấn ENTER để tiếp tục");
                scanner.nextLine();
                showServices();
                break;
            }
            case "4": {
                showServiceNameNotDuplicate(villaList);
                showServices();
                break;
            }
            case "5": {
                showServiceNameNotDuplicate(houseList);
                showServices();
                break;
            }
            case "6": {
                showServiceNameNotDuplicate(roomList);
                showServices();
                break;
            }
            case "7": {
                displayMainMenu();
                break;
            }
            case "8": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Nhập sai. Vui lòng ENTER để nhập lại !!!");
                scanner.nextLine();
                showServices();
            }
        }
    }

    public static void showServiceNameNotDuplicate(List<Services> serviceList) {
        TreeSet<String> serviceNameList = new TreeSet<>();
        for (Services service : serviceList) {
            serviceNameList.add(service.getServiceName());
        }
        System.out.println(serviceNameList.toString());
        System.out.println("Nhấn ENTER để tiếp tục");
        scanner.nextLine();
    }
}

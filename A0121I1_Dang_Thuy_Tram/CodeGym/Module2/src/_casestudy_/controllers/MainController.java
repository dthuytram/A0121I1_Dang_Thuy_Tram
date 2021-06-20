package _casestudy_.controllers;
import static _casestudy_.controllers.BookingController.addNewBooking;
import static _casestudy_.controllers.CinemaTicketController.cinemaTicket;
import static _casestudy_.controllers.EmployeeController.*;
import static _casestudy_.main.MainView.scanner;
import static _casestudy_.controllers.CustomerController.*;
import static _casestudy_.controllers.ServiceController.*;

public class MainController {
    public static void displayMainMenu() {
        System.out.print("---------------\nMAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customers\n" +
                "5. Add new booking\n" +
                "6. Cinema ticket\n" +
                "7. Show information of Employee\n" +
                "8. Search employee profile\n" +
                "9. Exit\n" +
                "Please choose the function: ");
        String mainMenuIndex = scanner.nextLine();
        switch (mainMenuIndex) {
            case "1":
                addNewServices();
                break;
            case "2": {
                showServices();
                break;
            }
            case "3":
                addNewCustomer();
                break;
            case "4": {
                showCustomerList();
                break;
            }
            case "5": {
                addNewBooking();
                break;
            }
            case "6": {
                cinemaTicket();
                break;
            }
            case "7": {
                showEmployee();
                break;
            }
            case "8": {
                searchEmployee();
                break;
            }
            case "9":
                System.exit(0);
            default:
                System.out.println("Nhập sai. Vui lòng ENTER để nhập lại !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }
}

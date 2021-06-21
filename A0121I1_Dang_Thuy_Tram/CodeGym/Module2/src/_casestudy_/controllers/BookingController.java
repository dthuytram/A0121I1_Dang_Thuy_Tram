package _casestudy_.controllers;

import _casestudy_.commons.FileCSV;
import _casestudy_.commons.Input;
import _casestudy_.model.Customer;
import _casestudy_.model.Services;

import static _casestudy_.controllers.MainController.displayMainMenu;
import static _casestudy_.main.MainView.*;

public class BookingController {
    public static void addNewBooking() {
        System.out.println("--------------");
        System.out.println("ADD NEW BOOKING");
        System.out.println("LIST OF CUSTOMERS");
        Customer customer = Input.selectElementInList(customerList);
        System.out.println("Customer: " + customer.getName() + " - " + customer.getBirthday() + " - " + customer.getId());
        System.out.print("LIST OF SERVICES: \n" +
                "1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "Please choose function: ");
        String bookingIndex = scanner.nextLine();
        switch (bookingIndex) {
            case "1": {
                Services service = Input.selectElementInList(villaList);
                if (bookingList.contains(customer)){
                    customer.setServices(service);
                } else {
                    customer.setServices(service);
                    bookingList.add(customer);
                }
                FileCSV.writeCustomerToCSV(customerList, CUSTOMER_LINK);
                FileCSV.writeBookingToCSV(bookingList, BOOKING_LINK);
                System.out.println("Add " + customer.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "2": {
                Services service = Input.selectElementInList(houseList);
                if (bookingList.contains(customer)){
                    customer.setServices(service);
                } else {
                    customer.setServices(service);
                    bookingList.add(customer);
                }
                FileCSV.writeCustomerToCSV(customerList, CUSTOMER_LINK);
                FileCSV.writeBookingToCSV(bookingList, BOOKING_LINK);
                System.out.println("Add " + customer.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "3": {
                Services service = Input.selectElementInList(roomList);
                if (bookingList.contains(customer)){
                    customer.setServices(service);
                } else {
                    customer.setServices(service);
                    bookingList.add(customer);
                }
                FileCSV.writeCustomerToCSV(customerList, CUSTOMER_LINK);
                FileCSV.writeBookingToCSV(bookingList, BOOKING_LINK);
                System.out.println("Add " + customer.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
            }
        }
    }
}

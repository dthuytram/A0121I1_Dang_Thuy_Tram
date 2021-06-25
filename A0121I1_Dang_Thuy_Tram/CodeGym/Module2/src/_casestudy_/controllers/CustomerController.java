package ab.controllers;

import static ab.main.MainView.scanner;

import ab.commons.FileCSV;
import ab.commons.Input;
import ab.commons.SortCustomer;
import ab.model.Customer;

import java.util.Collections;

import static ab.controllers.MainController.displayMainMenu;
import static ab.main.MainView.CUSTOMER_LINK;
import static ab.main.MainView.customerList;

public class CustomerController {
    public static void addNewCustomer() {
        Customer customer = Input.customer();
        customerList.add(customer);
        FileCSV.writeCustomerToCSV(customerList, CUSTOMER_LINK);
        System.out.println("Add " + customer.showInfo() + " successfully");
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showCustomerList(){
        SortCustomer sortCustomer = new SortCustomer();
        Collections.sort(customerList, sortCustomer);
        System.out.println("-----------------");
        System.out.println("LIST OF CUSTOMERS");
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }
}

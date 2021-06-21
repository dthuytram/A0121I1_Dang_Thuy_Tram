package _casestudy_.controllers;

import static _casestudy_.main.MainView.scanner;

import _casestudy_.commons.FileCSV;
import _casestudy_.commons.Input;
import _casestudy_.commons.SortCustomer;
import _casestudy_.model.Customer;

import java.util.Collections;

import static _casestudy_.controllers.MainController.displayMainMenu;
import static _casestudy_.main.MainView.CUSTOMER_LINK;
import static _casestudy_.main.MainView.customerList;

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

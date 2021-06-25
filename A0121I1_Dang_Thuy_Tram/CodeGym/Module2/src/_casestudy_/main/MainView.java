package ab.main;

import ab.commons.FileCSV;
import ab.model.Customer;
import ab.model.Employee;
import ab.model.Profile;
import ab.model.Services;

import java.util.*;

import static ab.controllers.MainController.displayMainMenu;

public class MainView {
    public static Scanner scanner = new Scanner(System.in);
    public static final String VILLA_LINK = "src/data/Villa.csv";
    public static final String HOUSE_LINK = "src/data/House.csv";
    public static final String ROOM_LINK = "src/data/Room.csv";
    public static final String CUSTOMER_LINK = "src/data/Customer.csv";
    public static final String BOOKING_LINK = "src/data/Booking.csv";
    public static final String EMPLOYEE_LINK = "src/data/Employee.csv";

    public static final String VILLA_CODE = "SVVL";
    public static final String HOUSE_CODE = "SVHO";
    public static final String ROOM_CODE = "SVRO";

    public static List<Services> villaList = new ArrayList<>();
    public static List<Services> houseList = new ArrayList<>();
    public static List<Services> roomList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();

    public static LinkedHashMap<String, Employee> employeeHashMap = new LinkedHashMap<>();
    public static List<Customer> bookingList = new ArrayList<>();
    public static Queue<Customer> waitingList = new LinkedList<>();
    public static Queue<Customer> boughtTicketList = new LinkedList<>();
    public static Profile profile = new Profile();
    public static int numTicket = 0;
    public static void main(String[] args) {
        readServices();
        readCustomer();
        readEmployee();
        getListCustomer();
        displayMainMenu();
    }

    private static void getListCustomer() {
        //list all customers who have booked service != null to bookingList
        for (Customer customer : customerList){
            if (customer.getServices() != null){
                bookingList.add(customer);
            }
        }
    }

    private static void readEmployee() {
        //Read Employee data from CSV file
        employeeHashMap = FileCSV.readEmployeeFromCSV(EMPLOYEE_LINK);
    }

    private static void readCustomer() {
        //read customerList data from CSV file.
        customerList = FileCSV.readCustomerListFromCSV(CUSTOMER_LINK, VILLA_CODE, villaList);
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_LINK, HOUSE_CODE, houseList));
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_LINK, ROOM_CODE, roomList));
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_LINK, "null", null));
    }

    private static void readServices() {
        //Read service list data from CSV file
        villaList = FileCSV.readServiceListFromCSV(VILLA_LINK);
        houseList = FileCSV.readServiceListFromCSV(HOUSE_LINK);
        roomList = FileCSV.readServiceListFromCSV(ROOM_LINK);
    }
}

package _casestudy_.main;

import _casestudy_.commons.FileCSV;
import _casestudy_.model.Customer;
import _casestudy_.model.Employee;
import _casestudy_.model.Profile;
import _casestudy_.model.Services;

import java.util.*;

import static _casestudy_.controllers.MainController.displayMainMenu;

public class MainView {
    public static Scanner scanner = new Scanner(System.in);
    public static final String VILLA_LINK = "src/data/Villa.csv";
    public static final String HOUSE_LINK = "src/data/House.csv";
    public static final String ROOM_LINK = "src/data/Room.csv";
    public static final String CUSTOMER_FILE_PATH = "src/data/Customer.csv";
    public static final String BOOKING_FILE_PATH = "src/data/Booking.csv";
    public static final String EMPLOYEE_FILE_PATH = "src/data/Employee.csv";
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
    public static Profile profileCarbinet = new Profile();
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
        employeeHashMap = FileCSV.readEmployeeFromCSV(EMPLOYEE_FILE_PATH);
    }

    private static void readCustomer() {
        //read customerList data from CSV file.
        customerList = FileCSV.readCustomerListFromCSV(CUSTOMER_FILE_PATH, VILLA_CODE, villaList);
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_FILE_PATH, HOUSE_CODE, houseList));
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_FILE_PATH, ROOM_CODE, roomList));
        customerList.addAll(FileCSV.readCustomerListFromCSV(CUSTOMER_FILE_PATH, "null", null));
    }

    private static void readServices() {
        //Read service list data from CSV file
        villaList = FileCSV.readServiceListFromCSV(VILLA_LINK);
        houseList = FileCSV.readServiceListFromCSV(HOUSE_LINK);
        roomList = FileCSV.readServiceListFromCSV(ROOM_LINK);
    }
}

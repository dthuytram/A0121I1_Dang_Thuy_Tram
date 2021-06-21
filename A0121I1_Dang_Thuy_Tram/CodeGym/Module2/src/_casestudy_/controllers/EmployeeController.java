package _casestudy_.controllers;

import _casestudy_.model.Employee;

import static _casestudy_.controllers.MainController.displayMainMenu;
import static _casestudy_.main.MainView.employeeHashMap;

import static _casestudy_.main.MainView.*;

public class EmployeeController {
    public static void showEmployee(){
        System.out.println("--------------------");
        System.out.println("LIST OF EMPLOYEE");
        for (String key : employeeHashMap.keySet()) {
            System.out.println(key + " - " + employeeHashMap.get(key));
        }
        System.out.println("Nhấn ENTER để nhập lại !!!");
        scanner.nextLine();
        displayMainMenu();
    }

    public static void searchEmployee(){
        for (String key : employeeHashMap.keySet()) {
            profile.add(employeeHashMap.get(key));
        }
        System.out.print("Input employee name: ");
        String name = scanner.nextLine();
        Employee employee = profile.search(name);
        if (employee == null) {
            System.out.println("Employee profile not found");
        } else {
            System.out.println(employee.toString());
        }
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }
}

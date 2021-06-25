package ab.model;

import java.util.Stack;

public class Profile {
    // Ho so
    private Stack<Employee> employeeStack = new Stack<>();

    public Profile() {
    }

    public void add(Employee employee){
        employeeStack.add(employee);
    }

    public Employee search(String name){
        for (Employee employee: employeeStack){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
}

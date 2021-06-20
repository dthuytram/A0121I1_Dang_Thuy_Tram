package _casestudy_.commons;

import _casestudy_.model.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileCSV {
    private static final String NEW_LINE = "\n";
    private static final String VILLA_CODE = "SVVL";
    private static final String HOUSE_CODE = "SVHO";
    private static final String ROOM_CODE = "SVRO";

    public static void writeServicesToCSV(List<Services> serviceList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Services service : serviceList) {
                //Writing header to the file
                if (serviceList.indexOf(service) == 0) {
                    fileWriter.append(service.getHeader());
                    fileWriter.append(NEW_LINE);
                }
                //Writing service data to the file
                fileWriter.append(service.writeToCSV());
                fileWriter.append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Services> readServiceListFromCSV(String filePath) {
        BufferedReader br = null;
        List<Services> serviceList = new ArrayList<>();

        //Check file tổn tại hay không. Nếu không, tạo file mới theo path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[1].equals("Service Name")) {
                    //Bỏ qua dòng header
                    continue;
                }
                String serviceId = splitData[0].substring(0, 4);

                //Base on service ID to identify class of elements, initialize service object and add to the list
                switch (serviceId) {
                    case VILLA_CODE: {
                        Villa villa = new Villa(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Double.parseDouble(splitData[8]), Integer.parseInt(splitData[9]));
                        serviceList.add(villa);
                        break;
                    }
                    case HOUSE_CODE: {
                        House house = new House(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Integer.parseInt(splitData[8]));
                        serviceList.add(house);
                        break;
                    }
                    case ROOM_CODE: {
                        Room room = new Room(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6]);
                        serviceList.add(room);
                        break;
                    }
                }
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return serviceList;
    }

    public static void writeCustomerToCSV(List<Customer> customerList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Customer customer : customerList) {
                //Writing header to the file
                if (customerList.indexOf(customer) == 0) {
                    fileWriter.append(customer.getHeader());
                    fileWriter.append(NEW_LINE);
                }
                //Writing service data to the file
                fileWriter.append(customer.writeToCSV());
                fileWriter.append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Customer> readCustomerListFromCSV(String filePath, String serviceCode, List<Services> serviceList) {
        //** Method reading list of bookings from the file following the file path.
        BufferedReader br = null;
        List<Customer> customerList = new ArrayList<>();

        //Check the file exists or not. If not, create new file following the file path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                //Bỏ qua dòng header
                if (splitData[0].equals("Name")) {
                    continue;
                }
                if (splitData[8].substring(0, 4).equals(serviceCode)) {
                    Customer customer = new Customer(splitData[0], splitData[1], splitData[2], splitData[3],
                            splitData[4], splitData[5], splitData[6], splitData[7], null);
                    //Search service by service ID and set to customer
                    if (!serviceCode.equals("null")) {
                        for (Services service : serviceList) {
                            if (service.getId().equals(splitData[8])) {
                                customer.setServices(service);
                            }
                        }
                    }
                    customerList.add(customer);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customerList;
    }

    public static void writeBookingToCSV(List<Customer> bookingList, String filePath) {
        //**Method writing booking list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Customer booking : bookingList) {
                //Writing header to the file
                if (bookingList.indexOf(booking) == 0) {
                    fileWriter.append(booking.getHeader());
                    fileWriter.append(NEW_LINE);
                }
                //Writing service data to the file
                fileWriter.append(booking.writeToCSV());
                fileWriter.append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static LinkedHashMap<String, Employee> readEmployeeFromCSV(String filePath) {
        BufferedReader br = null;
        LinkedHashMap<String, Employee> employeeHashMap = new LinkedHashMap<>();

        //Check the file exists or not. If not, create new file following the file path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                //Skip reading header
                if (splitData[0].equals("Name")) {
                    continue;
                }
                Employee employee = new Employee();
                employee.setName(splitData[0]);
                employee.setAge(Integer.parseInt(splitData[1]));
                employee.setAddress(splitData[2]);
                String employeeId = String.format("NV%04d", employeeHashMap.size() + 1);
                employeeHashMap.put(employeeId, employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return employeeHashMap;
    }
}

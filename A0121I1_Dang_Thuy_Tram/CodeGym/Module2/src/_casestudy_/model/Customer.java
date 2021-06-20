package _casestudy_.model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String id, String phoneNumber, String email, String customerType, String address, Services services) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String getFirstName() {
        String[] fullname = this.name.split(" ");
        return fullname[fullname.length - 1];
    }

    public LocalDate getBirthdayToDate() {
        String[] birthdayArr = this.birthday.split("/");
        LocalDate date = LocalDate.of(
                Integer.parseInt(birthdayArr[2]),
                Integer.parseInt(birthdayArr[1]),
                Integer.parseInt(birthdayArr[0]));
        return date;
    }

    public String showInfo() {
        return "Customer+ \n" +
                "name='" + name + "'\n" +
                ", birthday='" + birthday + "'\n" +
                ", gender='" + gender + "'\n" +
                ", id='" + id + "'\n" +
                ", phoneNumber='" + phoneNumber + "'\n" +
                ", email='" + email + "'\n" +
                ", customerClass='" + customerType + "'\n" +
                ", address='" + address + "'\n" +
                ", bookedService='" + (services == null ? "null" : services.showInfo()) + "'\n" ;
    }

    public String getHeader() {
        return "Name,Birthday,Gender,Id,Phone Number,Email,Customer Class,Address,Booked Service";
    }

    public String writeToCSV() {
        return name +
                "," + birthday +
                "," + gender +
                "," + id +
                "," + phoneNumber +
                "," + email +
                "," + customerType +
                "," + address +
                "," + (services == null ? null : services.getId());

    }

    @Override
    public String toString() {
        return "Customer: \n" +
                "name='" + name + "'\n" +
                ", birthday='" + birthday + "'\n" +
                ", gender='" + gender + "'\n" +
                ", id='" + id + "'\n" +
                ", phoneNumber='" + phoneNumber + "'\n" +
                ", email='" + email + "'\n" +
                ", customerClass='" + customerType + "'\n" +
                ", address='" + address + "'\n" +
                ", bookedService=" + (services == null ? "null" : services.showInfo()) ;
    }
}

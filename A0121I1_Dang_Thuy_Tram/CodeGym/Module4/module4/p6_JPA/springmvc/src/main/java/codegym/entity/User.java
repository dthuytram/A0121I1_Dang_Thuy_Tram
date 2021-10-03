package codegym.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="findCustomerByAge", query = "select u from User u where u.age = ?1"),
        @NamedQuery(name="findCustomerByName", query = "select u from User u where u.name like :name"),
})
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    private String address;

    public User() {
    }

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

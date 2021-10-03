package codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProvince;
    private String name;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Province() {
    }

    public Province(int idProvince, String name, List<Customer> customers) {
        this.idProvince = idProvince;
        this.name = name;
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

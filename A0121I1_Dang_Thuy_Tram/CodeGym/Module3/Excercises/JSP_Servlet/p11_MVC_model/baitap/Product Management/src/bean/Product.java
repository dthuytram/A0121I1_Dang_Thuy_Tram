package bean;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private String country;

    public Product() {
    }

    public Product(int id, String name, float price, int amount, String country) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.country = country;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

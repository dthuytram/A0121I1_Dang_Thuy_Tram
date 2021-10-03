package codegym.entity;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String description;
    private double priceProduct;
    private String producer;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, String description, double priceProduct, String producer) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.producer = producer;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

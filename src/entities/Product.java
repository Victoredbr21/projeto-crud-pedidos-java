package entities;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    //getters

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;

    }
} // essa chave fecha a classe
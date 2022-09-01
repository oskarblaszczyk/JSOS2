package pl.kurs.model;

public class Equipment {
    private String name;
    private Double price;

    public Equipment(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Equipment() {
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}

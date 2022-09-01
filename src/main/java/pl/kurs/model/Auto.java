package pl.kurs.model;

public class Auto {

    private String producer;//brand
    private int doors;//doorsNumber

    public Auto() {
    }

    public Auto(String producer, int doors) {
        this.producer = producer;
        this.doors = doors;
    }

    public String getProducer() {
        return producer;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "producer='" + producer + '\'' +
                ", doors=" + doors +
                '}';
    }
}

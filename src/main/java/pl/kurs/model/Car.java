package pl.kurs.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Car {
    private String brand;
    private String model;
    private Double engineCapacity;
    private boolean hasTurbo;
    private List<Equipment> equipmentList;

    public Car(String brand, String model, Double engineCapacity, boolean hasTurbo, List<Equipment> equipmentList) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.hasTurbo = hasTurbo;
        this.equipmentList = equipmentList;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public boolean getIsHasTurbo() {
        return hasTurbo;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public double getEquipmentPrice() {
        double equipmentPrice = 0;
        for (Equipment eq : getEquipmentList()) {
            equipmentPrice += eq.getPrice();
        }
        return equipmentPrice;
    }

    public static Car getTheMostExpensiveCar(List<Car> carList) {
        return Optional.ofNullable(carList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Car::getEquipmentPrice))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", hasTurbo=" + hasTurbo +
                ", equipmentList=" + equipmentList +
                '}';
    }
}

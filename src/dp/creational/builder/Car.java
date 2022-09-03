package dp.creational.builder;

public class Car {

    String fuel;
    int seatCount;
    double mileage;
    String manufacturer;
    String modelName;

    public Car setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car setSeatCount(int seatCount) {
        this.seatCount = seatCount;
        return this;
    }

    public Car setMileage(double mileage) {
        this.mileage = mileage;
        return this;
    }

    public Car setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Car setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
}

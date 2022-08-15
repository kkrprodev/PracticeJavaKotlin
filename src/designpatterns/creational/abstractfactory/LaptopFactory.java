package designpatterns.creational.abstractfactory;

public class LaptopFactory implements Factory {

    @Override
    public Device getDevice(String brand){
        return switch (brand){
            case "hp" -> new HP();
            case "asus" -> new Asus();
            default -> null;
        };
    }
}

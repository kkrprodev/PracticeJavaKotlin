package dp.creational.abstractFactory;

import dp.creational.abstractFactory.products.AsusVivoBook;
import dp.creational.abstractFactory.products.Device;
import dp.creational.abstractFactory.products.HPEnvy;

public class LaptopFactory implements Factory {

    @Override
    public Device getDevice(String brand){
        return switch (brand){
            case "hp" -> new HPEnvy();
            case "asus" -> new AsusVivoBook();
            default -> null;
        };
    }
}

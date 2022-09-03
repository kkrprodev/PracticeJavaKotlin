package dp.creational.abstractFactory;

import dp.creational.abstractFactory.products.Device;
import dp.creational.abstractFactory.products.LenovoWorkstation;
import dp.creational.abstractFactory.products.DellDesktop;

public class DesktopFactory implements Factory {

    @Override
    public Device getDevice(String brand) {
        return switch(brand){
            case "dell" -> new DellDesktop();
            case "lenovo" -> new LenovoWorkstation();
            default -> null;
        };
    }
}

package dp.creational.abstractFactory;

import dp.creational.abstractFactory.products.Device;

public interface Factory {
     Device getDevice(String brand);
}

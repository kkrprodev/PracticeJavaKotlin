package dp.creational.factory;

import dp.creational.factory.products.IPhone;
import dp.creational.factory.products.SamsungGalaxy;

/**
 *
 * Handle instantiation of class
 *
 */
public class PhoneFactory {

    public static Phone getPhoneWithOs(String os) {
        return switch (os) {
            case "iOS" -> new IPhone();
            case "Android" -> new SamsungGalaxy();
            default -> null;
        };
    }

}

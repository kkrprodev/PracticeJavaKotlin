package designpatterns.creational;

import designpatterns.creational.abstractfactory.AbstractMegaFactory;
import designpatterns.creational.abstractfactory.Device;
import designpatterns.creational.abstractfactory.Factory;
import designpatterns.creational.abstractfactory.FactoryType;
import designpatterns.creational.builder.Car;
import designpatterns.creational.factory.Phone;
import designpatterns.creational.factory.PhoneFactory;
import designpatterns.creational.factory.S21Ultra;
import designpatterns.creational.prototype.Prototype;
import designpatterns.creational.prototype.Zenbook;
import designpatterns.creational.singleton.JSingleton;

public class Shop {

    public static void main(String[] args) {
        Phone p1 = PhoneFactory.getPremiumPhoneWithOs("iOS");
        Phone p2 = PhoneFactory.getPremiumPhoneWithOs("Android");

        Car car = new Car().setFuel("Petrol").setManufacturer("Hyundai");

        String krishna = JSingleton.getInstance("Krishna").getName();
        String kumar = JSingleton.getInstance("Kumar").getName();

        System.out.println("Krishna : " + krishna);
        System.out.println("Kumar : " + kumar);

        Zenbook zenbook = new Zenbook("Intel i9");
        zenbook.setRAM("8GB");
        System.out.println(zenbook.getRAM());
        Prototype zenbookClone = zenbook.getClone();

        System.out.println(((Zenbook)zenbookClone).getRAM());


        System.out.println("--- MEGA FACTORY ---");
        Factory factory = AbstractMegaFactory.getFactory(FactoryType.LAPTOP);
        Device hp = factory.getDevice("hp");
        System.out.println(hp.getDisplayType());
        Device asus = factory.getDevice("asus");
        System.out.println(asus.getDisplayType());

        Factory factory1 = AbstractMegaFactory.getFactory(FactoryType.MOBILE);
        Device samsung = factory1.getDevice("samsung");
        System.out.println(samsung.getDisplayType());
        Device oneplus = factory1.getDevice("oneplus");
        System.out.println(oneplus.getDisplayType());
    }
}

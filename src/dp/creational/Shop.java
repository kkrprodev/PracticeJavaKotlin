package dp.creational;

import dp.creational.abstractFactory.MegaFactory;
import dp.creational.abstractFactory.products.Device;
import dp.creational.abstractFactory.Factory;
import dp.creational.abstractFactory.enums.FactoryType;
import dp.creational.builder.Car;
import dp.creational.factory.Phone;
import dp.creational.factory.PhoneFactory;
import dp.creational.prototype.Prototype;
import dp.creational.prototype.Laptop;
import dp.creational.singleton.JSingleton;

public class Shop {

    public static void main(String[] args) {
        System.out.println("--- FACTORY PATTERN ---");
        Phone p1 = PhoneFactory.getPhoneWithOs("iOS");
        p1.start6kVideo();

        Phone phoneWithoutCamera = PhoneFactory.getPhoneWithOs("Android");
        //phoneWithoutCamera.start6kVideo();

        System.out.println("--- ABSTRACT FACTORY PATTERN ---");
        Factory factory = MegaFactory.getFactory(FactoryType.LAPTOP);
        Device hp = factory.getDevice("hp");
        System.out.println(hp.getDisplayType());
        Device asus = factory.getDevice("asus");
        System.out.println(asus.getDisplayType());

        Factory factory1 = MegaFactory.getFactory(FactoryType.DESKTOP);
        Device samsung = factory1.getDevice("dell");
        System.out.println(samsung.getDisplayType());
        Device oneplus = factory1.getDevice("lenovo");
        System.out.println(oneplus.getDisplayType());

        System.out.println("--- SINGLETON PATTERN ---");
        String krishna = JSingleton.getInstance("Krishna").getName();
        String kumar = JSingleton.getInstance("Kumar").getName();

        System.out.println("Krishna : " + krishna);
        System.out.println("Kumar : " + kumar);

        System.out.println("--- BUILDER PATTERN ---");
        Car car = new Car().setFuel("Petrol").setManufacturer("Hyundai");

        System.out.println("--- PROTOTYPE PATTERN ---");
        Laptop laptop = new Laptop("Intel i9");
        laptop.setRAM("8GB");
        Prototype laptopClone = laptop.getClone();

        System.out.println(laptopClone.toString());

    }
}

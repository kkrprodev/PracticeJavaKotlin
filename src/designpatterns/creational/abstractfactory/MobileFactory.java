package designpatterns.creational.abstractfactory;

public class MobileFactory implements Factory {

    @Override
    public Device getDevice(String brand) {
        return switch(brand){
            case "samsung" -> new Samsung();
            case "oneplus" -> new OnePlus();
            default -> null;
        };
    }
}

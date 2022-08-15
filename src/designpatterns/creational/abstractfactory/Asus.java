package designpatterns.creational.abstractfactory;

public class Asus extends Device {
    @Override
    public DisplayType getDisplayType() {
        return DisplayType.OLED;
    }
}

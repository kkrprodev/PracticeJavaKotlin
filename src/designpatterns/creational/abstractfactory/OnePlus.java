package designpatterns.creational.abstractfactory;

public class OnePlus extends Device {
    @Override
    public DisplayType getDisplayType() {
        return DisplayType.LED;
    }
}

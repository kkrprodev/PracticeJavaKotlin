package designpatterns.creational.abstractfactory;

public class HP extends Device {

    @Override
    public DisplayType getDisplayType() {
        return DisplayType.LCD;
    }
}

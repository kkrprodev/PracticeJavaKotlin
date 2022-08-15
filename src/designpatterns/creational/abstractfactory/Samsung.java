package designpatterns.creational.abstractfactory;

public class Samsung extends Device {
    @Override
    public DisplayType getDisplayType() {
        return DisplayType.AMOLED;
    }
}

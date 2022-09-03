package dp.creational.abstractFactory.products;

import dp.creational.abstractFactory.enums.DisplayType;

public class HPEnvy extends Device {

    @Override
    public DisplayType getDisplayType() {
        return DisplayType.LCD;
    }
}

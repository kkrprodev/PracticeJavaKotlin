package dp.creational.factory.products;

import dp.creational.factory.Phone;

public class SamsungGalaxy implements Phone {

    @Override
    public void start6kVideo() {
        throw new UnsupportedOperationException("6k video recording not supported");
    }
}

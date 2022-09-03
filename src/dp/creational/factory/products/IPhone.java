package dp.creational.factory.products;

import dp.creational.factory.Phone;

public class IPhone implements Phone {

    @Override
    public void start6kVideo() {
        System.out.println("Recording 6k video");
    }
}

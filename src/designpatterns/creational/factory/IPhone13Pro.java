package designpatterns.creational.factory;

public class IPhone13Pro implements Phone {
    protected IPhone13Pro() {
    }
    @Override
    public String getProcessor() {
        return "A15 Bionic";
    }

    @Override
    public String getRefreshRate() {
        return "120Hz";
    }

    @Override
    public double getPrice() {
        return 1299;
    }
}

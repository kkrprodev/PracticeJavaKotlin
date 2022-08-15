package designpatterns.creational.factory;

public class S21Ultra implements Phone {
    protected S21Ultra() {}
    @Override
    public String getProcessor() {
        return "Snapdragon 888+";
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

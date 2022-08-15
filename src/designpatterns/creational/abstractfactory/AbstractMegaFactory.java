package designpatterns.creational.abstractfactory;

public class AbstractMegaFactory {


    public static Factory getFactory(FactoryType factoryType) {
        return switch (factoryType) {
            case LAPTOP:
                 yield new LaptopFactory();
            case MOBILE:
                yield new MobileFactory();
        };
    }

}

package dp.creational.abstractFactory;

import dp.creational.abstractFactory.enums.FactoryType;

/**
 *
 * Factory of factories.
 *
 * Abstract Factory Pattern is considered as another abstraction over Factory Pattern.
 *
 */
public class MegaFactory {

    public static Factory getFactory(FactoryType factoryType) {
        return switch (factoryType) {
            case LAPTOP:
                 yield new LaptopFactory();
            case DESKTOP:
                yield new DesktopFactory();
        };
    }

}

package designpatterns.creational.factory;

public class PhoneFactory {

    public static Phone getPremiumPhoneWithOs(String os) {
        if(os.equalsIgnoreCase("iOS"))
            return new IPhone13Pro();
        else if (os.equalsIgnoreCase("Android"))
            return new S21Ultra();
        else
            return null;
    }
}

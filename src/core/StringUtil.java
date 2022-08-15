package core;

public class StringUtil {
    public static void main(String[] args) {
        String a = "AD.1";
        String b = a.substring(0, a.indexOf('.'));
        System.out.println(b);
    }
}

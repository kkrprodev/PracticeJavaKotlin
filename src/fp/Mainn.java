package fp;

import java.io.IOException;

public class Mainn {

    public static void main(String[] args) {

        ConsumerEx<String> cEx = (d) -> System.out.println(d);
        try {
            cEx.execute("deep");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

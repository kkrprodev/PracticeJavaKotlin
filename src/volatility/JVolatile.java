package volatility;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JVolatile {

    public boolean isEnough() {
        // System.out.println("Returning the current value of enough : " + enough);
        return enough;
    }

    public void setEnough(boolean enough) {
        System.out.println("Changing the value from %s to %s".formatted(this.enough, enough));
        this.enough = enough;
    }

    public volatile boolean enough;

    private static JVolatile jVolatile;

    private JVolatile() {
        enough = false;
    }

    public static JVolatile getInstance(){
        return Optional.ofNullable(jVolatile).orElseGet(()->{
            jVolatile = new JVolatile();
            return jVolatile;
        });
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Thread1());
        executorService.submit(new Thread2());
        executorService.shutdown();
    }

}

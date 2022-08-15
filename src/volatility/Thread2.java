package volatility;

public class Thread2 implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Enough data received");
        JVolatile.getInstance().setEnough(true);
    }
}

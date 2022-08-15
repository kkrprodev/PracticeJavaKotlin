package volatility;

public class Thread1 implements Runnable {

    @Override
    public void run() {

        while (!JVolatile.getInstance().isEnough()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!JVolatile.getInstance().isEnough())
                System.out.println("Sending the data " + Math.random());
        }
        System.out.println("Thread 1 closed.");
    }
}

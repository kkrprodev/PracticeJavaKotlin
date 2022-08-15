package rs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Flow;

public class KSubsriber {

    public static void main(String[] args) {

        KPublisher kPublisher = new KPublisher();
        kPublisher.subscribe(new Flow.Subscriber<Integer>() {

            private Flow.Subscription subscription;
            ArrayList<Integer> results = new ArrayList<>();

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("Subscription successful");
                this.subscription.request(2);
            }

            @Override
            public void onNext(Integer item) {

                System.out.println("Integer received : " + item);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(results.size() < 5){
                    results.add(item);
                    this.subscription.request(2);
                } else {
                    subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error :" + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("Data Completed");
            }
        });

    }
}

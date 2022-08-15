package rs;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Flow;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class KPublisher implements Flow.Publisher<Integer> {


    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        KSubsription kSubsription = new KSubsription(subscriber);
        subscriber.onSubscribe(kSubsription);
    }



    private class KSubsription implements Flow.Subscription {

        Flow.Subscriber<? super Integer> subscriber;
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();


        public KSubsription(Flow.Subscriber<? super Integer> subscriber) {
            this.subscriber = subscriber;
            IntStream.range(1, 10).forEach(val -> {
                try {
                    linkedBlockingQueue.put(val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        @Override
        public void request(long n) {

            for (int i=0; i<n;i++){
                Integer removedInt = linkedBlockingQueue.remove();
                subscriber.onNext(removedInt);
            }
        }

        @Override
        public void cancel() {
            System.out.println("Subscription cancelled by subscriber");
        }
    }

}

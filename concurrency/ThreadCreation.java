package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCreation {
      int count=-1;

      Lock lock=new ReentrantLock();
      Condition waitForPro=lock.newCondition();
      Condition waitForCons=lock.newCondition();

    public  void producer()  {


        for(int i=0;i<120000;i++){
            try {
                lock.lock();
                if(count!=-1) {
                    waitForCons.await();
                }
                count=i;
                waitForPro.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

        }
    }

    public synchronized void consumer()  {
        for(int i=0;i<120000;i++){
            try {
                lock.lock();

                if(count==-1) {
                    waitForPro.await();
                }

            System.out.println("consumed:"+count);
            count=-1;
                waitForCons.signal();
            } catch(InterruptedException e){}finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        int cc=10;
        ThreadCreation threadCreation = new ThreadCreation();
        Thread producer = new Thread(){
            @Override
            public void run() {
                threadCreation.producer();
            }
        };

        Thread consumer = new Thread(){
            @Override
            public void run() {
                threadCreation.consumer();
            }
        };
        System.out.println("value of count:"+threadCreation.count);
        consumer.start();
       producer.start();

        System.out.println("value of count:"+threadCreation.count);

    }
}

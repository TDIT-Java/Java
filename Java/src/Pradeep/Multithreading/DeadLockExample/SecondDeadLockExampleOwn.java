package Pradeep.Multithreading.DeadLockExample;

class DeadLockProducer1{
    public synchronized void produce(DeadLockProducer2 d){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("Inside DeadLockProducer1 produce DeadLock");
        d.producer();
    }

    public synchronized void producer(){
        System.out.println("producer is running");
    }
}

class DeadLockProducer2{
    public synchronized void produce(DeadLockProducer1 d){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("Inside DeadLockProducer2 produce DeadLock");
        d.producer();
    }

    public synchronized void producer(){
        System.out.println("producer is running");
    }
}

public class SecondDeadLockExampleOwn extends Thread{
    DeadLockProducer1 d = new DeadLockProducer1();
    DeadLockProducer2 d2 = new DeadLockProducer2();

    public void method1(){
        this.start();
        d.produce(d2);
    }

    @Override
    public void run() {
        d2.produce(d);
    }

    public static void main(String[] args) {
        SecondDeadLockExampleOwn s = new SecondDeadLockExampleOwn();
        s.method1();
    }
}

package Pradeep.Multithreading.Synchronisation;

class Display{
    public synchronized void displayNumbers(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public synchronized void displayChars(){
        for (int i = 65; i < 75; i++) {
            System.out.println((char)i);
        }
    }
}

class MyThreadNumbers extends Thread{
    Display d;
    MyThreadNumbers(Display d){
        this.d = d;
    }

    @Override
    public void run() {
        d.displayNumbers();
    }
}

class MyThreadChars extends Thread{
    Display d;
    MyThreadChars(Display d){
        this.d = d;
    }

    @Override
    public void run() {
        d.displayChars();
    }
}

public class SyncDemoExample {
    public static void main(String[] args) {
        Display d = new Display();
        MyThreadNumbers n = new MyThreadNumbers(d);
        MyThreadChars c = new MyThreadChars(d);

        n.start();
        c.start();
    }
}

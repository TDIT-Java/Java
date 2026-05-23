package Pradeep.Java17.RecordClass;

public record RecordClassExample(String name, int rollNo) {
    public RecordClassExample {
        System.out.println("Non-parameterised constructor");
    }

    public void show(){
        System.out.println("show");
    }

    public final static void show1(){
        System.out.println("show1");
    }

    public static void main(String[] args) {
        RecordClassExample obj = new RecordClassExample("Abc", 1);
        System.out.println("name: " + obj.name());
        System.out.println("rollNo: " + obj.rollNo());
        System.out.println("obj : " + obj);

        obj.show();
        RecordClassExample.show1();
    }
}

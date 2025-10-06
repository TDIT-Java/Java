package Pradeep.staticAndInstanceBlock.instanceBlock;

public class InstanceInheritance {
    int a = 10;

    {
        int b = 20;
        System.out.println("instance block 1");
    }
}

class test extends InstanceInheritance {
    public static void main(String[] args) {
        test obj = new test();
    }
}

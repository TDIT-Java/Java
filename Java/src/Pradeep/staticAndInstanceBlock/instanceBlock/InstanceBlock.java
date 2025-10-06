package Pradeep.staticAndInstanceBlock.instanceBlock;

public class InstanceBlock {
    static {
        new InstanceBlock();
        System.out.println("static Block");
    }

    {
        System.out.println("instance block 1");
    }

    {
        System.out.println("instance block 2");
    }

    InstanceBlock() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
         new InstanceBlock();
    }
}

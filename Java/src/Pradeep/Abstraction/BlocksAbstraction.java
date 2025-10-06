package Pradeep.Abstraction;

abstract class BlocksAbstractionClass{
    static{
        System.out.println("Static block");
    }

    {
        System.out.println("Instance block");
    }

    BlocksAbstractionClass(){
        System.out.println("Constructor");
    }
}

public class BlocksAbstraction extends BlocksAbstractionClass{
    public static void main(String[] args) {
        BlocksAbstractionClass bac = new BlocksAbstraction();
    }
}

package Pradeep.staticAndInstanceBlock;

public class StaticAndInstanceBlock extends abc{
    static{
        new abc("from constructor block abc");
        int a = 10;
        System.out.println("static block 1: " + a);
    }

    StaticAndInstanceBlock() {
        super("from super");
        new abc("from constructor block abc");
        System.out.println("Constructor");
    }

    {
        new abc("from constructor block abc");
        System.out.println("non-static block 1");
    }

    public static void main(String[] args) {
        System.out.println("main block");
        StaticAndInstanceBlock obj = new StaticAndInstanceBlock();
    }
}

class abc{
    abc(String abc){
        System.out.println(abc);
    }
    static{
        System.out.println("static block abc");
    }
    {
        System.out.println("non-static abc");
    }
}
package Pradeep.OOPS.Inheritance.HybridInheritance;

class parent {
    void method1(){
        System.out.println("method1");
    }
}

class child extends parent{
    void method2(){
        System.out.println("method2");
    }
}

class child1 extends child{
    void method3(){
        System.out.println("method3");
    }
}

public class hybridInheritance extends parent{
    void method4(){
        System.out.println("method4");
    }

    public static void main(String[] args) {
        hybridInheritance obj = new hybridInheritance();
        obj.method1();
        obj.method4();

        child1  obj1 = new child1();
        obj1.method3();
        obj1.method2();
        obj1.method3();
    }
}

//O/P =>
//        method1
//        method4
//        method3
//        method2
//        method3
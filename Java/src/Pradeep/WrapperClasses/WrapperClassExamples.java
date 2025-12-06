package Pradeep.WrapperClasses;

import java.util.Arrays;

public class WrapperClassExamples {
    public void method(short s) {
        System.out.println("primitive short " + s);
    }

    public void method(Short S) {
        System.out.println("Wrapper Short " + S);
    }

    public void method(byte b) {
        System.out.println("primitive Short " + b);
    }

    public void method(Byte B) {
        System.out.println("primitive Short " + B);
    }

    public void method(int i) {
        System.out.println("primitive int " + i);
    }

    public void method(Integer I) {
        System.out.println("Wrapper Integer " + I);
    }

    public void method(long l) {
        System.out.println("primitive long " + l);
    }

    public void method(float a) {
        System.out.println("primitive float " + a);
    }

    public void method(Float a) {
        System.out.println("Wrapper Float " + a);
    }

    public void method(int... i) {
        System.out.println("Variable args int " + Arrays.toString(i));
    }

    public static void main(String[] args) {
        WrapperClassExamples obj = new WrapperClassExamples();

        short a = 10;
        obj.method(a);
        obj.method(1);

        Float f = 2.4f;
        obj.method(f);

        obj.method(1, 2, 3);

    }
}

//-The order of preference is as follows:
    //-Exact Match with Primitive Type
    //-Exact Match with Wrapper Class (Autoboxing):
    //-Widening Primitive Conversion:
    //-Widening Primitive Conversion into Match with Wrapper Class then Autoboxing
    //-Varargs
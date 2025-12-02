package org.example;

public class AdditionExample {
    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException" + e.getMessage());
        }
        return 0;
    }

    public static void main(String[] args) {
        AdditionExample add = new AdditionExample();
        System.out.println("Addition is : " + add.add(1, 2));
        System.out.println("Substraction is : " + add.sub(1, 2));
        System.out.println("Multiplication is : " + add.mul(2, 3));
        System.out.println("Division is : " + add.div(2, 3));
    }
}

package Pradeep.Java8.Supplier;

import java.util.function.*;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
    }
}

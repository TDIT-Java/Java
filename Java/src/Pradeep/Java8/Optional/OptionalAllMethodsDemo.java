package Pradeep.Java8.Optional;

import java.util.*;
import java.util.function.Supplier;

public class OptionalAllMethodsDemo {

    public static void main(String[] args) {

        // =========================================================
        // 1) Creating Optional
        // =========================================================
        Optional<String> opt1 = Optional.of("Pradeep");
        Optional<String> opt2 = Optional.ofNullable(null);
        Optional<String> opt3 = Optional.empty();

        System.out.println("opt1: " + opt1);
        System.out.println("opt2: " + opt2);
        System.out.println("opt3: " + opt3);

        // =========================================================
        // 2) isPresent()
        // =========================================================
        System.out.println("\n--- isPresent() ---");
        System.out.println("opt1 is present? " + opt1.isPresent());
        System.out.println("opt3 is present? " + opt3.isPresent());

        // =========================================================
        // 3) ifPresent(Consumer)
        // =========================================================
        System.out.println("\n--- ifPresent() ---");
        opt1.ifPresent(value -> System.out.println("Value: " + value));
        opt3.ifPresent(value -> System.out.println("This will not print"));

        // =========================================================
        // 4) get()  (NOT recommended without check)
        // =========================================================
        System.out.println("\n--- get() ---");
        System.out.println("opt1.get(): " + opt1.get());

        try {
            System.out.println("opt3.get(): " + opt3.get()); // will throw exception
        } catch (NoSuchElementException e) {
            System.out.println("opt3.get() Exception: " + e);
        }

        // =========================================================
        // 5) orElse(default)
        // =========================================================
        System.out.println("\n--- orElse() ---");
        System.out.println("opt1.orElse: " + opt1.orElse("DefaultName"));
        System.out.println("opt3.orElse: " + opt3.orElse("DefaultName"));

        // =========================================================
        // 6) orElseGet(Supplier)
        // =========================================================
        System.out.println("\n--- orElseGet() ---");
        Supplier<String> supplier = () -> "GeneratedDefault";
        System.out.println("opt1.orElseGet: " + opt1.orElseGet(supplier));
        System.out.println("opt3.orElseGet: " + opt3.orElseGet(supplier));

        // =========================================================
        // 7) orElseThrow()
        // =========================================================
        System.out.println("\n--- orElseThrow() ---");
        System.out.println("opt1.orElseThrow: " + opt1.orElseThrow(NoSuchElementException::new));

        try {
            opt3.orElseThrow(NoSuchElementException::new); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("opt3.orElseThrow Exception: " + e);
        }

        // =========================================================
        // 8) orElseThrow(Supplier<Exception>)
        // =========================================================
        System.out.println("\n--- orElseThrow(Supplier) ---");
        try {
            opt3.orElseThrow(() -> new RuntimeException("Value not found!"));
        } catch (RuntimeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        // =========================================================
        // 9) filter(Predicate)
        // =========================================================
        System.out.println("\n--- filter() ---");
        Optional<String> filtered1 = opt1.filter(v -> v.startsWith("P"));
        Optional<String> filtered2 = opt1.filter(v -> v.startsWith("X"));
        System.out.println("Filtered1: " + filtered1);
        System.out.println("Filtered2: " + filtered2);

        // =========================================================
        // 10) map(Function)
        // =========================================================
        System.out.println("\n--- map() ---");
        Optional<Integer> lengthOpt = opt1.map(String::length);
        System.out.println("Length of opt1: " + lengthOpt.orElse(0));

        // =========================================================
        // 11) flatMap(Function)  (returns Optional inside Optional)
        // =========================================================
        System.out.println("\n--- flatMap() ---");
        Optional<String> emailOpt = Optional.of("pradeep@gmail.com");
        Optional<String> domainOpt = emailOpt.flatMap(OptionalAllMethodsDemo::getDomain);
        System.out.println("Domain: " + domainOpt.orElse("No domain"));

        // =========================================================
        // 12) equals() and hashCode()
        // =========================================================
        System.out.println("\n--- equals() + hashCode() ---");
        Optional<String> opt4 = Optional.of("Pradeep");
        System.out.println("opt1 equals opt4? " + opt1.equals(opt4));
        System.out.println("opt1 hashCode: " + opt1.hashCode());

        // =========================================================
        // 13) toString()
        // =========================================================
        System.out.println("\n--- toString() ---");
        System.out.println(opt1.toString());
        System.out.println(opt3.toString());
    }

    // Helper for flatMap()
    private static Optional<String> getDomain(String email) {
        if (email != null && email.contains("@")) {
            return Optional.of(email.substring(email.indexOf("@") + 1));
        }
        return Optional.empty();
    }
}

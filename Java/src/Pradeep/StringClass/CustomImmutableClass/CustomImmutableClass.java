package Pradeep.StringClass.CustomImmutableClass;

import java.util.*;

public final class CustomImmutableClass {
    private String name;
    private int age;
    private List<Integer> numbers;

    public CustomImmutableClass(String name, int age, List<Integer> numbers) {
        this.name = name;
        this.age = age;
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        CustomImmutableClass cic = new CustomImmutableClass("Pradeep", 18, list);
        System.out.println(cic.getNumbers());
    }
}

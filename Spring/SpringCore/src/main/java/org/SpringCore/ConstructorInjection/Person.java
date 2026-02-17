package org.SpringCore.ConstructorInjection;

public class Person {
    private String name;
    private int personId;
    private Certi cer;

    public Person(String name, int personId, Certi cer) {
        this.name = name;
        this.personId = personId;
        this.cer = cer;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", personId=" + personId + " Certificate=" + cer.getCer() +
                '}';
    }
}

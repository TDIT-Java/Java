package Pradeep.Collection.Map;

import java.util.*;

class Student {
    private String name;
    private int rollNo;

    public Student() {
    }

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNo);
    }
}

public class HashMapExample {
    public static void main(String[] args) {
        Student s1 = new Student("Jack", 1);
        Student s2 = new Student("Jack", 1);

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s2, 2);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(map.size());

    }
}

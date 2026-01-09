package Pradeep.Collection.List.ArrayList.CustomArrayList;

import java.util.*;

class Student {
    int studentRollNo;
    String studentName;

    Student(int studentRollNo, String studentName) {
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
    }

    public String toString() {
        return "Student Name: " + studentName + ", " + " Roll No: " + studentRollNo + "\n";
    }
}

class CustomArrayList<S> {
    private final static int INITIAL_SIZE = 10;
    private Object[] elementData = {};
    private int size = 0;

    public CustomArrayList() {
        elementData = new Object[INITIAL_SIZE];
    }

    public void add(S e) {
        if (size == elementData.length) {
            ensureCapacity();
        }

        elementData[size++] = e;
    }

    public S getElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Out of Bound index " + index + " size " + index);
        }

        return (S) elementData[index];
    }

    public boolean isId(int element) {
        if (size == 0) {
            throw new ZeroSizeException("Size is 0");
        }

        for (int i = 0; i < size; i++) {
            if (((Student) elementData[i]).studentRollNo == (element)) {
                return true;
            }
        }

        return false;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Out of Bound index " + index + " size " + index);
        }

        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;

        return removedElement;
    }

    private void ensureCapacity() {
        int newSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }

    public void clear() {
        if (size > 0) {
            elementData = new Object[INITIAL_SIZE];
            size = 0;
        }
    }

    public Boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + " ");
        }
        return sb.toString();
    }
}

public class FirstCustomArrayListStudent {
    public static void main(String[] args) {
        CustomArrayList<Student> list = new CustomArrayList<>();

        list.add(new Student(1, "XZY"));
        list.add(new Student(2, "PQR"));

        System.out.println(list);

        System.out.println("\nStudent at index " + 1 + " = " + list.getElementAt(1));
        System.out.println("\nIs Id 1 Student Present: " + list.isId(1));

        System.out.println("Student removed from index " + 1 + " = " + list.remove(1));

        System.out.println("\nDisplay Students list again after removal at index 1");

        System.out.println(list);

        System.out.println("\nIs Students list empty: " + list.isEmpty());

        System.out.println("\nClearing all Students list");
        list.clear();

        System.out.println("After removed all students");

        System.out.println("\nIs Students list empty: " + list.isEmpty());

        System.out.println(list);
    }
}

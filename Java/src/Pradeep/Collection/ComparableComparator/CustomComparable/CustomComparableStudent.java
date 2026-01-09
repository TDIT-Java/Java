package Pradeep.Collection.ComparableComparator.CustomComparable;

import java.util.*;

class Student implements Comparable<Student> {
    private int rollNo;
    private String studName;
    private String studDept;

    public Student(int rollNo, String studName, String studDept) {
        this.rollNo = rollNo;
        this.studName = studName;
        this.studDept = studDept;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudName() {
        return studName;
    }

    public String getStudDept() {
        return studDept;
    }

    @Override
    public int compareTo(Student s) {
//        return this.getRollNo() - s.getRollNo(); // sort elements according to ascending order
//        return this.studName.compareTo(s.studName); // sort elements according to alphabetical order
        if (this.getRollNo() > s.getRollNo()) {
            return 1;
        } else if (this.getRollNo() == s.getRollNo()) {
            return 0;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", studName='" + studName + '\'' +
                ", studDept='" + studDept + '\'' +
                '}';
    }
}

public class CustomComparableStudent {
    public static void main(String[] args) {
        Student s1 = new Student(2, "ABC", "CS");
        Student s2 = new Student(1, "PQR", "IT");
        Student s3 = new Student(4, "XYZ", "ENTC");
        Student s4 = new Student(3, "MNQ", "CIVIL");

        List<Student> studList = new ArrayList<>();

        studList.add(s1);
        studList.add(s2);
        studList.add(s3);
        studList.add(s4);

        System.out.println("Before sorting student list: " + studList);
        Collections.sort(studList);
        System.out.println("After sorting student list: " + studList);
    }
}

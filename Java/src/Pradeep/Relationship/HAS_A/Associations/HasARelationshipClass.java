package Pradeep.Relationship.HAS_A.Associations;

class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
}

class Library {
    void issueBook(Student s) {
        System.out.println("Book issued to: " + s.name);
    }
}

public class HasARelationshipClass {
    public static void main(String[] args) {
        Student s1 = new Student("Pradeep");
        Library lib = new Library();
        lib.issueBook(s1);
    }
}

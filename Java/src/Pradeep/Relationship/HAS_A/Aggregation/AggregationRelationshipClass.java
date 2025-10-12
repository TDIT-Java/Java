package Pradeep.Relationship.HAS_A.Aggregation;

class Department {
    String name;
    Department(String name) {
        this.name = name;
        System.out.println("Department : " + this.name);
    }
}

class College {
    String name;
    Department department;

    College(String name, Department department) {
        this.name = name;
        this.department = department;
        System.out.println("College : " + this.name);
    }
}

public class AggregationRelationshipClass {
    public static void main(String[] args) {
        Department dept = new Department("Computer Science");
        College college = new College("ABC College", dept);
    }
}

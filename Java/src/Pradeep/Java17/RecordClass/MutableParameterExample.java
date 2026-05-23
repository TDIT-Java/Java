package Pradeep.Java17.RecordClass;

import java.util.*;

record UserRecord(String name, List<Integer> age) {

    public UserRecord {
        age = List.copyOf(age);
    }

    public List<Integer> age() {
        return Collections.unmodifiableList(age);
    }

}

public class MutableParameterExample {
    public static void main(String[] args) {
        UserRecord user = new UserRecord("John", List.of(1, 2, 3));

        System.out.println(user.name());
        System.out.println(user.age());
    }
}

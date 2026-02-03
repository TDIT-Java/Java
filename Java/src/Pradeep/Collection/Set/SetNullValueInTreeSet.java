package Pradeep.Collection.Set;

import java.util.*;

public class SetNullValueInTreeSet implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;

        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(new SetNullValueInTreeSet());
        treeSet.add(1);
        treeSet.add(null);
        treeSet.add(2);

        System.out.println(treeSet);
    }
}

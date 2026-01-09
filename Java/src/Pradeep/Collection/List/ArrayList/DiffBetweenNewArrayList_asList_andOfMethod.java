package Pradeep.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffBetweenNewArrayList_asList_andOfMethod {

    public static void main(String[] args) {

        String[] strArray = {"Pradeep", "Arjun", "Mallik", "Swamy"};

        // 1. List.of() method
        //List<String> immutableList = List.of(strArray); // of method reference error
        //immutableList.add("HiList"); //can not able to modify, will get UnsupportedException
        //immutableList.set(0, "hello"); //can not able to modify, will get UnsupportedException
        //immutableList.remove("Arjun");  //can not able to modify, will get UnsupportedException
        //System.out.println(immutableList);


        // 2. Arrays.asList() method
        //List<String> replaceableList = Arrays.asList(immutableList); // it needs only Array not any Collection list
        List<String> replaceableList = Arrays.asList(strArray);
        System.out.println(replaceableList.get(0));
        replaceableList.set(0, "Sandeep");     // allowed, since we are just replacing the existing value, and
        // not modifying the Array
        System.out.println(replaceableList.get(0));
        //replaceableList.add("Amar"); // Not Allowed, since it will add, a new element at the last
        // since the array is fixed size.


        // 3. Normal ArrayList constructor

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Aman");
        arrayList.add("Amar");
        System.out.println(arrayList);
        arrayList.set(1, "Alok");
        arrayList.add("Anjali");
        System.out.println(arrayList);

    }
}
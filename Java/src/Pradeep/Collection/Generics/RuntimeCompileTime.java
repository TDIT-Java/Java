package Pradeep.Collection.Generics;

import java.util.*;

public class RuntimeCompileTime {
    public static void main(String[] args) {
        ArrayList<String> compileTime = new ArrayList<>(); // Compile-Time: Checks Reference
        ArrayList runTime = new ArrayList<Integer>(); // Run-Time: there is no such type of concept
    }
}

//Generics concept is applicable only at compile time, at runtime there is no such
//type of concept. because compiler at the end removes the generics so
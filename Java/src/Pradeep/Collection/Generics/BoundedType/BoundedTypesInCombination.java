package Pradeep.Collection.Generics.BoundedType;

class A<T extends Number & Runnable & Comparable> {} //valid

//class Test<T extends Number&String> {} //(invalid)
//We can't extend more than one class at a time.

class Test<T extends Runnable&Comparable> {} //(valid)

//class Test1<T extends Runnable&Number> {} //(invalid)
//We have to take 1st class followed by interface.

package Pradeep.Collection.Generics.BoundedType;

class HashMap<K, V> {
    K key;
    V value;

    public HashMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }
}

public class MultiArgsBoundedType {
    public static void main(String[] args) {
        HashMap<String, Integer> obj = new HashMap<>("Pradeep", 1);
        System.out.println(obj);

        HashMap<Integer, Integer> obj1= new HashMap<>(1, 1);
        System.out.println(obj1);

    }
}

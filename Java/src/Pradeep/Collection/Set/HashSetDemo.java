package Pradeep.Collection.Set;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println("Initial map: " + map);

        // put(K,V)
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        System.out.println("\nAfter put(): " + map);

        // putIfAbsent(K,V)
        map.putIfAbsent(4, "JavaScript");
        map.putIfAbsent(2, "Ruby"); // won't replace existing
        System.out.println("\nAfter putIfAbsent(): " + map);

        // get(K)
        System.out.println("\nget(2): " + map.get(2));

        // getOrDefault(K, defaultValue)
        System.out.println("getOrDefault(10, \"Not Found\"): " + map.getOrDefault(10, "Not Found"));

        // containsKey(K)
        System.out.println("\ncontainsKey(3): " + map.containsKey(3));

        // containsValue(V)
        System.out.println("containsValue(\"Java\"): " + map.containsValue("Java"));

        // size()
        System.out.println("\nsize(): " + map.size());

        // isEmpty()
        System.out.println("isEmpty(): " + map.isEmpty());

        // remove(K)
        map.remove(3);
        System.out.println("\nAfter remove(3): " + map);

        // remove(K,V)
        boolean removed = map.remove(2, "Python");
        System.out.println("remove(2, \"Python\"): " + removed);
        System.out.println("After remove(2,\"Python\"): " + map);

        // Reinsert
        map.put(2, "Python");

        // replace(K,V)
        map.replace(2, "GoLang");
        System.out.println("\nAfter replace(2, \"GoLang\"): " + map);

        // replace(K, oldValue, newValue)
        boolean replaced = map.replace(1, "Java", "Spring");
        System.out.println("replace(1, \"Java\", \"Spring\"): " + replaced);
        System.out.println("After replace with old value check: " + map);

        // keySet()
        System.out.println("\nkeySet(): " + map.keySet());

        // values()
        System.out.println("values(): " + map.values());

        // entrySet()
        System.out.println("\nentrySet(): " + map.entrySet());

        // forEach(BiConsumer)
        System.out.println("\nforEach(): ");
        map.forEach((k, v) -> System.out.println(k + " => " + v));

        // putAll(Map)
        HashMap<Integer, String> newMap = new HashMap<>();
        newMap.put(5, "NodeJS");
        newMap.put(6, "React");
        map.putAll(newMap);
        System.out.println("\nAfter putAll(): " + map);

        // clone()
        HashMap<Integer, String> clonedMap = (HashMap<Integer, String>) map.clone();
        System.out.println("\nCloned Map: " + clonedMap);

        // compute(K, BiFunction)
        map.compute(2, (k, v) -> v + " Updated");
        System.out.println("\nAfter compute(2): " + map);

        // computeIfAbsent(K, Function)
        map.computeIfAbsent(7, k -> "Angular");
        System.out.println("\nAfter computeIfAbsent(7): " + map);

        // computeIfPresent(K, BiFunction)
        map.computeIfPresent(1, (k, v) -> v + " Framework");
        System.out.println("\nAfter computeIfPresent(1): " + map);

        // merge(K, value, BiFunction)
        map.merge(2, " Extra", (oldVal, newVal) -> oldVal + newVal);
        System.out.println("\nAfter merge(2): " + map);

        // replaceAll(BiFunction)
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("\nAfter replaceAll(): " + map);

        // clear()
        map.clear();
        System.out.println("\nAfter clear(): " + map);

        // equals(Object)
        System.out.println("\nEquals clonedMap? " + map.equals(clonedMap));

        // hashCode()
        System.out.println("hashCode(): " + map.hashCode());
    }
}

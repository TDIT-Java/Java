package Pradeep.stringClass;

public class RemoveAnElement {
    public static void main(String[] args) {
        String s = "Hello";

        System.out.println("\nRemoving H from Hello : ");
        String s1 = "";
        char key = 'H';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == key) {
                continue;
            }
            s1 = s1 + s.charAt(i);
        }
        System.out.println("After Removing H from Hello : " + s1);

        String str1 = "w3resource";
        char[] arr1 = str1.toCharArray();
        String targetStr = "";
        for (char value : arr1) {
            if (targetStr.indexOf(value) == -1) {
                targetStr += value;
            }
        }
        System.out.println("\n\nafter removing duplicates from str1: " + targetStr);
    }
}

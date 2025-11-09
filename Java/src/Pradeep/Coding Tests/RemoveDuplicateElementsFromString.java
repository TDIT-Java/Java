// find duplicate chars from string and remove it str = "Programming"
public class RemoveDuplicateElementsFromString {
    public static void main(String[] args) {
        String str = "Programming";
        char[] arr1 = str.toCharArray();
        String targetStr = "";
        for (char value : arr1) {
            if (targetStr.indexOf(value) == -1) {
                targetStr += value;
            }
        }
        System.out.println("\n\nafter removing duplicates from str1: " + targetStr);
    }
}

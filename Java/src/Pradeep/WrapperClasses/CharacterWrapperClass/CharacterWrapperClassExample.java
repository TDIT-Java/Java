package Pradeep.WrapperClasses.CharacterWrapperClass;

public class CharacterWrapperClassExample {
    public static void main(String[] args) {
        char charPrimitive = 'a';
        Character charWrapper = new Character(charPrimitive);
        char charUnboxed = charWrapper.charValue();

        String stringPrimitive = "abc";
        Character ch1 = new Character(charPrimitive);
        System.out.println(ch1); // a
    }
}

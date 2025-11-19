package Pradeep.WrapperClasses.StringToPrimitive;

public class StringToPrimitiveExample {
    public static void main(String[] args) {

        // String to Primitive

        String strInt = String.valueOf(100);
        int parsedInt = Integer.parseInt(strInt);

        String strChar = String.valueOf('c');
        char parsedChar = strChar.charAt(0);

        String strDouble = String.valueOf(10.10);
        double parsedDouble = Double.parseDouble(strDouble);

        String strFloat = String.valueOf(5.5f);
        float parsedFloat = Float.parseFloat(strFloat);

        String strBoolean = String.valueOf(true);
        boolean parsedBoolean = Boolean.parseBoolean(strBoolean);
    }
}

package Pradeep.StringClass;

public class InsertingAStringInAAnotherString {
    public static void main(String[] args) {
        String originalString = "How you";
        String stringToInsert = "are ";
        int atIndex = 4;
        String targateStr = "";

        for(int i = 0; i < originalString.length(); i++){
            if(i == atIndex){
                targateStr += stringToInsert;
            }
            targateStr += originalString.charAt(i);
        }

        System.out.println(targateStr);
    }
}

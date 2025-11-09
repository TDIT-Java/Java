public class PercentageOfLetters {
    public static void main(String[] args) {
        String str = "abc@#%de123";

        System.out.println("String: " + str);

        String vowels = "aeiou";
        String specialChars = "!@#$%^&*";
        String numbers = "1234567890";

        String totalVowels = "";
        String totalConsonents = "";
        String totalSpecialChars = "";
        String totalNumbers = "";

        for(char ch: str.toCharArray()){
            if (vowels.contains(String.valueOf(ch))){
                totalVowels += ch;
            }

            if (specialChars.contains(String.valueOf(ch))){
                totalSpecialChars += ch;
            }

            if (numbers.contains(String.valueOf(ch))){
                totalNumbers += ch;
            }

            if (!vowels.contains(String.valueOf(ch)) && !specialChars.contains(String.valueOf(ch)) && !numbers.contains(String.valueOf(ch))) {
                totalConsonents += ch;
            }
        }

        System.out.println("\ntotalVowels: " + totalVowels);
        System.out.println("totalConsonents: " + totalConsonents);
        System.out.println("totalSpecialChars: " + totalSpecialChars);
        System.out.println("totalNumbers: " + totalNumbers);

        System.out.println("\nPercentage of vowels: " + ((totalVowels.length() * 100) / str.length()));
        System.out.println("Percentage of Consonents: " + ((totalConsonents.length() * 100) / str.length()));
        System.out.println("Percentage of Numbers: " + ((totalNumbers.length() * 100) / str.length()));
        System.out.println("Percentage of SpecialChars: " + ((totalSpecialChars.length() * 100) / str.length()));

    }
}

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer un mot : ");
        
        // Read the user input
        String word = scanner.nextLine();
        
        // Close the scanner
        scanner.close();
        
        // Call the method to count vowels
        int vowelCount = countVowels(word);
        
        // Display the result
        System.out.println("Le mot \"" + word + "\" comprend " + vowelCount + " voyelles");
    }

    public static int countVowels(String str) {
        int count = 0;
        // Convert the string to lower case to make the comparison case-insensitive
        String lowerCaseStr = str.toLowerCase();
        for(int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);
            // Check if the character is a vowel
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                count++;
            }
        }
        return count;
    }
}

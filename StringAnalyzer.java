import java.util.Scanner;

public class StringAnalyzer {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Variables to hold counts for vowels, consonants, digits, and special characters
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        // Convert the input to lowercase for easier comparison (vowels)
        input = input.toLowerCase();

        // Loop through each character of the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
            // Check if the character is a consonant
            else if (ch >= 'a' && ch <= 'z') {
                consonantCount++;
            }
            // Check if the character is a digit
            else if (ch >= '0' && ch <= '9') {
                digitCount++;
            }
            // If it's not a letter or a digit, it must be a special character
            else {
                specialCharCount++;
            }
        }

        // Output the counts to the user
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Special characters: " + specialCharCount);

        // Close the scanner
        scanner.close();
    }
}

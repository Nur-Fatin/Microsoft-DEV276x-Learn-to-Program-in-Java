/*
What it does : encrypt and decrypt text
Part 1 - Normalize Text
Part 2 - Caesar Cipher
Part 3 - Codegroups
Part 4 - Putting it all together
Part 5 - Hacker Problem - Decrypt
 */

import java.util.Scanner;

public class Crypto {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type your message: ");
        String message = input.nextLine();
        System.out.print("Type your secret key number: ");
        int shiftValue = input.nextInt();
        System.out.println("This app will automatically break your encrypted text into groups of 3 letters");
        int groupSize = 3;

        String encryptedMessage = encryptString(message, shiftValue, groupSize);
        System.out.println("Message encrypted! " + encryptedMessage);

        System.out.print("Would you like to decrypt your message? Enter your secret key number ");
        int secretKey = input.nextInt();

        if (secretKey == shiftValue) {
            String decryptedMessage = ungroupify(encryptedMessage);
            decryptedMessage = decryptString(decryptedMessage, shiftValue);
            System.out.println("Message decrypted! " + decryptedMessage);

        }

    }

    // Part 1 - Normalize Text
    public static String normalizeText(String text) {
        return text.replaceAll("\\s", "").replaceAll("\\p{Punct}", "").toUpperCase();
    }

    // Part 2 - Caesar Cipher

    public static String caesarify(String givenText, int key) {
        String encryptedText = "";
        // loop through each char index in a given text, use the index to get the charAt()
        // find the index of the char in alphabet
        // add the index with key number
        // find char at new position and add the char to encryptedText
        for (int i = 0; i < givenText.length(); i++) {
            char letter = givenText.charAt(i);
            int position = ALPHABET.indexOf(letter);
            int newPosition = position + key;
            // Note that the alphabet “wraps around”, so with a shift value of +1 the “Z” in ZOOS became an A.
            if (newPosition > 25) {
                newPosition = newPosition % 26;
            }
            if (newPosition < 0) {
                newPosition = newPosition + 26;
            }
            char newLetter = ALPHABET.charAt(newPosition);
            encryptedText += newLetter;
        }

        return encryptedText;
    }

    // Part 3 - Codegroups
    // encrypted messages are broken into equal-length chunks, separated by spaces
    public static String groupify(String secretMessage, int n) {
        String codeGroups = "";
        if (secretMessage.length() % n != 0) {
            int padding = n -  (secretMessage.length() % n);
            for (int i = 1; i <= padding; i++) {
                secretMessage += "x";
            }
        }

        for (int i = 0; i < secretMessage.length(); i++) {
            if (i % n == 0) {
                codeGroups = codeGroups + " " + secretMessage.charAt(i);
            } else {
                codeGroups += secretMessage.charAt(i);
            }

        }
        return codeGroups;
    }

    // Part 4 - Putting it all together
    public static String encryptString(String message, int shiftValue, int groupSize ) {
        message = normalizeText(message);
        String encryptedMessage = caesarify(message, shiftValue);
        encryptedMessage = groupify(encryptedMessage, groupSize);
        return encryptedMessage;
    }

    // Part 5 - Hacker Problem - Decrypt
    public static String ungroupify(String cypherText) {
        String noSpaceText = cypherText.replace(" ", "");
        return noSpaceText.replace("x", "");
    }

    public static String decryptString(String encryptedMessage, int shiftValue) {
        String decryptedText = "";
        shiftValue *= -1;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char letter = encryptedMessage.charAt(i);
            int position = ALPHABET.indexOf(letter);
            int newPosition = position + shiftValue;
            // Note that the alphabet “wraps around”, so with a shift value of +1 the “Z” in ZOOS became an A.
            if (Math.abs(newPosition) > 25) {
                newPosition = newPosition % 26;
            }
            if (newPosition < 0) {
                newPosition = newPosition + 26;
            }
            decryptedText += ALPHABET.charAt(newPosition);
        }

        return decryptedText;
    }
}

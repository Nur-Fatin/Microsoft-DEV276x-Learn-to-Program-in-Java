public class StringManipulation {
    public static void main(String[] args) {
        String original = "nurfatin";

        // Find char at specific index
        for (int i = 0; i < original.length(); i++) {
            System.out.println("The character at index " + i + " is " + original.charAt(i));
        }

        // Find index of a specific char
        System.out.println("The index of character a  is  " + original.indexOf('a'));
        System.out.println("The index of character t  is  " + original.indexOf('t'));
        System.out.println("The index of character b  is  " + original.indexOf('b'));

        // Transform the String
        original = original.toUpperCase();
        System.out.println(original);

    }
}

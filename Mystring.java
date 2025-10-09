/**
 * @filename Mystring.java
 * This file defines the Mystring class which performs various string operations
 * such as append, replace, count words, check palindrome, splice, split, 
 * find maximum repeating character, sort, shift, and reverse.
 * 
 * @author Mayank Rathore
 * @class Mystring
 * @description The Mystring class is a user-defined representation of a string 
 *              that encapsulates common string manipulation functionalities. 
 *              
 */
package Java.openupvs.Assignment1_2;

public class Mystring {
    private String User_string;

    // Default constructor
    public Mystring() {
        this.User_string = "";
    }

    // Parameterized constructor
    public Mystring(String string) {
        this.User_string = string;
    }

    // Convert object to string
    @Override
    public String toString() {
        return this.User_string;
    }

    // Print current string
    public void Printstring() {
        System.out.println("The value stored in Mystring is: " + this.User_string);
    }

    // Append another string to data
    public String append(String newstring) {
        this.User_string = this.User_string + " " + newstring;
        return this.User_string;
    }
    // Overloaded method to handle integer input
    public String append(int number) {
        this.User_string = this.User_string + " " + number; 
        return this.User_string;
    }

    // Count number of words in data
    public int getcount() {
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < User_string.length(); i++) {
            char char_at_i = User_string.charAt(i);
            if (char_at_i != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (char_at_i == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    // Replace old word with new word
    public String replace(String oldword, String newword) {
        String result = "";
        String temp = "";

        for (int i = 0; i < User_string.length(); i++) {
            char character_at_i = User_string.charAt(i);

            if (character_at_i != ' ') {
                temp = temp + character_at_i;
            } else {
                if (temp.equals(oldword)) {
                    result = result + newword + " ";
                } else {
                    result = result + temp + " ";
                }
                temp = "";
            }
        }

        if (temp.equals(oldword)) {
            result += newword + " ";
        } else if (!temp.isEmpty()) {
            result += temp + " ";
        }

        this.User_string = result.trim();
        return this.User_string;
    }

    // Check if data is palindrome
    public boolean isPalindrome() {
        String text = User_string.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Splice (remove) substring from start index for given length
    public String splice(int start, int length) {
        if (start < 0 || start >= User_string.length()) {
            System.out.println("Invalid start index!");
            return this.User_string;
        }
        String result = "";
        for (int i = 0; i < User_string.length(); i++) {
            if (i < start || i >= start + length) {
                result += User_string.charAt(i);
            }
        }
        this.User_string = result;
        return this.User_string;
    }

    // Split the data and print words
    public void split() {
        String word = "";
        System.out.println("Splitted string:");
        for (int i = 0; i < User_string.length(); i++) {
            char ch = User_string.charAt(i);
            if (ch != ' ') {
                word = word + ch;
            } else {
                System.out.println(word);
                word = "";
            }
        }
        if (word.length() > 0) {
            System.out.println(word);
        }
    }

    // Find maximum repeating character
    public char Maximum_Repeating_Character() {
        int maxCount = 0;
        char maxChar = ' ';
        for (int i = 0; i < User_string.length(); i++) {
            int count = 0;
            for (int j = 0; j < User_string.length(); j++) {
                if (User_string.charAt(i) == User_string.charAt(j)) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = User_string.charAt(i);
            }
        }
        return maxChar;
    }

    // Sort string alphabetically
    public String sort() {
    char[] arr = User_string.toCharArray();

    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                char temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    this.User_string = new String(arr); // store back sorted data
    return this.User_string;            // return it as a String
}


    // Shift the string by n characters
    public String shift(int shifted_by) {
        int string_length = User_string.length();
        if (string_length == 0) return "";
        shifted_by = shifted_by % string_length;
        this.User_string = User_string.substring(shifted_by) + User_string.substring(0, shifted_by);
        return this.User_string;
    }

    // Reverse the string
    public String reversestring() {
        String rev = "";
        for (int i = User_string.length() - 1; i >= 0; i--) {
            rev += User_string.charAt(i);
        }
        this.User_string = rev;
        return this.User_string;
    }

}

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

package Java.openupvs.Assignment1;

public class Mystring {
    
    private String data;

    // Default constructor
    public Mystring() {
        this.data = "";
    }

    // Parameterized constructor
    public Mystring(String string) {
        this.data = string;
    }

    // Convert object to string
    @Override
    public String toString() {
        return this.data;
    }

    // Print current string
    public void Printstring() {
        System.out.println("The value stored in Mystring is: " + this.data);
    }

    // Append another string to data
    public void append(String toAppend) {
        this.data = this.data + " " + toAppend;
    }

    // Count number of words in data
    public int count() {
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            // Start of a new word
            if (c != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (c == ' ') {
                // End of a word
                inWord = false;
            }
        }
        return count;
    }

    // Replace old word with new word
    public void replace(String oldword, String newword) {
        String result = "";
        String temp = "";

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);

            if (ch != ' ') {
                temp = temp + ch;
            } else {
                if (temp.equals(oldword)) {
                    result = result + newword + " ";
                } else {
                    result = result + temp + " ";
                }
                temp = "";
            }
        }
        //Check for the last word
        if (temp.equals(oldword)) {
            result += newword + " ";
        } else if (!temp.isEmpty()) {
            result += temp + " ";
        }

        this.data = result.trim();
    }

    // Check if data is palindrome
    public boolean isPalindrome() {
        String text = data.replaceAll("\\s+", "").toLowerCase();//Remove spaces and convert the string to lower case
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                //The string is not a palindrome is the char at i and length-i is not same
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Splice (remove) substring from start index for given length
    public void splice(int start, int length) {
        if (start < 0 || start >= data.length()) {
            System.out.println("Invalid start index!");//check if the given length to slice is not greater then the given string
            return;
        }
        String result = "";
        for (int i = 0; i < data.length(); i++) {
            if (i < start || i >= start + length) {
                result += data.charAt(i);
            }
        }
        this.data = result;
    }

    // Split the data and print words
    public void split() {
        String word = "";
        System.out.println("Splitted string:");
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != ' ') {
                word = word + ch;// build word

            } else {
                System.out.println(word);
                word = "";// reset for next word

            }
        }
        if (word.length() > 0) {
            System.out.println(word);
        }
    }

    // Find maximum repeating character
    public char MaxRepeatingCharacter() {
        int maxCount = 0;
        char maxChar = ' ';
        for (int i = 0; i < data.length(); i++) {
            int count = 0;
            for (int j = 0; j < data.length(); j++) {
                if (data.charAt(i) == data.charAt(j)) count++;
            }
            if (count > maxCount) //if the count is more then the maximun count till find then change the maxCount
            {
                maxCount = count;
                maxChar = data.charAt(i);
            }
        }
        return maxChar;
    }

    // Sort string alphabetically
    public void sort() {
        char[] arr = data.toCharArray();
        //Bubble sorting
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])// using their ASCII/Unicode values
 
                {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        this.data = new String(arr);
    }

    // Shift the string by n characters
    public void shift(int n) {
        int len = data.length();
        if (len == 0) return;
        n = n % len;
        this.data = data.substring(n) + data.substring(0, n);
    }

    // Reverse the string
    public void reverse() {
        String rev = "";
        for (int i = data.length() - 1; i >= 0; i--) {
            rev += data.charAt(i);
        }
        this.data = rev;
    }
}

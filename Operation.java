  /**
 * @filename Operations.java
 * This file defines the Operations class which performs various string and number operations
 * including counting palindromes, Fibonacci sequence, string conversions, counting consonants,
 * binary-to-decimal conversion, character frequency, prime checking, number-to-words conversion,
 * and longest unique substring detection — all implemented manually without inbuilt functions.
 * 
 * @author Mayank Rathore
 * @class Operations
 * @description The Operations class provides static methods for different computational
 *              and string manipulation functionalities used by the Main class.
 */
package Java.openupvs.Assignment2_3;

import java.util.HashSet;
import java.util.Set;

public class Operations {
    //Method to find nth element in a Fibonacci Sequence
    public static long getNthFibonacci(long position)
    {
        if (position <= 1) return 0;
        if (position == 2 || position == 3) return 1;
        long a = 1, b = 1;
        for (long i = 3; i <= position; i++) {
            long temp = a + b;
            a = b; b = temp;
        }
        return b;

    }
    //Count Consonants
    public static int getConsonantCount(String userString) {
        int count = 0;
        for (int i = 0; i < userString.length(); i++) {
            char ch = userString.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')) ch = (char) (ch + 32); // convert to lowercase 

            if (ch >= 'a' && ch <= 'z' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                count++;
        }
        return count;
    }
    public static long convertBinaryToDecimal(long binaryNumber) {
        long decimalNumber = 0;
        int power = 0; // Represents the current power of 2 (2^0, 2^1, 2^2, ...)

        // Loop until the binary number becomes 0
        while (binaryNumber != 0) {
            // Get the last digit
            long lastDigit = binaryNumber % 10; 

            // Multiply the digit by the corresponding power of 2 and add to the decimal sum
            
            decimalNumber += lastDigit * Math.pow(2, power); 

            // Remove the last digit from the binary number
            binaryNumber /= 10; 

            
            power++;
        }

        return decimalNumber;
    }
    //This method expand each character by repeating it according to the digit that follows
    public static String expandCharacters(String userString)
    {
        String Expanded_string="";
        for(int i=0;i<userString.length();i++)
        {
            char ch=userString.charAt(i);
            if(i+1<userString.length())
            {
                char next = userString.charAt(i + 1);
                if (next >= '0' && next <= '9') {
                    int repeat = next - '0';// convert String to int
                    for (int j = 0; j < repeat; j++) {
                        Expanded_string += ch;
            }
            i++;
        }
    }
        
    }
    return Expanded_string;

    }
    //This method  output the frequency of each character in a compressed form
    public static String getCharacterFrequency(String userString)
    {
        String Compressed_string = "";

        int count = 1;
        for (int i = 0; i < userString.length(); i++) {
            if (i + 1 < userString.length() && userString.charAt(i) == userString.charAt(i + 1)) {
                count++;
            } else {
                Compressed_string = Compressed_string + userString.charAt(i) + count;
                count = 1;
            }
        }
    

        return Compressed_string;
    }
    //Method to check prime number
    public static String checkPrimeNumber(long userNumber)
    {
        if (userNumber <= 1) return "The given number is NOT prime.";
        for (long i = 2; i * i <= userNumber; i++) {
            if (userNumber % i == 0)
                return "The given number is NOT prime.";
        }
        return "The given number is PRIME.";
    }
    //Method to covert to word
    public static String convertNumber(int num) {
        String[] below20 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                            "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        if (num < 20) return below20[num];
        else if (num < 100) {
            return tens[num / 10] + ((num % 10 != 0) ? " " + below20[num % 10] : "");
        } else if (num < 1000) {
            return below20[num / 100] + " hundred" + ((num % 100 != 0) ? " " + convertNumber(num % 100) : "");
        } else if (num < 1000000) {
            return convertNumber(num / 1000) + " thousand" + ((num % 1000 != 0) ? " " + convertNumber(num % 1000) : "");
        } else return "number too large";
    }
    //Method to get longest substring
    public static int getLongestUniqueSubstringLength(String userString) {
        
        int Length = userString.length();
        int Longestsubstr = 0;

        // last index of all characters is initialized as -1
        int[] lastIndex = new int[256];
        for (int i = 0; i < 26; i++) {
            lastIndex[i] = -1;
        }

        // Initialize start of current window
        int start = 0;

        // Move end of current window
        for (int end = 0; end < Length; end++) {
            start = Math.max(start, lastIndex[userString.charAt(end) - 'a'] + 1);

            // Update result if we get a larger window
            Longestsubstr = Math.max(Longestsubstr, end - start + 1);

            // Update last index of s[end]
            lastIndex[userString.charAt(end) - 'a'] = end;
        }
        return Longestsubstr;
    }
    // Recursive function to generate unique palindromes
    public static int getUniquePalindromes(String s) {
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            expandAndCollectPalindromes(s, i, i, unique);     // odd-length
            expandAndCollectPalindromes(s, i, i + 1, unique); // even-length
        }

        return unique.size();
    }

    private static void expandAndCollectPalindromes(String s, int left, int right, Set<String> unique) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > 1) { // count palindromes of length >= 2
                unique.add(s.substring(left, right + 1));
            }
            left--;
            right++;
        }
    }
    //Snake Case to Camel Case Conversion
    public static String snakeToCamel(String s) {
        String result = "";
        boolean upper = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '_') {
                upper = true;
            } else {
                if (upper && ch >= 'a' && ch <= 'z') {
                    result += (char) (ch - 32); // convert to uppercase
                    upper = false;
                } else {
                    result += ch;
                }
            }
        }
        return result;
    }
    
}

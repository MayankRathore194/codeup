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
package Java.openupvs.Assignment2_2;

import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

public class Operation {
    //Method to find nth element in a Fibonacci Sequence
    public static int Nth_Fibonacci_Sequence_Element(int position)
    {
        if(position==0)
        {
            return 0;
        }
        if(position==1)
        {
            return 1;
        }
        return Nth_Fibonacci_Sequence_Element(position - 1) + Nth_Fibonacci_Sequence_Element(position - 2); //recursive call

    }
    //Count Consonants
    public static int countConsonants(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')) ch = (char) (ch + 32); // convert to lowercase 

            if (ch >= 'a' && ch <= 'z' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                count++;
        }
        return count;
    }
    public static long binaryToDecimal(long binaryNumber) {
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
    public static String Expand_user_string(String userstring)
    {
        String Expanded_string="";
        for(int i=0;i<userstring.length();i++)
        {
            char ch=userstring.charAt(i);
            if(i+1<userstring.length())
            {
                char next = userstring.charAt(i + 1);
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
    public static String Compressed_string_form(String USER_string)
    {
        String Compressed_string = "";

        int count = 1;
        for (int i = 0; i < USER_string.length(); i++) {
            if (i + 1 < USER_string.length() && USER_string.charAt(i) == USER_string.charAt(i + 1)) {
                count++;
            } else {
                Compressed_string = Compressed_string + USER_string.charAt(i) + count;
                count = 1;
            }
        }
    

        return Compressed_string;
    }
    //Method to check prime number
    public static String Check_if_number_is_Prime(int user_number)
    {
        if (user_number <= 1) return "The given number is NOT prime.";
        for (int i = 2; i * i <= user_number; i++) {
            if (user_number % i == 0)
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
    public static int longestUniqueSubstr(String uString) {
        
        int Length = uString.length();
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
            start = Math.max(start, lastIndex[uString.charAt(end) - 'a'] + 1);

            // Update result if we get a larger window
            Longestsubstr = Math.max(Longestsubstr, end - start + 1);

            // Update last index of s[end]
            lastIndex[uString.charAt(end) - 'a'] = end;
        }
        return Longestsubstr;
    }
    // Recursive function to generate unique palindromes
    static void generateUniquePalindromes(String iString, String current, int index, List<String> result) {
        int Length = iString.length();

        // Base case
        if (index == Length) {
            if (!current.equals("") && isPalindrome(current)) {
                // Add only if not already in list
                if (!result.contains(current)) {
                    result.add(current);
                }
            }
            return;
        }

        // Include current character
        generateUniquePalindromes(iString, current + iString.charAt(index), index + 1, result);

        // Exclude current character
        generateUniquePalindromes(iString, current, index + 1, result);
    }

    // function to check palindrome
    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
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
        

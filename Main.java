   /**
 * @filename Main.java
 * This file serves as the main driver program to demonstrate various string and number operations
 * implemented in the Operations class. It allows users to interactively perform operations like
 * counting palindromes, Fibonacci number, snake_case to camelCase conversion, consonant count,
 * binary-to-decimal conversion, prime check, number-to-words conversion, and more.
 * 
 * @author Mayank Rathore
 * @class Main
 * @description The Main class provides a menu-driven interface for testing and executing
 *              all string and number manipulation methods defined in the Operations class.
 */
package Java.openupvs.Assignment2_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Java.openupvs.Assignment2.Operations;
import Java.openupvs.Assignment2_2.Operation;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        boolean k=true;
        while(k)
        {
            System.out.println("""
                                 Choose an operation
                                 1. Count Unique Palindromes
                                 2. Fibonacci Sequence – Nth Number
                                 3. Snake Case to Camel Case Conversion
                                 4. Count Consonants in a String
                                 5. Binary to Decimal Conversion
                                 6. Expand Characters in a String
                                 7. Character Frequency in a String
                                 8. Prime Number Checker
                                 9. Number to Words Converter
                                 10. Longest Substring Without Repeating Characters
                                 11. Exit
                                 Enter your choice (1–11): """);
            int choice=sc.nextInt();
            sc.nextLine(); // consume newline
            switch(choice)
            {
                case 1:
                    System.out.println("Enter string: ");
                    String Userinput=sc.nextLine();
                    List<String> result = new ArrayList<>();
                    Operation.generateUniquePalindromes(Userinput, "", 0, result);
                    System.out.println("Unique palindromic substrings:");
                    System.out.println(result);
                    System.out.println("Count: " + result.size());
                    break;
                case 3:
                    System.out.print("Enter snake_case string: ");
                    String snake = sc.nextLine();
                    System.out.println("CamelCase: " + Operations.snakeToCamel(snake));
                    break;
        
                    
                case 2:
                    System.out.println("Enter position in Fibonacci sequence ");
                    try {
                        
                        int position=sc.nextInt();
                        System.out.println("Element at position:"+position+"\nIs:"+Operation.Nth_Fibonacci_Sequence_Element(position));
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        sc.nextLine(); 
                        break;
                            
                        }
                case 4:
                    System.out.println("Enter your string to count Consonants ");
                    try {
                        String User_string=sc.nextLine();
                    
                        System.out.println("Number of Consonants in your string :   "+ Operation.countConsonants(User_string));
                        
                        break;
                        
                        
                        } 
                    catch (NumberFormatException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid string.");
                        
                        // clear the invalid input from the buffer
                        sc.nextLine(); 
                        break;
                            
                        }
                    
                    
                case 5:
                    System.out.println("Enter the binary number");
                    try {
                        long User_binary_number=sc.nextInt();
                        System.out.println("the decimal number is:  "+Operation.binaryToDecimal(User_binary_number));
                        
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        sc.nextLine(); 
                        break;
                            
                        }
                case 6:
                    System.out.println("Enter String charater followed by its frequency ");
                    String User_input=sc.nextLine();
                    System.out.println("The expaned string is :"+Operation.Expand_user_string(User_input));
                    break;
                case 7:
                    System.out.println("Enter String to compress");
                    String USER_string=sc.nextLine();
                    System.out.println("the compressed form is :  "+Operation.Compressed_string_form(USER_string));
                    break;
                case 8:
                    System.out.println("Enter number to check");
                    int user_number=sc.nextInt();
                    System.out.println(Operation.Check_if_number_is_Prime(user_number));
                    break;
                case 9:
                    System.out.println("Enter number to covert to word");
                    try {
                        int number=sc.nextInt();
                        System.out.println("the number "+number+"in word is:  "+Operation.convertNumber(number));
                        
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        sc.nextLine(); 
                        break;
                            
                        }
                case 10:
                    System.out.println("Enter the string ");
                    String input_String=sc.nextLine();
                    
                    System.out.println("find the length of the longest substring without repeating characters"+Operation.longestUniqueSubstr(input_String));
                    break;
                    
                    
                    
                case 11:
                    System.out.println("Exiting the program. Thank you!");
                    k = false;
                    break;


            }

        }
    }

    
}

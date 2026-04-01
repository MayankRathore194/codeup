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
package Java.openupvs.Assignment2_3;

import java.util.InputMismatchException;
import java.util.Scanner;


import Java.openupvs.Assignment2_3.Operations;

public class Main {
    public static void main(String[] args)
    {
        Scanner scannerObject=new Scanner(System.in);

        boolean k=true;//For infinite loop
        while(k)
        {
            System.out.println("""
                                 Choose an operation
                                 1. Count Unique Palindromes
                                 2. Fibonacci Sequence  Nth Number
                                 3. Snake Case to Camel Case Conversion
                                 4. Count Consonants in a String
                                 5. Binary to Decimal Conversion
                                 6. Expand Characters in a String
                                 7. Character Frequency in a String
                                 8. Prime Number Checker
                                 9. Number to Words Converter
                                 10. Longest Substring Without Repeating Characters
                                 11. Exit
                                 Enter your choice (1-11): """);
            int choice=scannerObject.nextInt();
            scannerObject.nextLine(); // consume newline
            switch(choice)
            {
                case 1:
                    System.out.println("Enter string: ");
                    String userInput=scannerObject.nextLine();
                    int count=Operations.getUniquePalindromes(userInput);
                    System.out.println("Unique palindromic substrings count:");
                    System.out.println(count);
                    break;
                case 3:
                    System.out.print("Enter snakeCase string: ");
                    String snakeCaseString = scannerObject.nextLine();
                    System.out.println("CamelCase: " + Operations.snakeToCamel(snakeCaseString));
                    break;
        
                    
                case 2:
                    System.out.println("Enter position in Fibonacci sequence ");
                    try {
                        
                        long position=scannerObject.nextLong();
                        System.out.println("Element at position:"+position+"\nIs:"+Operations.getNthFibonacci(position));
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        scannerObject.nextLine(); 
                        break;
                            
                        }
                case 4:
                    System.out.println("Enter your string to count Consonants ");
                    try {
                        String userString=scannerObject.nextLine();
                    
                        System.out.println("Number of Consonants in your string :   "+ Operations.getConsonantCount(userString));
                        
                        break;
                        
                        
                        } 
                    catch (NumberFormatException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid string.");
                        
                        // clear the invalid input from the buffer
                        scannerObject.nextLine(); 
                        break;
                            
                        }
                    
                    
                case 5:
                    System.out.println("Enter the binary number");
                    try {
                        long userBinaryNumber=scannerObject.nextInt();
                        System.out.println("the decimal number is:  "+Operations.convertBinaryToDecimal(userBinaryNumber));
                        
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        scannerObject.nextLine(); 
                        break;
                            
                        }
                case 6:
                    System.out.println("Enter String charater followed by its frequency ");
                    String inputToExpend=scannerObject.nextLine();
                    System.out.println("The expaned string is :"+Operations.expandCharacters(inputToExpend));
                    break;
                case 7:
                    System.out.println("Enter String to compress");
                    String inputToCompress=scannerObject.nextLine();
                    System.out.println("the compressed form is :  "+Operations.getCharacterFrequency(inputToCompress));
                    break;
                case 8:
                    System.out.println("Enter number to check");
                    long userNumber=scannerObject.nextLong();
                    System.out.println(Operations.checkPrimeNumber(userNumber));
                    break;
                case 9:
                    System.out.println("Enter number to covert to word");
                    try {
                        int number=scannerObject.nextInt();
                        System.out.println("the number "+number+"in word is:  "+Operations.convertNumber(number));
                        
                        break;
                        
                        
                        } 
                    catch (InputMismatchException e) {
                        // If the attempt fails 
                        System.out.println("\nERROR: That was not a valid integer.");
                        
                        // clear the invalid input from the buffer
                        scannerObject.nextLine(); 
                        break;
                            
                        }
                case 10:
                    System.out.println("Enter the string ");
                    String inputStrings=scannerObject.nextLine();
                    
                    System.out.println("find the length of the longest substring without repeating characters"+Operations.getLongestUniqueSubstringLength(inputStrings));
                    break;
                    
                    
                    
                case 11:
                    System.out.println("Exiting the program. Thank you!");
                    k = false;
                    break;


            }

        }
    }
}

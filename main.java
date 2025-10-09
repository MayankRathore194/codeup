/**
 * @filename main.java
 * This file serves as the main driver program to demonstrate various string operations
 * implemented in the Mystring class. It allows users to interactively perform operations
 * like append, replace, count words, check palindrome, sort, reverse, etc.
 * 
 * @author Mayank Rathore
 * @class Main
 * @description The Main class is responsible for providing a menu-driven interface
 *              to test and execute all string manipulation methods defined in Mystring.
 *              
 */
package Java.openupvs.Assignment1_2;

import java.util.Scanner;

import Java.openupvs.Assignment1_2.Mystring;

public class Main {
    public static void main(String[] args) {
        Scanner scanner_object = new Scanner(System.in);
        System.out.println("Enter your string:");
        String Userstring = scanner_object.nextLine();

        Mystring Mystring_object = new Mystring(Userstring);
        Mystring_object.Printstring();
        boolean k=true;

        while (k) {
            // Choices of operation
            System.out.println("\nChoose an Operation");
            System.out.println("1. Append");
            System.out.println("2. CountWords");
            System.out.println("3. Replace");
            System.out.println("4. isPalindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. the Maximum Repeating Character");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("11. Print string");
            System.out.println("12. Exit");
            System.out.print("Enter choice (1-12): ");

            int choice = scanner_object.nextInt();
            scanner_object.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter text to append:");
                    String newstring = scanner_object.nextLine();
                    System.out.println(Mystring_object.append(newstring));
                    break;

                case 2:
                    int Word_count = Mystring_object.getcount();
                    System.out.println("Number of words in the string: " + Word_count);
                    break;

                case 3:
                    System.out.println("Enter the word to replace:");
                    String oldword = scanner_object.nextLine();
                    System.out.println("Enter the word to replace with:");
                    String newword = scanner_object.nextLine();
                     System.out.println(Mystring_object.replace(oldword, newword));
                    break;

                case 4:
                    if (Mystring_object.isPalindrome()) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = scanner_object.nextInt();
                    System.out.print("Enter length: ");
                    int length = scanner_object.nextInt();
                    scanner_object.nextLine();
                     System.out.println(Mystring_object.splice(start, length));
                    break;

                case 6:
                    Mystring_object.split();
                    break;

                case 7:
                    char Maximum_Repeating_Character = Mystring_object.Maximum_Repeating_Character();
                    System.out.println("Maximum repeated character is: " + Maximum_Repeating_Character);
                    break;

                case 8:
                     System.out.println(Mystring_object.sort());
                    break;

                case 9:
                    System.out.print("Enter shift value: ");
                    int shift_by = scanner_object.nextInt();
                    scanner_object.nextLine();
                     System.out.println(Mystring_object.shift(shift_by));
                    break;

                case 10:
                    System.out.println(Mystring_object.reversestring());
                    break;

                case 11:
                    Mystring_object.Printstring();
                    break;

                case 12:
                    System.out.println("Exiting program...");
                    scanner_object.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1–12.");
            }
        }
    }
}
    
    


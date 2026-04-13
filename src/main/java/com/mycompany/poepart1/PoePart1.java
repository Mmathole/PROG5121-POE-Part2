/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poepart1;

import java.util.Scanner; 

public class PoePart1 {
    //variables to storethe correct details when the user registers
 private static String correctUsername, correctPassword, correctPhoneNum;
 private static String name, surname;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        registerUser(input); //to register the user
        loginUser(input); //to log in the user
        input.close();
    }
    
    //Method to check if the username is valid
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    //Method to check if the password meets the complexity rules
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        
        //it will fail if the password is shorter than 8 characters
        if (password.length() < 8) {
            return false;
        }
       //loop through each charecter to check the different rules for each character
       //for loop
       for (char ch : password.toCharArray()) {
           if(Character.isUpperCase(ch)) {
               hasUpper = true;
           }
           else if(Character.isDigit(ch)) {
               hasNumber = true;
           }
           else if(!Character.isLetterOrDigit(ch));
           hasSpecialChar = true;
       }
        return hasUpper && hasNumber && hasSpecialChar; //if all conditions are met it will return true
    }
    
    //Method to check if phone number is valid
    public static boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
        //Regex reference:
        //The regular expression "^\\+27\\d{9}$" is used to validate South African phone numbers
        //^    - matches the start of the String 
        // \\+27   - ensure the number begins with the South African country code +27
        // \\d{9}    - matches exactley 9 digits after the country code
        //$    - matches of the string
        // This ensure the entire input follows the required format exactly.
        //Source: https://www.regular-expressions.info/anchors.html
    }
    
    //Method to register the user (ask the user to enter their details)
    public static String registerUser(Scanner input) {
        //Declarations
        String username;
        String password;
        String phoneNum;
        
        System.out.println("=== REGISTRATION ===");
        
        //Get user's first and last name
        System.out.println("Enter your first name: ");
        name = input.nextLine();
        
        System.out.println("Enter your last name: ");
        surname = input.nextLine();
        
        //Loop until the username is correctly formatted
        while (true) {
            System.out.println("Enter username: ");
            username = input.nextLine();
            if (checkUserName(username)) {
                correctUsername = username;
                System.out.println("Username successfully captured.");
                break;
            }
            else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }
        //Loop until the password is correctly formatted
        while (true) {
            System.out.println("Enter Password: ");
            password = input.nextLine();
            if (checkPasswordComplexity(password)) {
                correctPassword = password;
                System.out.println("Password seccessfully captured.");
                break;
            }
            else {
                System.out.println("Password is not correctly formatted; please ensure that it contains at least eight characters, a capital letter, a number, and a special character");
            }
        }
        //Loop to ensure cell phone number is valid
        while (true) {
            System.out.println("Enter your cell phone number: ");
            phoneNum = input.nextLine();
            if (checkCellPhoneNumber(phoneNum)) {
                correctPhoneNum = phoneNum;
                System.out.println("Cell phone number successfully added.");
                break;
            }
            else {
                System.out.println("Cell phone number incorrectle formatted pr does not contain international code.");
            }
        }
        return "User registered successfully.";
                
    }
    //Method to login user (asks the user to enter their username and password)
    //to check if the they match the details stored from registration
    public static boolean loginUser(Scanner input) {
        
        //Declare login details
        String username;
        String password;
        
        
        System.out.println("=== LOGIN ===");
        
            System.out.println("Enter your username:");
            username = input.nextLine();
            System.out.println("Enter password:");
            password = input.nextLine();
            
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Welcome " + name + " , " + surname + " it is great to see you again. ");
            return true;
        }
            else {
                System.out.println("Username or password incorrect, please try again.");
                return false;
        }       
    }
    //Method  return login status
    //it returns a message depending on whether login was successful or not
    public static String returnLoginStatus(boolean success) {
        if (success) {
            return ("Welcome" + name + "," + surname + "it is great to see you again.");
        }
        else {
            return ("Username or password incorrect, please try again.");
        }
    }
 
}

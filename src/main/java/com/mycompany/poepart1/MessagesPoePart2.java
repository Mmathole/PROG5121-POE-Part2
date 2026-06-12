package com.mycompany.poepart1;

import java.util.Scanner;
import java.util.ArrayList; //arrayList stores multiple values 
import java.util.Random; //helps generate random numbers

public class MessagesPoePart2 {
    static Scanner input = new Scanner(System.in);
    //an ArrayList to store all messages that are sent and stored
    static ArrayList<String> sentMessages = new ArrayList<>();
    //part 3======================================================================================================================
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<String> recipients = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();
    
    
    public static int totalMessages = 0; //variable to count total messages sent
    
    public static void main(String[] args) {
    
    //------------WELCOME MESSAGE AFTER LOGIN-----------
    System.out.println("=======WELCOME TO QUICKCHAT=======");
    
    
    boolean running = true; //variable used to control the menu loop
    int choice = 0; //variable to store the users choice
    
    //use while so that it loops until the user chooses to quit
    while (running) {
          System.out.println("QUICKCHAT Menu:");
          System.out.println("1. Send Messages");
          System.out.println("2. Show recently sent messages");
          System.out.println("3. Stored Messages");//part3=================================================================================
          System.out.println("4. Quit");
            
          //ask user to choose an option on the menu
            System.out.println("Choose an option");
            choice = input.nextInt(); //reads the users choice
            input.nextLine();
            
            //switch statement to check which option the user selected
            switch (choice) {
                case 1: //send messages
                System.out.println("Enter how many messages you'd like to send? ");
                int numOfMessages = input.nextInt();
                input.nextLine();
                
                //loop according to how many messages the user entered
                for (int i = 0; i < numOfMessages; i++) {
                    System.out.println("\nMessage " + (i + 1));
              
                    
                    //create a message object
                   Message msg = new Message();
                   msg.generateMessageID();
                   messageIDs.add(msg.messageID);//part3========================================================================================
                   
                   //ask for recipient's number
                while (true) {

                    System.out.println("Enter recipient phone number (+27...): ");
                    msg.recipient = input.nextLine();

                    //validate recipient number
                    if (msg.checkRecipientCell()) {
                        System.out.println("Cell phone number successfully captured.");
                        break; //  exits loop when number is correct
                    }
                    else {
                        System.out.println("Cell phone number incorrectly formatted.");
                        System.out.println("Please re-enter the phone number.");
                    }
                } 
                   
                   //ask user for message
                    while (true) {

                        System.out.println("Enter your message:");
                        msg.messageText = input.nextLine();

                        //check message length
                        if (msg.messageText.length() <= 250) {

                            System.out.println("Message sent.");
                            break; 
                        }
                        else {

                            int extraCharacters = msg.messageText.length() - 250;

                            System.out.println(
                                "Message exceeds 250 characters by "
                                + extraCharacters +
                                " characters. Please enter a shorter message."
                            );
        
                        }
                    }
                   
                   //Create message hash
                   msg.createMessageHash();
                   messageHashes.add(msg.messageHash);//part3===========================================================================
                   
                   //ask the user what to do the message
                   System.out.println("Choose what to do:");
                   System.out.println("1) Send Message");
                   System.out.println("2) Disregard Message (Press 0 to delete)");
                   System.out.println("3) Store Message");
                   
                   int action = input.nextInt();
                   input.nextLine();
                   
                   //------------MESSAGE OPTION-----------
                   switch (action) {
                        case 1:
                           String formattedMessage =msg.printMessages();
                           
                           sentMessages.add(formattedMessage); //it adds message to sent list
                           totalMessages++; ////Increases total messages counter 
                           System.out.println("Message successfully sent."); 
                           
                           //display message details
                           System.out.println("---MESSAGE DETAILS---");
                           System.out.println(formattedMessage);////shows message details
                           break;
                           
                        case 2:
                        System.out.println("Press 0 to delete.");
                        int delete = input.nextInt();
                        input.nextLine();
                        if (delete == 0) {

                            System.out.println("Message disregarded.");
                        }
                        else {
                            System.out.println("Message not deleted.");
                        }
                        break;
                           
                       case 3:
                          String storedMessage = msg.printMessages();
                          sentMessages.add(storedMessage);
                          storedMessages.add(msg);
                          msg.storeMessage();
                          totalMessages++;

                          System.out.println("Message successfully stored.");
                          System.out.println("---STORED MESSAGE---");
                          System.out.println(storedMessage);

    break;
                   }   
                }
                break;
                
                //SHOW MESSAGEs------------------------------------
                case 2:
                    if (sentMessages.isEmpty()) {
                    System.out.println("Coming soon.");
                    }
                     else {
                         System.out.println("---RECENT MESSAGES---");

                           for (String message : sentMessages) {
                             System.out.println(message);
                             System.out.println("-------------------");
        }
                    }
                    break;
                case 3://part3================================================================================================
                    Report report = new Report(storedMessages);//report object so it can access the stored message ArrayList
                    System.out.println("\n===== STORED MESSAGES MENU =====");

                    System.out.println("1. Display Sender and Recipient");
                    System.out.println("2. Display Longest Stored Message");
                    System.out.println("3. Search Message ID");
                    System.out.println("4. Search Recipient");
                    System.out.println("5. Delete Message Using Message Hash");
                    System.out.println("6. Display Full Report");
                    
                    int reportChoice = input.nextInt();
                    input.nextLine();
                    //Check which report option the user selected
                    switch(reportChoice) {
                        case 1:
                            report.displaySenderRecipient(); 
                            break;
                            
                        case 2: 
                            report.displayLongestMessage();
                            break;
                            
                        case 3:
                            System.out.println("Enter Message ID:");
                            String id = input.nextLine();
                            report.searchMessageID(id);//sends the ID to the Report class so it can search for messages that match
                            break;
                        case 4:
                            System.out.println("Enter recipient:");
                            String recipient = input.nextLine();
                            report.searchRecipient(recipient);
                           break;
                        case 5:
                            System.out.println("Enter Message Hash:");
                            String hash = input.nextLine();
                            report.deleteMessageHash(hash);
                            break;
                        case 6:
                            report.displayReport();
                            break;
                            //if the user selects a menu option that does not exists
                        default:
                            System.out.println("Invalid option.");
                     
                    }
                    break;
                    //=======Quit=========
                case 4:
                    running = false;
                    
                    //display total messages sent
                    System.out.println("\nTotal messages sent:"  + totalMessages);
                    System.out.println("Goodbye");
                    break;
            }
                             
         }
    }
  
}



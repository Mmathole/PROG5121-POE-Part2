package com.mycompany.poepart1;

import java.util.ArrayList;

public class Report { 
    
    private ArrayList<Message> storedMessages;//ArrayList to store all messages that were saved/stored from MessagesPoePart2
    //to recieve the storedMessages ArrayList from MessagesPoePart2
    public Report(ArrayList<Message> storedMessages) { 
        this.storedMessages = storedMessages; //save the AraayList inside this class
        
    }
    //Display sender and recipient of all stored messages
    public void displaySenderRecipient() {
        //check if there are no stored messages
        if(storedMessages.isEmpty()) {
            System.out.println("No stored messages available.");
            return;
        }
        //Loop through every message in the arrsylist
        for(Message msg : storedMessages) {
            System.out.println("===============");
            System.out.println("Recipient: " + msg.recipient); //display recipients number
        }
    }
    //Display the longest stored message
    public void displayLongestMessage() {
        if (storedMessages.isEmpty()) {
            System.out.println("There are no stored messages available.");
            return;
        }
        //use the first message as the initial longest message
        //the program will then compare all the other messages against it
        Message longest = storedMessages.get(0);
        for(Message msg : storedMessages) {
            if(msg.messageText.length() > longest.messageText.length()) {
                longest = msg;//to replace the longest message
            }
        }
        System.out.println("Longest Stored Message: \n" + longest.messageText );
        
    }
    //search for message using message id
    public void searchMessageID(String id) {

        for(Message msg : storedMessages) { 
            //check if the IDs mathch
            if(msg.messageID.equals(id)) {
            System.out.println("Recipient: " + msg.recipient);
            System.out.println("Message: " + msg.messageText);
            return;
            }
        }
        //continue running if ID is not found
        System.out.println("Message not found.");
    }
    
    public void searchRecipient(String recipient) {

        boolean found = false; //Variable used to check whether messages were found
        for(Message msg : storedMessages) {
            //to compare recipient numbers
            if(msg.recipient.equals(recipient)) {
                System.out.println("==========================");
                System.out.println("Message ID: " + msg.messageID);
                System.out.println("Message: " + msg.messageText);
                found = true;
            }
        }
        //continue running if no messages were found
        if(!found) { 
            System.out.println("No messages found.");
        }
        
    }
    public void deleteMessageHash(String hash) {
        for(int i = 0; i < storedMessages.size(); i++) {
            //compares the hash values
            if(storedMessages.get(i) .messageHash.equals(hash)) {
                storedMessages.remove(i);//removes the message that matches from the arraylist
                System.out.println( "Message successfully deleted." );
                return;
            }
           
            }
        //if hash is not found
        System.out.println("Hash not found.");
            
        } 
    public void displayReport() {
        if(storedMessages.isEmpty()) { 
            System.out.println("No stored messages available."); 
            return; 
        }
        for(Message msg : storedMessages) {
            
            System.out.println("==================================");
            System.out.println("Message ID: " + msg.messageID);
            System.out.println("Message Hash: " + msg.messageHash);
            System.out.println("Recipient: " + msg.recipient);
            System.out.println("Message: " + msg.messageText);
        }
    }

}

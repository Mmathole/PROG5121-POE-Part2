package com.mycompany.poepart1;

import java.util.Random;

public class Message {
    public String messageID;
    public String recipient;
    public String messageText;
    public String messageHash;
        
        //Method to generateMessageID
        public void generateMessageID() {
            Random random = new Random();
            
            //random 10-digit number
            long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
            //Generate random 10-digit number
            //random.nextDouble()    -  generates a random decimal number between 0.0 and 1.0
            //* 9000000000L   - multiply by 9000000000L to increase the renage into billions
            //(long)  - remves the decimal part
            //1000000000L - is always added to ensure the final result is always a 10-digit number
            //Source: Oracle. (2024) Class Random.
            //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
            
           messageID = String.valueOf(number); //converts number into String
        }
           
           //Method to checkMessageID
           public boolean checkMessageID() {
               return messageID.length() <= 10;   
           }
           
           //Method to checkRecipientCell
          public boolean checkRecipientCell() {
            return recipient != null
                    && recipient.startsWith("+")
                    && recipient.length() <= 12;
        }
           //Method createMessageHash
            public String createMessageHash() {
            String[] words = messageText.split(" ");

            String firstWord = words[0];
            String lastWord = words[words.length - 1];

            messageHash = messageID.substring(0, 2) + ":" +
                    firstWord.toUpperCase() + lastWord.toUpperCase();

            return messageHash;
        }
           
           //Method for sentMessages
           public String SentMessage(String action) {
               if (action.equalsIgnoreCase("send")) {
                   return "Message successfully sent.";
               }
               else if (action.equalsIgnoreCase("store")) {
                   return "Message successfully stored.";           
               }
               else if (action.equalsIgnoreCase("discard")) {
                   return "Press 0 to delete message.";
               }
               else {
                   return "Invalid option.";
               }
           }
           //Method to PrintMessages
           public String printMessages() {
               System.out.println("Message ID: " + messageID);
               System.out.println("Message Hash: " + messageHash);
               System.out.println("Recipient: " + recipient);
               System.out.println("Message: " + messageText);
               
               return  "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;           
           }
           //Method to return total messages sent
           public static int returnTotalMessages() {
               return MessagesPoePart2.totalMessages;
           }
           
           //Method to store messgaes in JSON
           public void storeMessage() {
               try {
                   String json = "{\n" + "\"MessageID\":\"" + messageID + "\"," +
                         "\"MessageHash\":\"" + messageHash + "\"," +
                         "\"Recipient\":\"" + recipient + "\"," +
                         "\"Message\":\"" + messageText + "\"" + "}";
                   
                   //FileWriter used to write text into a file
                   java.io.FileWriter writer = new java.io.FileWriter("messages.json", true); //messages.json is the file name where the JSON data will be stored
                   writer.write(json + "\n"); //apends JSON to file
                   writer.close();
                   
                   //confirmation message
                   System.out.println("Message saved to messages.json file.");
               }
               catch (Exception e) {
                   //if something goes wrong it must show error
                   System.out.println("Error saving message: " + e.getMessage());
               }
               
           }
           
    }
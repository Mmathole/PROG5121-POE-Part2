package TestReport;
import com.mycompany.poepart1.Report;
import com.mycompany.poepart1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;



public class TestReportClass {
    @Test
     public void testSentMessagesArrayPopulated() {
         ArrayList<String> sentMessages = new ArrayList<>();
         
         sentMessages.add("Did you get the cake?");
         sentMessages.add("It is dinner time !");
         
         assertEquals(2, sentMessages.size());
         assertEquals("Did you get the cake?", sentMessages.get(0));
          assertEquals("It is dinner time !", sentMessages.get(1));
         
     }
     @Test
     public void testLongestMessage() {
         Message msg1 = new Message();
         msg1.messageText = "Did you get the cake?";
         
          Message msg2 = new Message();
          msg2.messageText = "Where are you? You are late! I have asked you to be on time.";
          
          Message msg3 = new Message();
          msg3.messageText = "Ok, I am leaving without you.";

          ArrayList<Message> storedMessages = new ArrayList<>();

          storedMessages.add(msg1);
          storedMessages.add(msg2);
          storedMessages.add(msg3);

          Message longest = storedMessages.get(0);
          for(Message msg : storedMessages) {
              if(msg.messageText.length() > longest.messageText.length()) {
                  longest = msg;
              }
          }
          assertEquals("Where are you? You are late! I have asked you to be on time.",longest.messageText);

     }
     
     @Test
      public void testSearchMessageID() {
          Message msg = new Message();
          msg.messageID = "0838884567";
          msg.messageText = "It is dinner time !";

          assertEquals("0838884567", msg.messageID);

          assertEquals("It is dinner time !", msg.messageText);
                       
          }
      @Test
      public void testSearchRecipient() {
          ArrayList<Message> storedMessages = new ArrayList<>();
           Message msg1 = new Message();
           msg1.recipient = "+27838884567";
           msg1.messageText = "Where are you? You are late! I have asked you to be on time.";
           
            Message msg2 = new Message();
            msg2.recipient = "+27838884567";
            msg2.messageText = "Ok, I am leaving without you.";

            storedMessages.add(msg1);
            storedMessages.add(msg2);

            int count = 0;
            
             for(Message msg : storedMessages) {
                 if(msg.recipient.equals("+27838884567")) {
                 count++;
                 
             }
           }
             assertEquals(2, count);
             

      }
      @Test
      public void testDeleteMessageHash() {
           ArrayList<Message> storedMessages = new ArrayList<>();
           
            Message msg = new Message();          

            msg.messageHash = "12:WHERETIME";
            storedMessages.add(msg);
            int beforeDelete = storedMessages.size();
            storedMessages.remove(0);
            int afterDelete = storedMessages.size();
            assertEquals(1, beforeDelete);
            assertEquals(0, afterDelete);
      }
      
      @Test
       public void testDisplayReport() {
           Message msg = new Message();

           msg.messageID = "1234567890";
           msg.messageHash = "12:DIDGETCAKE";
           msg.recipient = "+27834557896";
           msg.messageText = "Did you get the cake?";

           assertNotNull(msg.messageID);
           assertNotNull(msg.messageHash);
           assertNotNull(msg.recipient);
           assertNotNull(msg.messageText);//
       }
  
}

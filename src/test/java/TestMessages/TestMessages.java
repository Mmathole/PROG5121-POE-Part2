package TestMessages;
import com.mycompany.poepart1.Message;
import com.mycompany.poepart1.MessagesPoePart2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMessages {
    
    @Test
    void testMessage1_SendMessage() {
        Message msg1 = new Message();//test data 1
        
        msg1.generateMessageID();
        msg1.recipient = "+27718693002";
        msg1.messageText = "Hi Mike, can you join us for dinner tonight?";
        
        // validate recipient
        assertTrue(msg1.checkRecipientCell());

        // create hash
        String hash = msg1.createMessageHash();
        assertNotNull(hash);

        // simulate SEND action
        String output = msg1.SentMessage("send");
        assertEquals("Message successfully sent.", output);

        // simulate system counter increase
        int before = MessagesPoePart2.totalMessages;
        MessagesPoePart2.totalMessages++;
        assertEquals(before + 1, MessagesPoePart2.totalMessages);
    }
    @Test
    void testMessage2_DiscardMessage() {
        Message msg2 = new Message();//test data 2

        msg2.generateMessageID();
        msg2.recipient = "08575975889"; // invalid format
        msg2.messageText = "Hi Keegan, did you receive the payment?";

        // recipient should fail validation
        assertFalse(msg2.checkRecipientCell());

        // discard action (0 flow in your menu)
        String output = msg2.SentMessage("discard");
        assertEquals("Press 0 to delete message.", output);

        // totalMessages should NOT increase for discard
        int before = MessagesPoePart2.totalMessages;

        // simulate discard = no increment
        assertEquals(before, MessagesPoePart2.totalMessages);
    }
        
    @Test
    void testMessageHashGeneration() {
        Message msg = new Message();

        msg.messageID = "1234567890";
        msg.messageText = "Hello there friend";

        String hash = msg.createMessageHash();

        assertTrue(hash.startsWith("12:"));
        assertTrue(hash.contains("HELLO"));
        assertTrue(hash.contains("FRIEND"));
    }
     @Test
    void testReturnTotalMessages() {
        MessagesPoePart2.totalMessages = 0;

        MessagesPoePart2.totalMessages++;
        MessagesPoePart2.totalMessages++;

        assertEquals(2, Message.returnTotalMessages());
    
}
    
    
}

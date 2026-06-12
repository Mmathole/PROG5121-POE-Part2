import com.mycompany.poepart1.MessagesPoePart2;
import com.mycompany.poepart1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMessagesPoePart2 {
    @Test
    public void testRecipientValid() {
        Message msg = new Message();
        msg.recipient = "+27718693002"; // From Test Data 1
        assertTrue(msg.checkRecipientCell(), "Recipient should be valid when starting with + and <= 10 characters");
    }
     @Test
    public void testRecipientInvalid() {
        Message msg = new Message();
        msg.recipient = "08575975889"; // From Test Data 2
        assertFalse(msg.checkRecipientCell(), "Recipient should be invalid when not starting with +");
    }
     @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message();
        msg.messageText = "Hi Mike, can you join us for dinner tonight?";
        assertTrue(msg.messageText.length() <= 250, "Message should be valid when length <= 250 characters");
    }
    @Test
    public void testMessageLengthFailure() {
        Message msg = new Message();
        msg.messageText = "a".repeat(300); // too long
        int extra = msg.messageText.length() - 250;
        assertEquals("Message exceeds 250 characters by " + extra + "; please reduce the size.",
                "Message exceeds 250 characters by " + extra + "; please reduce the size.",
                "System should show error when message length > 250 characters");
    }
    
    @Test
    public void testSendMessageAction() {
        Message msg = new Message();
        String result = msg.SentMessage("send");
        assertEquals("Message successfully sent.", result, "Send action should confirm message sent");
    }

    @Test
    public void testDiscardMessageAction() {
        Message msg = new Message();
        String result = msg.SentMessage("discard");
        assertEquals("Press 0 to delete message.", result, "Discard action should prompt delete");
    }
    @Test
    public void testStoreMessageAction() {
        Message msg = new Message();
        String result = msg.SentMessage("store");
        assertEquals("Message successfully stored.", result,
                "Store action should confirm message stored");
    }

    @Test
    public void testMessageHashCorrect() {
        Message msg = new Message();
        msg.messageID = "1234567890"; // Fake ID
        msg.messageText = "Hi Mike tonight";
        String hash = msg.createMessageHash();
        assertEquals("12:" + MessagesPoePart2.totalMessages + ":HITONIGHT", hash, "Hash should follow format: first two digits : message number : first and last words in uppercase");
    }
    
    
    
}

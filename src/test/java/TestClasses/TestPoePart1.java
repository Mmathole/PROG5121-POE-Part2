/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package TestClasses;
import com.mycompany.poepart1.PoePart1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPoePart1 {
   
    //Test if username is correctly formatted
    @Test 
    public void testUsernameCorrectlyFormatted() {
       String expected = "kyl_1";
       boolean actual = PoePart1.checkUserName(expected);
       assertEquals(true, actual, "Expected username to be valid."); 
    }
    //Test if username is incorrectly formatted
    @Test
    public void userNameIncorrectlyFormatted() {
        
        String expected = "kyle!!!!!!";
        boolean actual = PoePart1.checkUserName(expected);
        assertEquals(false, actual, "Expected username to be valid.");
    }
    //Test if the password meets the complexity of the requirements
    @Test
    public void testInvalidPasswordValid() {
        String expectedPassword = "Ch&&sec@ke99!";
        boolean actual = PoePart1.checkPasswordComplexity(expectedPassword);
        assertEquals(false, actual,"Expect the password to fail to meet the complexity rules");
    }
    //Test if the password does not meet the complexity of the requirements
    @Test
    public void testPasswordValid() {
        String expectedPassword = "Ch&&sec@ke99!";
        boolean actual = PoePart1.checkPasswordComplexity(expectedPassword);
        assertEquals(true, actual,"Expect the password to meet the complexity rules");
    }
    //Test if the cell phone is correctly formatted
    @Test
    public void testValidPhoneNumber() {
        String expectedPhone = "+27839868976";
        boolean actual = PoePart1.checkCellPhoneNumber(expectedPhone);
        assertEquals(false, actual,"Expect the phone number to be valid");
    }
    //Test if the cell phone is incorrectly formatted
    @Test
    public void testInvalidPhoneNumber() {
        String expectedPhone = "08966553";
        boolean actual = PoePart1.checkCellPhoneNumber(expectedPhone);
        assertEquals(false, actual,"Expect the phone number to be ivalid.");
    }
}

 
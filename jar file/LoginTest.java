import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {
    Login app = new Login();

    @Test
    public void testUserNameFormatting() {
        // Test Data: "kyl_1" (True)
        assertTrue(app.checkUserName("kyl_1"));

        // Test Data: "kyle!!!!!!!" (False)
        assertFalse(app.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordComplexity() {
        // Test Data: "Ch&&sec@ke99!" (True)
        assertTrue(app.checkPasswordComplexity("Ch&&sec@ke99!"));

        // Test Data: "password" (False)
        assertFalse(app.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneFormatting() {
        // Test Data: "+27838968976" (True)
        assertTrue(app.checkCellPhoneNumber("+27838968976"));

        // Test Data: "08966553" (False)
        assertFalse(app.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginLogic() {
        // Register a valid user
        app.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kylie", "Smith");

        // Login Successful (True)
        assertTrue(app.loginUser("kyl_1", "Ch&&sec@ke99!"));

        // Login Failed (False)
        assertFalse(app.loginUser("kyl_1", "wrongPass"));
    }

    @Test
    public void testReturnLoginStatusMessages() {
        app.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kylie", "Smith");

        // Successful message check
        String successMsg = app.returnLoginStatus(true);
        assertEquals("Welcome Kylie ,Smith it is great to see you again.", successMsg);

        // Failed message check
        String failMsg = app.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", failMsg);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerUser method, of class Login. Username incorrectly formatted
     */
    @Test
    public void testRegisterUser_username_correctly_formatted() {
        System.out.println("registerUser");
        User user = new User("Kyle", "One", new Credentials("kyl_1", "Test1234@"));
        Login instance = new Login();
        String expResult = utils.utils.WELCOME_MESSAGE;
        String result = instance.registerUser(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login. Username incorrectly formatted
     */
    @Test
    public void testRegisterUser_username_incorrectly_formatted() {
        System.out.println("registerUser");
        User user = new User("Kyle", "One", new Credentials("kyle!!!!!!!", "Ch&&sec@ke99!"));
        Login instance = new Login();
        String expResult = utils.utils.NOT_VALIDATED_USERNAME;
        String result = instance.registerUser(user);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of registerUser method, of class Login. Password meets requirements
     */
    @Test
    public void testRegisterUser_password_meets_requirements() {
        System.out.println("registerUser");
        User user = new User("Kyle", "One", new Credentials("kyl_1", "Test1234@"));
        String expResult = utils.utils.VALIDATED_PASSWORD;
        String result = Login.validatePassword(user.credentials.password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of loginUser method, of class Login. Successful Login
     */
    @Test
    public void testLoginUser_successful() {
        System.out.println("loginUser");
        User user = new User("Kyle", "One", new Credentials("kyl_1", "Test1234@"));
        String username = "kyl_1";
        String password = "Test1234@";
        Login instance = new Login();
        boolean result = instance.loginUser(user, username, password);
        assertTrue(result);
    }    
     
    /**
     * Test of loginUser method, of class Login. Unsuccessful Login
     */
    @Test
    public void testLoginUser_unsuccessful() {
        System.out.println("loginUser");
        User user = new User("Kyle", "One", new Credentials("kyl_1", "Test1234@"));
        String username = "kyl_1";
        String password = "Test1234@1";
        Login instance = new Login();
        boolean result = instance.loginUser(user, username, password);
        assertFalse(result);
    }

    /**
     * Test of checkUserName method, of class Login. Username correctly formatted
     */
    @Test
    public void testCheckUserName_formatted_correctly() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        boolean result = Login.checkUserName(username);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }   
    

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName_formatted_incorrectly() {
        System.out.println("checkUserName");
        String username = "kyl_1asdasd";
        boolean result = Login.checkUserName(username);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity_valid_password() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = Login.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of checkPasswordComplexity method, of class Login using assertTrue
     */
    @Test
    public void testCheckPasswordComplexity_valid_password_assertTrue() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean result = Login.checkPasswordComplexity(password);
        assertTrue(result);
    }   
    

    /**
     * Test of checkPasswordComplexity method, of class Login using assertTrue
     */
    @Test
    public void testCheckPasswordComplexity_invalid_password_assertFalse() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch!";
        boolean result = Login.checkPasswordComplexity(password);
        assertFalse(result);
    }

  
    /**
     * Test of validatePassword method, of class Login.
     */
    @Test
    public void testValidatePassword_valid() {
        System.out.println("validatePassword");
        String password = "Ch&&sec@ke99!";
        String expResult = utils.utils.VALIDATED_PASSWORD;
        String result = Login.validatePassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of validatePassword method, of class Login.
     */
    @Test
    public void testValidatePassword_invalid() {
        System.out.println("validatePassword");
        String password = "password";
        String expResult = utils.utils.NOT_VALIDATED_PASSWORD;
        String result = Login.validatePassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

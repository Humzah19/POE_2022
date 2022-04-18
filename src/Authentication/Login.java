/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.utils;

/**
 *
 * @author user
 */
public class Login {
    
    public User registeredUser;
        
    public String registerUser(User user){
        String response = validateRegistration(user);
        if(response.equals(utils.SUCCESSFULLY_REGISTERED)){
            registeredUser = user;
            return returnLoginStatus(true);
        }
        return response;

    }
    
    public boolean loginUser(User user, String username, String password){
        
        if(user.credentials.username.equalsIgnoreCase(username) && 
                user.credentials.password.equals(password))
            return true;
        
        return false;
    }
    
    public static boolean  checkUserName(String username){
        if(username == null || username.equals("")){
            return false;
        }
        if(!username.contains("_") || username.length() > 5)
            return false;
        return true;
    }   
    
    public static String validatePassword(String password){
        if(checkPasswordComplexity(password)) 
            return utils.VALIDATED_PASSWORD;
        else
            return utils.NOT_VALIDATED_PASSWORD;
    }       
    
    public static boolean checkPasswordComplexity(String password)
    {  
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        Pattern p = Pattern.compile(regex);
  
        if (password == null) {
            return false;
        }
        
        Matcher m = p.matcher(password);
  
        return m.matches();
    }        
    
    private boolean validateUser(User user){
        if(user != null && user.firstName != null && !user.firstName.equals("") 
                && user.lastName != null && !user.lastName.equals("") 
                && checkUserName(user.credentials.username)  && 
                checkPasswordComplexity(user.credentials.password)){
            return true;
        }
        else 
            return false;
    }
    
    private String validateRegistration(User user){
        String response = utils.SUCCESSFULLY_REGISTERED;
        
        if(!checkPasswordComplexity(user.credentials.password)){
            response = utils.NOT_VALIDATED_PASSWORD;
        }
        
        if(!checkUserName(user.credentials.username)){
            response = utils.NOT_VALIDATED_USERNAME;
        }

        return response;
    }
    
    public String returnLoginStatus(boolean successfullyLoggedIn){
        if(successfullyLoggedIn)
            return utils.WELCOME_MESSAGE;
        else
            return utils.LOGIN_FAILURE_MESSAGE;
    }
  
}

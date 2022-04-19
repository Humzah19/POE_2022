/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe_2022;

import Authentication.Credentials;
import Authentication.Login;
import Authentication.User;
import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class POE_2022 {

    static Login auth; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         auth = new Login();
         
         String[] options = {"1- Register a new user",
                            "2- Login",
                            "3- Exit",
        };
        int option = 1;
        Scanner scanner = new Scanner(System.in);
        while (option!=3){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: register(scanner); break;
                    case 2: login(scanner); break;
                    case 3: exit(0);
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }
    
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    
     private static void register(Scanner sc) {
        System.out.println("Enter your first name");
        String firstName = sc.next();
        System.out.println("Enter your last name");
        String lastName = sc.next();
       
        System.out.println("Enter your Username");
        String username = sc.next();
        while(!Login.checkUserName(username)){
            System.out.println(utils.utils.NOT_VALIDATED_USERNAME);
            username = sc.next();
        }
        
        System.out.println("Enter your Password");
        String password = sc.next();
        while(!Login.checkPasswordComplexity(password)){
            System.out.println(utils.utils.NOT_VALIDATED_PASSWORD);
            password = sc.next();
        }
        System.out.println(Login.validatePassword(password));
        
        Credentials creds = new Credentials(username, password);
        User user = new User(firstName, lastName, creds);
        
        System.out.println(auth.registerUser(user));       


    }
     
    private static void login(Scanner sc) {
        System.out.println("Enter your username");
        String username = sc.next();
        
        System.out.println("Enter your password");
        String password = sc.next();
        System.out.println(auth.returnLoginStatus(auth.loginUser(username, password)));

        while(!auth.loginUser(username, password)){
            password = sc.next();
            System.out.println(auth.returnLoginStatus(auth.loginUser(username, password)));
        }
    }
    
    
   
    
}

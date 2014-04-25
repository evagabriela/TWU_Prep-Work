package com.twu.biblioteca;
import java.util.ArrayList;

/**
 * Created by evazamudio on 2014-04-25.
 */
public class User {
    private static int nextLibraryNumber = 1111111;
    private static ArrayList<User> users = new ArrayList<User>();

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private int libraryNumber;

    public static User authenticate(String username, String password){
        for (User user : users) {
            if(user.getUsername().equals(username) &&
                    user.checkPassword(password))
                return user;
        }
        return null;
    }

    public User(String username, String password, String email, String phoneNumber){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = nextLibraryNumber++;
        users.add(this);
    }

    public String getLibraryNumber() {
        return (libraryNumber / 10000) + "-" + (libraryNumber % 10000);
    }

    public String getUsername() {
        return username;
    }

    private boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public static void cleanUp() {
        nextLibraryNumber = 1111111;
        users = new ArrayList<User>();
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private ArrayList listOfBooks = new ArrayList<String>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.getWelcomeMessage();
        System.out.print(bibliotecaApp.getListOfBooks());
    }

    public void getWelcomeMessage() {
        System.out.println("Welcome to the Biblioteca");
    }

    public ArrayList getListOfBooks() {
//        Animal myPet = new Dog();
        return listOfBooks;
    }

    public void showMenu() {
        System.out.println("Menu");
    }


    public String selectMenu(String choice) {

        if (choice.equals("1")) {// View all books
            return "List of Books";

        } if (choice.equals("Quit")){
            System.out.println("Quit");
        } else{
            System.out.println("Select a valid option!!");
        }
        return choice;
    }

    public void checkoutBook(String s) {
    }
}

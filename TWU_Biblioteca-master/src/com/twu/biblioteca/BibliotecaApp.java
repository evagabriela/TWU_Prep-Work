package com.twu.biblioteca;

import javax.xml.soap.SOAPPart;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

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
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
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

    public String checkoutBook(String bookName) {

        if (bookName.equals("Book 1")){
            System.out.print("Thank you! Enjoy the book");
        } if (bookName.equals("Book 2")){
            System.out.print("Thank you! Enjoy the book");
        }else{
            System.out.print("That book is not available");
        }
        return bookName;
    }

    public void returnItem(String book) {
        listOfBooks.add(book);
        System.out.print("Thank you for returning the book.");
    }
}

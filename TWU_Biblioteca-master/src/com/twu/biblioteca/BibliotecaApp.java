package com.twu.biblioteca;

import java.util.ArrayList;

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
        System.out.println("List of Books");
    }

    public void mainMenu() {
    }
}

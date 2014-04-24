package com.twu.biblioteca;
import java.util.Scanner;
import javax.xml.soap.SOAPPart;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class BibliotecaApp {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.getWelcomeMessage();
        bibliotecaApp.setup();
        bibliotecaApp.mainMenu();
        bibliotecaApp.getListOfBooks();


    }

    private void setup() {
        Book book1 = new Book("Running with the Giants", "John Maxwell");
        Book book2 = new Book("Developing the leader within You", "John Maxwell");

        addBook(book1);
        addBook(book2);
    }

    public void addBook(Book book){
        listOfBooks.add(book);
    }
    public Book getBook(int index){
        return listOfBooks.get(index - 1);
    }

    public void getWelcomeMessage() {
        System.out.println("Welcome to the Bangalore Biblioteca");
    }

    public void getListOfBooks() {
        int index = 1;
        for (Book book: listOfBooks){
            System.out.println( book.getTitle() + " by " + book.getAuthor());
            index ++;
        }
    }

    public void showMenu() {
        System.out.println("Main Menu: ");
        System.out.println("1. View all Books");
        System.out.println("2. Checkout a Book");
        System.out.println("3. Return a Book");
        System.out.println("Quit");
        System.out.println("Select an option");
    }

    public void mainMenu(){
        String option;

        do {
            showMenu();
            option = getMenuOption();
            selectMenu(option);
        } while (!option.equals("Quit"));
    }

    private String getMenuOption(){
        Scanner in = new Scanner(System.in);
        return in.next().toLowerCase();
    }

    public void selectMenu(String option) {
        if (option.equals("1")) {// List all books the library has
            getListOfBooks();

        } if (option.equals("2")) {// Reserve a book
            System.out.print("Which book would you like to checkout? ");
            int bookNumber = getNumberInput();
            checkoutBook(bookNumber);

        } if (option.equals("Quit")) {// Quit
            System.out.println("Quit");
        } else{
            System.out.print("Select a valid option!!");
        }
    }



    private int getNumberInput(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }



    public void checkoutBook(int bookNumber) {
        Book book = null;

        if (bookNumber <= 0 || bookNumber > listOfBooks.size()) {
            System.out.println("Book number not found.");
            return;
        }

        book = getBook(bookNumber);
        if (book.isAvailableBook()) {
            book.setAvailableBook(false);
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available");
        }
    }

    public String returnItem(String name, String author) {
        String bookName = name + "by "+ author;
        if (bookName.equals("\"Running with the Giants by John Maxwell\"")){
            System.out.print("Thank you for returning the book.");
        } if (bookName.equals("Developing the leader within You by John Maxwell")){
            System.out.print("Thank you for returning the book.");
        }
        else System.out.print(("Thank you for returning the book."));

        return bookName;
    }
}

package com.twu.biblioteca;
import java.util.Scanner;
import javax.xml.soap.SOAPPart;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class BibliotecaApp {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private User currentUser;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.getWelcomeMessage();
        bibliotecaApp.setup();
        bibliotecaApp.mainMenu();
        bibliotecaApp.getListOfBooks();


    }

    public void start() {
        setup();
        getWelcomeMessage();
        mainMenu();
    }

    private void setup() {
        Book book1 = new Book("Running with the Giants", "John Maxwell");
        Book book2 = new Book("Developing the leader within You", "John Maxwell");

        addBook(book1);
        addBook(book2);

        addMovie(new Movie("Shrek", "Andrew Adamson", 0));

        new User("Gaby", "1234", "email", "124343");
        new User("Keith", "12345", "email1", "123124124");
        new User("Eva", "123456", "email", "31343434");
    }

    public void addBook(Book book){
        listOfBooks.add(book);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void showMenu() {
        System.out.println("Main Menu: ");
        System.out.println("1. View all Books");
        System.out.println("2. Checkout a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. View all movies");
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

        } if (option.equals("4")){
            showAllMovies();
        } if (option.equals("Quit")) {// Quit
            System.out.println("Quit");
        } else{
            System.out.print("Select a valid option!!");
        }
    }

    public void showAllMovies(){
        int index = 1;
        for (Movie movie : movies) {
            System.out.print(index + "; " + movie.getTitle() + " | " + movie.getDirector());
            if (movie.getRating() < 1){
                System.out.println("N/A");
            }else{
                System.out.println(movie.getRating());
                index++;
            }
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

    public void checkoutMovie(String movieName) {
//addMovie(new Movie("Shrek", "Andrew Adamson", 0));
        if (movies.contains(movieName)){

            System.out.print("Thank you! Enjoy the movie");
        } else {
            System.out.print("That movie is not available");
        }
    }

    public void checkLibraryNumber() {
        if (UserLoggedIn()){
            System.out.println("Your library number is " + getCurrentUser().getLibraryNumber());
        } else{
            System.out.println("Please talk to Librarian. Thank you");
        }

    }

    public void login(String userName, String password) {
        currentUser = User.authenticate(userName, password);
        if (!UserLoggedIn()){
            System.out.print("Invalid username or password");
        }
    }

    private boolean UserLoggedIn(){
        return !(currentUser == null);
    }



}

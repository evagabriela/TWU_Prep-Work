package com.twu.biblioteca;


import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.*;


public class BibliotecaAppTests {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    BibliotecaApp bibliotecaApp;
//    private ByteArrayInputStream in;

    @Before
    public void setUp() throws Exception {
     System.setOut(new PrintStream(out));
     bibliotecaApp = new BibliotecaApp();

        Book book = new Book("Running with the Giants" ,"John Maxwell");
        bibliotecaApp.addBook(book);

        bibliotecaApp.addMovie(new Movie("Shrek", "Andrew Adamson"));

    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void ShouldWelcomeWhenStartApplication() throws Exception {
        bibliotecaApp.getWelcomeMessage();
        assertThat(out.toString(), containsString("Welcome to the Bangalore Biblioteca"));
    }

    @Test
    public void ShouldListBooks(){
        bibliotecaApp.getListOfBooks();
        assertThat(out.toString(), containsString("Running with the Giants by John Maxwell"));
    }

    @Test
    public void ShouldShowMenu(){
        bibliotecaApp.showMenu();
        assertThat(out.toString(), containsString("Main Menu: "));
    }

    @Test
    public void ShouldSelectFromMenu(){
        bibliotecaApp.selectMenu("invalid");
        assertThat(out.toString(),containsString("Select a valid option!"));
    }

    @Test
    public void ShouldRespondToQuit(){
        bibliotecaApp.selectMenu("Quit");
        assertThat(out.toString(),containsString("Quit"));
    }


    @Test
    public void ShouldConfirmCheckoutBook(){

       Book book = bibliotecaApp.getBook(1);

        assertEquals(true, book.isAvailableBook());

        bibliotecaApp.checkoutBook(1);
        assertEquals(false, book.isAvailableBook());
        assertThat(out.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void ShouldBeNotifyIfUnsuccessfulCheckout(){
        bibliotecaApp.checkoutBook(1);
        bibliotecaApp.checkoutBook(1);
        assertThat(out.toString(), containsString("That book is not available"));
    }


    @Test
    public void ShouldReturnBook(){
        bibliotecaApp.returnItem("Developing the leader within You", "John Maxwell");
        assertThat(out.toString(), containsString("Thank you for returning the book."));
    }


    @Test
    public void ShouldBeNotifyIfUnsuccesfulReturn(){
        bibliotecaApp.returnItem("Invalid Name", "Invalid author");
        assertThat(out.toString(), containsString("Thank you for returning the book."));
    }


//    List Movies - see a list of available movies. Movies have a name, year, director and movie rating (from 1-10 or unrated).
    @Test
    public void showAllMovies(){
        bibliotecaApp.showAllMovies();
        assertThat(out.toString(), containsString("Shrek"));
        assertThat(out.toString(), containsString("Andrew Adamson"));
    }

//    Check-out Movie -  check out a movie from the library.
    @Test
    public void ShouldConfirmCheckoutMovie(){

        bibliotecaApp.checkoutMovie("Invalid Movie");
        assertThat(out.toString(), containsString("That movie is not available"));
    }
//      User Accounts - Login: As a librarian, I want to know who has checked out a book.
//          Users must now login using their library number (which is in the format xxx-xxxx)
//          and a password in order to check-out and return books.
//          User credentials are predefined, so registering new users is not part of this story.
    @Test
    public void login(){
        User gaby = new User("Gaby", "12345", "email", "1234133");

        bibliotecaApp.login("Gaby", "12345");

        assert gaby == bibliotecaApp.getCurrentUser();
    }

    @Test
    public void ShouldCheckLibraryNumber(){
        User gaby = new User("Gaby","12345", "email", "123455" );
        bibliotecaApp.login("gaby", "wrong_password");

        assertEquals(null, bibliotecaApp.getCurrentUser());
        assertThat(out.toString(), containsString("Invalid username or password"));
    }

    @Test
    public void CheckLibraryNumber() {
        bibliotecaApp.checkLibraryNumber();
        assertThat(out.toString(), containsString("Please talk to Librarian. Thank you"));

    }

//    User Accounts - User information - As a customer, I want to be able to see my user information
// (name, email address and phone number), so that I know that the library can contact me.
// This option should only be available when the customer is logged in and should only display that customer’s information.

    @Test
    public void CheckUserEmail(){
        User gaby = new User("Gaby", "12345", "gaby@email", "1234133");
        String email = gaby.getEmail();

        assertEquals(gaby.getEmail(), "gaby@email");

    }




}




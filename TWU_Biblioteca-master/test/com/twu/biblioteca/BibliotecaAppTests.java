package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.*;
import java.util.ArrayList;


public class BibliotecaAppTests {
    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayInputStream in;

    @Before
    public void setUp() throws Exception {
     System.setOut(new PrintStream(out));
     bibliotecaApp = new BibliotecaApp();
    }

    public void tearDown() throws Exception {
        System.setOut(null);
    }

//    Welcome Message
    @Test
    public void ShouldWelcomeWhenStartApplication() throws Exception {
        bibliotecaApp.getWelcomeMessage();
        assertThat(out.toString(), containsString("Welcome to the Biblioteca"));
    }

//    List Books
    @Test
    public void ShouldListBooks(){
        ArrayList expectedList = new ArrayList<String>();
        expectedList.add("Book 1");
        expectedList.add("Book 2");

        ArrayList listBooks = bibliotecaApp.getListOfBooks();
        assertThat(listBooks, is(expectedList));
    }

//    Main Menu
    //    A customer  should see a list of options and be able to choose one
    @Test
    public void ShouldListOptions(){
        bibliotecaApp.showMenu();

        assertThat(out.toString(), containsString("Menu"));
    }

//    Invalid Menu Option
    @Test
    public void ShouldSelectFromMenu(){
        bibliotecaApp.selectMenu("invalid");
        assertThat(out.toString(),containsString("Select a valid option!"));
    }

//    Quit
    @Test
    public void ShouldRespondToQuit(){
        bibliotecaApp.selectMenu("Quit");
        assertThat(out.toString(),containsString("Quit"));
    }

//    1.Checkout Book
//As a librarian, I would like customers to be able to check-out a book. Checked out books should not appear in the list of all library books.
//    ------------------------------------------
//    2.Successful Checkout
//    As a customer, I would like to know that a book has been checked out by seeing the message “Thank you! Enjoy the book”.
    @Test
    public void ShouldConfirmCheckoutBook(){
        bibliotecaApp.checkoutBook("Book 1");
        assertThat(out.toString(),containsString("Thank you! Enjoy the book"));
    }

//    Unsuccessful Checkout
//    be notified if the book I tried to check-out is not available by seeing the message, “That book is not available.”
    @Test
    public void ShouldBeNotifyIfUnsuccessfulCheckout(){
        bibliotecaApp.checkoutBook("InvalidBook");
        assertThat(out.toString(), containsString("“That book is not available.”"));
    }

}




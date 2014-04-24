package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.*;
import java.util.ArrayList;


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


}




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

    @Test
    public void ShouldWelcomeWhenStartApplication() throws Exception {
        bibliotecaApp.getWelcomeMessage();
        assertThat(out.toString(), containsString("Welcome to the Biblioteca"));
    }

    @Test
    public void ShouldListBooks(){
        ArrayList expectedList = new ArrayList<String>();
        expectedList.add("Book 1");
        expectedList.add("Book 2");

        ArrayList listBooks = bibliotecaApp.getListOfBooks();
        assertThat(listBooks, is(expectedList));
    }

    @Test
    public void ShouldListOptions(){
        bibliotecaApp.showMenu();

        assertThat(out.toString(), containsString("Menu"));
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
        bibliotecaApp.checkoutBook("Book 1");

        assertThat(out.toString(),containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void ShouldBeNotifyIfUnsuccessfulCheckout(){
        bibliotecaApp.checkoutBook("Invalid");
        assertThat(out.toString(), containsString("That book is not available"));
    }


    @Test
    public void ShouldReturnBook(){
        bibliotecaApp.returnItem("Book 3");
        assertThat(out.toString(), containsString("Thank you for returning the book."));
    }


    @Test
    public void ShouldBeNotifyIfUnsuccesfulReturn(){
        bibliotecaApp.returnItem("Invalid Book");
        assertThat(out.toString(), containsString("That is not a valid boot to return"));
    }




}




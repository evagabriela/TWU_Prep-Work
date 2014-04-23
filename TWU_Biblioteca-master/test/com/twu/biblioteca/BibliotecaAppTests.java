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

        ArrayList listBooks = bibliotecaApp.getListOfBooks();
        assertThat(listBooks, is(expectedList));
    }

//    Main Menu
//    A customer  should see a list of options and be able to choose one
    @Test
    public void ShouldListOptions(){
        bibliotecaApp.showMenu();

        assertThat(out.toString(), containsString("List Books"));
    }


}


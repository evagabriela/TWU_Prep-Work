package com.twu.biblioteca;


import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.*;


public class BibliotecaAppTests {
    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();


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
        System.setOut(new PrintStream(out));
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.getWelcomeMessage();
        assertThat(out.toString(), containsString("Welcome to the Biblioteca"));
    }
}

package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.*;

public class BibliotecaAppTests {
    private BibliotecaApp bibliotecaApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void setUp() throws Exception {
     System.setOut(new PrintStream(outContent));
    }

    public void tearDown() throws Exception {
     System.setOut(null);
    }

//    Welcome Message
    @Test
    public void ShouldWelcomeWhenStartApplication() {
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.getWelcomeMessage();
        assertEquals("Welcome to the Biblioteca", outContent.toString());
    }
}

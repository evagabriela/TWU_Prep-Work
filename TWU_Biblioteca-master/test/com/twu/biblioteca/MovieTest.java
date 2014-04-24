package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by evazamudio on 2014-04-24.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
    movie = new Movie("The Godfather", "Francis Ford Coppola");
     }

    @Test
    public void createMovieWithoutRating() {
    assertEquals(0, movie.getRating());
    }

    @Test
    public void setInvalidRating() {
        movie.setRating(-1);
        assertEquals(0, movie.getRating());
    }

}

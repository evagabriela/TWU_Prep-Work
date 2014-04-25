package com.twu.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by evazamudio on 2014-04-25.
 */
public class UserTest {
    private User user;
    @Before
    public void createTestUser() {
        user = new User("eva", "12345");
    }

    @After
    public void cleanUp() {
        User.cleanUp();
    }

    @Test
    public void testLibraryNumber() {
        User new_user = new User("joseph", "1234");
        assertEquals("111-1111", user.getLibraryNumber());
        assertEquals("111-1112", new_user.getLibraryNumber());
    }

    @Test
    public void authenticateUser() {
        User eva = User.authenticate("eva", "12345");
        assert user == eva;
    }

    @Test
    public void authenticateUserFail() {
        User eva = User.authenticate("john", "wrong password");
        assertEquals(null, eva);
    }
}

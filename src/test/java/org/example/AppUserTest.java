package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    //Testing construtor with no null and overridden toString
    @Test
    void AppUserTestAllGoodTest(){
        AppUser user = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
        assertEquals(user.toString(), "Username: Jari, role: ROLE_APP_ADMIN");
    }

    //Testing constructor with null username
    @Test
    void AppUserTestNullUserName(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            AppUser user = new AppUser(null, "12345", AppRole.ROLE_APP_ADMIN);
        });
    }

    //Testing constructor with empty username
    @Test
    void AppUserTestEmptyUserName(){
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
           AppUser user = new AppUser("", "12345", AppRole.ROLE_APP_USER);
        });
    }

    //Testing overridden hashcode
    @Test
    void hashCodeTestDifferentPassword(){
        AppUser user1 = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("Jari", "678910", AppRole.ROLE_APP_ADMIN);
        assertEquals(user1.hashCode(), user2.hashCode());
    }
    @Test
    void hashCodeTestDifferentRole(){
        AppUser user1 = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("Jari", "12345", AppRole.ROLE_APP_USER);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    //Testing overridden equals
    @Test
    void equalsTestTrueDifferentPassword(){
        AppUser user1 = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("Jari", "678910", AppRole.ROLE_APP_ADMIN);
        assertEquals(user1, user2);
    }
    @Test
    void eualsTestFalseDifferentRole(){
        AppUser user1 = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("Jari", "12345", AppRole.ROLE_APP_USER);
        assertNotEquals(user1, user2);
    }
}

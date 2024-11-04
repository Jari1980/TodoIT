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

    //Testing ok, null and empty setters
    AppUser user = new AppUser("Jari", "12345", AppRole.ROLE_APP_ADMIN);
    @Test
    void setUsernameOk(){
        user.setUsername("Jari Testar");
        assertEquals(user.getUsername(), "Jari Testar");
    }
    @Test
    void setUsernameNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            user.setUsername(null);
        });
    }
    @Test
    void setUsernameEmpty(){
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            user.setUsername("");
        });
    }

    @Test
    void setPasswordOk(){
        user.setPassword("11111");
        assertEquals(user.getPassword(), "11111");
    }
    @Test
    void setPasswordNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            user.setPassword(null);
        });
    }
    @Test
    void setPasswordEmpty(){
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            user.setPassword("");
        });
    }

    @Test
    void setRoleOk(){
        user.setRole(AppRole.ROLE_APP_USER);
        assertEquals(user.getRole(), AppRole.ROLE_APP_USER);
    }
    @Test
    void setRoleNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            user.setRole(null);
        });
    }
}

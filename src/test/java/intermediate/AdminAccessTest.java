package intermediate;

import entity.Administrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminAccessTest {

    private AdminAccess adminAccess;

    @BeforeEach
    void setUp() {

    }

    @Test
    void verify() {
        Administrator admin = new Administrator();
        admin.setLogin("stefy");
        admin.setPassword("0000");
        adminAccess = new AdminAccess(admin);

        Boolean rs = adminAccess.verify();
        assertTrue(rs);
    }

    @Test
    void verifyUserNotAdmin() {
        Administrator admin = new Administrator();
        admin.setLogin("utente");
        admin.setPassword("pincopallino");
        adminAccess = new AdminAccess(admin);

        Boolean rs = adminAccess.verify();
        assertTrue(rs);
    }
}
package interfacce;

import utils.TestUtils;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class AutenticationTest {

    private Autentication autentication;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        autentication = new Autentication();
    }

    @org.junit.jupiter.api.Test
    void jbInit() {
        assertNotNull(autentication.getCon());
    }

    @org.junit.jupiter.api.Test
    void creaPannello() {
        autentication.creaPannello();
        JPanel pannello = autentication.getPannello();

        assertNotNull(pannello);
        JTextField login = (JTextField) TestUtils.getChildName(pannello, "login");
        assertNotNull(login);
        login.setText("message");
        System.out.println(login.getText());
        login.postActionEvent();

        System.out.println(login.getText());
    }

    @org.junit.jupiter.api.Test
    void buttonCreate() {
    }

    @org.junit.jupiter.api.Test
    void button() {
    }
}
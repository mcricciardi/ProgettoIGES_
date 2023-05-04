package com.m2fas_webapp.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RegisterServletTest {
    RegisterServlet registerServlet = new RegisterServlet();

    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("http://localhost:9080/m2fas_webapp/");

        registerServlet.linkLogin.click();
        registerServlet.linkRegistrati.click();

    }
    @Test
    public void registerUsernameLength(){
        registerServlet.inputUsername.setValue("A");
        registerServlet.inputEmail.setValue("A@gmail");
        registerServlet.inputPassword.setValue("0");
        registerServlet.inputRole.setValue("User");
        registerServlet.buttonRegister.click();
        registerServlet.error.shouldHave(text("Username deve avere almeno 2 caratteri"));

    }
    @Test
    public void registerEmailLength(){
        registerServlet.inputUsername.setValue("Aaa");
        registerServlet.inputEmail.setValue("A@gmail");
        registerServlet.inputPassword.setValue("0");
        registerServlet.inputRole.setValue("User");
        registerServlet.buttonRegister.click();
        registerServlet.error.shouldHave(text("Email deve avere almeno 10 caratteri"));
    }
    @Test
    public void registerEmailIsExist(){
        registerServlet.inputUsername.setValue("Aaa");
        registerServlet.inputEmail.setValue("elleoneit@gmail.com");
        registerServlet.inputPassword.setValue("12345678");
        registerServlet.inputRole.setValue("User");
        registerServlet.buttonRegister.click();
        registerServlet.error.shouldHave(text("Email già è presente nel database"));
    }
    @Test
    public void registerPasswordLength(){
        registerServlet.inputUsername.setValue("Aaa");
        registerServlet.inputEmail.setValue("elleoneit@gmail.com");
        registerServlet.inputPassword.setValue("0");
        registerServlet.inputRole.setValue("User");
        registerServlet.buttonRegister.click();
        registerServlet.error.shouldHave(text("Password deve avere almeno 8 caratteri"));
    }
    @Test
    public void register(){
        registerServlet.inputUsername.setValue("Elleone");
        registerServlet.inputEmail.setValue("cris@gmail.com");
        registerServlet.inputPassword.setValue("12345678");
        registerServlet.inputRole.setValue("User");
        registerServlet.buttonRegister.click();
        registerServlet.error.shouldHave(text("Utente inserito con successo"));
    }
}

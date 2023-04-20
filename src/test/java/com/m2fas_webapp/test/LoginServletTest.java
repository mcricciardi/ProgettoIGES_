package com.m2fas_webapp.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class LoginServletTest {
    LoginServlet loginServlet = new LoginServlet();




    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("http://localhost:9080/m2fas_webapp/");
    }

    @Test
    public void login(){
        loginServlet.linkLogin.click();

        loginServlet.inputEmail.sendKeys("elleone@yahoo.com");
        loginServlet.inputPassword.sendKeys("0");
        loginServlet.buttonLogin.click();
        loginServlet.divLoginEmail.should(disappear);
        }

    @Test
    public void loginEmailError(){
        loginServlet.linkLogin.click();

        loginServlet.inputEmail.sendKeys("elleone@yahoo");
        loginServlet.inputPassword.sendKeys("0");
        loginServlet.buttonLogin.click();
        loginServlet.divError.shouldHave(text("Dati non validi"));

    }
    @Test
    public void loginPasswordError(){
        loginServlet.linkLogin.click();

        loginServlet.inputEmail.sendKeys("elleone@yahoo.com");
        loginServlet.inputPassword.sendKeys("2");
        loginServlet.buttonLogin.click();
        loginServlet.divError.shouldHave(text("Dati non validi"));

    }
}

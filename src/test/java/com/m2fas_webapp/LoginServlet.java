package com.m2fas_webapp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginServlet {

    @FindBy(xpath = "//a[@href='/m2fas_webapp/login?action=login']")
    public WebElement linkLogin = $x("//a[@href='/m2fas_webapp/login?action=login']");

    @FindBy(xpath = "//a[@href='index.jsp']")
    public WebElement linkHome = $x("//a[@href='index.jsp']");

   
    @FindBy(name = "email")
    public WebElement inputEmail = $(By.name("email"));

    @FindBy(name = "password")
    public WebElement inputPassword = $(By.name("password"));

    @FindBy(css = "div.form-box.login")
    public SelenideElement divLoginEmail = $("div.form-box.login");

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement buttonLogin = $x("//button[@class='btn']");

}

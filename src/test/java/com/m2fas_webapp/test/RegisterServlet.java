package com.m2fas_webapp.test;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterServlet {
   
    @FindBy(xpath = "//a[@class='register-link']")
    public WebElement linkRegistrati = $x("//a[@class='register-link']");

    @FindBy(xpath = "//a[@href='/m2fas_webapp/login?action=login']")
    public WebElement linkLogin = $x("//a[@href='/m2fas_webapp/login?action=login']");

    @FindBy(css = "input[name='username']")
    public SelenideElement inputUsername = $("input[name='username']");



    @FindBy(css = "div[class='error'] span")
    public SelenideElement error = $("div[class='error'] span");

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement buttonRegister = $x("//button[@class='btn']");

    @FindBy(css = "input[name='email']")
    public SelenideElement inputEmail = $("input[name='email']");

    @FindBy(css = "input[name='password']")
    public SelenideElement inputPassword = $("input[name='password']");

    @FindBy(css = "input[list='role']")
    public SelenideElement inputRole = $("input[list='role']");

    
}

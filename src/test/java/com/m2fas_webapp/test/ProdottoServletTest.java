package com.m2fas_webapp.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class ProdottoServletTest {

    ProdottoServlet prodottoServlet = new ProdottoServlet();

    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("http://localhost:9080/m2fas_webapp/");

        prodottoServlet.linkProdotto.click();
    }

    @Test
    public void searchErrorProdottoTest(){
        prodottoServlet.linkCerca.click();
        prodottoServlet.inputProdotto.sendKeys("inputerrato");
        prodottoServlet.buttonInvio.click();
        prodottoServlet.divError.shouldHave(Condition.text("ID non è stato inserito, riprovare"));
    }
    @Test
    public void searchPrdottoTest(){
        prodottoServlet.linkCerca.click();
        prodottoServlet.inputProdotto.sendKeys("2");
        prodottoServlet.buttonInvio.click();

        String url = "http://localhost:9080/m2fas_webapp/prodotto";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
    }

    @Test
    public void insertNewProdottoTest(){
        prodottoServlet.linkGestione.click();
        prodottoServlet.inputProdotto.sendKeys("10");
        prodottoServlet.inputCategoriaProdotto.sendKeys("Sport");
        prodottoServlet.inputMarcaProdotto.sendKeys("Nike");
        prodottoServlet.inputModelloProdotto.sendKeys("Scarpe");
        prodottoServlet.inputPrezzoProdotto.sendKeys("100");
        prodottoServlet.inputProdottoQta.sendKeys("10");
        prodottoServlet.buttonGestioneProdottoInserisci.click();
        prodottoServlet.divError.shouldHave(Condition.text("Prodotto inserito con successo"));
    }
    @Test
    public void updateProdottoTest(){
        prodottoServlet.linkGestione.click();
        prodottoServlet.inputProdotto.sendKeys("10");
        prodottoServlet.inputCategoriaProdotto.sendKeys("Sport");
        prodottoServlet.inputMarcaProdotto.sendKeys("Nike");
        prodottoServlet.inputModelloProdotto.sendKeys("Scarpe");
        prodottoServlet.inputPrezzoProdotto.sendKeys("1000");
        prodottoServlet.inputProdottoQta.sendKeys("100");
        prodottoServlet.buttonGestioneProdottoAggiorna.click();
        prodottoServlet.divError.shouldHave(Condition.text("Prodotto aggiornato con successo"));
    }
    @Test
    public void removeProdottoTest(){
        prodottoServlet.linkGestione.click();
        prodottoServlet.inputProdotto.sendKeys("10");
        prodottoServlet.inputCategoriaProdotto.sendKeys("Sport");
        prodottoServlet.inputMarcaProdotto.sendKeys("Nike");
        prodottoServlet.inputModelloProdotto.sendKeys("Scarpe");
        prodottoServlet.inputPrezzoProdotto.sendKeys("100");
        prodottoServlet.inputProdottoQta.sendKeys("10");
        prodottoServlet.buttonGestioneProdottoCancella.click();
        prodottoServlet.divError.shouldHave(Condition.text("Prodotto 10 rimosso con successo"));
    }
}

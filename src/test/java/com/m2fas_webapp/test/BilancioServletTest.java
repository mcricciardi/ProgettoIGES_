package com.m2fas_webapp.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class BilancioServletTest {
    BilancioServlet bilancioServlet = new BilancioServlet();

    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("http://localhost:9080/m2fas_webapp/");

        bilancioServlet.buttonBilancio.click();

    }
    @Test
    public void inserisciSpeseImportoTest(){
        bilancioServlet.linkSpese.click();
        bilancioServlet.inputDataPagamenti.sendKeys("23/06/2023");
        bilancioServlet.inputImportoPagamenti.sendKeys("ok");
        bilancioServlet.inputNcontoPagamenti.sendKeys("2");
        bilancioServlet.inputDescPagamenti.sendKeys("...");
        bilancioServlet.buttonInserisciSpesaGestioneProdotto.click();
        bilancioServlet.divError.shouldHave(Condition.text("Importo spese non è un numero, riprovare"));
    }
    @Test
    public void inserisciSpeseContoTest(){
        bilancioServlet.linkSpese.click();
        bilancioServlet.inputDataPagamenti.sendKeys("23/06/2023");
        bilancioServlet.inputImportoPagamenti.sendKeys("200");
        bilancioServlet.inputNcontoPagamenti.sendKeys("OK");
        bilancioServlet.inputDescPagamenti.sendKeys("...");
        bilancioServlet.buttonInserisciSpesaGestioneProdotto.click();
        bilancioServlet.divError.shouldHave(Condition.text("Conto spese non è un numero, riprovare"));
    }
    @Test
    public void inserisciSpeseDataTest(){
        bilancioServlet.linkSpese.click();
        bilancioServlet.inputDataPagamenti.sendKeys("23/33/2023");
        bilancioServlet.inputImportoPagamenti.sendKeys("200");
        bilancioServlet.inputNcontoPagamenti.sendKeys("2");
        bilancioServlet.inputDescPagamenti.sendKeys("...");
        bilancioServlet.buttonInserisciSpesaGestioneProdotto.click();
        bilancioServlet.divError.shouldHave(Condition.text("23/33/2023 formato data non valido"));
    }
}

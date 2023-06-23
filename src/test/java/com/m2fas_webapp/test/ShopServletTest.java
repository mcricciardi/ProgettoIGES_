package com.m2fas_webapp.test;

import com.codeborne.selenide.*;
import entity.Product;
import intermediate.ProductManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class ShopServletTest {
    ShopServlet shopServlet = new ShopServlet();

    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("http://localhost:9080/m2fas_webapp/");

        shopServlet.buttonShop.click();
        shopServlet.linkShop.click();

    }

    @Test
    public void showListProductTest(){
        shopServlet.h2ListaProdotti.shouldHave(text("Lista prodotti"));
    }
    /* Verifica il numero degli elementi della pagina */
    @Test
    public void sizeListProductTest(){
        ArrayList<Product> products = new ProductManagement().getProducts();
        shopServlet.sizeElementsTableListaProdotti.shouldHave(size(products.size()));
    }

    @Test
    public void checkButtonCartTest(){
        String url = "http://localhost:9080/m2fas_webapp/shop?action=viewCart";
        shopServlet.linkCarrello.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
    }

    /* verifica che il prodotto scelto dall'utente venga messo nel carrello */
    @Test
    public void checkProductCartTest(){
        String marca = "Adidadas";
        String modello = "M";
        String categoria = "Scarpe";
        String id = "2";
        String prezzo = "200.0";
        List<String> lista = new ArrayList<>();


        shopServlet.linkAdidadas.click();
        lista = shopServlet.marca_prodotto.texts();
        Assertions.assertEquals(marca, lista.get(0));
        lista = shopServlet.id_prodotto.texts();
        Assertions.assertEquals(id, lista.get(0));
        lista = shopServlet.categoria_prodotto.texts();
        Assertions.assertEquals(categoria, lista.get(0));
        lista = shopServlet.modello_prodotto.texts();
        Assertions.assertEquals(modello, lista.get(0));
        lista = shopServlet.prezzo_prodotto.texts();
        Assertions.assertEquals(prezzo, lista.get(0));

    }

    @Test
    public void emptyCartTest(){
        shopServlet.linkAdidadas.click();
        shopServlet.linkEmptyCart.click();
        shopServlet.tableCarrello.shouldHave(empty);
    }
}

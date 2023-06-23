package com.m2fas_webapp.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class ShopServlet {
    public SelenideElement buttonShop = $x("/html/body/div[1]/div[4]/button");

    public SelenideElement linkShop = $x("//a[contains(@href, 'browse')]");

    public SelenideElement h2ListaProdotti = $("h2");

    public SelenideElement tableListaProdotti = $("#lista_prodotti");

    public ElementsCollection sizeElementsTableListaProdotti = $$("#lista_prodotti tbody tr.prodotto");

    public SelenideElement linkCarrello = $x("/html/body/div[2]/div/table/tbody/tr[10]/td/p/a");

    public SelenideElement linkAdidadas = $x("//a[@href='/m2fas_webapp/shop?action=addToCart&productId=2']");

    public ElementsCollection marca_prodotto = $$("#carrello tbody tr.product td[id='marca_product']");
    public ElementsCollection id_prodotto = $$("#carrello tbody tr.product td[id='id_product']");
    public ElementsCollection categoria_prodotto = $$("#carrello tbody tr.product td[id^='categoria']");
    public ElementsCollection modello_prodotto = $$("#carrello tbody tr.product td[id^='modello']");
    public ElementsCollection prezzo_prodotto = $$("#carrello tbody tr.product td[id^='prezzo']");

    public SelenideElement linkEmptyCart = $x("//a[contains(@href, 'empty')]");
    public ElementsCollection tableCarrello = $$("#carrello tbody tr.product ");



 


    
}

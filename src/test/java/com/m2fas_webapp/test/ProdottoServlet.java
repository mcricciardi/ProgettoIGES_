package com.m2fas_webapp.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProdottoServlet {
    public SelenideElement linkProdotto = $x("//a[@class='dropbtn']");

    public SelenideElement linkCerca = $x("//a[@href='/m2fas_webapp/prodotto?action=search']");

    public SelenideElement linkGestione = $x("//a[@href='/m2fas_webapp/prodotto?action=gestione']");

    public SelenideElement inputProdotto = $("input[name='id_prodotto']");

    public SelenideElement buttonInvio = $x("//button[@class='btn']");

    public SelenideElement divError = $("div[class='error']");

    public SelenideElement inputProdotto2 = $("input[name='id_prodotto']");

    public SelenideElement inputMarcaProdotto = $("input[name='marca_prodotto']");

    public SelenideElement inputModelloProdotto = $("input[name='modello_prodotto']");

    public SelenideElement inputCategoriaProdotto = $("input[name='categoria_prodotto']");

    public SelenideElement inputPrezzoProdotto = $("input[name='prezzo_prodotto']");

    public SelenideElement inputProdottoQta = $("input[name='qta_prodotto']");

    public SelenideElement buttonGestioneProdottoInserisci = $x("//button[@value='inserisci']");

    public SelenideElement buttonGestioneProdottoCancella = $x("//button[@value='cancella']");

    public SelenideElement buttonGestioneProdottoAggiorna = $x("//button[@value='aggiorna']");



   
    
    
}

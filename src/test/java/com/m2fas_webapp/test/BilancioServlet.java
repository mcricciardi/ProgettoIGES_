package com.m2fas_webapp.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BilancioServlet {
    public SelenideElement buttonBilancio = $x("/html/body/div[1]/div[3]/button");

    public SelenideElement linkPagamenti = $x("//a[contains(@href, 'pagamenti')]");

    public SelenideElement linkSpese = $x("//a[contains(@href, 'spese')]");

    public SelenideElement linkStampa = $x("//a[contains(@href, 'stampa')]");

    public SelenideElement inputPagamenti = $("input[name='id_pagamenti']");

    public SelenideElement inputImportoPagamenti = $("input[name='importo_pagamenti']");

    public SelenideElement inputDebitoPagamenti = $("input[name='debito_pagamenti']");

    public SelenideElement buttonGestioneProdottoInserisci = $x("//button[@type='submit']");

    public SelenideElement inputDataPagamenti = $("input[name='data_pagamenti']");

    public SelenideElement inputInserisciSpesaImportoPagamenti2 = $("input[name='importo_pagamenti']");

    public SelenideElement inputNcontoPagamenti = $("input[name='nconto_pagamenti']");

    public SelenideElement inputDescPagamenti = $("input[name='desc_pagamenti']");

    public SelenideElement buttonInserisciSpesaGestioneProdotto = $x("//button[@type='submit']");

    public SelenideElement divError = $("div[class='error']");


   
}

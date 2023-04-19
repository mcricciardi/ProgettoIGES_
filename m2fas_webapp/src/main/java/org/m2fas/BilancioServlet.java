package org.m2fas;

import entity.Expense;
import intermediate.EntrancesManagement;
import intermediate.ExitsManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@WebServlet(
        name = "bilancioServelet",
        urlPatterns = {"/bilancio"},
        loadOnStartup = 1
)
public class BilancioServlet extends HttpServlet {
    CheckUtils cu = new CheckUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null)
            action = "search";

        switch (action){
            case "pagamenti":
                this.pagamentiBilancio(req, resp);
                break;
            case "spese":
                this.inserireSpese(req, resp);
                break;
            case "stampa":
                this.viewBilancio(req, resp);
                break;
        }
    }

    private void viewBilancio(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/bilancio/stampa.jsp").forward(req, resp);
    }

    private void inserireSpese(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/bilancio/spese.jsp").forward(req, resp);
    }

    private void pagamentiBilancio(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/bilancio/pagamenti.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {
                case "inserisci":
                    this.insertSpesa(request, response);
                    break;
                case "cerca_bilancio":
                    this.stampaBilancio(request, response);
                    break;
            }

        }
    }

    private void stampaBilancio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String da_date = request.getParameter("da_date_stampa");
        String[] ar_da_date = da_date.split("-");
        String a_date = request.getParameter("a_date_stampa");
        String[] ar_a_date = a_date.split("-");
        String[] period = { ar_da_date[2], ar_da_date[1], ar_da_date[0],
                            ar_a_date[2], ar_a_date[1], ar_a_date[0]
                          };
        ArrayList elenco_spese = new ExitsManagement().getExit(period);
        ArrayList elenco_entrate = new EntrancesManagement().getEntrance(period);
        request.setAttribute("elenco_spese", elenco_spese);
        request.setAttribute("elenco_entrate", elenco_entrate);
        request.getRequestDispatcher("/WEB-INF/jsp/view/bilancio/viewBilancio.jsp").forward(request, response);

    }

    private void insertSpesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data_pagamenti = request.getParameter("data_pagamenti");
        if(!cu.isValidFormat("dd/MM/yyyy", data_pagamenti, Locale.ITALY)){
            request.setAttribute("error",  data_pagamenti + MSG.NOT_DATE.getName());
            this.inserireSpese(request, response);
        }
        String importo_pagamenti = request.getParameter("importo_pagamenti");
        if(!cu.isNumeric(importo_pagamenti)){
            request.setAttribute("error", "Importo spese"+MSG.NOT_NUMBER.getName() );
            this.inserireSpese(request, response);
        }
        String nconto_pagamenti = request.getParameter("nconto_pagamenti");
        if(!cu.isNumeric(nconto_pagamenti)){
            request.setAttribute("error", "Conto spese"+MSG.NOT_NUMBER.getName() );
            this.inserireSpese(request, response);
        }
        String desc_pagamenti = request.getParameter("desc_pagamenti");
        if(cu.isEmpty(desc_pagamenti)){
            request.setAttribute("error", "Descrizione"+MSG.UNKNOW.getName());
            this.inserireSpese(request, response);
        }
        ExitsManagement exitsManagement = new ExitsManagement();
        Expense expense = new Expense();
        expense.setDesc(desc_pagamenti);
        expense.setCount(nconto_pagamenti);
        expense.setAmount(importo_pagamenti);
        String[] ar_date = data_pagamenti.split("/");
        expense.setDay(ar_date[0]);
        expense.setMonth(ar_date[1]);
        expense.setYear(ar_date[2]);
        if(exitsManagement.addExit(expense)){
            request.setAttribute("error", "Spesa" + MSG.OK_INSERT.getName());
            this.inserireSpese(request, response);
        }
    }
}

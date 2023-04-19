package org.m2fas;

import entity.Product;
import entity.Supplies;
import intermediate.ProductManagement;
import intermediate.SuppliesManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(
        name = "fornitoreServlet",
        urlPatterns = {"/fornitore"},
        loadOnStartup = 1
)
public class FornitoreServlet extends HttpServlet {
    CheckUtils cu = new CheckUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null)
            action = "search";

        switch (action){
            case "search":
                this.searchFornitore(req, resp);
                break;
            case "gestione":
                this.gestioneFornitore(req, resp);
                break;
        }
    }

    private void gestioneFornitore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/fornitore/gestioneFornitore.jsp").forward(req, resp);
    }

    private void searchFornitore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/fornitore/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {

            switch (action) {
                case "view":
                    this.viewFornitore(request, response);
                    break;
                case "inserisci":
                    this.insertFornitore(request, response);
                    break;
                case "cancella":
                    this.deleteFornitore(request, response);
                    break;
                case "aggiorna":
                    this.updateFornitore(request, response);
                    break;
            }

        }
    }

    private void updateFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id_fornitore");
        if(cu.isEmpty(idString)) {
            request.setAttribute("error", "ID"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }

        String nome_fornitore = request.getParameter("nome_fornitore");
        if(cu.isEmpty(nome_fornitore)){
            request.setAttribute("error", "Nome Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String cognome_fornitore = request.getParameter("cognome_fornitore");
        if(cu.isEmpty(cognome_fornitore)){
            request.setAttribute("error", "Cognome Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String telefono_fornitore = request.getParameter("telefono_fornitore");
        if(cu.isEmpty(telefono_fornitore)){
            request.setAttribute("error", "Telefono Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String fax_fornitore = request.getParameter("telefono_fornitore");
        if(cu.isEmpty(fax_fornitore)){
            request.setAttribute("error", "Fax Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String indirizzo_fornitore = request.getParameter("indirizzo_fornitore");
        if(cu.isEmpty(indirizzo_fornitore)){
            request.setAttribute("error", "Indirizzo Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String debito_fornitore = request.getParameter("debito_fornitore");
        if(!cu.isNumeric(debito_fornitore)){
            request.setAttribute("error", "Debito Fornitore"+MSG.NOT_NUMBER.getName() );
            this.gestioneFornitore(request, response);
        }
        String pagato_fornitore = request.getParameter("pagato_fornitore");
        if(!cu.isNumeric(pagato_fornitore)){
            request.setAttribute("error", "Pagato Fornitore"+MSG.NOT_NUMBER.getName() );
            this.gestioneFornitore(request, response);
        }

        Supplies supplies = new Supplies();
        supplies.setPiva(Integer.parseInt(idString));
        supplies.setNome(nome_fornitore);
        supplies.setCognome(cognome_fornitore);
        supplies.setTel(telefono_fornitore);
        supplies.setFax(fax_fornitore);
        supplies.setIndirizzo(indirizzo_fornitore);
        supplies.setDebito(Double.parseDouble(debito_fornitore));
        supplies.setPagato(Double.parseDouble(pagato_fornitore));
        SuppliesManagement suppliesManagement = new SuppliesManagement(supplies.getPiva());
        if(suppliesManagement.updateSupplies(supplies)) {
            request.setAttribute("error", "Fornitore" + MSG.OK_UPDATE.getName());
            this.gestioneFornitore(request, response);
        }
    }

    private void deleteFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id_fornitore");
        SuppliesManagement suppliesManagement = new SuppliesManagement(Integer.parseInt(idString));
        Supplies supplies = new Supplies();
        supplies.setPiva(Integer.parseInt(idString));
        if(suppliesManagement.removeSupplies(supplies)){
            request.setAttribute("error", "Fornitore "+idString + MSG.OK_REMOVE.getName());
            this.gestioneFornitore(request, response);
        }else {
            request.setAttribute("error",  MSG.WARNING.getName());
            this.gestioneFornitore(request, response);
        }
    }

    private void insertFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id_fornitore");
        if(cu.isEmpty(idString)) {
            request.setAttribute("error", "ID"+MSG.UNKNOW.getName());
            this.
                    gestioneFornitore(request, response);
        }

        String nome_fornitore = request.getParameter("nome_fornitore");
        if(cu.isEmpty(nome_fornitore)){
            request.setAttribute("error", "Nome Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String cognome_fornitore = request.getParameter("cognome_fornitore");
        if(cu.isEmpty(cognome_fornitore)){
            request.setAttribute("error", "Cognome Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String telefono_fornitore = request.getParameter("telefono_fornitore");
        if(cu.isEmpty(telefono_fornitore)){
            request.setAttribute("error", "Telefono Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String fax_fornitore = request.getParameter("telefono_fornitore");
        if(cu.isEmpty(fax_fornitore)){
            request.setAttribute("error", "Fax Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String indirizzo_fornitore = request.getParameter("indirizzo_fornitore");
        if(cu.isEmpty(indirizzo_fornitore)){
            request.setAttribute("error", "Indirizzo Fornitore"+MSG.UNKNOW.getName());
            this.gestioneFornitore(request, response);
        }
        String debito_fornitore = request.getParameter("debito_fornitore");
        if(!cu.isNumeric(debito_fornitore)){
            request.setAttribute("error", "Debito Fornitore"+MSG.NOT_NUMBER.getName() );
            this.gestioneFornitore(request, response);
        }
        String pagato_fornitore = request.getParameter("pagato_fornitore");
        if(!cu.isNumeric(pagato_fornitore)){
            request.setAttribute("error", "Pagato Fornitore"+MSG.NOT_NUMBER.getName() );
            this.gestioneFornitore(request, response);
        }

        Supplies supplies = new Supplies();
        supplies.setPiva(Integer.parseInt(idString));
        supplies.setNome(nome_fornitore);
        supplies.setCognome(cognome_fornitore);
        supplies.setTel(telefono_fornitore);
        supplies.setFax(fax_fornitore);
        supplies.setIndirizzo(indirizzo_fornitore);
        supplies.setDebito(Double.parseDouble(debito_fornitore));
        supplies.setPagato(Double.parseDouble(pagato_fornitore));
        SuppliesManagement suppliesManagement = new SuppliesManagement(supplies.getPiva());
        if(suppliesManagement.insertSupplies(supplies)) {
            request.setAttribute("error", "Fornitore" + MSG.OK_INSERT.getName());
            this.gestioneFornitore(request, response);
        }
    }

    private void viewFornitore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id_fornitore");
        Supplies supplies = this.getFornitore(idString, resp);
        if(supplies == null) {
            req.setAttribute("error", "ID" + idString + MSG.NOT_FOUND.getName());

            this.searchFornitore(req, resp);

        }else{
            req.setAttribute("fornitoreID", idString);
            req.setAttribute("fornitore", supplies);

            req.getRequestDispatcher("/WEB-INF/jsp/view/fornitore/viewFornitore.jsp").forward(req, resp);
        }
    }

    private Supplies getFornitore(String idString, HttpServletResponse resp) throws IOException {
        if(idString == null || idString.length() == 0){

            resp.sendRedirect("fornitore");
            return null;
        }
        try {
            SuppliesManagement suppliesManagement = new SuppliesManagement(Integer.parseInt(idString));
            Supplies supplies = suppliesManagement.getSupplies();

            return supplies;
        }catch (Exception e){
            return null;
        }
    }
}

package org.m2fas;

import entity.Product;
import intermediate.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "prodottoServlet",
        urlPatterns = {"/prodotto"},
        loadOnStartup = 1
)
public class ProdottoServlet extends HttpServlet {

    CheckUtils cu = new CheckUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null)
            action = "search";

        switch (action){
            case "search":
                this.searchProduct(req, resp);
                break;
            case "gestione":
                this.gestioneProduct(req, resp);
                break;
        }
    }

    private void gestioneProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/prodotto/gestioneProdotto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//System.out.println(action);
        if (action != null) {
         //   request.getSession().setAttribute("user", user);
          //  response.sendRedirect("home");
            switch (action){
                case "view":
                    this.viewProduct(request, response);
                    break;
                case "inserisci":
                    this.insertProduct(request, response);
                    break;
                case "cancella":
                    this.deleteProduct(request, response);
                    break;
                case "aggiorna":
                    this.updateProduct(request, response);
                    break;
            }
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id_prodotto");
        if(cu.isEmpty(idString)) {
            request.setAttribute("error", "ID"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String marca_prodotto = request.getParameter("marca_prodotto");
        if(cu.isEmpty(marca_prodotto)){
            request.setAttribute("error", "Marca Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String modello_prodotto = request.getParameter("modello_prodotto");
        if(cu.isEmpty(modello_prodotto)){
            request.setAttribute("error", "Modello Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String categoria_prodotto = request.getParameter("categoria_prodotto");
        if(cu.isEmpty(categoria_prodotto)){
            request.setAttribute("error", "Categoria Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String prezzo_prodotto = request.getParameter("prezzo_prodotto");
        if(!cu.isNumeric(prezzo_prodotto)){
            request.setAttribute("error", "Prezzo Prodotto"+MSG.NOT_NUMBER.getName() );
            this.gestioneProduct(request, response);
        }

        String qta_prodotto = request.getParameter("qta_prodotto");
        if(!cu.isNumeric(qta_prodotto)){
            request.setAttribute("error", "Quantità Prodotto"+MSG.NOT_NUMBER.getName() );
            this.gestioneProduct(request, response);
        }
        Product product = new Product();
        product.setID(Integer.parseInt(idString));
        product.setMarca(marca_prodotto);
        product.setModello(modello_prodotto);
        product.setCategoria(categoria_prodotto);
        product.setPrz(Float.parseFloat(prezzo_prodotto));
        product.setQta(Integer.parseInt(qta_prodotto));
        ProductManagement productManagement = new ProductManagement(product.getID());
        if(productManagement.updateProduct(product)) {
            request.setAttribute("error", "Prodotto" + MSG.OK_UPDATE.getName());
            this.gestioneProduct(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id_prodotto");
        ProductManagement productManagement = new ProductManagement(Integer.parseInt(idString));
        if(productManagement.removeProduct()){
            request.setAttribute("error", "Prodotto "+idString + MSG.OK_REMOVE.getName());
            this.gestioneProduct(request, response);
        }else {
            request.setAttribute("error",  MSG.WARNING.getName());
            this.gestioneProduct(request, response);
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idString = request.getParameter("id_prodotto");
    //    Product product = this.getProduct(idString, response);
        if(cu.isEmpty(idString)) {
            request.setAttribute("error", "ID"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String marca_prodotto = request.getParameter("marca_prodotto");
        if(cu.isEmpty(marca_prodotto)){
            request.setAttribute("error", "Marca Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String modello_prodotto = request.getParameter("modello_prodotto");
        if(cu.isEmpty(modello_prodotto)){
            request.setAttribute("error", "Modello Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String categoria_prodotto = request.getParameter("categoria_prodotto");
        if(cu.isEmpty(categoria_prodotto)){
            request.setAttribute("error", "Categoria Prodotto"+MSG.UNKNOW.getName());
            this.gestioneProduct(request, response);
        }

        String prezzo_prodotto = request.getParameter("prezzo_prodotto");
        if(!cu.isNumeric(prezzo_prodotto)){
            request.setAttribute("error", "Prezzo Prodotto"+MSG.NOT_NUMBER.getName() );
            this.gestioneProduct(request, response);
        }

        String qta_prodotto = request.getParameter("qta_prodotto");
        if(!cu.isNumeric(qta_prodotto)){
            request.setAttribute("error", "Quantità Prodotto"+MSG.NOT_NUMBER.getName() );
            this.gestioneProduct(request, response);
        }
        Product product = new Product();
        product.setID(Integer.parseInt(idString));
        product.setMarca(marca_prodotto);
        product.setModello(modello_prodotto);
        product.setCategoria(categoria_prodotto);
        product.setPrz(Float.parseFloat(prezzo_prodotto));
        product.setQta(Integer.parseInt(qta_prodotto));
        ProductManagement productManagement = new ProductManagement(product.getID());
        if(productManagement.insertProduct(product)) {
            request.setAttribute("error", "Prodotto" + MSG.OK_INSERT.getName());
            this.gestioneProduct(request, response);
        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/prodotto/search.jsp").forward(req, resp);
    }

    private void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String idString = req.getParameter("id_prodotto");
        Product product = this.getProduct(idString, resp);
        if(product == null) {
            req.setAttribute("error", "ID"+MSG.UNKNOW.getName());
       //     resp.sendRedirect("prodotto");
            this.searchProduct(req, resp);

        }else{
            req.setAttribute("prodottoID", idString);
            req.setAttribute("prodotto", product);

            req.getRequestDispatcher("/WEB-INF/jsp/view/prodotto/viewProduct.jsp").forward(req, resp);
        }

    }

    private Product getProduct(String idString, HttpServletResponse resp) throws IOException {
        if(idString == null || idString.length() == 0){

            resp.sendRedirect("prodotto");
            return null;
        }
        try {
            ProductManagement pm = new ProductManagement(Integer.parseInt(idString));
            Product product = pm.getProduct();

            return product;
        }catch (Exception e){
          //  resp.sendRedirect("prodotto");
            return null;
        }

    }

}

package org.m2fas;

import entity.Product;
import intermediate.ProductManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(
        name = "shopServlet",
        urlPatterns = {"/shop"}
)
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null)
            action = "browse";

        switch (action){
            case "addToCart":
                this.addToCart(req, resp);
                break;
            case "viewCart":
                this.viewCart(req, resp);
                break;
            case "emptyCart":
                this.emptyCart(req, resp);
                break;
            case "browse":
            default:
                this.browse(req, resp);
                break;
        }
    }

    private void emptyCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("cart");
        resp.sendRedirect("shop?action=viewCart");
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId;
        try{
            productId = Integer.parseInt(req.getParameter("productId"));
        }catch(Exception e){
            resp.sendRedirect("shop");
            return;
        }
     //   System.out.println(productId);
        HttpSession session = req.getSession();
        if(session.getAttribute("cart") == null)
            session.setAttribute("cart", new Hashtable<Integer, Integer>());

        @SuppressWarnings("unchecked")
                Map<Integer, Integer> cart= (Map<Integer, Integer>) session.getAttribute("cart");
        if(!cart.containsKey(productId))
            cart.put(productId, 0);
        cart.put(productId, cart.get(productId) + 1);
   //     System.out.println(Arrays.asList(cart));
        resp.sendRedirect("shop?action=viewCart");
    }


    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", this.getProducts(req.getSession(), "cart"));
        req.getRequestDispatcher("/WEB-INF/jsp/view/shop/viewCart.jsp").forward(req, resp);
    }

    /**
     * Ritorna tutti i prodotti selezionati in base alla sessione del carrello
     * @param session
     *      sessione http
     * @param nome_session
     *      nome della sessione da recuperare da http
     * @return ArrayList<Product>
     *      ritorna l'elenco dei prodotto selezionati dalla sessione cart,
     *      il quale contiene productID e la quantità di ogni prodotto
     */
    private ArrayList<Product> getProducts(HttpSession session, String nome_session) {
        if(session.getAttribute(nome_session) != null) {
            try {
                Map<Integer, Integer> cart= (Map<Integer, Integer>) session.getAttribute(nome_session);
                ProductManagement pm = new ProductManagement();
                if(cart.size()>0){
                    ArrayList<Product> products = new ArrayList<>();
                    for (int id: cart.keySet()) {

                        Product product = pm.getProduct(id);
                        products.add(product);

                    }
                //    System.out.println("getproducts: " + Arrays.asList(products));
                    return products;
                }

            }catch (Exception e){

            }
        }
        return null;
    }

    public void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(this.getProducts()!=null)
            req.setAttribute("products", this.getProducts());

        req.getRequestDispatcher("/WEB-INF/jsp/view/shop/browse.jsp").forward(req, resp);
    }

    /**
     * Ritorna tutti i prodotti dal database
     * @return  ArrayList<Product>
     */
    private ArrayList<Product> getProducts() {
        try {
            ProductManagement pm = new ProductManagement();
            return pm.getProducts();

        }catch (Exception e){
            //  resp.sendRedirect("prodotto");
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

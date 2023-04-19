<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 11/04/2023
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<body onload="calculatePrzXQuantity()">
<div class="wrapper" id="gestione_prodotto">
    <div>
        <h2>Nel carrello...</h2>
        <table>
            <tr>
                <td colspan="3"><a href="<c:url value="/shop" />">Product List</a></td>
                <td colspan="3"><a href="<c:url value="/shop?action=emptyCart" />">Empty Cart</a></td>
            </tr>

<%
    @SuppressWarnings("unchecked")
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");

    @SuppressWarnings("unchecked")
    Map<Integer, Integer> cart =
            (Map<Integer, Integer>)session.getAttribute("cart");

    if(cart == null || cart.size() == 0) {
        %>
       <h2>Il carrello è vuoto</h2>
 <%   }else
    {
        int i=0;
        for(int id : cart.keySet())
        {
            Product product = products.get(i);
            %>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Modello</th>
                <th>Categoria</th>
                <th>Quantità</th>
                <th>Prezzo</th>
            </tr>
            <tr>
                <td><%=product.getID()%> ss:<%=id%></td>
            <td><%=product.getMarca() %></td>
            <td><%=product.getModello() %></td>
            <td><%=product.getCategoria() %></td>
            <td><input type="number" name="quantity"
                       id="quantity"
                       min="0" max="10" step="1"
                       value="<%=cart.get(id) %>"
                        onchange="calculatePrzXQuantity()"
            ></td>
            <td><input type="hidden"
                       name="prz"
                       value="<%=product.getPrz() %>"

                >
                <%=product.getPrz() %>
            </td>
            </tr>
        <%
            i++;
        }
        %>
            <tr>
                <th colspan="6">Totale: <span id="total">0</span></th>
            </tr>
            <%
    }
%>

        </table>
    </div>
    <script  >
        function calculatePrzXQuantity(){

            var prz = document.getElementsByName("prz")
            var quantities = document.getElementsByName("quantity");
            var total = 0;
            for(var i=0; i<prz.length; i++){
                total += quantities[i].value * prz[i].value;
            }

            document.getElementById("total").innerHTML= total;
       //     alert();
        }
    </script>
</div>
</body>
</html>

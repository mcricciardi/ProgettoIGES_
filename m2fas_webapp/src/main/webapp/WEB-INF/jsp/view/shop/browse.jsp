<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 11/04/2023
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper">
    <div>
        <h2>Lista prodotti</h2>
        <table>
            <tr>
                <th>Marca</th>
                <td>Modello</td>
                <td>Categoria</td>
                <td>Quantità</td>
                <td>Prezzo</td>
            </tr>
            <%
                @SuppressWarnings("unchecked")
                ArrayList<Product> products =
                        (ArrayList<Product>)request.getAttribute("products");


                if(products.size()>0)
                    for(int i =0; i<products.size(); i++)
                    {
                        Product product = products.get(i);
                        %>
                        <tr>
                            <td>
                                <a href="<c:url value="/shop">
                                <c:param name="action" value="addToCart" />
                                <c:param name="productId" value="<%=String.valueOf(product.getID())%>"/>
                                </c:url>"><%=product.getMarca()%></a>
                            </td>
                            <td><%=product.getModello() %></td>
                            <td><%=product.getCategoria() %></td>
                            <td><%=product.getQta() %></td>
                            <td><%=product.getPrz() %></td>
                        </tr>
           <% } %>
            <tr>
                <td colspan="5" style="border:0">
                    <p class="login-register"><a href="<c:url value="/shop?action=viewCart" />">Carrello</a></p>
                </td>
            </tr>
        </table>
    </div>

</div>

</body>
</html>
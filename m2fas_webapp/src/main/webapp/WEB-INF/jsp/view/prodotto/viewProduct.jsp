<%@ page import="entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 06/04/2023
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String productID = (String) request.getAttribute("prodottoID");
  Product product = (Product) request.getAttribute("prodotto");
%>

<div class="wrapper">
<div>
    <table>
        <tr>
            <th>ID Prodotto</th>
            <td><%=productID %></td>
        </tr>
        <tr>
            <th>Modello</th>
            <td><%= product.getModello()%></td>
        </tr>
        <tr>
            <th>Categoria</th>
            <td><%= product.getCategoria() %></td>
        </tr>
        <tr>
            <th>Quantita'</th>
            <td><%= product.getQta() %></td>
        </tr>
        <tr>
            <th>Marca</th>
            <td><%= product.getMarca() %></td>
        </tr>
        <tr>
            <th>Prezzo</th>
            <td><%= product.getPrz() %></td>
        </tr>
        <tr>
            <td colspan="5" style="border:0">
                <p class="login-register"><a href="<c:url value="/prodotto"/> ">Return to search</a></p>
            </td>
        </tr>
    </table>
</div>


</body>
</html>

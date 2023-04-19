<%@ page import="entity.Supplies" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 09/04/2023
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String suppliesID = (String) request.getAttribute("fornitoreID");
    Supplies supplies = (Supplies) request.getAttribute("fornitore");
%>

<div class="wrapper">
    <div>
        <table>
            <tr>
                <th>P.IVA</th>
                <td><%=suppliesID %></td>
            </tr>
            <tr>
                <th>Nome</th>
                <td><%= supplies.getNome()%></td>
            </tr>
            <tr>
                <th>Cognome</th>
                <td><%= supplies.getCognome() %></td>
            </tr>
            <tr>
                <th>Telefono</th>
                <td><%= supplies.getTel()%></td>
            </tr>
            <tr>
                <th>Fax</th>
                <td><%= supplies.getFax() %></td>
            </tr>
            <tr>
                <th>Indirizzo</th>
                <td><%= supplies.getIndirizzo() %></td>
            </tr>
            <tr>
                <th>Debito</th>
                <td><%= supplies.getDebito() %></td>
            </tr>
            <tr>
                <th>Pagato</th>
                <td><%= supplies.getPagato() %></td>
            </tr>
        </table>
    </div>

    <div class="login-register">
        <p><br />
            <br /><a href="<c:url value="/fornitore"/> ">Return to search</a></p>
    </div>
</div>

</body>
</html>
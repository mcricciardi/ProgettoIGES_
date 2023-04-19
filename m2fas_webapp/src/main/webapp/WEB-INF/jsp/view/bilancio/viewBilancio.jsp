<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="interfacce.PrintBalanceResult" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 09/04/2023
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList elenco_spese = (ArrayList) request.getAttribute("elenco_spese");
    ArrayList elenco_entrate = (ArrayList) request.getAttribute("elenco_entrate");
    System.out.println(
            Arrays.deepToString(elenco_spese.toArray())
    );
    System.out.println(
            Arrays.deepToString(elenco_entrate.toArray())
    );
%>
<c:set var="numCols" value="3"/>
<c:set var="numRows" value="3"/>
<c:set var="rowCount" value="0"/>
<table>
    <tr>
        <!--Loop through each element in the dataList and assign it to a variable named info -->
        <c:forEach items="${elenco_spese}" var="spesa" varStatus="status">
        <!-- If the current row count is less than the number of row allowed, proceed-->
        <c:if test="${rowCount lt numRows}">
        <!--Output the element (info) into a table cell -->
        <td>${spesa}</td>
        <!--Check to see if the cell that was just created is the 3 one in the row,
         excluding the very first cell of the table (because 0 % 0 is undefined) -->
        <c:if test="${status.count ne 0 && status.count % numCols == 0}">
        <!--Increment the row count -->
        <c:set var="rowCount" value="${rowCount + 1}"/>
        <!-- End that row and start a new one-->

    </tr><tr>
    </c:if>
    </c:if>
    </c:forEach>
</tr>
</table>

<table>
    <tr>
        <!--Loop through each element in the dataList and assign it to a variable named info -->
        <c:forEach items="${elenco_entrate}" var="entrate" varStatus="status">
        <!-- If the current row count is less than the number of row allowed, proceed-->
        <c:if test="${rowCount lt numRows}">
        <!--Output the element (info) into a table cell -->
        <td>${entrate}</td>
        <!--Check to see if the cell that was just created is the 3 one in the row,
         excluding the very first cell of the table (because 0 % 0 is undefined) -->
        <c:if test="${status.count ne 0 && status.count % numCols == 0}">
        <!--Increment the row count -->
        <c:set var="rowCount" value="${rowCount + 1}"/>
        <!-- End that row and start a new one-->

    </tr><tr>
    </c:if>
    </c:if>
    </c:forEach>
</tr>
</table>
<%@ page import="ec.edu.epn.logica.Cliente" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 10/5/2024
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Lista de Usuarios registrados</h1>
<%
        List<Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes");
        int cont = 0;
            for (Cliente cliente : listaClientes) {
%>
                <p><b>Usuario Nº <%=cont %></b></p>
                <p>Nombre: <%=cliente.getNombre()%></p>
                <p>Apellido: <%=cliente.getApellido()%></p>
                <p>----------------------------------</p>
<% cont += cont ;%>

<%}%>
</body>
</html>

<%@ page import="Persistencia.Compra" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 28/4/2024
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista de juegos comprados: </h1>
<%
    //debe coincidir los nombres del atributo
    List<Compra> listaJuegosComprados = (List) request.getSession().getAttribute("listaJuegosComprados");
    int contador = 1;
    for(Compra compra : listaJuegosComprados) {
        //NO CIERRO EL FOR POR EL CODIGO HTML

%>
<p><b>Juego Comprado N°: <%=contador%></b></p>
<p>idVideojuego: <%=compra.getIdVideojuego()%></p>
<p>precioAPagar: <%=compra.getPrecioAPagar()%></p>
<p>--------------------------------------</p>

<%
        //POR FIN SE CIERRA EL FOR
        contador++;
    }
%>
</body>
</html>

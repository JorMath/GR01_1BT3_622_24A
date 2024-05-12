<%@ page import="ec.edu.epn.logica.Videojuego" %>
<%@ page import="java.util.List" %><%--
<%@ page import="ec.edu.epn.logica.Videojuego" %><%--
  Created by IntelliJ IDEA.
  User: jeanp
  Date: 11/5/2024
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalogo</title>
</head>
<body>
    <%
        List<Videojuego> videojuegos = (List<Videojuego>) request.getSession().getAttribute("listaVideojuegos");
        for (Videojuego videojuego : videojuegos) {
    %>
    <form action="SvVideojuego" method="post">
        <p><b>Juego N°: <%=videojuego.getIdVideojuego()%></b></p>
        <p>Titulo: <%=videojuego.getTitulo()%></p>
        <p>Precio: <%=videojuego.getPrecio()%></p>
        <button type="submit">Comprar</button>
        <p>--------------------------------------</p>
    </form>
    <%
        }
    %>
</body>
</html>

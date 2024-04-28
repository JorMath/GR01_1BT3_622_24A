<%@ page import="java.util.List" %>
<%@ page import="Persistencia.Videojuego" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jorma
  Date: 26/4/2024
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Juegos Disponibles</title>
</head>
<body>
<h1>Lista de Juegos: </h1>
<%
    //debe coincidir los nombres del atributo
    List<Videojuego> listaVideojuegos = (List) request.getSession().getAttribute("listaVideojuegos");
    if(listaVideojuegos != null) {
    int contador = 1;
    for(Videojuego videojuego : listaVideojuegos) {
        //NO CIERRO EL FOR POR EL CODIGO HTML

%>
<form action="servlet-compra" method="post">
    <p><b>Juego N°: <%=contador%></b></p>
    <p>Titulo: <%=videojuego.getTitulo()%></p>
    <p>Precio: <%=videojuego.getPrecio()%></p>
    <p>Copias Disponibles: <%=videojuego.getCopiasDisponibles()%></p>
    <button type="submit">Comprar</button>
<p>--------------------------------------</p>
</form>
<%
        //POR FIN SE CIERRA EL FOR
        contador++;
    }
    }
    else {


%>
<h1>No se encontro el titulo</h1>
<%
    }
%>
<form action="servlet-busqueda" method="post">
<button type="submit">Volver</button>
</form>
</body>
</html>

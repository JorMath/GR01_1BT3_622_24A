<%--
  Created by IntelliJ IDEA.
  User: jorma
  Date: 28/4/2024
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ingresa el titulo a buscar</h1>
<form action="SvVideojuego" method="get">
    <p><label>Titulo: </label> <input type="text" name="titulo"></p>
    <button type="submit">Buscar</button>
</form>
<form action="SvBiblioteca" method="get">
    <button type="submit">Biblioteca de juegos</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: carla
  Date: 5/11/2024
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario para subir Videojuego</title>
</head>
<body>
<fieldset>
<h1>Ingrese los datos del videojuego:</h1>
<form action="SvVideojuego" method="POST">
    Título de Videojuego:<br>
    <input type="text" name="tituloVideojuego" required>
    <br>
    Descripción:<br>
    <input type="text" name="descripcionVideojuego" required>
    <br>
    Precio:<br>
    <input type="number" name="precioVideojuego" required>
    <br>
    <br>
    <input type="submit" value="Publicar videojuego">
</form>
</fieldset>
</body>
</html>

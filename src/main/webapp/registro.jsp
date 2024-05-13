<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 11/5/2024
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <h1>Bienvenido, llene los siguientes datos para su registro</h1>
    <form action="SvCliente" method="post">
        Nombre*: <br>
        <input type="text" name="nombre" required> <br>
        Apellido*: <br>
        <input type="text" name="apellido" required> <br>
        Clave*: <br>
        <input type="password" name="clave" required> <br>
        <input type="submit" value="Subir">
    </form>
</fieldset>

</body>
</html>

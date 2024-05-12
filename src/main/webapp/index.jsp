<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ingresar al Sistema</title>
</head>
<body>
<h1>Ingresa tus datos:</h1>
<form action="SvCliente" method="post">
    <p><label>Nombre: </label> <label>
        <input type="text" name="nombre">
    </label></p>
    <p><label>Apellido: </label> <label>
        <input type="text" name="apellido">
    </label></p>
    <button type="submit">Ingresar</button>
</form>
<form action="SvCliente" method="get">
    <button type="submit">Ver usuarios</button>
</form>

</body>
</html>
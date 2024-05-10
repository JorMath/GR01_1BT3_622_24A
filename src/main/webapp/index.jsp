<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ingresar al Sistema</title>
</head>
<body>
<h1>Ingresa tus datos:</h1>
<form action="SvUsuario" method="POST">
    <p><label>Nombre: </label> <input type="text" name="nombre"></p>
    <p><label>Apellido: </label> <input type="text" name="apellido"></p>
    <button type="submit">Ingresar</button>
</form>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ingresar al Sistema</title>
</head>
<body>
<fieldset>
    <h1>Ingresa tus credenciales</h1>
    <form action="SvControlAcceso" method="post">
        Nombre* : <br>
        <input type="text" name="nombreEntrante" required> <br>
        Clave*: <br>
        <input type="password" name="claveEntrante" required> <br>
        <input type="submit" value="Ingresar"> <br><br>
    </form>
    <br>
    <h6>¿Usuario nuevo?</h6>
    <form action="registro.jsp" method="post">
        <input type="submit" value="Registrarse">
    </form>
</fieldset>
</body>
</html>
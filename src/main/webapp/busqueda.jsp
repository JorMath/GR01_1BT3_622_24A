<%@ page import="java.util.List" %>
<%@ page import="Persistencia.Comprador" %>
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
    <title>Mostrar compradores</title>
</head>
<body>
<h1>Lista de compradores: </h1>
<%
    //debe coincidir los nombres del atributo
    List<Comprador> listaCompradores = (List) request.getSession().getAttribute("listaCompradores");
    int contador = 1;
    for(Comprador comprador : listaCompradores) {
        //NO CIERRO EL FOR POR EL CODIGO HTML

%>
<p><b>Cliente N°: <%=contador%></b></p>
<p>Cedula: <%=comprador.getCedula()%></p>
<p>Nombre: <%=comprador.getNombre()%></p>
<p>Apellido: <%=comprador.getApellido()%></p>
<p>Telefono: <%=comprador.getTelefono()%></p>
<p>--------------------------------------</p>

<%
        //POR FIN SE CIERRA EL FOR
        contador++;
    }
%>

</body>
</html>
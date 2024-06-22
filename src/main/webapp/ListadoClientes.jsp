<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.TblCliente" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Listado de Clientes Registrados en BD</h1>

<h2 align="center">
<a href="FormRegistrarCliente.jsp">Registrar Cliente</a>
</h2>

<table border="2" align="center">
    <tr>
        <td>Nombre</td>
        <td>Apellido</td>
        <td>Dni</td>
        <td>Email</td>
        <td>Telf</td>
        <td>Sexo</td>
        <td>Nacionalidad</td>
    </tr>

    <%
    List<TblCliente> listadocliente = (List<TblCliente>) request.getAttribute("listadoclientes");

    if (listadocliente != null) {
        for (TblCliente lis : listadocliente) {
    %>
    <tr>
        <td><%= lis.getNombre() %></td>
        <td><%= lis.getApellido() %></td>
        <td><%= lis.getDni() %></td>
        <td><%= lis.getEmail() %></td>
        <td><%= lis.getTelf() %></td>
        <td><%= lis.getSexo() %></td>
        <td><%= lis.getNacionalidad() %></td>
    </tr>
    <%
        }
    }
    %>
</table>
</body>
</html>
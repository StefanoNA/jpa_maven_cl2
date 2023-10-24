<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestinar Producto</title>
</head>
<body bgcolor="c5dec9">
<h1 align="center">
Gestionar Producto
</h1>
<form action="ControladorServlet" method="post">

<table align="center">

<tr>
<td>Nombre</td>
<td><input type="text" name="nombrecl2"></td>
</tr>


<tr>
<td>Precio</td>
<td><input type="text" name="preciocompcl2"></td>
</tr>


<tr>
<td>Precioventa</td>
<td><input type="text" name="precioventacl2"></td>
</tr>


<tr>
<td>Estado</td>
<td><input type="text" name="estadocl2"></td>
</tr>


<tr>
<td>Descrip</td>
<td><input type="text" name="descripcl2"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Registrar Producto">
</td>
</tr>

</table>

</form>
</body>
</html>
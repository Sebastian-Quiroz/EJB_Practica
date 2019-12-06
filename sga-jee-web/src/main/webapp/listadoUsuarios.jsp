<%-- 
    Document   : ListadoUsuarios
    Created on : 6/12/2019, 8:39:38 a. m.
    Author     : ADMIN
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Usuarios JPS</title>
    </head>
    <body>
        <h1>Listado Usuarios</h1>
        <ul>
            <!-- Se trae la variable creada en PersonaServlet linea 35 -->
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario.username} ${usuario.persona.nombre}</li>
            </c:forEach>
        </ul>
    </body>
</html>

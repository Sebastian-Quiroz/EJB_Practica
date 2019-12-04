<%-- 
    Document   : listadoPersonas
    Created on : 4/12/2019, 11:24:16 a. m.
    Author     : ADMIN
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Personas JSP</title>
    </head>
    <body>
        <h1>Listado Personas</h1>
        <ul>
            <!-- Se trae la variable creada en PersonaServlet linea 35 -->
            <c:forEach items="${personas}" var="persona">
                <li>${persona.nombre} ${persona.apellido}</li>
            </c:forEach>
        </ul>
    </body>
</html>

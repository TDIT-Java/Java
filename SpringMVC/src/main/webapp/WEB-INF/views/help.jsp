<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>

<html>
    <head>
    <meta charset="ISO-8859-1">
    <title> Help Page </title>
    </head>
    <body>
        <h3>
            <%@ page import="java.time.LocalDate" %>
            <%
                 String msg = (String) request.getAttribute("message");
                 LocalDate today = (LocalDate) request.getAttribute("today");
             %>
            <h2>My name is : ${name} </h2>
            <h2>message is : <%=msg%> </h2>
            <h2> Today date is : <%=today.toString()%>
        </h3>

    </body>
</html>

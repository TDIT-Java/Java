<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title> Home Page </title>
    </head>
    <body>
        <h1> This is home page </h1>
        <h1> Called by home controller </h1>
        <h1> url /home </h1>

        <h3>
        <%@ page import="java.util.List" %>
            <%
                 String name = (String) request.getAttribute("title");
                 String msg = (String) request.getAttribute("message");
                 List<String> topics = (List<String>) request.getAttribute("topics");
             %>
            <h2>Tute. name is : <%=name%> </h2>
            <h2>Tute. message is : <%=msg%> </h2>
        </h3>

        <p> Spring content </p>

        <%
            for(String s:topics){
        %>

        <h3> <%=s%> </h3>

        <% } %>

    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>

<html>
    <head>
    <meta charset="ISO-8859-1">
    <title> Help Page </title>
    </head>
    <body>
    <h1> ${Header} </h1>

       <h1> User Registration </h1>
       <form action="processForm" method="post">
       <input type="email" name="email" placeholder="email">
       <input type="text" name="username" placeholder="username" id="userName">
       <input type="password" name="password" placeholder="password" id="userPassword">
       <button type="submit">Sign Up</button>
       </form>
    </body>
</html>

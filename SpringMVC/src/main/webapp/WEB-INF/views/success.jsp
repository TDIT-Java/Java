<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>

<html>
    <head>
    <meta charset="ISO-8859-1">
    <title> Success Page </title>
    </head>
    <body>
      <h1> Welcome </h1>
      <h1> ${Header} </h1>
      <h2 style="color:green;"> ${msg} </h2>
      <h2> Your email is ${user.email} </h2>
      <h2> Your username is ${user.username} </h2>
      <h2> Your password is ${user.password} </h2>

    </body>
</html>

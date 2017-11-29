
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Successful</title>

        <style>
            .regSuccess {
                align-content: center;
                margin: 25px;
                padding: 15px;
                max-width: 300px;
                height: 500px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;
            } 
            .regSuccess:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 

            <center>
                <h1>XYZ Drivers Association </h1>
                <h1>Registration Successful</h1>
        </div>

        <div class ="regSuccess">
            <center>
                <h1> Registration Successful </h1>
                <p><b>Your generated username is:  </b></p>
                <% out.println(request.getAttribute("username")); %>
                <br>
                <p><b>Your generated password is:</b></p>
                <% out.println(request.getAttribute("password"));%>
                <br>
                <p><b>Please write them down somewhere safe </b></p>
                <br>
                <br>
                <form action="index.jsp">
                    <input type="submit" value="Go Back to Login Page" />
                </form>
        </div>
    <center>

    </body>
</html>

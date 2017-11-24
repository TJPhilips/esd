
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Unsuccessful</title>

        <style>
            .userLoginFail {
                float: top;
                align-content: center;
                margin: 25px;
                padding: 15px;
                max-width: 300px;
                height: 275px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;  
            } 
            .userLoginFail:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>


    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 

            <center>
                <h1>XYZ Drivers Association </h1>
                <h1>User Login Failed</h1>

        </div>
        <div class ="userLoginFail">

            <center>
                <h1>Username or Password Incorrect. Please try again</h1>

        </div>
    </center>
    <jsp:include page="foot.jsp"/>
</body>
</html>

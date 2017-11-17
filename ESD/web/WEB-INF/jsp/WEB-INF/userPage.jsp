

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Members page </title>
        <style>
            .options {
                float: left;
                margin: 200px;
                padding: 15px;
                width: 300px;
                height: 300px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;  
            } 
            .options:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
        <style>
            .options2 {
                float: left;
                margin: 200px;
                padding: 15px;
                width: 300px;
                height: 300px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8; 
            } 
            .options2:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 
            <center>
                <h1>XYZ Drivers Association</h1>
                <h1>Members page</h1>
            </center>
        </div>

    <center>
        <div class ="options">
            Outstanding Balance: <br/>
            <%=(String) (request.getAttribute("query"))%> <br />

            Make Payment: <br />
            <input type="text"> <br />
            <input type=submit value="Check"> <br />

            All Payments: <br />
            <%=(String) (request.getAttribute("query"))%> <br />
        </div>


        <form action="claims.do" method ="post">

            <div class ="options2">

                Submit Claim: <br />
                <input type="text"> <br />
                <input type=submit value="Check"> <br />

                All Claims: <br />
                <%=(String) (request.getAttribute("query"))%> <br />
                </center>
            </div>
        </form>



        <jsp:include page="foot.jsp"/>
    </body>
</html>

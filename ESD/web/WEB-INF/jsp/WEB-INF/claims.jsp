

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        .claimBorder {
        float: left;
        margin: 200px;
        padding: 15px;
        max-width: 300px;
        height: 300px;
        border: 1px solid black;
        } 
        </style>
    </head>
    <body>
        <div class ="w3-container w3-blue w3-hover-light-blue"> 
            <h1>XYZ Drivers Association</h1>
            <h1>Claims</h1>
            
            <div class ="claimBorder">
                What is the reason for your claim: <br />
                <input type="text"> <br />
                
                Enter the amount <br />
                <input type ="text"> <br />
                <input type=submit value="Submit"> <br />
                
            </div>
            <jsp:include page="foot.jsp"/>
    </body>
</html>

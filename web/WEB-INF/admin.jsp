
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <style>
            .admin {
                float: top;
                align-content: center;
                margin: 25px;
                padding: 15px;
                max-width: 300px;
                height: 500px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;  
            } 
            .admin:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 

            <center>
                <h1>XYZ Drivers Association </h1>
                <h1>Admin Page</h1>

        </div>
        <div class ="admin">
            <center>
                <form action="Admin.do" method="post">
                    Current Members <br/>
                    <input type=submit name="members" value="View All Members"> <br />

                    Outstanding Balances: <br/>
                    <input type=submit name="outstanding" value="View All Members"> <br /> <br />

                    Check Claims <br />
                    <input type=submit value="Check"> <br />

                    Member Applications <br />
                    <input type=submit name="applications" value="View All Application"> <br /> <br />

                    Individual Claims <br />
                    <input type=submit value="Check"> <br />

                    Member Applications <br />
                    <%=(String) (request.getAttribute("query"))%> <br />
                    <input type=submit value="Approve">
                    <input type=submit value="Deny"> <br />

                    Suspend/Resume Memberships
                    <%=(String) (request.getAttribute("query"))%> <br />
                    <input type=submit value="Suspend">
                    <input type=submit value="Resume"> <br />

                    Annual Turnover
                    <%=(String) (request.getAttribute("query"))%> <br />
                    </div>
            </center>


            <jsp:include page="foot.jsp"/>
        </center>
</body>
</html>

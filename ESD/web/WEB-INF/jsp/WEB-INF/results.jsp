
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Results</title>
    </head>
    <body>
        <h1><%=(String)(request.getAttribute("title"))%></h1>

        <%=(String)(request.getAttribute("msg"))%>
        <jsp:include page="foot.jsp"/>
    </body>
</html>

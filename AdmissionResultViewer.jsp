

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admission Results Viewer</title>
    </head>
    <body>
        <h1>Admission  Status </h1>
        
        <%  String results=(String) request.getAttribute("outcome"); %>
        
        
        <p>  <%= results%> </p>
        
        <p>Click <a href="index.html">here</a>  to go to main page</p1>
    </body>
</html>

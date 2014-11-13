<%-- 
    Document   : login.jsp
    Created on : Jan 9, 2012, 6:01:55 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" name="username" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : addTrainStation
    Created on : Jan 6, 2012, 7:35:29 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Add a station</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" />
            </div>
            <div>
                <label for="address">Address</label>
                <input type="text" id="address" name="address" />
            </div>
            <div>
                <label for="city">City</label>
                <input type="text" id="city" name="city" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
        </form>
    </body>
</html>

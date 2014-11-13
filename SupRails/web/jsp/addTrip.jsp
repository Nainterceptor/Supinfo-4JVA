<%-- 
    Document   : addTrip
    Created on : Jan 9, 2012, 3:21:29 PM
    Author     : bargenson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Add Trip</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="departure">Departure station:</label>
                <select id="departure" name="departure">
                    <c:forEach items="${stations}" var="station">
                        <option value="${station.id}">
                            <c:out value="${station.name} (${station.city})"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="arrival">Arrival station:</label>
                <select id="arrival" name="arrival">
                    <c:forEach items="${stations}" var="station">
                        <option value="${station.id}">
                            <c:out value="${station.name} (${station.city})"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : listTrainStations
    Created on : Jan 6, 2012, 7:42:11 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Train stations</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${trainStations}" var="station">
                <li><c:out value="${station.name} (${station.city})" /></li>
            </c:forEach>
        </ul>
        
        <c:if test="${not empty user}">
            <c:url value="/admin/train-stations/add" var="addTrainStationUrl" />
            <a href="${addTrainStationUrl}">Add a new station</a>
        </c:if>
        
    </body>
</html>

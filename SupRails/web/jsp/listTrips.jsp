<%-- 
    Document   : listTrips
    Created on : Jan 6, 2012, 7:42:11 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Trips</title>
        <style>
            table {
                width: 80%; 
                margin: auto;
                border-collapse: collapse;
            }
            
            table tr td, table tr th {
                text-align: center;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty trips}">
                <table>
                    <tr>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Price</th>
                        <c:if test="${not empty user}">
                            <th>Action</th>
                        </c:if>
                    </tr>
                    <tr>
                        <c:forEach items="${trips}" var="trip">

                            <c:url value="/admin/trips/delete" var="deleteTripUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>

                            <td><c:out value="${trip.departureStation.name}" /></td>
                            <td><c:out value="${trip.arrivalStation.name}" /></td>
                            <td><c:out value="€${trip.price}" /></td>
                            <c:if test="${not empty user}">
                                <td>
                                    <a href="${deleteTripUrl}">Delete</a>
                                </td>
                            </c:if>

                        </c:forEach>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <p>No Trips in Database.</p>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${not empty user}">
            <c:url value="/admin/trips/add" var="addTripUrl" />
            <a href="${addTripUrl}">Add a new trip</a>
        </c:if>
    </body>
</html>

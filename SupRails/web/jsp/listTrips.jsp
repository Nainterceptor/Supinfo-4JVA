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
                <form method="GET">
                    <table>
                        <tr>
                            <td>
                                <select id="departure" name="departure">
                                    <option value="">Choose departure</option>
                                    <c:forEach items="${stations}" var="station">
                                        <option value="${station.id}"
                                            <c:if test="${station.id == departure}">
                                                selected="selected"
                                            </c:if>
                                        >
                                            <c:out value="${station.name} (${station.city})"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                            
                            <td>
                                <select id="arrival" name="arrival">
                                    <option value="">Choose arrival</option>
                                    <c:forEach items="${stations}" var="station">
                                        <option value="${station.id}"
                                            <c:if test="${station.id == arrival}">
                                                selected="selected"
                                            </c:if>
                                        >
                                            <c:out value="${station.name} (${station.city})"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                            
                            <td>
                                <label for="price">Max price</label>
                                <input type="text" name="price" id="price" value="${price}" />
                            </td>
                            
                            <td>
                                <input type="submit" value="Filter" />
                            </td>
                        </tr>
                    </table>
                </form>
                <table>
                    <tr>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${trips}" var="trip">
                        <tr>

                            <c:url value="/admin/trips/delete" var="deleteTripUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>
                            <c:url value="/customerorder/new" var="newOrderUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>

                            <td><c:out value="${trip.departureStation.name}" /></td>
                            <td><c:out value="${trip.arrivalStation.name}" /></td>
                            <td><c:out value="€${trip.price}" /></td>
                            <td>
                                <a href="${newOrderUrl}">Buy it</a>
                                <c:if test="${not empty user}">
                                    <a href="${deleteTripUrl}">Delete</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
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

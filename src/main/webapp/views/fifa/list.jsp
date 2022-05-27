<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>FiFa</title>
</head>
<body>
<h1>WedstijdenForm</h1>
<h2>${stadium.name}</h2>

<table>
    <tr>
        <th>Nr</th>
        <th>VoetbalMatch</th>
        <th>Datum</th>
        <th>Aftrap</th>
        <th>Tickets</th>
    </tr>
    <spring:url value="/fifa/buy/" var="showWedstrijdUrl"/>
    <c:forEach items="${wedstrijdenList}" var="ticket">
        <tr>
            <td>
                <a href="${showWedstrijdUrl}${ticket.wedstrijd.id}">${ticket.wedstrijd.id}</a>
            </td>
            <td>${ticket.wedstrijd.landen[0]} - ${ticket.wedstrijd.landen[1]}</td>
            <td>${ticket.wedstrijd.dag}</td>
            <td><fmt:formatNumber pattern="00" value="${ticket.wedstrijd.uur}" />:<fmt:formatNumber pattern="00" value="${ticket.wedstrijd.minute}" /></td>
            <td>${ticket.tickets}</td>
        </tr>
    </c:forEach>
</table>
<form action='/logout' method='post'>
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
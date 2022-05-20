<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${stadium.name}</h1>
	<table>
		<tr>
			<th>Nr</th>
			<th>VoetbalMatch</th>
			<th>Datum</th>
			<th>Aftrap</th>
			<th>Tickets</th>
		</tr>
		<spring:url value="/wedstrijden/" var="showWedstrijdUrl"/>
		<c:forEach items="${wedstrijden}" var="match">
			<tr>
				<td>
					<a href="${showWedstrijdUrl}${match.wedstrijd.id}">${match.wedstrijd.id}</a>
				</td>
				<td>${match.wedstrijd.landen[0]} - ${match.wedstrijd.landen[1]}</td>
				<td>${match.wedstrijd.dag}</td>
				<td>${match.wedstrijd.uur}:${match.wedstrijd.minute}</td>
				<td>${match.tickets}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>Stadion ${stadium.name}</h1>
<h2>${wedstrijdTicket.wedstrijd.landen[0]} - ${wedstrijdTicket.wedstrijd.landen[1]}</h2>
<h3>Aantal tickets beschikbaar: ${wedstrijdTicket.tickets}</h3>

<%--@elvariable id="wedstrijd" type=""--%>
<form:form method="post" modelAttribute="aankoopTicket">
    <form:errors path="*" cssClass="error"/>
    <p>
        <label>Email:</label>
        <form:input path="email" size="20" />
        <form:errors path="email" cssClass="error"/>
    </p>
    <p>
        <label>Aantal tickets:</label>
        <form:input path="aantalTickets" size="20" />
        <form:errors path="aantalTickets" cssClass="error"/>
    </p>

    <p>
        <label>VoetbalCode1:</label>
        <form:input path="voetbalCode1" size="20" />
        <form:errors path="voetbalCode1" cssClass="error"/>
    </p>
    <p>
        <label>VoetbalCode2:</label>
        <form:input path="voetbalCode2" size="20"/>
        <form:errors path="voetbalCode2" cssClass="error"/>
    </p>

    <p>
        <input type="submit" value="Koop" />
    </p>
</form:form>
</body>
</html>
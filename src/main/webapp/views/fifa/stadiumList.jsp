<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>FIFA</title>
    <spring:url value="/css/style.css" var="urlCss"/>
    <link rel="STYLESHEET" href="${urlCss}" type="text/css" />
</head>
<body>
<fieldset>
<%--    <p>${aantalTickets} tickets werden aangekocht</p>--%>
<%--    <c:if test="${aantalTickets != null && aantalTickets.intValue() > 0} ">--%>
        <p>${aantalTickets} tickets werden aangekocht</p>
<%--    </c:if>--%>

    <c:if test="${uitverkocht}">
        <p>De voetbalmatch is uitverkocht</p>
    </c:if>

    <legend>Stadiums</legend>
    <form:form method="post" action="stadium" modelAttribute="stadium">
        <form:select path="name">
            <form:options items="${stadiumList}" itemValue="name" itemLabel="name"></form:options>
        </form:select>
        <input type="submit" value="Voer uit"/>
    </form:form>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</fieldset>
<form action='/logout' method='post'>
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
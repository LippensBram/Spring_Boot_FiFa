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
    <legend>Stadiums</legend>
    <form:form method="post" action="stadium" modelAttribute="selectedStadium">
    <p>stadiums:
        <select name="selectedStadium">
            <c:forEach items="${stadiumList}" var="stadiumName" varStatus="loop">
                <option>${stadiumName.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Voer uit"/>
        </form:form>
</fieldset>
</body>
</html>
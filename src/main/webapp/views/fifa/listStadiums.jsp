<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Account Balance</title>
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="STYLESHEET" href="${urlCss}" type="text/css" />
</head>
<body>
        <fieldset>
            <legend>Stadiums</legend>
            <form:form method="post" action="fifa" modelAttribute="selectedStadium">
            	<p>stadiums:
<%--				<form:select path="stadium">--%>
<%--					<form:option value="NONE" label="---SELECT---"/>--%>
<%--					<form:options items="${stadiumList}" />--%>
<%--				</form:select>--%>
            	<select name="selectedStadium">
            		<c:forEach items="${stadiumList}" var="stadiumName" varStatus="loop">
            			<option>${stadiumName}</option>
            		</c:forEach>
            	</select>
            	<input type="submit" value="Voer uit"/>
            </form:form> 
        </fieldset>
    </body>
</html>
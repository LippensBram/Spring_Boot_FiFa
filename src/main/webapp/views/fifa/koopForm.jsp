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
	<h1>Stadion ${stadiumName}</h1>
	<h2>${landen[0]} - ${landen[1]}</h2>
	<h3>Aantal tickets beschikbaar: ${tickets}</h3>
	
	<form:form method="POST" action="wedstrijd" modelAttribute="wedstrijd">
		<form:errors path="*" cssClass="error"/>
		<p>
			<label>Email:</label>
			<form:input path="email" size="20" />
			<form:errors path="email" cssClass="error"/>
		</p>
		<p>
			<label>Aantal tickets:</label>
			<form:input path="tickets" size="20" />
			<form:errors path="tickets" cssClass="error"/>
		</p>

		<p>
			<label>VoetbalCode1:</label>
			<form:input path="VoetbalCode1" size="20" />
			<form:errors path="VoetbalCode1" cssClass="error"/>
		</p>
		<p>
			<label>VoetbalCode2:</label>
			<form:input path="VoetbalCode2" size="20"/>
			<form:errors path="VoetbalCode2" cssClass="error"/>
		</p>

		<p>
			<input type="submit" value="Koop" />
		</p>
	</form:form>
</body>
</html>
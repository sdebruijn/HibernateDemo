<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!doctype html>
<html>
<head>

<title>Rittenregistratie</title>
</head>
<body>
	<ul>
		<c:forEach items="${ritten}" var="rit">
			<li>
				Rit ${rit.id}: <a href="<c:url value="/rit/${rit.id}" />"> ${rit.omschrijving}</a>, 
				<a href="<c:url value="/delete/${rit.id}" />">verwijder</a>
			</li>
		</c:forEach>
	</ul>
	
	<!-- Let op! We MOETEN hier form:form gebruiken in plaats van een normale HTML form -->
	<form:form method="post">
		<p>
			Omschrijving: <input type="text" name="omschrijving"><br>
			Start: <input type="text" name="start"><br>
			Eind: <input type="text" name="end"><br>
			<input type="submit">
		</p>
	</form:form>
</body>
</html>
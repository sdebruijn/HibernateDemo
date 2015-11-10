<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!doctype html>
<html>
<head>

<title>Rit Detail View</title>
</head>
<body>
	<h1>Rit: ${rit.omschrijving}</h1>
	<p>Kilometers: van ${rit.start} tot ${rit.end} = ${rit.end - rit.start} km.</p>
	<p>
		Dit was <c:if test="${!rit.business}">g</c:if>een zakelijke rit.
	</p>
	
</body>
</html>
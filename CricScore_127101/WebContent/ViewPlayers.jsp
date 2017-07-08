<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>ICC ODI Cricket Score Records Application</h3>
<br>
<table border="1">
	<tr>
		<th>Player Id</th>
		<th>Player Name</th>
		<th>Age(In Yrs)</th>
		<th>Country</th>
		<th>Batting Style</th>
		<th>No. Of Centuries</th>
		<th>No. Of Matches Played</th>
		<th>Total Run Score</th>
	<tr>
	<c:forEach items="${playerrecords}" var="plist">
	<tr>
		<td>${plist.playerId}</td>
		<td>${plist.playerName}</td>
		<td>${plist.age}</td>
		<td>${plist.country}</td>
		<td>${plist.battingStyle}</td>
		<td>${plist.century}</td>
		<td>${plist.matches}</td>
		<td>${plist.totalRunScore}</td>
	</tr>
	</c:forEach>
</table>
<br>
<a href="CricketController?action=insertPlayerPage">ADD New Player</a>
</body>
</html>
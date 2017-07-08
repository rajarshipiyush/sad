<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>ICC ODI Cricket Score Records Application</h3>
<br>
<h4>New Player Score Entry Form</h4>
<form action="CricketController?action=insertPlayer" method="post">
<table>
	<tr>
		<td><label>Enter Player Name(*)</label></td>
		<td><input type="text" name ="player" pattern="[A-Za-z]{1-20}" title="Name can contain only letters" required/></td>
	</tr>
	<tr>
		<td>Enter DOB(*)</td>
		<td><input type="text" name="dateBirth" pattern="[0-9]{9}" title="Enter date of birth" required/>(dd/mm/yyyy)</td>
	</tr>
	<tr>
		<td>Select Team(*)</td>
		<td><select name="team" required>
		<option value="UK">UK</option>
		<option value="SriLanka">SriLanka</option>
		<option value="Australia">Australia</option>
		<option value="Zimbawe">Zimbawe</option>
		<option value="India">India</option>
		</select>
		</td>
	</tr>
	<tr>
		<td><label>Batting Style:(*)</label>
		<td>
			<input type="radio" name="batstyle" value="Left Handed Batsman" required/>Left Handed Batsman
			<input type="radio" name="batstyle" value="Right Handed Batsman"required/>Right Handed Batsman
		</td>
	</tr>
	<tr>
		<td><label>No. Of Centuries:(*)</label></td>
		<td><input type="text" name="centuries" pattern="[0-9]{3}" title="Total Number of Century can be in numbers" required/></td>
	</tr>
	<tr>
		<td><label>No. Of Matches Played:(*)</label></td>
		<td><input type="text" name="matchesplayed" pattern="[0-9]{4}" title="Enter Matches Played in Numbers" required/></td>
	</tr>
	<tr>
		<td>Total Run Score:(*)</td>
		<td><input type="text" name="scoreRun" pattern="[0-9]{10}" title="Runs can be in Numbers" required/>(Total Score cannot be less than no of centuries*100)</td>
	</tr>
	<tr><td><input type="submit" value="Save Player Data"/></td></tr>
</table>
</form>
</body>
</html>
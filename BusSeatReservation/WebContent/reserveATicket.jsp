<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy a ticket</title>
</head>
<body>

<h2>Buy a ticket</h2><br>
<form action="controller" method="post">
<input type="hidden" name="action" value="buyTicket">
<h3>Purchase a ticket , click Submit</h3>
  We have ${ availableSeats } available seats for bus 22<br>
  
  <h2><i> ${ errorMessage }</i></h2>
  
<input type="submit" value="Submit">
</form>

</body>
</html>
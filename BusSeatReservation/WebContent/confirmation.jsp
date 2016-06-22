<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final confirmation</title>
</head>
<body>
<h1>Success !</h1>
<h3>We would like to confirm the following reservation</h3>

<p>
-- Details -- <br>
First name : ${ user.firstName } <br>
Last name : ${ user.lastName } <br>
Email : ${ user.email } <br>
Phone number : ${ user.phoneNumber } <br>
Seat number : ${ seatNumber } <br>
</p>

</body>
</html>
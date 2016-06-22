<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg Form</title>
</head>
<body>

<h2>Looks like you are new on Bus Seat Reservation ... Welcome ! <br></h2>
<p>
Register here , and we are going to authenticate you automatically in the future :)
</p>

  <h2><i> ${ errorMessageRegistration }</i></h2>

<form action="controller" method="post">
<input type="hidden" name="action" value="registerUser">

First name : <br>
<input type="text" name="firstName" value="${ user.firstName }"><br>

Last name : <br>
<input type="text" name="lastName" value="${ user.lastName }"><br>

Email : <br>
<input type="email" name="email" value="${ user.email }"><br>

Phone number : <br>
<input type="text" name="phoneNumber" value="${ user.phoneNumber }"><br>

<input type="submit" value="Register">
</form>

</body>
</html>
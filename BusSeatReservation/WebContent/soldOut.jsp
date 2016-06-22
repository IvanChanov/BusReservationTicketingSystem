<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SoldOut</title>
</head>
<body>
<h2>Sorry ${ user.firstName } , all tickets have been sold out</h2>
<p> Daily we sell only 50 tickets <br>
		please come back tomorrow</p>
<img src="${pageContext.request.contextPath}/Images/soldOut.png" />
</body>
</html>
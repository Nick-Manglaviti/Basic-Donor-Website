<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Donor</title>
</head>
<body>
<h1>All Donors</h1>
<h2><a href="index.html">Home</a></h2>
<h3><a href="add.html">Add More Donors</a></h3>

<c:if test="${!empty donors}">
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone #</th>
			<th>Address</th>
			<th>Date Donated</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${donor.id}"/></td>
				<td><c:out value="${donor.name}"/></td>
				<td><c:out value="${donor.number}"/></td>
				<td><c:out value="${donor.address}"/></td>
				<td><c:out value="${donor.ddate}"/></td>
				<td><c:out value="${donor.amount}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
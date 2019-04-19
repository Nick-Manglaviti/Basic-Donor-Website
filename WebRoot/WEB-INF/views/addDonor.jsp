<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<h2> <a href="index.html">Home</a></h2>
		<title>Donor</title>
	</head>
	<body>
		<h2>Please Enter Your Details Below</h2>
		<form:form method="POST" action="/sdnext/save.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">ID:</form:label></td>
			        <td><form:input path="id" value="${donor.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Name:</form:label></td>
			        <td><form:input path="name" value="${donor.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="number">Phone #:</form:label></td>
			        <td><form:input path="number" value="${donor.number}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="address">Address:</form:label></td>
                    <td><form:input path="address" value="${donor.address}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="amount">Amount:</form:label></td>
			        <td><form:input path="amount" value="${donor.amount}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
			      <td>${errMessage}</td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty donors}">
		<h2>All Donors</h2>
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone #</th>
			<th>Address</th>
			<th>Date Donated</th>
			<th>Amount</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="donor">
			<tr>
				<td><c:out value="${donor.id}"/></td>
				<td><c:out value="${donor.name}"/></td>
				<td><c:out value="${donor.number}"/></td>
				<td><c:out value="${donor.address}"/></td>
				<td><c:out value="${donor.ddate}"/></td>
				<td><c:out value="${donor.amount}"/></td>
				<td align="center"><a href="edit.html?id=${donor.id}">Edit</a> | <a href="delete.html?id=${donor.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>
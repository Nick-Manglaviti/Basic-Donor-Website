<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<h2> <a href="index.html">Home</a></h2>

	<form:form method="GET" action="/sdnext/lookup.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">ID:</form:label></td>
			        <td><form:input path="id" placeholder="Enter id" /></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>

	
	  <c:if test="${!empty employee}">
		<h2>Donor</h2>
	<table align="left" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone #</th>
			<th>Address</th>
			<th>Date Donated</th>
			<th>Amount</th>
		</tr>

			<tr>
				<td><c:out value="${donor.d_id}"/></td>
				<td><c:out value="${donor.d_name}"/></td>
				<td><c:out value="${donor.d_number}"/></td>
				<td><c:out value="${donor.d_address}"/></td>
				<td><c:out value="${donor.d_date}"/></td>
				<td><c:out value="${donor.d_amount}"/></td>
			</tr>

	</table>
</c:if>
</body>
</html>
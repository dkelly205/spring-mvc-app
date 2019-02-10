<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		
		<div id="container">
		
			<div id="content">
			
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
				<table>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th></th>
					</tr>
					<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email}</td>
						<td><a href="">Update</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		
		</div>
	</div>
</body>


</html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
				
			<table>
				<tr>
					<th>City</th>
					<th>Address</th>
					<th>Total Capacity</th>
					<th>Free Spaces</th>
					<th>Free Spaces for disabled</th>
					<th>Price</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempParking" items="${parkings}">
				
					<tr>
						<td> ${tempParking.cityName} </td>
						<td> ${tempParking.adress} </td>
						<td> ${tempParking.spacesInTotal} </td>
						<td> ${tempParking.freeSpaces} </td>
						<td> ${tempParking.disabledSpaces} </td>
						<td> ${tempParking.price} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
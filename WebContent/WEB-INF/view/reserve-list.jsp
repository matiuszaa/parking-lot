<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Reservations</title>
	
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
					<th>start date</th>
					<th>end date</th>
					<th>parking adress</th>
					<th>parking spot</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempReservations" items="${reservations}">
				
					<tr>
						<td> ${tempReservations.startDate} </td>
						<td> ${tempReservations.endDate} </td>
						<td> ${tempReservations.parkingAdress} </td>
						<td> ${tempReservations.spaceSignature} </td>
						<c:url var="deleteLink" value="/parking/delete">
							<c:param name="tempReservations" value="${tempReservations}" />
						</c:url>	
						<td>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Register User</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Reserve Parking Spot</h3>
	
		<form:form action="getParkingSpot" modelAttribute="theParking" method="POST">
		
			<br><br>
			
		 	<form:select path="adress">
      			<form:option value="-" label="--Please Select"/>
      			<form:options items="${parkingsy}"/>
			</form:select>

		<tr>
			<td><label></label></td>
			<td><input type="submit" value="Reserve" class="save" /></td>
		</tr>
		
		</form:form>
		

		
		<div style="clear; both;"></div>
		
		
		<p>
			<a href="${pageContext.request.contextPath}/parking/list">Back to List</a>
		</p>
	

	</div>

</body>

</html>

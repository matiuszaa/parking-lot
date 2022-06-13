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
		<h3>Register User</h3>
	
		<form:form action="registerUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" type="password"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Register" class="save" /></td>
					</tr>
					

				</tbody>
			</table>
			
			<br><br>
			
			Disability:
			false <form:radiobutton path="isDisability" value="0"/>
			true <form:radiobutton	path="isDisability" value="1"/>
			<br><br>
			
		 	<form:select path="city">
      			<form:option value="-" label="--Please Select"/>
      			<form:options items="${cities}"/>
			</form:select>

		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>

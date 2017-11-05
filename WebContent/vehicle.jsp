<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="VehicleServlet" method="post">
		<table >
				
					<td>Vehicle No</td>
					<td><input type="text" name="vehicle_no" /></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><input type="text" name="model" /></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><input type="text" name="type" /></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><input type="text" name="company" /></td>
				</tr>
				<tr>
					<td>Insurance Deatils</td>
					<td><input type="text" name="insurance_details" /></td>
				</tr>
			</table>
			<input type="submit" value="register" />
		</form>
	
</body>
</html>
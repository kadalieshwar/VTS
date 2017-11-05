<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DriverServlet" method="post">
		<table >
				
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile" /></td>
				</tr>
				<tr>
					<td>Id Proof</td>
					<td><input type="text" name="id_proof" /></td>
				</tr>
				<tr>
					<td>Licence No</td>
					<td><input type="text" name="lic_no" /></td>
				</tr>
				<tr>
					<td>Exp Licence Date</td>
					<td><input type="text" name="exp_lic_date" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	
</body>
</html>
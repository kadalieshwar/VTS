<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
 <%@page import="java.util.ArrayList"%>
 
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RouteServlet" method="post">
		<table >
				
				<tr>
					<td>Vehicle Details</td>
					<td><select name="vd">
  							<c:forEach var="vehicle" items="${vehicleList}">
  							<option value="${vehicle.vid}"/>${vehicle.vehicle_no}-${vehicle.company }</option>
  							</c:forEach>
						</select></td>
				</tr>
				<tr>
					<td>Driver Details</td>
					<td><select name="dd">
  							<c:forEach var="driver" items="${driverList}">
  							<option value="${driver.did}"/>${driver.name}</option>
  							</c:forEach>
						</select></td>
				</tr>
				<tr>
					<td>Date Of Journey</td>
					<td><input type="text" name="d_o_j" /></td>
				</tr>
				<tr>
					<td>Expected Journey</td>
					<td><input type="text" name="e_j" /></td>
				</tr>
				<tr>
					<td>Actual Journey</td>
					<td><input type="text" name="a_j_d" /></td>
				</tr>
				<tr>
					<td>Route Details</td>
					<td><select name="rod">
  							<option >Bangalore to Vijayawada via Tirupati</option>
  							<option >Bangalore to Vijayawada via Ananthapur</option>
						</select></td>
					
				</tr>
				<tr>
					<td>Source</td>
					<td><select name="s">
  							<option value="bangalore">Bangalore</option>
  							<option value="tirupati">Tirupati</option>
 							<option value="ongole">Ongole</option>
  							<option value="vijayawada">Vijayawada</option>
						</select></td>
					
				</tr>
				<tr>
					<td>Destination</td>
					<td><select name="de">
  							<option value="bangalore">Bangalore</option>
  							<option value="tirupati">Tirupati</option>
 							<option value="ongole">Ongole</option>
  							<option value="vijayawada">Vijayawada</option>
						</select></td>
					
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>

</body>
</html>
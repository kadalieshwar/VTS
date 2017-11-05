<%@page import="dto.RouteDTO"%>
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
<table>
 <c:forEach var="route" items="${list}">
  <tr>
  <td><c:out value="${route.rid}"/></td>
  	<td><c:out value="${route.vehicle_id}"/></td>
  	<td><c:out value="${route.driver_id}"/></td>
  	<td><c:out value="${route.d_o_j}"/></td>
  	<td><c:out value="${route.e_j}"/></td>
  	<td><c:out value="${route.a_j_d}"/></td>
  	<td><c:out value="${route.route_details}"/></td>
  	<td><c:out value="${route.source}"/></td>
  	<td><c:out value="${route.destination}"/></td>
  
  	
  </tr>
</c:forEach>

</table>

</body>
</html>



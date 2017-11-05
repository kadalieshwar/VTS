<%@page import="dto.DriverDTO"%>
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
 <c:forEach var="driver" items="${list}">
  <tr>
  <td><c:out value="${driver.did}"/></td>
  	<td><c:out value="${driver.name}"/></td>
  	<td><c:out value="${driver.address}"/></td>
  	<td><c:out value="${driver.mobile}"/></td>
  	<td><c:out value="${driver.id_proof}"/></td>
  	<td><c:out value="${driver.lic_no}"/></td>
  	<td><c:out value="${driver.exp_lic_date}"/></td>
  	
  </tr>
</c:forEach>

</table>

</body>
</html>



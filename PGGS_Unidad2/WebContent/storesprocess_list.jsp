<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StoresProcess</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="StoreProcessController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Pid</th>
			 <th>State</th>
			 <th>Type</th>
			  <th>Version</th>
			  <th>Du</th>
			
		</tr>
		<c:forEach var="storeprocess" items="${storesprocess}">
		
		<tr>
			<td>
				<form action= "StoreProcessController">
					<input type = "hidden" name = "pid" value= "${storeprocess.pid}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${storeprocess.pid}</td>
			<td> ${storeprocess.state}</td>
			<td> ${storeprocess.type}</td>
			<td> ${storeprocess.version}</td>
			<td> ${storeprocess.du}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>
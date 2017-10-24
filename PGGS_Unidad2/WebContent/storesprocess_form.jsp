<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evidence Form</title>
</head>
<body>

<form action="StoreProcessController">

		<label>State:</label><br>
		<input type = "text" name= "state" value = "${storeprocess.state}" /><br>
		
		<label>Type:</label><br>
		<input type = "text" name= "type" value = "${storeprocess.type}" /><br>
		
		<label>Version:</label><br>
		<input type = "text" name= "version" value = "${storeprocess.version}" /><br>
		
		<label>Du:</label><br>
		<input type = "text" name= "du" value = "${storeprocess.du}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>

</form>

</body>
</html>
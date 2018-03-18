<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login with Spring MVC</title>
</head>
<body>


${message}
<s:form method="POST" modelAttribute="acc" action="logins.do">

	<table cellpadding="2",cellspacing="2">
		<tr>
			<td>User Name: </td>
			<td> <s:input path="username"></s:input></td>
		</tr>
	    <tr>
			<td>Password: </td>
			<td> <s:password path="password"></s:password></td>
		</tr>
		
		<tr>
			<td>&nbsp; </td>
			<td> <input type="submit" value="Login" /></td>
		</tr>
	</table>
</s:form>

</body>
</html>
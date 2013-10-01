<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=(String) request.getSession().getAttribute("messageTitle")%></title>
</head>
<body>

	<form
		action="<%=(String) request.getSession().getAttribute("goToServlet")%>"
		method="get">

		<p>
			<b><%=(String) request.getSession().getAttribute("messageBody")%>
			</b>
		</p>
		<p>
			<input type="submit" id="Button1" name="" value="OK"
				style="position: absolute; width: 96px; height: 25px;">
		</p>
	</form>
</body>
</html>










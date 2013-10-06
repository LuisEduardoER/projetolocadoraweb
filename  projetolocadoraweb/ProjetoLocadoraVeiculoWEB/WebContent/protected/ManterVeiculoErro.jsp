<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=(String)request.getSession().getAttribute("errorTitle") %></title>
</head>
<body>

<% 
	String erro = (String)request.getSession().getAttribute("erro");
%>

<p><b>Ocorreu um erro no sistema: </b></p>
<p><%=erro%></p>

</body>
</html>
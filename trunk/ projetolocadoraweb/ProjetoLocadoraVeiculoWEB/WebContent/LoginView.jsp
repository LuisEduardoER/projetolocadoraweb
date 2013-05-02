<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agencia"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<style type="text/css">
		label {
			font-family: arial, helvetica, sans-serif;
			font-size: 13;
		}
		input {
			font-style: normal;
			font-family: sans-serif;
			border-style: solid;
		}
	</style>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<form action="login" method="POST">
				
		<p>
			<b>Usuario: </b><input type="text" name="usuario" />
		</p>
		<p>
			<b>Senha: </b><input type="password" name="senha" />
		</p>

		<!-- Barra de Idiomas -->
		<select name=mytextarea>
			<option name=portugues value=portugues>Português</option>
			<option name=inglês value=inglês>Inglês</option>
			<option name=espanhol value=espanhol>Espanhol</option>
		</select>

		<!-- Barra de Agencias -->
		<p>
			<select name="cbAgencia">
				<%
					List retorno = (ArrayList) request.getSession().getAttribute(
							"listaAgencias");
					for (Iterator<Agencia> it = retorno.iterator(); it.hasNext();) {
						Agencia ag = (Agencia) it.next();
				%>
				<option name=<%=ag.getNome()%> value=<%=ag.getCodigo()%>><%=ag.getNome()%></option>
				<%
					}
				%>
			</select>
		<p>
			<input type="submit" name="logar" value="Logar">		
		</p>

	</form>

</body>
</html>

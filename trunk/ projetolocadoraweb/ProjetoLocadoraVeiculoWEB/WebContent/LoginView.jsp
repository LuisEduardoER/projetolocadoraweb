<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agencia"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<style>
body {
	background-color: #11a6d4;
}
/*-----------------------------------------------------------*/
#login-box {
	background-color: #1992b7;
	width: 380px;
	height: 320px;
	margin: 140px auto 0px;
	border-radius: 10px;
}
/*-----------------------------------------------------------*/
#login-box-interno {
	width: 360px;
	height: 300px;
	background-color: #fdfdfd;
	position: absolute;
	margin: 10px;
	border-radius: 5px;
	box-shadow: 0px 0px 5px black;
	overflow: hidden;
}
/*-----------------------------------------------------------*/
#login-box-label {
	background-color: #E0EAFF;
	/*Cor e sombra envolta do texto*/
	color: 555555;
	text-shadow: 1px 0px 3px #dedede;
	/*Comprimento da parte mais escura onde esta o texto*/
	height: 45px;
	/*Alinha o Texto no centro*/
	text-align: center;
	font: bold 14px/45px sans-serif;
	/**/
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom: 1px solid white;
	/*Risco preto na parte inferior*/
	border-bottom: 1px solid #C2C2C2;
	box-shadow: 1px 0px 3px #dedede;
}
/*-----------------------------------------------------------*/
.input-div {
	margin: 20px;
	padding: 5px;
	background-color: #f2f5f7;
	border-radius: 3px;
}
/*-----------------------------------------------------------*/
.input-div input {
	width: 310px;
	height: 35px;
	padding-left: 5px;
	font: normal 13px sans-serif;
	color: #aeaeae;
	border-radius: 3px;
	border: 1px solid #bfc4c6;
	outline: none;
}
/*-----------------------------------------------------------*/
.input-div:hover {
	background-color: #e0f1fc;
}
/*-----------------------------------------------------------*/
.input-div:hover input {
	border-color: #7dc6dd;
}
/*-----------------------------------------------------------*/
#senha {
	margin-top: -10px;
}
/*-----------------------------------------------------------*/
#botoes {
	width: 310px;
	margin-left: 25px;
}
/*-----------------------------------------------------------*/
#botao {
	float: right; <!-- Botao na msm linha do lebrar senha -->
	background-color: #aeaeae;
	color: #527988;
	padding: 5px 15px; /* Tamanho alt. larg. */ font : bold 12px
	sans-serif;
	border-radius: 20px;
	text-shadow: 0px 1px 0px white;
	border: 1px solid #9eb9c3;
	box-shadow: 0px 0px 10px #c9c9c9;
	cursor: pointer;
}
/*-----------------------------------------------------------*/
#botao:hover {
	color: black;
	background-color: #E0EAFF;
}
/*-----------------------------------------------------------*/
#lembrar-senha {
	font: normal 12px sans-serif;
}
/*----CBOX------------------------------------------------------*/
#cb-idioma {
	padding: 1px 10px;
	border-radius: 10px;
	font: normal 12px sans-serif;
	color: #757575;
	border: 1px solid #c9c9c9;
}
/*-----------------------------------------------------------*/
#cb-agencia {
	padding: 1px 20px;
	border-radius: 10px;
	font: normal 12px sans-serif;
	color: #757575;
	border: 1px solid #c9c9c9;
	float: right;
}
/*-----------------------------------------------------------*/
.input-cbox {
	margin: 20px;
	padding: 2px 5px;
	border-radius: 10px;
}
/*-----------------------------------------------------------*/
.input-cbox input {
	width: 310px;
	height: 35px;
	padding-left: 5px;
	font: normal 13px sans-serif;
	color: #aeaeae;
	border-radius: 3px;
	border: 1px solid #bfc4c6;
}
/*-----------------------------------------------------------*/
.input-cbox:hover {
	/*background-color: #e0f1fc;  COLOCA UM FUNDO AZUL ATRAZ DOS COMBO BOX*/
}
/*-----------------------------------------------------------*/
.input-cbox:hover input {
	border-color: #7dc6dd;
}
/*-----------------------------------------------------------*/
</style>
</head>
<body>
	<form action="login" method="POST">
		<div id="login-box">
			<div id="login-box-interno">

				<div id="login-box-label">Login</div>

				<div class="input-div" id="usuario">
					<input type="text" value="Usuario ou Email" name="usuario"/>
				</div>

				<div class="input-div" id="senha">
					<input type="password" value="Senha" name="senha" />
				</div>

				<!-- Barra de Idiomas _________________________________________________________________________-->
				<div class="input-cbox" id="cbox-idioma">
					<select id="cb-idioma">
						<option name=portugues value=portugues>Português</option>
						<option name=inglês value=inglês>Inglês</option>
						<option name=espanhol value=espanhol>Espanhol</option>
					</select>

					<!-- Barra de Agencias ____________________________________________________________________-->
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
				</div>

				<!-- _________________________________________Botoes____________________________________________-->
				<div id="botoes">
				
				<!-- _________________________________________Botao Logar________________________________________-->
					<input id="botao" type="submit" name="logar" value="Logar"/>
					
				<!-- ____________________________________Lembrar senha___________________________________________-->
					<div id="lembrar-senha">
						<input type="checkbox" /> Lembrar minha senha
					</div>
				</div>
			</div>
	</form>
</body>
</html>

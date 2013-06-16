<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%@page import="model.PessoaFisica"%><html>
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
	.tableDados {
		table-layout: auto;
		border-collapse: collapse;
		border-color: #0000FF;
		border-width: 0;
		border-style: solid;
		font-size: 12;
		font-style: normal;
		font-family: sans-serif;
		width: 800px;	
	}
	.tdDados {
		border-color: #0000FF;
		border-width: 1;
		border-style: solid;
		empty-cells: show;	
	}
	.trHeader{
		border-color: #0000FF;
		background-color: #FFC0CB;
		border-width: 1;
		border-style: solid;
	}
	button {
		border-style: groove;
		border-color: #8B6914;
		font-style: normal;
	}
	</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Veículos</title>
</head>
<body>
	<jsp:useBean id="clienteSelecionado" class="model.PessoaFisica" scope="session"/>

	<form action="manterCliente" method="POST">
		<input type="hidden" name="operacao" value="salvarAlteracao">
		<table>
			<tbody>
				<tr>
					<td colspan="2"><label><b>Alteração</b></label></td>
				</tr>
			
				<tr>
					<td><label>Id</label></td>
					<td><input readonly="true" type="text" maxlength="5" size="5" tabindex="1" name="id"
						value="<jsp:getProperty name='clienteSelecionado' property='id' />"></td>
				</tr>			
				<tr>
					<td><label>Nome</label></td>
					<td>
					 <input type="text" maxlength="20" size="20" tabindex="2" name="nome" 
					 	value="<jsp:getProperty name='clienteSelecionado' property='nome' />"></td>
				</tr>
				<tr>
					<td><label>RA</label></td>
					<td><input type="text" maxlength="7" size="10" tabindex="3" name="ra"
						value="<jsp:getProperty name='clienteSelecionado' property='ra' />"></td>
				</tr>

				<tr>
					<td colspan="2">
						<button type="submit" name="salvar" tabindex="13">Salvar</button>
						<button type="reset" name="limpar" tabindex="14">Limpar</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
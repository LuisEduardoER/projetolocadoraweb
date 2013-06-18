<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="model.PessoaFisica"%>
<%@page import="java.util.ArrayList"%>
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

	<script language="JavaScript">
		function executar(form,operacao){
				form.operacao.value = operacao;
				form.submit();
		}
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Clientes</title>
	</head>

	<body>
	
	<form  action="manterCliente" method="POST">
		<input type="hidden" name="operacao" value="consultar">
		
		<table>
			<tbody>
				
				<tr>
					<td><label>CPF (Somente Números)</label></td>
					<td><input type="text" maxlength="11" size="11" tabindex="0" name="cpf"></td>
				</tr>
						
				<tr>
					<td colspan="2">
						<INPUT TYPE="submit" NAME="pesquisar" Value="Pesquisar" >
						<button type="reset" name="limpar">Limpar</button>
						<INPUT TYPE="button" NAME="incluir" Value="Incluir" onclick="executar(this.form,'incluir')">
						<INPUT TYPE="button" NAME="alterar" Value="Alterar" onclick="executar(this.form,'alterar')">
					</td>
				</tr>
			</tbody>
		</table>	
	</form>
	</body>
</html>

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
					<td><label>Nome</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="nome"></td>
				</tr>
				<tr>
				<tr>
					<td><label>CPF</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="cpf"></td>
				</tr>
				<tr>
					<td><label>RG</label></td>
					<td><input type="text" maxlength="7" size="10" tabindex="1" name="rg"></td>
				</tr>
                <tr>
					<td><label>Data de Nascimento</label></td>
					<td><input type="date" maxlength="60" size="60" tabindex="0" name="dtaNascimento"></td>
				</tr>
				<tr>
					<td><label>Telefone</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="fone"></td>
				</tr>
				<tr>
					<td><label>E-mail</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="email"></td>
				</tr>
                <tr>
					<td><label>Sexo (M,F)</label></td>
					<td><input type="text" maxlength="1" size="1" tabindex="0" name="sexo"></td>
				</tr>
                <tr>
					<td><label>Número da Habilitação</label></td>
					<td><input type="text" maxlength="11" size="11" tabindex="0" name="nroHabilitacao"></td>
				</tr>
                <tr>
					<td><label>Estado Emissor</label></td>
					<td><input type="text" maxlength="2" size="2" tabindex="0" name="estadoEmissor"></td>
				</tr>
                <tr>
					<td><label>Data da Primeira Habilitação</label></td>
					<td><input type="date" maxlength="60" size="60" tabindex="0" name="primeiraHabilitacao"></td>
				</tr>
                <tr>
					<td><label>Validade da Habilitação</label></td>
					<td><input type="date" maxlength="6" size="6" tabindex="0" name="valHabilitacao"></td>
				</tr>
							
				<tr>
					<td colspan="2">
						<INPUT TYPE="submit" NAME="pesquisar" Value="Pesquisar" >
						<button type="reset" name="limpar">Limpar</button>
					</td>
				</tr>
			</tbody>
		</table>

		<table class="tableDados">
		  <tr align="center" class="trHeader">
		    <td width="10px" class="tdDados">&nbsp;</td>
		    <td width="20px" class="tdDados">ID</td>
		    <td width="20px" class="tdDados">Nome</td>
		    <td width="20px" class="tdDados">RG</td>
		  </tr>
		  <%
		  	PessoaFisica pf = (PessoaFisica)request.getSession().getAttribute("ListaCliente");
		  %>
			  <tr align="center">
			    <td width="10px" class="tdDados">
			    	<input type="radio" name="item" checked="checked" value="<%=pf.getIdPF()%>"></td>
			    <td width="20px" class="tdDados"><%=pf.getId()%></td>
			    <td width="20px" class="tdDados"><%=pf.getNome()%></td>
			    <td width="20px" class="tdDados"><%=pf.getRg()%></td>
			  </tr>  
			<tr>
	   		
			</tr>		    	  
		</table>
	</form>
	</body>
</html>

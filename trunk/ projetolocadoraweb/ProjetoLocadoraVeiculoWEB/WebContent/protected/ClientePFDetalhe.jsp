<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%@page import="model.PessoaFisica"%>
<%@page import="java.util.List"%><html>
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

	<form action="manterCliente" method="post">
		<input type="hidden" name="operacao" value="excluir">
		<table>
			<tbody>
				<%
  					PessoaFisica pf = (PessoaFisica)request.getSession().getAttribute("ListaCliente");
				%>
				<tr>
					<td colspan="2"><label><b>Detalhe do Cliente</b></label></td>
				</tr>
				<tr>
					<td><label>Nome</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="nome" value="<%=pf.getNome()%>"></td>
				</tr>
				<tr>
					<td><label>CPF</label></td>
					<td><input type="text" maxlength="11" size="11" tabindex="0" name="cpf" value="<%=pf.getRegistro()%>"></td>
				</tr>
				<tr>
					<td><label>RG</label></td>
					<td><input type="text" maxlength="10" size="10" tabindex="1" name="rg" value="<%=pf.getRg()%>"></td>
				</tr>
                <tr>
					<td><label>Data de Nascimento</label></td>
					<td><input type="date" maxlength="9" size="9" tabindex="0" name="dtaNascimento" value="<%=pf.getDtaNascimento()%>"></td>
				</tr>
				<tr>
					<td><label>Telefone</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="fone" value="<%=pf.getTelefone()%>"></td>
				</tr>
				<tr>
					<td><label>E-mail</label></td>
					<td><input type="text" maxlength="60" size="60" tabindex="0" name="email" value="<%=pf.getEmail()%>"></td>
				</tr>
                <tr>
					<td><label>Sexo (M,F)</label></td>
					<td><input type="text" maxlength="1" size="1" tabindex="0" name="sexo" value="<%=pf.getSexo()%>"></td>
				</tr>
                <tr>
					<td><label>Número da Habilitação</label></td>
					<td><input type="text" maxlength="11" size="11" tabindex="0" name="nroHabilitacao" value="<%=pf.getNumHabilitacao()%>"></td>
				</tr>
                <tr>
					<td><label>Estado Emissor</label></td>
					<td><input type="text" maxlength="2" size="2" tabindex="0" name="estadoEmissor" value="<%=pf.getEstadoEmissor()%>"></td>
				</tr>
                <tr>
					<td><label>Data da Primeira Habilitação</label></td>
					<td><input type="date" maxlength="9" size="9" tabindex="0" name="primeiraHabilitacao" value="<%=pf.getPrimeiraHabilitacao()%>"></td>
				</tr>
                <tr>
					<td><label>Validade da Habilitação</label></td>
					<td><input type="date" maxlength="9" size="9" tabindex="0" name="valHabilitacao" value="<%=pf.getValidadeCartMotorista()%>"></td>
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
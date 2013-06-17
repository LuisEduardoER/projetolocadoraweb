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
<title>Alterar Dados do Cliente</title>
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
						<button type="submit" name="salvar" tabindex="13">Salvar</button>
						<button type="reset" name="limpar" tabindex="14">Limpar</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
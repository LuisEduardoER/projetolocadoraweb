<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Cliente"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="JavaScript">

		function executar(form,operacao){
				form.operacao.value = operacao;
				form.submit();
		}
		
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Cliente</title>
<meta name="generator"
	content="WYSIWYG Web Builder 8 - http://www.wysiwygwebbuilder.com">
<style type="text/css">
body {
	background-color: #FFFFFF;
	color: #000000;
}
</style>
<style type="text/css">
a {
	color: #C8D7EB;
	text-decoration: underline;
}

a:visited {
	color: #C8D7EB;
}

a:active {
	color: #C8D7EB;
}

a:hover {
	color: #376BAD;
	text-decoration: underline;
}
</style>
<style type="text/css">
#wb_txtCpnjCpf1_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCpnjCpf1_id div {
	text-align: left;
}

#btnPesquisar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#lblCpnjCpf1_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#Line1 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#wb_txtNome_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtNome_id div {
	text-align: left;
}

#wb_txtCpnjCpf2_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCpnjCpf2_id div {
	text-align: left;
}

#wb_txtTelefone_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtTelefone_id div {
	text-align: left;
}

#wb_txtEmail_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtEmail_id div {
	text-align: left;
}

#Line2 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#btnCancelar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnAlterar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnLocar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnDetalhes_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#lblNome_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCpnjCpf2_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblTelefone_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblEmail_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}
</style>
</head>
<body>
  <%Cliente cliente = (Cliente) request.getSession().getAttribute("clienteSelecionado");%>
  <form action="fc" method="POST">
    <input type="hidden" name="operacao" value="consultarCliente">
	<div id="wb_txtCpnjCpf1_id"
		style="position: absolute; left: 60px; top: 100px; width: 250px; height: 32px; z-index: 0;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF<br></span>
	</div>
	<input type="button" id="btnPesquisar_id" name="" value="Pesquisar"
		style="position: absolute; left: 400px; top: 100px; width: 96px; height: 25px; z-index: 1;"
		onclick="executar(this.form,'consultarCliente')">
	<input type="text" id="lblCpnjCpf1_id"
		style="position: absolute; left: 180px; top: 100px; width: 178px; height: 19px; line-height: 19px; z-index: 2;"
		name="txtCnpjCpf" value="">
	<hr id="Line1"
		style="margin: 0; padding: 0; position: absolute; left: 1px; top: 199px; width: 1000px; height: 1px; z-index: 3;">
	<div id="wb_txtNome_id"
		style="position: absolute; left: 60px; top: 300px; width: 250px; height: 16px; z-index: 4;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Nome</span>
	</div>
	<div id="wb_txtCpnjCpf2_id"
		style="position: absolute; left: 60px; top: 350px; width: 250px; height: 32px; z-index: 5;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF<br></span>
	</div>
	<div id="wb_txtTelefone_id"
		style="position: absolute; left: 60px; top: 400px; width: 250px; height: 16px; z-index: 6;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Telefone</span>
	</div>
	<div id="wb_txtEmail_id"
		style="position: absolute; left: 60px; top: 450px; width: 250px; height: 16px; z-index: 7;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">E-mail</span>
	</div>
	<hr id="Line2"
		style="margin: 0; padding: 0; position: absolute; left: 0px; top: 528px; width: 1000px; height: 1px; z-index: 8;">
	<input type="button" id="btnCancelar_id" name="" value="Cancelar"
		style="position: absolute; left: 200px; top: 600px; width: 96px; height: 25px; z-index: 9;"
		onclick="executar(this.form,'cancelarConsultaCliente')">
	<input type="button" id="btnAlterar_id" name="" value="Alterar"
		style="position: absolute; left: 400px; top: 600px; width: 96px; height: 25px; z-index: 10;"
		onclick="executar(this.form,'detalhesConsultaCliente')">
	<input type="button" id="btnLocar_id" name="btnLocar" value="Locar"
		style="position: absolute; left: 600px; top: 600px; width: 96px; height: 25px; z-index: 11;" 
		onclick="executar(this.form,'locarCliente')">
	<input type="button" id="btnDetalhes_id" name="" value="+ Detalhes"
		style="position: absolute; left: 400px; top: 300px; width: 96px; height: 25px; z-index: 12;"
		onclick="executar(this.form,'detalhesConsultaCliente')">
	<input type="text" id="lblNome_id"
		style="position: absolute; left: 180px; top: 300px; width: 94px; height: 19px; line-height: 19px; z-index: 13;"
		name="Editbox2" value="<%=cliente.getNome()%>">
	<input type="text" id="lblCpnjCpf2_id"
		style="position: absolute; left: 180px; top: 350px; width: 94px; height: 19px; line-height: 19px; z-index: 14;"
		name="Editbox2" value="<%=cliente.getRegistro()%>">
	<input type="text" id="lblTelefone_id"
		style="position: absolute; left: 180px; top: 400px; width: 94px; height: 19px; line-height: 19px; z-index: 15;"
		name="Editbox2" value="<%=cliente.getTelefone()%>">
	<input type="text" id="lblEmail_id"
		style="position: absolute; left: 180px; top: 450px; width: 94px; height: 19px; line-height: 19px; z-index: 16;"
		name="Editbox2" value="<%=cliente.getEmail()%>">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente Editar PJ</title>
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
#wb_txtDadosPessoais_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDadosPessoais_id div {
	text-align: left;
}

#wb_Text2 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text2 div {
	text-align: left;
}

#wb_txtRazaoSocial_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtRazaoSocial_id div {
	text-align: left;
}

#wb_txtNomeFantasia_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtNomeFantasia_id div {
	text-align: left;
}

#wb_txtCnpj_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCnpj_id div {
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

#Line1 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#btnVoltar_id {
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

#btnExcluir_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
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

#lblTelefone_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCnpj_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblRazaoSocial_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblNomeFantasia_id {
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
	<div id="wb_txtDadosPessoais_id"
		style="position: absolute; left: 290px; top: 40px; width: 250px; height: 19px; z-index: 0;">
		<span style="color: #000000; font-family: Arial; font-size: 16px;"><strong>Dados
				Pessoais</strong></span>
	</div>
	<div id="wb_Text2"
		style="position: absolute; left: 65px; top: 215px; width: 250px; height: 16px; z-index: 1;">
		&nbsp;</div>
	<div id="wb_txtRazaoSocial_id"
		style="position: absolute; left: 60px; top: 100px; width: 250px; height: 16px; z-index: 2;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Razão
			Social</span>
	</div>
	<div id="wb_txtNomeFantasia_id"
		style="position: absolute; left: 60px; top: 150px; width: 250px; height: 16px; z-index: 3;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Nome
			Fantasia</span>
	</div>
	<div id="wb_txtCnpj_id"
		style="position: absolute; left: 60px; top: 200px; width: 250px; height: 16px; z-index: 4;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ</span>
	</div>
	<div id="wb_txtTelefone_id"
		style="position: absolute; left: 60px; top: 250px; width: 250px; height: 16px; z-index: 5;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Telefone</span>
	</div>
	<div id="wb_txtEmail_id"
		style="position: absolute; left: 60px; top: 300px; width: 250px; height: 16px; z-index: 6;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">E-mail</span>
	</div>
	<hr id="Line1"
		style="margin: 0; padding: 0; position: absolute; left: 0px; top: 410px; width: 1000px; height: 1px; z-index: 7;">
	<input type="submit" id="btnVoltar_id" name="" value="Voltar"
		style="position: absolute; left: 100px; top: 500px; width: 96px; height: 25px; z-index: 8;">
	<input type="submit" id="btnAlterar_id" name="" value="Alterar"
		style="position: absolute; left: 300px; top: 500px; width: 96px; height: 25px; z-index: 9;">
	<input type="submit" id="btnLocar_id" name="" value="Locar"
		style="position: absolute; left: 700px; top: 500px; width: 96px; height: 25px; z-index: 10;">
	<input type="submit" id="btnExcluir_id" name="" value="Excluir"
		style="position: absolute; left: 500px; top: 500px; width: 96px; height: 25px; z-index: 11;">
	<input type="text" id="lblEmail_id"
		style="position: absolute; left: 200px; top: 300px; width: 94px; height: 19px; line-height: 19px; z-index: 12;"
		name="Editbox1" value="">
	<input type="text" id="lblTelefone_id"
		style="position: absolute; left: 200px; top: 250px; width: 94px; height: 19px; line-height: 19px; z-index: 13;"
		name="Editbox1" value="">
	<input type="text" id="lblCnpj_id"
		style="position: absolute; left: 200px; top: 200px; width: 94px; height: 19px; line-height: 19px; z-index: 14;"
		name="Editbox1" value="">
	<input type="text" id="lblRazaoSocial_id"
		style="position: absolute; left: 200px; top: 100px; width: 94px; height: 19px; line-height: 19px; z-index: 15;"
		name="Editbox1" value="">
	<input type="text" id="lblNomeFantasia_id"
		style="position: absolute; left: 200px; top: 150px; width: 94px; height: 19px; line-height: 19px; z-index: 16;"
		name="Editbox1" value="">
</body>
</html>
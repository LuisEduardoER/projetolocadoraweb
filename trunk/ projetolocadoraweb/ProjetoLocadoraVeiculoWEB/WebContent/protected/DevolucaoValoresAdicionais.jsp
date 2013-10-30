<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Locacao"%>
<%@page import="model.Devolucao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agencia"%>
<%@page import="util.DataFormatada"%>
<%@page import="util.Conversao"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="JavaScript">
	function executar(form,operacao){
			form.operacao.value = operacao;
			form.submit();
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devolver Veículo - Valores Adicionais</title>
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
#wb_txtNumero_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtNumero_id div {
	text-align: left;
}

#wb_txtCliente_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCliente_id div {
	text-align: left;
}

#wb_txtCnpjCpf_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCnpjCpf_id div {
	text-align: left;
}

#Line1 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#wb_txtValoresAdicionais_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtValoresAdicionais_id div {
	text-align: left;
}

#Line2 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#Line3 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#Line4 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#Line5 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#Line6 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#btnVoltar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnAvancar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#lblNumero_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCliente_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCnpjCpf_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_txtAcrescimo_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtAcrescimo_id div {
	text-align: left;
}

#wb_txtDecrescimo_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDecrescimo_id div {
	text-align: left;
}

#Line7 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#Line8 {
	color: #000000;
	background-color: #000000;
	border-width: 0px;
}

#wb_txtDataDevolucao_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDataDevolucao_id div {
	text-align: left;
}

#wb_txtCidadeDevolucao_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCidadeDevolucao_id div {
	text-align: left;
}

#wb_txtAgenciaDevolucao_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtAgenciaDevolucao_id div {
	text-align: left;
}

#wb_txtDataDevolucao_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDataDevolucao_id div {
	text-align: left;
}

#wb_txtSubTotal_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtSubTotal_id div {
	text-align: left;
}

#wb_txtSubTotal_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtSubTotal_id div {
	text-align: left;
}

#lblDataDevolucao_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblAgenciaDevolucao_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCidadeDevolucao_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblSubTotal_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblSubTotal_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblDataDevolucao_id {
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
		<%Devolucao devolucao = (Devolucao) request.getSession().getAttribute("devolucao");%>
		<form action="fc" method="POST">
			<input type="hidden" name="operacao" value="avancarDevolucaoValAdicionais">
		<div id="wb_txtNumero_id"
			style="position: absolute; left: 60px; top: 60px; width: 250px; height: 16px; z-index: 0;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Número</span>
		</div>
		<div id="wb_txtCliente_id"
			style="position: absolute; left: 60px; top: 100px; width: 250px; height: 16px; z-index: 1;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cliente</span>
		</div>
		<div id="wb_txtCnpjCpf_id"
			style="position: absolute; left: 400px; top: 100px; width: 250px; height: 16px; z-index: 2;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF</span>
		</div>
		<div id="wb_txtCnpjCpf_id"
			style="position: absolute; left: 740px; top: 100px; width: 250px; height: 16px; z-index: 3;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Total</span>
		</div>
		<hr id="Line1"
			style="margin: 0; padding: 0; position: absolute; left: 0px; top: 176px; width: 1000px; height: 1px; z-index: 3;">
		<div id="wb_txtValoresAdicionais_id"
			style="position: absolute; left: 151px; top: 217px; width: 250px; height: 14px; z-index: 4;">
			<span style="color: #000000; font-family: Arial; font-size: 11px;">Valores Adicionais</span>
		</div>
		<hr id="Line2"
			style="margin: 0; padding: 0; position: absolute; left: 41px; top: 224px; width: 108px; height: 1px; z-index: 5;">
		<hr id="Line3"
			style="margin: 0; padding: 0; position: absolute; left: 253px; top: 224px; width: 541px; height: 1px; z-index: 6;">
		<hr id="Line4"
			style="margin: 0; padding: 0; position: absolute; left: 41px; top: 225px; width: 1px; height: 266px; z-index: 7;">
		<hr id="Line5"
			style="margin: 0; padding: 0; position: absolute; left: 793px; top: 225px; width: 1px; height: 265px; z-index: 8;">
		<hr id="Line6"
			style="margin: 0; padding: 0; position: absolute; left: 41px; top: 490px; width: 753px; height: 1px; z-index: 9;">
		<input type="button" id="btnVoltar_id" name="" value="Voltar"
			style="position: absolute; left: 294px; top: 534px; width: 96px; height: 25px; z-index: 10;"
			onclick="executar(this.form,'voltarDevolucaoValAdicionais')">
		<input type="button" id="btnAvancar_id" name="" value="Avançar"
			style="position: absolute; left: 449px; top: 533px; width: 96px; height: 25px; z-index: 11;"
			onclick="executar(this.form,'avancarDevolucaoValAdicionais')">
		<input type="text" id="lblNumero_id"
			style="position: absolute; left: 120px; top: 60px; width: 94px; height: 19px; line-height: 19px; z-index: 12;"
			name="Editbox1" value="<%=devolucao.getLocacao().getId()%>">
		<input type="text" id="lblCliente_id"
			style="position: absolute; left: 120px; top: 100px; width: 94px; height: 19px; line-height: 19px; z-index: 13;"
			name="Editbox1" value="<%=devolucao.getLocacao().getClienteEscolhido().getNome()%>">
		<input type="text" id="lblCnpjCpf_id"
			style="position: absolute; left: 480px; top: 100px; width: 94px; height: 19px; line-height: 19px; z-index: 14;"
			name="Editbox1" value="<%=devolucao.getLocacao().getClienteEscolhido().getRegistro()%>">
		<input type="text" id="lblCnpjCpf_id"
			style="position: absolute; left: 840px; top: 100px; width: 94px; height: 19px; line-height: 19px; z-index: 15;"
			name="Editbox1" value="<%="R$ " + Conversao.formatDouble(devolucao.getTotal())%>">
		<div id="wb_txtAcrescimo_id"
			style="position: absolute; left: 90px; top: 250px; width: 250px; height: 16px; z-index: 15;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Acréscimo</span>
		</div>
		<div id="wb_txtDecrescimo_id"
			style="position: absolute; left: 480px; top: 250px; width: 250px; height: 16px; z-index: 16;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Decréscimo</span>
		</div>
		<hr id="Line7"
			style="margin: 0; padding: 0; position: absolute; left: 90px; top: 280px; width: 220px; height: 1px; z-index: 17;">
		<hr id="Line8"
			style="margin: 0; padding: 0; position: absolute; left: 480px; top: 280px; width: 220px; height: 1px; z-index: 18;">
		<div id="wb_txtDataDevolucao_id"
			style="position: absolute; left: 90px; top: 300px; width: 250px; height: 16px; z-index: 19;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Data de Devolução</span>
		</div>
		<div id="wb_txtCidadeDevolucao_id"
			style="position: absolute; left: 90px; top: 350px; width: 250px; height: 16px; z-index: 20;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cidade de Devolução</span>
		</div>
		<div id="wb_txtAgenciaDevolucao_id"
			style="position: absolute; left: 90px; top: 400px; width: 250px; height: 16px; z-index: 21;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência de Devolução</span>
		</div>
		<div id="wb_txtDataDevolucao_id"
			style="position: absolute; left: 480px; top: 300px; width: 250px; height: 16px; z-index: 22;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Data de Devolução</span>
		</div>
		<div id="wb_txtSubTotal_id"
			style="position: absolute; left: 90px; top: 450px; width: 250px; height: 16px; z-index: 23;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Sub-Total</span>
		</div>
		<div id="wb_txtSubTotal_id"
			style="position: absolute; left: 480px; top: 450px; width: 250px; height: 16px; z-index: 24;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Sub-Total</span>
		</div>
		<input type="text" id="lblDataDevolucao_id"
			style="position: absolute; left: 250px; top: 300px; width: 78px; height: 19px; line-height: 19px; z-index: 25;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("dataAcrescimo"))%>">
		<input type="text" id="lblAgenciaDevolucao_id"
			style="position: absolute; left: 250px; top: 400px; width: 78px; height: 19px; line-height: 19px; z-index: 26;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("cidadeAcrescimo"))%>">
		<input type="text" id="lblCidadeDevolucao_id"
			style="position: absolute; left: 250px; top: 350px; width: 78px; height: 19px; line-height: 19px; z-index: 27;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("agenciaAcrescimo"))%>">
		<input type="text" id="lblSubTotal_id"
			style="position: absolute; left: 250px; top: 450px; width: 78px; height: 19px; line-height: 19px; z-index: 28;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("dataDecrescimo"))%>">
		<input type="text" id="lblSubTotal_id"
			style="position: absolute; left: 620px; top: 450px; width: 78px; height: 19px; line-height: 19px; z-index: 29;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("subtotalAcrescimo"))%>">
		<input type="text" id="lblDataDevolucao_id"
			style="position: absolute; left: 620px; top: 300px; width: 78px; height: 19px; line-height: 19px; z-index: 30;"
			name="Editbox4" value="<%="R$ " + Conversao.formatDouble((Double) request.getSession().getAttribute("subtotalDecrescimo"))%>">
		</form>
	</body>
</html>
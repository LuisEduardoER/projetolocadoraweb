<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Locacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agencia"%>
<%@page import="util.DataFormatada"%>
<%@page import="util.Conversao"%>

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
<title>Realizar Locação - Dados Locação</title>
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
#wb_Form1 {
	background-color: #FAFAFA;
	border: 1px #000000 solid;
	-moz-border-radius: 1px;
	-webkit-border-radius: 1px;
	border-radius: 1px;
	-moz-box-shadow: 1px 1px 1px #000000;
	-webkit-box-shadow: 1px 1px 1px #000000;
	box-shadow: 1px 1px 1px #000000;
}

#wb_Text1 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text1 div {
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

#wb_Text3 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text3 div {
	text-align: left;
}

#wb_Text4 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text4 div {
	text-align: left;
}

#wb_Text5 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text5 div {
	text-align: left;
}

#wb_Text6 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text6 div {
	text-align: left;
}

#wb_Text7 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text7 div {
	text-align: left;
}

#wb_Text8 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text8 div {
	text-align: left;
}

#wb_Text9 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text9 div {
	text-align: left;
}

#wb_Text10 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text10 div {
	text-align: left;
}

#wb_Text11 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text11 div {
	text-align: left;
}

#wb_Text12 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text12 div {
	text-align: left;
}

#txtDtaRetirada_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtDtaDevolucao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtTipoTarifa_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtAgenciaRetirada_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtAgenciaDevolucao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtQtdDias_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtTotal_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtGrupo_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtAcessorio_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtVeiculo_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#btnVoltar_ID {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnAvancar_ID {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#Line1 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
}
</style>
</head>
<body>
	<div id="wb_Form1" style="position: absolute; left: 1px; top: 12px; width: 718px; height: 427px; z-index: 24;">
		<%Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");%>
		<form action="fc" method="POST">
			<input type="hidden" name="operacao" value="avancarCalcularLocacao">
			<div id="wb_Text1"
				style="position: absolute; left: 20px; top: 16px; width: 131px; height: 16px; z-index: 0;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Dados da Locação</span>
			</div>
			<div id="wb_Text2"
				style="position: absolute; left: 22px; top: 54px; width: 131px; height: 16px; z-index: 1;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora Retirada:</span>
			</div>
			<div id="wb_Text3"
				style="position: absolute; left: 22px; top: 90px; width: 131px; height: 16px; z-index: 2;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora Devolução:</span>
			</div>
			<div id="wb_Text4"
				style="position: absolute; left: 22px; top: 126px; width: 131px; height: 16px; z-index: 3;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tipo	de Tarifa:</span>
			</div>
			<div id="wb_Text9"
				style="position: absolute; left: 20px; top: 237px; width: 131px; height: 16px; z-index: 4;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Dados do Veículo</span>
			</div>
			<div id="wb_Text10"
				style="position: absolute; left: 21px; top: 272px; width: 131px; height: 16px; z-index: 5;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Grupo:</span>
			</div>
			<input type="text" id="txtDtaRetirada_ID"
				style="position: absolute; left: 160px; top: 54px; width: 126px; height: 19px; line-height: 19px; z-index: 6;"
				name="txtDtaRetirada" value="<%=DataFormatada.parseStringDataCompleta(locacao.getDtaRetirada())%>" tabindex="1" readonly="readonly">
			<input type="text" id="txtDtaDevolucao_ID"
				style="position: absolute; left: 160px; top: 88px; width: 126px; height: 19px; line-height: 19px; z-index: 7;"
				name="txtDtaDevolucao" value="<%=DataFormatada.parseStringDataCompleta(locacao.getDtaPrevDevolucao())%>" tabindex="2" readonly="readonly">
			<input type="text" id="txtTipoTarifa_ID"
				style="position: absolute; left: 160px; top: 121px; width: 94px; height: 19px; line-height: 19px; z-index: 8;"
				name="txtTipoTarifa" value="<%=locacao.getTipoTarifa()%>" tabindex="3" readonly="readonly">
			<input type="text" id="txtGrupo_ID"
				style="position: absolute; left: 101px; top: 271px; width: 94px; height: 19px; line-height: 19px; z-index: 9;"
				name="txtGrupo" value="<%=locacao.getVeiculoEscolhido().getGrupo().getNome()%>" tabindex="8" readonly="readonly">
			<div id="wb_Text11"
				style="position: absolute; left: 23px; top: 308px; width: 131px; height: 16px; z-index: 10;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Acessório:</span>
			</div>
			<input type="text" id="txtAcessorio_ID"
				style="position: absolute; left: 101px; top: 305px; width: 94px; height: 19px; line-height: 19px; z-index: 11;"
				name="txtAcessorio" value="<%=locacao.getVeiculoEscolhido().getTotalAcessorios()%>" tabindex="9" readonly="readonly">
			<div id="wb_Text5"
				style="position: absolute; left: 331px; top: 54px; width: 131px; height: 16px; z-index: 12;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência Retirada:</span>
			</div>
			<div id="wb_Text6"
				style="position: absolute; left: 331px; top: 90px; width: 131px; height: 16px; z-index: 13;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência Devolução:</span>
			</div>
			<div id="wb_Text7"
				style="position: absolute; left: 331px; top: 126px; width: 131px; height: 16px; z-index: 14;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Qtd Dias:</span>
			</div>
			<div id="wb_Text8"
				style="position: absolute; left: 331px; top: 158px; width: 131px; height: 16px; z-index: 15;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Total:</span>
			</div>
			<input type="button" id="btnVoltar_ID" name="btnVoltar" value="Voltar"
				style="position: absolute; left: 380px; top: 297px; width: 96px; height: 25px; z-index: 16;" tabindex="11" onclick="executar(this.form,'voltarCalcularLocacao')"> 
			<input type="text" id="txtQtdDias_ID"
				style="position: absolute; left: 461px; top: 124px; width: 75px; height: 19px; line-height: 19px; z-index: 17;"
				name="txtQtdDias" value="<%=locacao.getQtdDias()%>" tabindex="6" readonly="readonly">
			<div id="wb_Text12"
				style="position: absolute; left: 22px; top: 342px; width: 131px; height: 16px; z-index: 18;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Veículo:</span>
			</div>
			<input type="text" id="txtVeiculo_ID"
				style="position: absolute; left: 101px; top: 340px; width: 94px; height: 19px; line-height: 19px; z-index: 19;"
				name="txtVeiculo" value="<%=locacao.getVeiculoEscolhido().getModelo()%>" tabindex="10" readonly="readonly">
			<input type="text" id="txtTotal_ID"
				style="position: absolute; left: 461px; top: 160px; width: 94px; height: 19px; line-height: 19px; z-index: 20;"
				name="txtTotal" value="<%="R$ " + Conversao.formatDouble(locacao.getTotal()) %>" tabindex="7" readonly="readonly"> 
			<input
				type="submit" id="btnAvancar_ID" name="btnAvancar" value="Avançar"
				style="position: absolute; left: 491px; top: 297px; width: 96px; height: 25px; z-index: 21;"
				tabindex="12"> 
			<input type="text" id="txtAgenciaRetirada_ID"
				style="position: absolute; left: 461px; top: 52px; width: 176px; height: 19px; line-height: 19px; z-index: 22;"
				name="txtAgenciaRetirada" value="<%=locacao.getAgenciaRetirada().getNome()%>" tabindex="4" readonly="readonly">
			<input type="text" id="txtAgenciaDevolucao_ID"
				style="position: absolute; left: 461px; top: 88px; width: 176px; height: 19px; line-height: 19px; z-index: 23;"
				name="txtAgenciaDevolucao" value="<%=locacao.getAgenciaDevolucao().getNome()%>" tabindex="5" readonly="readonly">
		</form>
	</div>
	<hr id="Line1"
		style="margin: 0; padding: 0; position: absolute; left: 0px; top: 221px; width: 718px; height: 1px; z-index: 25;">
</body>
</html>
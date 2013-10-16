<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Locacao"%>
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
<title>Devolver Veículos - Consulta</title>

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
#wb_txtIdLocacao1_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtIdLocacao1_id div {
	text-align: left;
}

#wb_txtCnpjCpf1_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCnpjCpf1_id div {
	text-align: left;
}

#btnConsultar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#lblIdLocacao1_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCnpjCpf1_id {
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

#wb_txtIdLocacao2_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtIdLocacao2_id div {
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

#wb_txtCnpjCpf2_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtCnpjCpf2_id div {
	text-align: left;
}

#wb_txtDataHoraRetirada_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDataHoraRetirada_id div {
	text-align: left;
}

#wb_txtDataHoraDevolucao_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtDataHoraDevolucao_id div {
	text-align: left;
}

#wb_txtTipoTarifa_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtTipoTarifa_id div {
	text-align: left;
}

#wb_txtAgenciaRetirada_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtAgenciaRetirada_id div {
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

#wb_txtQtdDias_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtQtdDias_id div {
	text-align: left;
}

#wb_txtTotal_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtTotal_id div {
	text-align: left;
}

#Line2 {
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

#lblDataHoraRetirada_id {
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

#lblIdLocacao2_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblCnpjCpf2_id {
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

#lblQtdDias_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblAgenciaRetirada_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblTotal_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblDataHoraDevolucao_id {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#lblTipoTarifa_id {
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
		<%Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");%>
		<form action="fc" method="POST">
			<input type="hidden" name="operacao" value="consultarConsultaDevolucao">
			<div id="wb_txtIdLocacao1_id"style="position: absolute; left: 200px; top: 70px; width: 250px; height: 16px; z-index: 0;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">ID Locação</span>
			</div>
			<div id="wb_txtCnpjCpf1_id"
				style="position: absolute; left: 200px; top: 120px; width: 250px; height: 16px; z-index: 1;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF</span>
			</div>
			<input type="submit" id="btnConsultar_id" name="" value="Consultar"
				style="position: absolute; left: 440px; top: 95px; width: 96px; height: 25px; z-index: 2;">
			<input type="text" id="lblIdLocacao1_id"
				style="position: absolute; left: 300px; top: 70px; width: 94px; height: 19px; line-height: 19px; z-index: 3;"
				name="txtIdLocacaoConsulta" value="">
			<input type="text" id="lblCnpjCpf1_id"
				style="position: absolute; left: 300px; top: 120px; width: 94px; height: 19px; line-height: 19px; z-index: 4;"
				name="txtCnpjCpfConsulta" value="">
			<hr id="Line1"
				style="margin: 0; padding: 0; position: absolute; left: 0px; top: 200px; width: 1000px; height: 1px; z-index: 5;">
			<div id="wb_txtIdLocacao2_id"
				style="position: absolute; left: 121px; top: 253px; width: 174px; height: 16px; z-index: 6;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">ID Locação</span>
			</div>
			<div id="wb_txtCliente_id"
				style="position: absolute; left: 120px; top: 300px; width: 250px; height: 16px; z-index: 7;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Cliente</span>
			</div>
			<div id="wb_txtCnpjCpf2_id"
				style="position: absolute; left: 450px; top: 300px; width: 250px; height: 16px; z-index: 8;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF</span>
			</div>
			<div id="wb_txtDataHoraRetirada_id"
				style="position: absolute; left: 120px; top: 400px; width: 250px; height: 16px; z-index: 9;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora Retirada</span>
			</div>
			<div id="wb_txtDataHoraDevolucao_id"
				style="position: absolute; left: 120px; top: 450px; width: 250px; height: 16px; z-index: 10;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora Devolução</span>
			</div>
			<div id="wb_txtTipoTarifa_id"
				style="position: absolute; left: 120px; top: 500px; width: 250px; height: 16px; z-index: 11;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tipo	de Tarifa</span>
			</div>
			<div id="wb_txtAgenciaRetirada_id"
				style="position: absolute; left: 450px; top: 400px; width: 250px; height: 16px; z-index: 12;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência Retirada</span>
			</div>
			<div id="wb_txtAgenciaDevolucao_id"
				style="position: absolute; left: 450px; top: 450px; width: 250px; height: 16px; z-index: 13;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência Devolução</span>
			</div>
			<div id="wb_txtQtdDias_id"
				style="position: absolute; left: 450px; top: 500px; width: 250px; height: 16px; z-index: 14;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Qtd Dias</span>
			</div>
			<div id="wb_txtTotal_id"
				style="position: absolute; left: 450px; top: 600px; width: 250px; height: 16px; z-index: 15;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Total</span>
			</div>
			<hr id="Line2"
				style="margin: 0; padding: 0; position: absolute; left: 0px; top: 650px; width: 1000px; height: 1px; z-index: 16;">
			<input type="button" id="btnVoltar_id" name="" value="Voltar"
				style="position: absolute; left: 300px; top: 690px; width: 96px; height: 25px; z-index: 17;"
				onclick="executar(this.form,'voltarConsultaDevolucao')">
			<input type="button" id="btnAvancar_id" name="" value="Avançar"
				style="position: absolute; left: 500px; top: 690px; width: 96px; height: 25px; z-index: 18;"
				onclick="executar(this.form,'avancarConsultaDevolucao')">
			<input type="text" id="lblDataHoraRetirada_id"
				style="position: absolute; left: 300px; top: 400px; width: 94px; height: 19px; line-height: 19px; z-index: 19;"
				name="Editbox3" value="<%=DataFormatada.parseStringDataCompleta(locacao.getDtaRetirada())%>">
			<input type="text" id="lblCliente_id"
				style="position: absolute; left: 200px; top: 300px; width: 94px; height: 19px; line-height: 19px; z-index: 20;"
				name="Editbox3" value="<%=locacao.getClienteEscolhido().getNome()%>">
			<input type="text" id="lblIdLocacao2_id"
				style="position: absolute; left: 200px; top: 250px; width: 94px; height: 19px; line-height: 19px; z-index: 21;"
				name="Editbox3" value="<%=locacao.getId()%>">
			<input type="text" id="lblCnpjCpf2_id"
				style="position: absolute; left: 550px; top: 300px; width: 94px; height: 19px; line-height: 19px; z-index: 22;"
				name="Editbox3" value="<%=locacao.getClienteEscolhido().getRegistro()%>">
			<input type="text" id="lblAgenciaDevolucao_id"
				style="position: absolute; left: 650px; top: 450px; width: 94px; height: 19px; line-height: 19px; z-index: 23;"
				name="Editbox3" value="<%=locacao.getAgenciaDevolucao().getNome()%>">
			<input type="text" id="lblQtdDias_id"
				style="position: absolute; left: 650px; top: 500px; width: 94px; height: 19px; line-height: 19px; z-index: 24;"
				name="Editbox3" value="<%=locacao.getQtdDias()%>">
			<input type="text" id="lblAgenciaRetirada_id"
				style="position: absolute; left: 650px; top: 400px; width: 94px; height: 19px; line-height: 19px; z-index: 25;"
				name="Editbox3" value="<%=locacao.getAgenciaRetirada().getNome()%>">
			<input type="text" id="lblTotal_id"
				style="position: absolute; left: 550px; top: 600px; width: 94px; height: 19px; line-height: 19px; z-index: 26;"
				name="Editbox3" value="<%="R$ " + Conversao.formatDouble(locacao.getTotal())%>">
			<input type="text" id="lblDataHoraDevolucao_id"
				style="position: absolute; left: 300px; top: 450px; width: 94px; height: 19px; line-height: 19px; z-index: 27;"
				name="Editbox3" value="<%=DataFormatada.parseStringDataCompleta(locacao.getDtaPrevDevolucao())%>">
			<input type="text" id="lblTipoTarifa_id"
				style="position: absolute; left: 300px; top: 500px; width: 94px; height: 19px; line-height: 19px; z-index: 28;"
				name="Editbox3" value="<%=locacao.getTipoTarifa()%>">
		</form>
	</body>
</html>
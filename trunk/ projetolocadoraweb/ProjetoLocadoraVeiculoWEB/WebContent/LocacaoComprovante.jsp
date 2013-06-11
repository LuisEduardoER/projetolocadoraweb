<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realizar Locação - Comprovante</title>
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

#txtDataRetirada_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#txtDataDevolucao_ID {
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

#btnImprimirComprovante_ID {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

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

#Line1 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
}

#wb_Text13 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text13 div {
	text-align: left;
}

#txtNumero_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text14 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text14 div {
	text-align: left;
}

#txtCliente_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text15 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text15 div {
	text-align: left;
}

#txtCnpjCpf_ID {
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
	<div id="wb_Form1"
		style="position: absolute; left: 6px; top: 10px; width: 718px; height: 507px; z-index: 29;">
		<form name="Form1" method="post"
			action="mailto:yourname@yourdomain.com" enctype="text/plain"
			id="Form1">
			<div id="wb_Text1"
				style="position: absolute; left: 24px; top: 17px; width: 131px; height: 16px; z-index: 0;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Dados
					da Locação</span>
			</div>
			<div id="wb_Text2"
				style="position: absolute; left: 23px; top: 147px; width: 131px; height: 16px; z-index: 1;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora
					Retirada:</span>
			</div>
			<div id="wb_Text3"
				style="position: absolute; left: 23px; top: 183px; width: 131px; height: 16px; z-index: 2;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data/Hora
					Devolução:</span>
			</div>
			<div id="wb_Text4"
				style="position: absolute; left: 23px; top: 219px; width: 131px; height: 16px; z-index: 3;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tipo
					de Tarifa:</span>
			</div>
			<div id="wb_Text9"
				style="position: absolute; left: 27px; top: 300px; width: 131px; height: 16px; z-index: 4;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Dados
					do Veículo</span>
			</div>
			<div id="wb_Text10"
				style="position: absolute; left: 28px; top: 335px; width: 131px; height: 16px; z-index: 5;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Grupo:</span>
			</div>
			<input type="text" id="txtDataRetirada_ID"
				style="position: absolute; left: 161px; top: 147px; width: 126px; height: 19px; line-height: 19px; z-index: 6;"
				name="txtDataRetirada" value="" tabindex="4" readonly="readonly">
			<input type="text" id="txtDataDevolucao_ID"
				style="position: absolute; left: 161px; top: 181px; width: 126px; height: 19px; line-height: 19px; z-index: 7;"
				name="txtDataDevolucao" value="" tabindex="5" readonly="readonly">
			<input type="text" id="txtTipoTarifa_ID"
				style="position: absolute; left: 161px; top: 214px; width: 94px; height: 19px; line-height: 19px; z-index: 8;"
				name="txtTipoTarifa" value="" tabindex="6" readonly="readonly">
			<input type="text" id="txtGrupo_ID"
				style="position: absolute; left: 108px; top: 333px; width: 94px; height: 19px; line-height: 19px; z-index: 9;"
				name="txtGrupo" value="" tabindex="11" readonly="readonly">
			<div id="wb_Text11"
				style="position: absolute; left: 30px; top: 371px; width: 131px; height: 16px; z-index: 10;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Acessório:</span>
			</div>
			<input type="text" id="txtAcessorio_ID"
				style="position: absolute; left: 108px; top: 368px; width: 94px; height: 19px; line-height: 19px; z-index: 11;"
				name="txtAcessorio" value="" tabindex="12" readonly="readonly">
			<div id="wb_Text5"
				style="position: absolute; left: 332px; top: 147px; width: 131px; height: 16px; z-index: 12;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência
					Retirada:</span>
			</div>
			<div id="wb_Text6"
				style="position: absolute; left: 332px; top: 183px; width: 131px; height: 16px; z-index: 13;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência
					Devolução:</span>
			</div>
			<div id="wb_Text7"
				style="position: absolute; left: 332px; top: 219px; width: 131px; height: 16px; z-index: 14;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Qtd
					Dias:</span>
			</div>
			<div id="wb_Text8"
				style="position: absolute; left: 332px; top: 251px; width: 131px; height: 16px; z-index: 15;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Total:</span>
			</div>
			<input type="text" id="txtQtdDias_ID"
				style="position: absolute; left: 462px; top: 217px; width: 75px; height: 19px; line-height: 19px; z-index: 16;"
				name="txtQtdDias" value="" tabindex="9" readonly="readonly">
			<div id="wb_Text12"
				style="position: absolute; left: 29px; top: 405px; width: 131px; height: 16px; z-index: 17;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Veículo:</span>
			</div>
			<input type="text" id="txtVeiculo_ID"
				style="position: absolute; left: 108px; top: 402px; width: 94px; height: 19px; line-height: 19px; z-index: 18;"
				name="txtVeiculo" value="" tabindex="13" readonly="readonly">
			<input type="text" id="txtTotal_ID"
				style="position: absolute; left: 462px; top: 253px; width: 94px; height: 19px; line-height: 19px; z-index: 19;"
				name="txtTotal" value="" tabindex="10" readonly="readonly">
			<input type="button" id="btnImprimirComprovante_ID"
				name="btnImprimirComprovante" value="Imprimir Comprovante"
				style="position: absolute; left: 280px; top: 468px; width: 145px; height: 25px; z-index: 20;"
				tabindex="14"> <input type="text" id="txtAgenciaRetirada_ID"
				style="position: absolute; left: 462px; top: 145px; width: 176px; height: 19px; line-height: 19px; z-index: 21;"
				name="txtAgenciaRetirada" value="" tabindex="7" readonly="readonly">
			<input type="text" id="txtAgenciaDevolucao_ID"
				style="position: absolute; left: 462px; top: 181px; width: 176px; height: 19px; line-height: 19px; z-index: 22;"
				name="txtAgenciaDevolucao" value="" tabindex="8" readonly="readonly">
			<div id="wb_Text13"
				style="position: absolute; left: 24px; top: 57px; width: 131px; height: 16px; z-index: 23;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Número:</span>
			</div>
			<input type="text" id="txtNumero_ID"
				style="position: absolute; left: 106px; top: 54px; width: 69px; height: 19px; line-height: 19px; z-index: 24;"
				name="txtNumero" value="" tabindex="1" readonly="readonly">
			<div id="wb_Text14"
				style="position: absolute; left: 24px; top: 89px; width: 131px; height: 16px; z-index: 25;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Cliente:</span>
			</div>
			<input type="text" id="txtCliente_ID"
				style="position: absolute; left: 106px; top: 86px; width: 182px; height: 19px; line-height: 19px; z-index: 26;"
				name="txtCliente" value="" tabindex="2" readonly="readonly">
			<div id="wb_Text15"
				style="position: absolute; left: 300px; top: 88px; width: 132px; height: 16px; z-index: 27;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">CNPJ/CPF:</span>
			</div>
			<input type="text" id="txtCnpjCpf_ID"
				style="position: absolute; left: 380px; top: 86px; width: 95px; height: 19px; line-height: 19px; z-index: 28;"
				name="txtCnpjCpf" value="" tabindex="3" readonly="readonly">
		</form>
	</div>
	<hr id="Line1"
		style="margin: 0; padding: 0; position: absolute; left: 7px; top: 466px; width: 718px; height: 1px; z-index: 30;">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VeiculoConsulta</title>
<style type="text/css">
body {
	background-color: #FFFFFF;
	color: #000000;
	scrollbar-face-color: #F0F0F0;
	scrollbar-arrow-color: #000000;
	scrollbar-3dlight-color: #F0F0F0;
	scrollbar-darkshadow-color: #696969;
	scrollbar-highlight-color: #FFFFFF;
	scrollbar-shadow-color: #A0A0A0;
	scrollbar-track-color: #C8C8C8;
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
#Table1 {
	border: 3px #000000 solid;
	background-color: transparent;
	border-spacing: 1px;
}

#Table1 td {
	padding: 1px 1px 1px 1px;
}

#Table1 td div {
	white-space: nowrap;
}

#wb_lblNavegador_ID {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_lblNavegador_ID div {
	text-align: left;
}

#wb_lblCadeira_ID {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_lblCadeira_ID div {
	text-align: left;
}

#wb_lblMotorista_ID {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_lblMotorista_ID div {
	text-align: left;
}

#wb_lblTotalAcessorios_ID {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_lblTotalAcessorios_ID div {
	text-align: left;
}

#txtTotalAcessorios_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#Table2 {
	border: 2px #000000 none;
	background-color: transparent;
	border-spacing: 1px;
}

#Table2 td {
	padding: 1px 1px 1px 1px;
}

#Table2 td div {
	white-space: nowrap;
}

#btnVoltar_ID {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnIncluir_ID {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#wb_Text1 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text1 div {
	text-align: left;
}

#comboGrupo_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}
</style>
</head>
<body>
	<table
		style="position: absolute; left: 526px; top: 47px; width: 256px; height: 172px; z-index: 0;"
		cellpadding="1" cellspacing="1" id="Table1">
		<tr>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; height: 160px;">
				&nbsp;</td>
		</tr>
	</table>
	<input type="checkbox" id="Checkbox1" name="checkNavegador" value="on"
		style="position: absolute; left: 561px; top: 74px; z-index: 1;"
		tabindex="1" title="Navegador GPS - R$30,00">
	<div id="wb_lblNavegador_ID"
		style="position: absolute; left: 586px; top: 75px; width: 158px; height: 16px; z-index: 2;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Navegador
			GPS - R$30,00</span>
	</div>
	<div id="wb_lblCadeira_ID"
		style="position: absolute; left: 586px; top: 102px; width: 158px; height: 16px; z-index: 3;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Cadeira
			de bebê - R$45,00</span>
	</div>
	<input type="checkbox" id="Checkbox2" name="checkCadeira" value="on"
		style="position: absolute; left: 561px; top: 102px; z-index: 4;"
		tabindex="2" title="Cadeira de bebê - R$45,00">
	<input type="checkbox" id="Checkbox3" name="checkMotorista" value="on"
		style="position: absolute; left: 561px; top: 128px; z-index: 5;"
		tabindex="3" title="Motorista - R$30,00">
	<div id="wb_lblMotorista_ID"
		style="position: absolute; left: 586px; top: 129px; width: 158px; height: 16px; z-index: 6;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Motorista
			- R$30,00</span>
	</div>
	<div id="wb_lblTotalAcessorios_ID"
		style="position: absolute; left: 579px; top: 176px; width: 39px; height: 16px; z-index: 7;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Total:</span>
	</div>
	<input type="text" id="txtTotalAcessorios_ID"
		style="position: absolute; left: 623px; top: 171px; width: 106px; height: 18px; line-height: 18px; z-index: 8;"
		name="txtTotalAcessorios" value="" tabindex="4"
		title="Valor Total de Acessórios">
	<table
		style="position: absolute; left: 205px; top: 274px; width: 669px; height: 53px; z-index: 9;"
		cellpadding="1" cellspacing="1" id="Table2">
		<tr>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 73px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 73px; height: 19px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Grupo</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 181px; height: 19px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Modelos Referência de Carro</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 133px; height: 19px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Tarifa KM Controlado</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 49px; height: 19px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Diária</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; height: 19px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Tarifa KM Livre</span>
				</div>
			</td>
		</tr>
		<tr>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 73px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 73px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 181px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 133px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 49px; height: 19px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; height: 19px;">
				&nbsp;</td>
		</tr>
	</table>
	<input type="button" id="btnVoltar_ID" name="btnVoltar" value="Voltar"
		style="position: absolute; left: 385px; top: 475px; width: 96px; height: 25px; z-index: 10;"
		tabindex="5" title="Voltar">
	<input type="button" id="btnIncluir_ID" name="btnAvancar"
		value="Avançar"
		style="position: absolute; left: 517px; top: 475px; width: 96px; height: 25px; z-index: 11;"
		tabindex="6" title="Avançar">
	<input type="radio" id="RadioButton1" name="RadioButton1" value="on"
		style="position: absolute; left: 237px; top: 301px; z-index: 12;">
	<div id="wb_Text1"
		style="position: absolute; left: 242px; top: 70px; width: 165px; height: 16px; z-index: 13;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Selecione
			um Grupo</span>
	</div>
	<select name="comboGrupo" size="1" id="comboGrupo_ID"
		style="position: absolute; left: 243px; top: 93px; width: 166px; height: 20px; z-index: 14;">
	</select>
</body>
</html>
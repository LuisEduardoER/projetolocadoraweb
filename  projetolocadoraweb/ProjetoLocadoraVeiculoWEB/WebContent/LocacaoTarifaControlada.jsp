<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarifa Controlada</title>
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

#Table1 {
	border: 2px #C0C0C0 solid;
	background-color: transparent;
	border-spacing: 1px;
}

#Table1 td {
	padding: 1px 1px 1px 1px;
}

#Table1 td div {
	white-space: nowrap;
}

#Button1 {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#Button2 {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}
</style>
</head>
<body>
	<div id="wb_Text1"
		style="position: absolute; left: 81px; top: 53px; width: 288px; height: 16px; z-index: 0;">
		<span style="color: #000000; font-family: Arial; font-size: 13px;">Adicionando
			Tarifa KM Controlada</span>
	</div>
	<table
		style="position: absolute; left: 140px; top: 105px; width: 469px; height: 51px; z-index: 1;"
		cellpadding="1" cellspacing="1" id="Table1">
		<tr>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; width: 134px; height: 18px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Clientes</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; width: 148px; height: 18px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						Ve�culos</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; width: 80px; height: 18px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						KM Inicial</span>
				</div>
			</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; height: 18px;">
				<div>
					<span style="color: #000000; font-family: Arial; font-size: 13px;">
						KM Final</span>
				</div>
			</td>
		</tr>
		<tr>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; width: 134px; height: 18px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: top; width: 148px; height: 18px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; width: 80px; height: 18px;">
				&nbsp;</td>
			<td
				style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; height: 18px;">
				&nbsp;</td>
		</tr>
	</table>
	<input type="button" id="Button1" name="btnVoltar" value="Voltar"
		style="position: absolute; left: 269px; top: 194px; width: 96px; height: 25px; z-index: 2;">
	<input type="button" id="Button2" name="btnConcluir" value="Concluir"
		style="position: absolute; left: 392px; top: 194px; width: 96px; height: 25px; z-index: 3;">
</body>
</html>
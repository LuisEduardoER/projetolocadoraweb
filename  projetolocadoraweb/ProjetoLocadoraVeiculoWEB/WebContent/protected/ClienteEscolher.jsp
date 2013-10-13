<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Escolher Cliente</title>
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
#wb_txtPessoaFisica_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtPessoaFisica_id div {
	text-align: left;
}

#wb_txtPessoaJuridica_id {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_txtPessoaJuridica_id div {
	text-align: left;
}

#btnVoltar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#btnConfirmar_id {
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}
</style>
</head>
<body>
	<form action="fc" method="POST">
		<input type="hidden" name="operacao" value="confirmarEscolherCliente">
		
		<input type="radio" id="checkPessoaFisica_id" name="escolherCliente" value="pf" checked
			style="position: absolute; left: 320px; top: 100px; z-index: 0;">
			
		<input type="radio" id="checkPessoaJuridica_id" name="escolherCliente" value="pj"
			style="position: absolute; left: 320px; top: 140px; z-index: 1;">
		<div id="wb_txtPessoaFisica_id"
			style="position: absolute; left: 350px; top: 100px; width: 250px; height: 16px; z-index: 2;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Pessoa Física</span>
		</div>
		<div id="wb_txtPessoaJuridica_id"
			style="position: absolute; left: 350px; top: 140px; width: 250px; height: 16px; z-index: 3;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Pessoa Jurídica</span>
		</div>
		<input type="button" id="btnVoltar_id" name="" value="Voltar"
			style="position: absolute; left: 250px; top: 200px; width: 96px; height: 25px; z-index: 4;" onclick="executar(this.form,'voltarClienteEscolher')">
		<input type="submit" id="btnConfirmar_id" name="" value="Confirmar"
			style="position: absolute; left: 450px; top: 200px; width: 96px; height: 25px; z-index: 5;">
	</form>
</body>
</html>
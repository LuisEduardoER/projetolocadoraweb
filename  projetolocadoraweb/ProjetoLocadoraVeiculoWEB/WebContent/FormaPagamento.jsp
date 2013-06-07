<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script language="JavaScript">
	
	function executar(form,operacao){
		form.operacao.value = operacao;
		if(operacao == "Confirmar"){
// 			alert("entrou no confirmar");
			var isOk = verificaCamposBranco(form);
			
			if(isOk == true){
				alert("não tem campos branco");
			}else{
				alert("tem campos em branco");
			}
			
			var r = confirm("Tem certeza que deseja Confirmar o Pagamento?");
			if(r == true){
				form.submit();
			}
		}else{
			form.submit();
		}
	}
	
	function verificaCamposBranco(form){
		if(form.txtTipoCartao.value == ""){
			return false;
		}
		return true;
	}
	
	function habilitarCampos(form){

		if(form.tipoPagamento[0].checked){
			habilitarCartao('1',form);
			habilitarCheque('2',form);

		}
		if(form.tipoPagamento[1].checked){
			habilitarCartao('2',form);
			habilitarCheque('1',form);
			
		}
		if(form.tipoPagamento[2].checked){
			habilitarCartao('2',form);
			habilitarCheque('2',form);
			
		}
		
	}
		
	function habilitarCartao(op,form){
// 		Opção 1 - Habilita os campos do Cartão
		if(op == '1'){
			
			form.txtTipoCartao.disabled = false;
			form.txtNomeCliCartao.disabled = false;
			form.txtCpfCartao.disabled = false;
			form.txtNroCartao.disabled = false;
			form.txtDtaValidadeCartao.disabled = false;
			form.txtCodSegCartao.disabled = false;
			
		}else{
			form.txtTipoCartao.disabled = true;
			form.txtNomeCliCartao.disabled = true;
			form.txtCpfCartao.disabled = true;
			form.txtNroCartao.disabled = true;
			form.txtDtaValidadeCartao.disabled = true;
			form.txtCodSegCartao.disabled = true;
		}
	}
	
	function habilitarCheque(op,form){
// 		Opção 1 - Habilita os campos do Cheque
		if(op == '1'){
			form.txtNomeBanco.disabled = false;
			form.txtNroAgencia.disabled = false;
			form.txtCcoBanco.disabled = false;
			form.txtNomeCliBanco.disabled = false;
			form.txtCpfBanco.disabled = false;
			form.txtFoneBanco.disabled = false;
			
		}else{
			form.txtNomeBanco.disabled = true;
			form.txtNroAgencia.disabled = true;
			form.txtCcoBanco.disabled = true;
			form.txtNomeCliBanco.disabled = true;
			form.txtCpfBanco.disabled = true;
			form.txtFoneBanco.disabled = true;
		}
	}
	
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forma de Pagamentos</title>

<style type="text/css">
html,body {
	height: 100%;
}

div#space {
	width: 1px;
	height: 50%;
	margin-bottom: -384px;
	float: left
}

div#container {
	width: 994px;
	height: 768px;
	margin: 0 auto;
	position: relative;
	clear: left;
}

body {
	margin: 0;
	padding: 0;
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

#Line1 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
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

#Line2 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
}

#Line3 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
}

#wb_Text5 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text5 div {
	text-align: left;
}

#txtTipoCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text6 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text6 div {
	text-align: left;
}

#txtNomeCliCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text7 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text7 div {
	text-align: left;
}

#txtCpfCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text8 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text8 div {
	text-align: left;
}

#txtNroCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text9 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text9 div {
	text-align: left;
}

#txtDtaValidadeCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text10 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text10 div {
	text-align: left;
}

#txtCodSegCartao_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text11 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text11 div {
	text-align: left;
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

#Line4 {
	color: #B8CFE9;
	background-color: #B8CFE9;
	border-width: 0px;
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

#wb_Text12 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text12 div {
	text-align: left;
}

#txtNomeBanco_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text13 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text13 div {
	text-align: left;
}

#txtNroAgencia_ID {
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

#txtCcoBanco_ID {
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

#txtNomeCliBanco_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text16 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text16 div {
	text-align: left;
}

#txtCpfBanco_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text17 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text17 div {
	text-align: left;
}

#txtFoneBanco_ID {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#wb_Text18 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text18 div {
	text-align: left;
}

#wb_Text19 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text19 div {
	text-align: left;
}

#wb_Text20 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text20 div {
	text-align: left;
}
</style>
</head>


<body>
	<form action="efetuarPagamento" method="POST">
	<input type="hidden" name="operacao" value="Confirmar">

	<div id="space">
		<br>
	</div>
	<div id="container">
		<div id="wb_Text1"
			style="position: absolute; left: 48px; top: 39px; width: 165px; height: 16px; z-index: 0;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Forma de Pagamentos</span>
		</div>
		
<!-- 		RadioButtons -->
		
		<input type="radio" id="rbCartao_ID" name="tipoPagamento" value="rbCartao" checked
			style="position: absolute; left: 57px; top: 90px; z-index: 1;"
			tabindex="1" title="Cartão de Crédito" onclick="habilitarCampos(this.form)"> 
		<input type="radio" id="rbCheque_ID" name="tipoPagamento" value="rbCheque"
			style="position: absolute; left: 331px; top: 90px; z-index: 2;"
			tabindex="2" title="Cheque" onclick="habilitarCampos(this.form)"> 
		<input type="radio" id="rbDinheiro_ID" name="tipoPagamento" value="rbDinheiro"
			style="position: absolute; left: 605px; top: 90px; z-index: 3;"
			tabindex="3" title="Dinheiro" onclick="habilitarCampos(this.form)">
			
<!-- 		RadioButtons -->
			
		<hr id="Line1"
			style="margin: 0; padding: 0; position: absolute; left: 44px; top: 141px; width: 598px; height: 1px; z-index: 4;">
		<div id="wb_Text2"
			style="position: absolute; left: 48px; top: 176px; width: 188px; height: 16px; z-index: 5;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Dados da Forma de Pagamento</span>
		</div>
		<div id="wb_Text3"
			style="position: absolute; left: 46px; top: 221px; width: 53px; height: 16px; z-index: 6;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cartão</span>
		</div>
		<div id="wb_Text4"
			style="position: absolute; left: 358px; top: 222px; width: 54px; height: 16px; z-index: 7;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cheque</span>
		</div>
		<hr id="Line2"
			style="margin: 0; padding: 0; position: absolute; left: 335px; top: 235px; width: 1px; height: 279px; z-index: 8;">
		<hr id="Line3"
			style="margin: 0; padding: 0; position: absolute; left: 648px; top: 231px; width: 1px; height: 279px; z-index: 9;">
		<div id="wb_Text5"
			style="position: absolute; left: 46px; top: 273px; width: 32px; height: 16px; z-index: 10;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Tipo:</span>
		</div>
		<input type="text" id="txtTipoCartao_ID"
			style="position: absolute; left: 151px; top: 270px; width: 111px; height: 18px; line-height: 18px; z-index: 11;"
			name="txtTipoCartao" value="" maxlength="20" tabindex="4"
			title="Nome da Operadora do cartão de Crédito. Ex: Mastercard, Visa">
		<div id="wb_Text6"
			style="position: absolute; left: 46px; top: 310px; width: 43px; height: 16px; z-index: 12;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Nome:</span>
		</div>
		<input type="text" id="txtNomeCliCartao_ID"
			style="position: absolute; left: 151px; top: 307px; width: 170px; height: 18px; line-height: 18px; z-index: 13;"
			name="txtNomeCliCartao" value="" maxlength="50" tabindex="5">
		<div id="wb_Text7"
			style="position: absolute; left: 46px; top: 347px; width: 35px; height: 16px; z-index: 14;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">CPF:</span>
		</div>
		<input type="text" id="txtCpfCartao_ID"
			style="position: absolute; left: 151px; top: 344px; width: 97px; height: 18px; line-height: 18px; z-index: 15;"
			name="txtCpfCartao" value="" maxlength="14" tabindex="6"
			title="Formato: xxx.xxx.xxx-xx">
		<div id="wb_Text8"
			style="position: absolute; left: 46px; top: 384px; width: 66px; height: 16px; z-index: 16;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Nº
				Cartão:</span>
		</div>
		<input type="text" id="txtNroCartao_ID"
			style="position: absolute; left: 151px; top: 381px; width: 125px; height: 18px; line-height: 18px; z-index: 17;"
			name="txtNroCartao" value="" maxlength="19" tabindex="7"
			title="Formato: XXXX XXXX XXXX XXXX">
		<div id="wb_Text9"
			style="position: absolute; left: 46px; top: 421px; width: 108px; height: 16px; z-index: 18;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Data
				de Validade:</span>
		</div>
		<input type="date" id="txtDtaValidadeCartao_ID"
			style="position: absolute; left: 151px; top: 418px; width: 125px; height: 18px; line-height: 18px; z-index: 19;"
			name="txtDtaValidadeCartao" value="" tabindex="8"
			title="dd/MM/aaaa Ex: 23/03/2013">
		<div id="wb_Text10"
			style="position: absolute; left: 47px; top: 457px; width: 97px; height: 16px; z-index: 20;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cód Segurança:</span>
		</div>
		<input type="text" id="txtCodSegCartao_ID"
			style="position: absolute; left: 151px; top: 454px; width: 29px; height: 18px; line-height: 18px; z-index: 21;"
			name="txtCodSegCartao" value="" maxlength="4" tabindex="9"
			title="Formato: 0124">
		<div id="wb_Text11"
			style="position: absolute; left: 46px; top: 540px; width: 38px; height: 16px; z-index: 22;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Total:</span>
		</div>
		<input type="text" id="txtTotal_ID"
			style="position: absolute; left: 88px; top: 536px; width: 70px; height: 18px; line-height: 18px; z-index: 23;"
			name="txtTotal" value="<%="R$" + (Double) request.getSession().getAttribute("totalPedido") %>" disabled="disabled">
		<hr id="Line4"
			style="margin: 0; padding: 0; position: absolute; left: 47px; top: 588px; width: 598px; height: 1px; z-index: 24;">
		
<!-- 		Botões -->

		<input type="button" id="Button1" name="btnVoltar" value="Voltar"
			style="position: absolute; left: 236px; top: 614px; width: 96px; height: 25px; z-index: 25;"
			title="Voltar" onclick="executar(this.form,'Voltar')"> 
		<input type="button" id="Button2" name="btnConfirmar" value="Confirmar"
			style="position: absolute; left: 347px; top: 614px; width: 96px; height: 25px; z-index: 26;"
			title="Confirmar" onclick="executar(this.form,'Confirmar')">
			
<!-- 		Botões -->		
		
		<div id="wb_Text12"
			style="position: absolute; left: 356px; top: 271px; width: 52px; height: 16px; z-index: 27;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Banco:</span>
		</div>
		<input type="text" id="txtNomeBanco_ID"
			style="position: absolute; left: 419px; top: 268px; width: 109px; height: 18px; line-height: 18px; z-index: 28;"
			name="txtNomeBanco" value="" maxlength="20" tabindex="10"
			title="Nome do Banco. Ex: Itaú, Bradesco">
		<div id="wb_Text13"
			style="position: absolute; left: 358px; top: 305px; width: 59px; height: 16px; z-index: 29;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência:</span>
		</div>
		<input type="text" id="txtNroAgencia_ID"
			style="position: absolute; left: 421px; top: 302px; width: 42px; height: 18px; line-height: 18px; z-index: 30;"
			name="txtNroAgencia" value="" maxlength="6" tabindex="11"
			title="Código da Agência. Formato: 012467">
		<div id="wb_Text14"
			style="position: absolute; left: 357px; top: 339px; width: 44px; height: 16px; z-index: 31;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">CCO:</span>
		</div>
		<input type="text" id="txtCcoBanco_ID"
			style="position: absolute; left: 420px; top: 336px; width: 76px; height: 18px; line-height: 18px; z-index: 32;"
			name="txtCcoBanco" value="" maxlength="10" tabindex="12">
		<div id="wb_Text15"
			style="position: absolute; left: 359px; top: 373px; width: 45px; height: 16px; z-index: 33;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Nome:</span>
		</div>
		<input type="text" id="txtNomeCliBanco_ID"
			style="position: absolute; left: 422px; top: 370px; width: 170px; height: 18px; line-height: 18px; z-index: 34;"
			name="txtNomeCliBanco" value="" maxlength="50" tabindex="13">
		<div id="wb_Text16"
			style="position: absolute; left: 360px; top: 407px; width: 39px; height: 16px; z-index: 35;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">CPF:</span>
		</div>
		<input type="text" id="txtCpfBanco_ID"
			style="position: absolute; left: 423px; top: 404px; width: 97px; height: 18px; line-height: 18px; z-index: 36;"
			name="txtCpfBanco" value="" maxlength="14" tabindex="14"
			title="Formato: xxx.xxx.xxx-xx">
		<div id="wb_Text17"
			style="position: absolute; left: 359px; top: 443px; width: 65px; height: 16px; z-index: 37;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Telefone:</span>
		</div>
		<input type="text" id="txtFoneBanco_ID"
			style="position: absolute; left: 422px; top: 440px; width: 93px; height: 18px; line-height: 18px; z-index: 38;"
			name="txtFoneBanco" value="" maxlength="11" tabindex="15">
		<div id="wb_Text18"
			style="position: absolute; left: 78px; top: 91px; width: 107px; height: 16px; z-index: 39;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cartão
				de Crédito</span>
		</div>
		<div id="wb_Text19"
			style="position: absolute; left: 354px; top: 91px; width: 54px; height: 16px; z-index: 40;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Cheque</span>
		</div>
		<div id="wb_Text20"
			style="position: absolute; left: 627px; top: 91px; width: 54px; height: 16px; z-index: 41;">
			<span style="color: #000000; font-family: Arial; font-size: 13px;">Dinheiro</span>
		</div>
	</div>
	
	</form>
</body>


</html>
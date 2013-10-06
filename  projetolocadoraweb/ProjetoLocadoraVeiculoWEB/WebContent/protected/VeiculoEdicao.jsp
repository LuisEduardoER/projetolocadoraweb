<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.Grupo"%>
<%@page import="model.Veiculo"%>
<%@page import="util.Conversao"%>
<%@page import="java.util.ArrayList"%>


<html>
	<script language="JavaScript">
		function executar(form,operacao){
			form.operacao.value = operacao;
			if(operacao == "excluir"){
				var r = confirm("Deseja Excluir?");
				if(r == true){
					form.submit();
				}
			}else{
				form.submit();
			}
		}
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Veículos - Detalhes Edição</title>
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
		#wb_lblDadosVeiculo_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblDadosVeiculo_id div {
			text-align: left;
		}
		
		#Line1 {
			color: #B8CFE9;
			background-color: #B8CFE9;
			border-width: 0px;
		}
		
		#wb_lblModelo_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblModelo_id div {
			text-align: left;
		}
		
		#txtModelo_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblFabricante_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblFabricante_id div {
			text-align: left;
		}
		
		#wb_lblChassi_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblChassi_id div {
			text-align: left;
		}
		
		#txtFabricante_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#txtChassi_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblPlaca_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblPlaca_id div {
			text-align: left;
		}
		
		#txtPlaca_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblKM_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblKM_id div {
			text-align: left;
		}
		
		#txtKM_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblCidade_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblCidade_id div {
			text-align: left;
		}
		
		#txtCidade_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblEstado_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblEstado_id div {
			text-align: left;
		}
		
		#txtEstado_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#Line2 {
			color: #B8CFE9;
			background-color: #B8CFE9;
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
		
		#btnExcluir_id {
			color: #000000;
			font-family: Arial;
			font-size: 13px;
		}
		
		#Table1 {
			border: 2px #000000 solid;
			background-color: transparent;
			border-spacing: 1px;
		}
		
		#Table1 td {
			padding: 0px 0px 0px 0px;
		}
		
		#Table1 td div {
			white-space: nowrap;
		}
		
		#wb_lblGrupo_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblGrupo_id div {
			text-align: left;
		}
		
		#cbGrupo_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
		}
		
		#wb_lblTarifaLivre_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblTarifaLivre_id div {
			text-align: left;
		}
		
		#txtTarifaLivre_id {
			border: 1px #C0C0C0 solid;
			background-color: #FFFFFF;
			color: #000000;
			font-family: Arial;
			font-size: 13px;
			text-align: left;
			vertical-align: middle;
		}
		
		#wb_lblTarifaControlada_id {
			background-color: transparent;
			border: 0px #000000 solid;
			padding: 0;
		}
		
		#wb_lblTarifaControlada_id div {
			text-align: left;
		}
		
		#txtTarifaControlada_id {
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
		<jsp:useBean id="veiculoSelecionado" class="model.Veiculo" scope="session"/>
		<%Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");%>
		<form action="fc" method="POST">
			<input type="hidden" name="operacao" value="alterar">
			<div id="wb_lblDadosVeiculo_id"
				style="position: absolute; left: 309px; top: 18px; width: 135px; height: 18px; z-index: 0;">
				<span style="color: #000000; font-family: Arial; font-size: 15px;"><strong>Dados do Veículo</strong></span>
			</div>
			<hr id="Line1"
				style="margin: 0; padding: 0; position: absolute; left: 4px; top: 42px; width: 804px; height: 1px; z-index: 1;">
			<div id="wb_lblModelo_id"
				style="position: absolute; left: 43px; top: 62px; width: 53px; height: 16px; z-index: 2;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Modelo:
				</span>
			</div>
			<input type="text" id="txtModelo_id"
				style="position: absolute; left: 109px; top: 58px; width: 124px; height: 19px; line-height: 19px; z-index: 3;"
				name="txtModelo" value="<jsp:getProperty name='veiculoSelecionado' property='modelo' />" tabindex="1" disabled="disabled"
				title="Nome ou Modelo do Veículo. Ex: Gol 1.0" >
				
			<div id="wb_lblFabricante_id"
				style="position: absolute; left: 43px; top: 98px; width: 69px; height: 16px; z-index: 4;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Fabricante:
				</span>
			</div>
			<div id="wb_lblChassi_id"
				style="position: absolute; left: 43px; top: 134px; width: 48px; height: 16px; z-index: 5;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Chassi:</span>
			</div>
			<input type="text" id="txtFabricante_id"
				style="position: absolute; left: 109px; top: 95px; width: 124px; height: 19px; line-height: 19px; z-index: 6;"
				name="txtFabricante" value="<jsp:getProperty name='veiculoSelecionado' property='fabricante' />" tabindex="2" disabled="disabled"
				title="Fabricante do Veículo. Ex: Volkswagen, Fiat">
			<input type="text" id="txtChassi_id"
				style="position: absolute; left: 109px; top: 132px; width: 124px; height: 19px; line-height: 19px; z-index: 7;"
				name="txtChassi" value="<jsp:getProperty name='veiculoSelecionado' property='chassi' />" tabindex="3" disabled="disabled"
				title="Número do Chassi do Veículo. Ex: 9BWHE21JX24060960">
			<div id="wb_lblPlaca_id"
				style="position: absolute; left: 43px; top: 170px; width: 44px; height: 16px; z-index: 8;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Placa:</span>
			</div>
			<input type="text" id="txtPlaca_id"
				style="position: absolute; left: 109px; top: 169px; width: 80px; height: 19px; line-height: 19px; z-index: 9;"
				name="txtPlaca" value="<jsp:getProperty name='veiculoSelecionado' property='placa' />" tabindex="4" disabled="disabled"
				title="Placa do Veículo. Ex: JXH-1234">
			<div id="wb_lblKM_id"
				style="position: absolute; left: 212px; top: 170px; width: 28px; height: 16px; z-index: 10;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">KM:</span>
			</div>
			<input type="text" id="txtKM_id"
				style="position: absolute; left: 247px; top: 169px; width: 40px; height: 19px; line-height: 19px; z-index: 11;"
				name="txtKM" value="<jsp:getProperty name='veiculoSelecionado' property='km' />" tabindex="5" disabled="disabled"
				title="Potência do Veículo. Ex: 1.0 , 1.6 , 2.0">
			<div id="wb_lblCidade_id"
				style="position: absolute; left: 43px; top: 207px; width: 52px; height: 16px; z-index: 12;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Cidade:</span>
			</div>
			<input type="text" id="txtCidade_id"
				style="position: absolute; left: 109px; top: 205px; width: 124px; height: 19px; line-height: 19px; z-index: 13;"
				name="txtCidade" value="<jsp:getProperty name='veiculoSelecionado' property='cidade' />" tabindex="6" disabled="disabled"
				title="Nome da Cidade do Veículo. Guarulhos, Campinas, São Paulo">
			<div id="wb_lblEstado_id"
				style="position: absolute; left: 265px; top: 209px; width: 59px; height: 16px; z-index: 14;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Estado:</span>
			</div>
			<input type="text" id="txtEstado_id"
				style="position: absolute; left: 322px; top: 208px; width: 124px; height: 19px; line-height: 19px; z-index: 15;"
				name="txtEstado" value="<jsp:getProperty name='veiculoSelecionado' property='estado' />" tabindex="7" disabled="disabled"
				title="Estado do Veículo. Ex: São Paulo/SP , Minas Gerais/MG">
			<hr id="Line2"
				style="margin: 0; padding: 0; position: absolute; left: 4px; top: 262px; width: 804px; height: 1px; z-index: 16;">
			<input type="button" id="btnVoltar_id" name="voltar" value="Voltar"
				style="position: absolute; left: 190px; top: 281px; width: 96px; height: 25px; z-index: 17;"
				tabindex="11" title="Voltar"
				onclick="executar(this.form,'voltarEdicao')">
			<input type="submit" id="btnAlterar_id" name="alterar" value="Alterar"
				style="position: absolute; left: 309px; top: 281px; width: 96px; height: 25px; z-index: 18;"
				tabindex="12" title="Alterar">
			<input type="button" id="btnExcluir_id" name="excluir" value="Excluir"
				style="position: absolute; left: 427px; top: 281px; width: 96px; height: 25px; z-index: 19;"
				tabindex="13" title="Excluir"
				onclick="executar(this.form,'excluir')">
			<table
				style="position: absolute; left: 509px; top: 56px; width: 266px; height: 140px; z-index: 20;"
				cellpadding="0" cellspacing="1" id="Table1">
				<tr>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; height: 132px;">
						&nbsp;</td>
				</tr>
			</table>
			<div id="wb_lblGrupo_id"
				style="position: absolute; left: 523px; top: 72px; width: 49px; height: 16px; z-index: 21;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Grupo:</span>
			</div>
			<select name="cbGrupo" size="1" id="cbGrupo_id"
				style="position: absolute; left: 636px; top: 67px; width: 130px; height: 26px; z-index: 22;" tabindex="8" disabled="disabled">
				<option value="<%=veiculo.getGrupo().getId()%>"><%=veiculo.getGrupo().getNome()%></option>
										
			</select>
			<div id="wb_lblTarifaLivre_id"
				style="position: absolute; left: 523px; top: 110px; width: 70px; height: 16px; z-index: 23;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tarifa Livre: </span>
			</div>
			<input type="text" id="txtTarifaLivre_id"
				style="position: absolute; left: 636px; top: 104px; width: 64px; height: 22px; line-height: 22px; z-index: 24;"
				name="txtTarifaLivre" value="<%="R$ " + Conversao.formatDouble(veiculo.getGrupo().getTarifaLivre())%>" tabindex="9" disabled="disabled"
				title="Valor da Tarifa Livre em R$">
			<div id="wb_lblTarifaControlada_id"
				style="position: absolute; left: 523px; top: 147px; width: 107px; height: 16px; z-index: 25;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tarifa Controlada: </span>
			</div>
			<input type="text" id="txtTarifaControlada_id"
				style="position: absolute; left: 636px; top: 142px; width: 64px; height: 22px; line-height: 22px; z-index: 26;"
				name="txtTarifaControlada" value="<%="R$ " + Conversao.formatDouble(veiculo.getGrupo().getTarifaControloda())%>" tabindex="10" disabled="disabled"
				title="Valor da Tarifa Controlada em R$">
		</form>
	</body>
</html>
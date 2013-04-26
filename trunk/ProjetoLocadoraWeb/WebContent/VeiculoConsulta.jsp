<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Grupo"%>
<%@page import="Model.Veiculo"%>
<%@page import="Util.Conversao"%>


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
		<title>VeiculoConsulta</title>
	<style type="text/css">
		body {
			background-color: #FFFFFF;
			color: #000000;
		}
		.tdDados {
			border-width: 2;
			border-style: solid;
			empty-cells: show;
			background-color: transparent; 
			border: 1px #C0C0C0 solid; 
			text-align: center; 
			vertical-align: middle;
			font-family: Arial;
			font-size: 13px;
			width: 180px; 
			height: 18px;
		
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
		border: 2px #000000 solid;
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
	
	#btnDetalhes_ID {
		color: #000000;
		font-family: Arial;
		font-size: 13px;
	}
	</style>
	</head>
	
	
	<body>
		<form  action="manterVeiculo" method="POST">
			<input type="hidden" name="operacao" value="consultar">
			<table
				style="position: absolute; left: 369px; top: 47px; width: 256px; height: 172px; z-index: 0;"
				cellpadding="1" cellspacing="1" id="Table1">
				<tr>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: left; vertical-align: top; height: 160px;">
						&nbsp;</td>
				</tr>
			</table>
			<input type="checkbox" id="Checkbox1" name="checkNavegador" value="on"
				style="position: absolute; left: 404px; top: 74px; z-index: 1;"
				tabindex="1" title="Navegador GPS - R$30,00">
			<div id="wb_lblNavegador_ID"
				style="position: absolute; left: 429px; top: 75px; width: 158px; height: 16px; z-index: 2;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Navegador
					GPS - R$30,00</span>
			</div>
			<div id="wb_lblCadeira_ID"
				style="position: absolute; left: 429px; top: 102px; width: 158px; height: 16px; z-index: 3;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Cadeira
					de bebê - R$45,00</span>
			</div>
			<input type="checkbox" id="Checkbox2" name="checkCadeira" value="on"
				style="position: absolute; left: 404px; top: 102px; z-index: 4;"
				tabindex="2" title="Cadeira de bebê - R$45,00">
			<input type="checkbox" id="Checkbox3" name="checkMotorista" value="on"
				style="position: absolute; left: 404px; top: 128px; z-index: 5;"
				tabindex="3" title="Motorista - R$30,00">
			<div id="wb_lblMotorista_ID"
				style="position: absolute; left: 429px; top: 129px; width: 158px; height: 16px; z-index: 6;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Motorista
					- R$30,00</span>
			</div>
			<div id="wb_lblTotalAcessorios_ID"
				style="position: absolute; left: 422px; top: 176px; width: 39px; height: 16px; z-index: 7;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Total:</span>
			</div>
			<input type="text" id="txtTotalAcessorios_ID"
				style="position: absolute; left: 466px; top: 171px; width: 106px; height: 18px; line-height: 18px; z-index: 8;"
				name="txtTotalAcessorios" value="" tabindex="4"
				title="Valor Total de Acessórios">
			<table
				style="position: absolute; left: 204px; top: 274px; width: 663px; height: 51px; z-index: 9;"
				cellpadding="1" cellspacing="1" id="Table2">
				<tr>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 72px; height: 18px;">
						&nbsp;</td>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 72px; height: 18px;">
						<div>
							<span style="color: #000000; font-family: Arial; font-size: 13px;">
								Grupo</span>
						</div>
					</td>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 180px; height: 18px;">
						<div>
							<span style="color: #000000; font-family: Arial; font-size: 13px;">
								Modelos Referência de Carro</span>
						</div>
					</td>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 132px; height: 18px;">
						<div>
							<span style="color: #000000; font-family: Arial; font-size: 13px;">
								Tarifa KM Controlado</span>
						</div>
					</td>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; width: 48px; height: 18px;">
						<div>
							<span style="color: #000000; font-family: Arial; font-size: 13px;">
								Diária</span>
						</div>
					</td>
					<td
						style="background-color: transparent; border: 1px #C0C0C0 solid; text-align: center; vertical-align: middle; height: 18px;">
						<div>
							<span style="color: #000000; font-family: Arial; font-size: 13px;">
								Tarifa KM Livre</span>
						</div>
					</td>
				</tr>
				
				
								  
				  <%
				  	try{
				  	ArrayList<Grupo> grupos = (ArrayList) request.getSession().getAttribute("listaGruposByAgencia");
				  	Grupo grupo = new Grupo();	
				  
				  	for(int i = 0; i < grupos.size() ; i++){
						grupo = grupos.get(i);
						for (int j = 0; j < grupo.getListaDeVeiculos().size() ; j++) {
							
							%>
							<tr align="center">
					    		<td width="10px" class="tdDados">
					    			<input type="radio" name="item"
					    				checked="checked" 
					    				value="<%=grupo.getVeiculo(j).getId()%>"></td>				    						    		
					    		<td width="20px" class="tdDados"><%=grupo.getNome().substring(0 , 1)%></td>
					    		<td width="20px" class="tdDados"><%=grupo.getVeiculo(j).getModelo()%></td>
					    		<td width="20px" class="tdDados"><%="R$ " + Conversao.formatDouble(grupo.getTarifaControloda()) + " + R$ " + Conversao.formatDouble(grupo.getKmExtra())%></td>
					    		<td width="20px" class="tdDados"><%="R$ " + Conversao.formatDouble(grupo.getTarifaLivre())%></td>
					    		<td width="20px" class="tdDados"><%="R$ " + Conversao.formatDouble(grupo.getSemanaLivre()) + " + R$ " + Conversao.formatDouble(grupo.getDiaExtra())%></td>
					  		</tr>
							<%						
						}
					} }catch(Exception e) {} %>		  				  
				
				<tr>
	   				<td colspan="13">
	   					<input type="button" id="btnVoltar_ID" name="btnVoltar" value="Voltar"
						style="position: absolute; left: 201px; top: 479px; width: 96px; height: 25px; z-index: 10;"
						tabindex="5" title="Voltar"
						onclick="executar(this.form,'voltar')">
						
						<input type="submit" id="btnConsultar_ID" name="btnConsultar" value="Consultar"
						style="position: absolute; left: 333px; top: 479px; width: 96px; height: 25px; z-index: 11;"
						tabindex="6" title="Consultar">
						
						<input type="button" id="btnIncluir_ID" name="btnIncluir" value="Incluir"
						style="position: absolute; left: 465px; top: 479px; width: 96px; height: 25px; z-index: 12;"
						tabindex="7" title="Incluir"
						onclick="executar(this.form,'incluir')">
				
						<input type="button" id="btnDetalhes_ID" name="btnDetalhes" value="Detalhes"
						style="position: absolute; left: 597px; top: 479px; width: 96px; height: 25px; z-index: 13;"
						tabindex="8" title="Detalhes" 
						onclick="executar(this.form,'detalhes')">
					</td>
				</tr>	
			</table>			
		</form>
	</body>
</html>
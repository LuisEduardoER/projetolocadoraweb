<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<script language = "JavaScript">
	  function executar(form,operacao){
	    form.operacao.value = operacao;
	    form.submit();
	  }
	 </script>
	
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Page</title>
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
	#Line1 {
		color: #000000;
		background-color: #000000;
		border-width: 0px;
	}
	
	#Line2 {
		color: #000000;
		background-color: #000000;
		border-width: 0px;
	}
	
	#txtAgencia_id {
		border: 1px #C0C0C0 solid;
		background-color: #FFFFFF;
		color: #000000;
		font-family: Arial;
		font-size: 13px;
		text-align: left;
		vertical-align: middle;
	}
	
	#txtNome_id {
		border: 1px #C0C0C0 solid;
		background-color: #FFFFFF;
		color: #000000;
		font-family: Arial;
		font-size: 13px;
		text-align: left;
		vertical-align: middle;
	}
	
	#btnManterVeiculos_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnRealizarLocacao_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnConslutarVeiuclos_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnDevolverVeiculos_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnConsultarClientes_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnCadastrarClientes_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnAlterarClientes_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#btnExcluirClientes_id {
		color: #000000;
		font-family: Arial;
		font-size: 11px;
	}
	
	#wb_txtPaginaInicial_id {
		background-color: transparent;
		border: 0px #000000 solid;
		padding: 0;
	}
	
	#wb_txtPaginaInicial_id div {
		text-align: left;
	}
	
	#wb_txtAgencia_id {
		background-color: transparent;
		border: 0px #000000 solid;
		padding: 0;
	}
	
	#wb_txtAgencia_id div {
		text-align: left;
	}
	
	#wb_txtNome_id {
		background-color: transparent;
		border: 0px #000000 solid;
		padding: 0;
	}
	
	#wb_txtNome_id div {
		text-align: left;
	}
	</style>
	
	</head>

	<body>
		<jsp:useBean id="usuarioSelecionado" class="model.Usuario" scope="session"/>
		<jsp:useBean id="agenciaSelecionada" class="model.Agencia" scope="session"/>
		<form action="fc" method="POST">
			<input type="hidden" name="operacao" value="homePageInitialize">
			<hr id="Line1"
				style="margin: 0; padding: 0; position: absolute; left: 260px; top: 260px; width: 600px; height: 1px; z-index: 0;">
			<hr id="Line2"
				style="margin: 0; padding: 0; position: absolute; left: 150px; top: 510px; width: 720px; height: 1px; z-index: 1;">
			<input type="text" id="txtAgencia_id"
				style="position: absolute; left: 700px; top: 80px; width: 198px; height: 28px; line-height: 28px; z-index: 2;"
				name="txtAgencia" value="<jsp:getProperty name='agenciaSelecionada' property='nome' />" disabled="disabled">
				
			<input type="text" id="txtNome_id"
				style="position: absolute; left: 700px; top: 120px; width: 198px; height: 28px; line-height: 28px; z-index: 3;"
				name="txtNome" value="<jsp:getProperty name='usuarioSelecionado' property='nome' />" disabled="disabled">
				
			<input type="button" id="btnManterVeiculos_id" name="btnManterVeiculos"
				value="Manter Veiculos"
				style="position: absolute; left: 301px; top: 300px; width: 100px; height: 28px; z-index: 4;"
				onclick="executar(this.form,'ManterVeiculoHomePage')">
				
			<input type="button" id="btnRealizarLocacao_id"	name="btnRealizarLocacao" 
				value="Realizar Locação"
				style="position: absolute; left: 300px; top: 350px; width: 100px; height: 28px; z-index: 5;"
				onclick="executar(this.form,'RealizarLocacaoHomePage')">
				
			<input type="button" id="btnConslutarVeiuclos_id"
				name="btnConsultarVeiculos" value="Consultar Veiculos"
				style="position: absolute; left: 300px; top: 400px; width: 100px; height: 28px; z-index: 6;">
				
			<input type="button" id="btnDevolverVeiculos_id"
				name="btnDevolverVeiculos" value="Devolver Veiculos"
				style="position: absolute; left: 300px; top: 450px; width: 100px; height: 28px; z-index: 7;">
				
			<input type="button" id="btnConsultarClientes_id"
				name="btnConsultarClientes" value="Consultar Clientes"
				style="position: absolute; left: 550px; top: 300px; width: 100px; height: 28px; z-index: 8;">
				
			<input type="button" id="btnCadastrarClientes_id"
				name="btnCadastrarClientes" value="Cadastrar Clientes"
				style="position: absolute; left: 550px; top: 350px; width: 100px; height: 28px; z-index: 9;">
				
			<input type="button" id="btnAlterarClientes_id"
				name="btnAlterarClientes" value="Alterar Clientes"
				style="position: absolute; left: 550px; top: 400px; width: 100px; height: 28px; z-index: 10;">
				
			<input type="button" id="btnExcluirClientes_id"
				name="btnExcluirClientes" value="Excluir Clientes"
				style="position: absolute; left: 550px; top: 450px; width: 100px; height: 28px; z-index: 11;">
				
			<div id="wb_txtPaginaInicial_id"
				style="position: absolute; left: 177px; top: 252px; width: 80px; height: 32px; z-index: 12;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Pagina Inicial</span>
			</div>
		
			<div id="wb_txtAgencia_id"
				style="position: absolute; left: 642px; top: 88px; width: 51px; height: 16px; z-index: 13;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agencia</span>
			</div>
		
			<div id="wb_txtNome_id"
				style="position: absolute; left: 651px; top: 130px; width: 40px; height: 16px; z-index: 14;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Nome</span>
			</div>
		</form>
	</body>
</html>
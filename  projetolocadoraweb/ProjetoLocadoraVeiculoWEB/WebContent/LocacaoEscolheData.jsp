<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Locacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agencia"%>

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
<title>Realizar Locação - Escolhe Data</title>
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
<link rel="stylesheet" href="./cupertino/jquery.ui.all.css"
	type="text/css">
<style type="text/css">
#Line2 {
	-moz-box-shadow: 3px 3px 3px #000000;
	-webkit-box-shadow: 3px 3px 3px #000000;
	box-shadow: 3px 3px 3px #000000;
}

#Line1 {
	-moz-box-shadow: 3px 3px 3px #000000;
	-webkit-box-shadow: 3px 3px 3px #000000;
	box-shadow: 3px 3px 3px #000000;
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

#Editbox1 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#Combobox1 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#Combobox2 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#wb_Text5 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text5 div {
	text-align: left;
}

#Combobox3 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
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

#Editbox2 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
	text-align: left;
	vertical-align: middle;
}

#Combobox4 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#Combobox5 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#wb_Text8 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text8 div {
	text-align: left;
}

#Combobox6 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#wb_Text9 {
	background-color: transparent;
	border: 0px #000000 solid;
	padding: 0;
}

#wb_Text9 div {
	text-align: left;
}

#Combobox7 {
	border: 1px #C0C0C0 solid;
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-size: 13px;
}

#Line3 {
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
</style>
</head>
<body>
	<div id="wb_Form1"
		style="position: absolute; left: 2px; top: 1px; width: 761px; height: 380px; z-index: 23;">
		
		<%Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");%>
		<form action="realizarLocacao" method="POST" id="Form1">
			<input type="hidden" name="operacao" value="avancar">
			<hr id="Line2" class="ui-widget-header"
				style="margin: 0; padding: 0; position: absolute; left: 434px; top: 57px; width: 272px; height: 173px; z-index: 0;">
			<hr id="Line1" class="ui-widget-header"
				style="margin: 0; padding: 0; position: absolute; left: 56px; top: 56px; width: 272px; height: 173px; z-index: 1;">
			<input type="button" id="Button1" name="btnCancelar" value="Cancelar"
				style="position: absolute; left: 266px; top: 314px; width: 96px; height: 25px; z-index: 2;"
				tabindex="10" title="Cancelar" onclick="executar(this.form,'cancelarEscolheData')"> 
			<input type="button"
				id="Button2" name="btnAvancar" value="Avançar"
				style="position: absolute; left: 405px; top: 314px; width: 96px; height: 25px; z-index: 3;"
				tabindex="11" title="Avançar" onclick="executar(this.form,'avancarEscolheData')">
			<div id="wb_Text9"
				style="position: absolute; left: 489px; top: 256px; width: 87px; height: 16px; z-index: 4;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Tipo
					de Tarifa:</span>
			</div>
					
			<select name="comboTarifa" size="1" id="Combobox7"
				style="position: absolute; left: 577px; top: 253px; width: 116px; height: 20px; z-index: 5;"
				tabindex="9">
				<option selected value="kmLivre">KM Livre</option>
				<option value="kmControlado">KM Controlado</option>
			</select>
			<hr id="Line3"
				style="margin: 0; padding: 0; position: absolute; left: 32px; top: 293px; width: 680px; height: 1px; z-index: 6;">
			<div id="wb_Text8"
				style="position: absolute; left: 459px; top: 157px; width: 55px; height: 16px; z-index: 7;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência:</span>
			</div>
			<div id="wb_Text5"
				style="position: absolute; left: 81px; top: 156px; width: 130px; height: 16px; z-index: 8;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Agência:</span>
			</div>

<!-- 			Combo Box Agencia Retirada-->
			<select name="comboAgenciaDevolucao" size="1" id="Combobox6" 
				style="position: absolute; left: 558px; top: 155px; width: 130px; height: 21px; z-index: 9;"
				tabindex="8">
				<%
				List retorno = (ArrayList) request.getSession().getAttribute(
						"listaAgencias");
				for (Iterator<Agencia> it = retorno.iterator(); it.hasNext();) {
					Agencia ag = (Agencia) it.next();
			%>
				<option name=<%=ag.getNome()%> value=<%=ag.getCodigo()%>><%=ag.getNome()%></option>
				<%
				}
			%>
			</select>
			
				
<!-- 			Combo Box Agencia Retirada-->
				
			 <select name="comboAgenciaRetirada" size="1"id="Combobox3"
				style="position: absolute; left: 180px; top: 154px; width: 130px; height: 21px; z-index: 10;" tabindex="4"disabled="disabled">
				<option value="<%=locacao.getAgenciaRetirada().getCodigo()%>"><%=locacao.getAgenciaRetirada().getNome()%></option>
				
			</select>
<!-- 			Fim Combo Box Agencia Retirada -->
			
			<input type="date" id="Editbox1"
				style="position: absolute; left: 81px; top: 123px; width: 126px; height: 18px; line-height: 18px; z-index: 11;"
				name="txtDataRetirada" value="" tabindex="1"> 
				<select name="comboHorasRetirada" size="1" id="Combobox1"
				style="position: absolute; left: 220px; top: 123px; width: 40px; height: 21px; z-index: 12;"
				tabindex="2">
				<option selected value="00">00</option>
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
			</select> <select name="comboMinutosRetirada" size="1" id="Combobox2"
				style="position: absolute; left: 269px; top: 123px; width: 41px; height: 21px; z-index: 13;"
				tabindex="3">
				<option selected value="00">00</option>
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
				<option value="32">32</option>
				<option value="33">33</option>
				<option value="34">34</option>
				<option value="35">35</option>
				<option value="36">36</option>
				<option value="37">37</option>
				<option value="38">38</option>
				<option value="39">39</option>
				<option value="40">40</option>
				<option value="41">41</option>
				<option value="42">42</option>
				<option value="43">43</option>
				<option value="44">44</option>
				<option value="45">45</option>
				<option value="46">46</option>
				<option value="47">47</option>
				<option value="48">48</option>
				<option value="49">49</option>
				<option value="50">50</option>
				<option value="51">51</option>
				<option value="52">52</option>
				<option value="53">53</option>
				<option value="54">54</option>
				<option value="55">55</option>
				<option value="56">56</option>
				<option value="57">57</option>
				<option value="58">58</option>
				<option value="59">59</option>
			</select> 
			<input type="date" id="Editbox2"
				style="position: absolute; left: 459px; top: 124px; width: 126px; height: 18px; line-height: 18px; z-index: 14;"
				name="txtDataDevolucao" value="" tabindex="5"> 
			<select name="comboHorasDevolucao" size="1" id="Combobox4"
				style="position: absolute; left: 598px; top: 124px; width: 40px; height: 21px; z-index: 15;"
				tabindex="6">
				<option selected value="00">00</option>
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
			</select> <select name="comboMinutosDevolucao" size="1" id="Combobox5"
				style="position: absolute; left: 647px; top: 124px; width: 41px; height: 21px; z-index: 16;"
				tabindex="7">
				<option selected value="00">00</option>
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
				<option value="32">32</option>
				<option value="33">33</option>
				<option value="34">34</option>
				<option value="35">35</option>
				<option value="36">36</option>
				<option value="37">37</option>
				<option value="38">38</option>
				<option value="39">39</option>
				<option value="40">40</option>
				<option value="41">41</option>
				<option value="42">42</option>
				<option value="43">43</option>
				<option value="44">44</option>
				<option value="45">45</option>
				<option value="46">46</option>
				<option value="47">47</option>
				<option value="48">48</option>
				<option value="49">49</option>
				<option value="50">50</option>
				<option value="51">51</option>
				<option value="52">52</option>
				<option value="53">53</option>
				<option value="54">54</option>
				<option value="55">55</option>
				<option value="56">56</option>
				<option value="57">57</option>
				<option value="58">58</option>
				<option value="59">59</option>
			</select>
			<div id="wb_Text7"
				style="position: absolute; left: 598px; top: 96px; width: 55px; height: 16px; z-index: 17;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Hora:</span>
			</div>
			<div id="wb_Text4"
				style="position: absolute; left: 220px; top: 95px; width: 55px; height: 16px; z-index: 18;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Hora:</span>
			</div>
			<div id="wb_Text6"
				style="position: absolute; left: 459px; top: 95px; width: 55px; height: 16px; z-index: 19;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data:</span>
			</div>
			<div id="wb_Text3"
				style="position: absolute; left: 81px; top: 94px; width: 55px; height: 16px; z-index: 20;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Data:</span>
			</div>
			<div id="wb_Text2"
				style="position: absolute; left: 398px; top: 33px; width: 70px; height: 16px; z-index: 21;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Devolução</span>
			</div>
			<div id="wb_Text1"
				style="position: absolute; left: 32px; top: 32px; width: 55px; height: 16px; z-index: 22;">
				<span style="color: #000000; font-family: Arial; font-size: 13px;">Retirada</span>
			</div>
		</form>
	</div>
</body>
</html>
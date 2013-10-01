<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Inserindo linhas em uma tabela com JavaScript</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

<script language="javascript">
        // Função responsável por inserir linhas na tabela
        function inserirLinhaTabela() {
            // Captura a referência da tabela com id “minhaTabela”
            var table = document.getElementById("minhaTabela");
            // Captura a quantidade de linhas já existentes na tabela
            var numOfRows = table.rows.length;
            // Captura a quantidade de colunas da última linha da tabela
            var numOfCols = table.rows[numOfRows-1].cells.length;
            // Insere uma linha no fim da tabela.
            var newRow = table.insertRow(numOfRows);
 
            // Faz um loop para criar as colunas
            for (var j = 0; j < numOfCols; j++) {
                // Insere uma coluna na nova linha 
                newCell = newRow.insertCell(j);
                // Insere um conteúdo na coluna
                newCell.innerHTML = "Linha "+ numOfRows + " – Coluna "+ j;
            }
        }
        //Pegar valor da tabela
        
</script>


</head>
<script type= "text/javascript">
		$('#table tr').each(function()
		{
			$("#campo").val($(this).parent().find("td")[0].innerHTML);
		});
</script>
<body>
        <!-- Tabela simples contendo linhas e colunas -->
        <table id="minhaTabela" border="1">
            <tr>
                <td>
                    Linha 0 - Coluna 0
                </td>
                <td>
                    Linha 0 - Coluna 1
                </td>
            </tr>
            <tr>
                <td>
                    Linha 1 - Coluna 0
                </td>
                <td>
                    Linha 1 - Coluna 1
                </td>
            </tr>
        </table>
        <!-- Este botão quando acionado irá chamar a função responsável em inserir a linha na tabela -->
        <input type="button" value="Inserir Linha" onclick="inserirLinhaTabela()"  />
        <button id="teste">Clica aki</button>
</body>
</html>

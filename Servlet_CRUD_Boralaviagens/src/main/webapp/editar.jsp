<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar - Bora La Viagens</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<img src="imagens/logoborala.png">
	<h1>Editar Cliente</h1>
	<form name="frmCliente" action="update">
		<table>
			<tr>
				<td><input type="text" name="idcli" id="caixa3" readonly 
				value="<%out.println(request.getAttribute("idcli")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" 
				value="<%out.println(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" 
				value="<%out.println(request.getAttribute("email")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="senha" class="Caixa2"
				value="<%out.println(request.getAttribute("senha")); %>"></td>
			</tr>
		</table>
		<input type="button" class="Botao1" value="Salvar"
			onclick="validar()">
	</form>

	<script src="scripts/validador.js"></script>
</body>
</html>
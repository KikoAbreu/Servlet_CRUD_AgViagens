<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("contatos");%>
<html lang=pt-br>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<img src="imagens/logoborala.png">
	<h1>Lista de Clientes</h1>
	<a href="novo.html" class="Botao1">Novo Cliente</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Opcoes</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getIdcli()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getSenha()%></td>
				<td>
					<a href="select?idcli=<%=lista.get(i).getIdcli() %>" class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcli()%>)" class="Botao2">Excluir</a>
				
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
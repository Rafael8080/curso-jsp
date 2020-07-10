<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<h3 style="text-align: center;">Cadastro de Produtos</h3>
	<form action="salvarProduto" method="post">
		<ul class="form-style-1">
			<li>
				<table>
					<tr>
						<td><label for="id">Id:</label></td>
						<td><input type="text" name="id" id="id" value="${prod.id }"></td>
					</tr>
					<tr>
						<td><label for="nome">Nome:</label></td>
						<td><input type="text" name="nome" id="nome"
							value="${prod.nome }"></td>
					</tr>
					<tr>
						<td><label for="quantidade">Quantidade:</label></td>
						<td><input type="number" name="quantidade"
							value="${pord.quantidade }" id="quantidade"></td>
					</tr>
					<tr>
						<td><label for="valor">Valor:</label></td>
						<td><input type="number" name="valor" value="${prod.valor }"
							id="valor"></td>						
					</tr>
						<td></td>
						<td><input type="submit" value="salvar"></td>
					

				</table>
			</li>
		</ul>
	</form>
	<div class="container">
		<table class="responsive-table">
			<tr>
				<th>Id:</th>
				<th>Nome:</th>
				<th>Quantidade:</th>
				<th>Valor</th>
			</tr>
			<c:forEach items="${produtos}" var="prod">
			<tr>		
				<td><c:out value="${prod.id }"></c:out></td>
				<td><c:out value="${prod.nome }"></c:out></td>
				<td><c:out value="${prod.quantidade }"></c:out></td>
				<td><c:out value="${prod.valor }"></c:out></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
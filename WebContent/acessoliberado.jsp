 <jsp:useBean id="calcula"  class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/> 
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
	<jsp:setProperty property="*" name="calcula"/>  
	<h3>Seja bem vindo ao sistema em jsp</h3>
	
	 <a href="salvarUsuario?acao=listartodos"><img width="100px" height="100px" title="Cadastro de usu�rio" alt="Cadastro de usu�rio" src="resources/img/user-female-icon.png"> </a>
	 <a style="margin-left:15px;" href="salvarProduto?acao=listarprodutos"><img width="100px" height="100px" title="Cadastro de produto" alt="Cadastro de produto" src="resources/img/produto.jpg"> </a>
	</body>
</html>
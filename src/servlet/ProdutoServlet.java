package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Produto;
import dao.DaoProduto;

@WebServlet("/salvarProduto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoProduto daoproduto = new DaoProduto();

    public ProdutoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("listarprodutos")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("produtos", daoproduto.listar());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String quantidade = request.getParameter("quantidade");
		String valor = request.getParameter("valor");
		
		Produto produto = new Produto();
		
		produto.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		produto.setNome(nome);	
		produto.setQuantidade(Double.parseDouble(quantidade));
		produto.setValor(Double.parseDouble(valor));
		
		
		daoproduto.salvar(produto);
		
		try {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("produtos", daoproduto.listar());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

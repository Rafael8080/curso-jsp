package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import beans.Telefones;
import dao.DaoTelefones;
import dao.DaoUsuario;


@WebServlet("/salvarTelefones")
public class TelefonesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	private DaoTelefones daotelefones = new DaoTelefones();

    public TelefonesServlets() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String acao = request.getParameter("acao");
			if(acao.equalsIgnoreCase("addFone")) {

			String user = request.getParameter("user");
		
			BeanCursoJsp usuario = daoUsuario.consultar(user);
			
			request.getSession().setAttribute("userEscolhido", usuario);
			
			
			RequestDispatcher view = 
					request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daotelefones.listar(usuario.getId()));
			view.forward(request, response);
			
		} else if(acao.equalsIgnoreCase("deleteFone")){
			String foneId = request.getParameter("foneId");
			daotelefones.delete(foneId);
			
			BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");
			
			RequestDispatcher view = 
					request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daotelefones.listar(beanCursoJsp.getId()));
			request.setAttribute("msg", "Removido com sucesso");
			
			view.forward(request, response);
			
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");
		
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		
		Telefones telefones = new Telefones();
		telefones.setNumero(numero);
		telefones.setTipo(tipo);
		telefones.setUsuario(beanCursoJsp.getId());
		
		daotelefones.salvar(telefones);
		
		request.getSession().setAttribute("userEscolhido", beanCursoJsp);
		request.setAttribute("userEscolhido", beanCursoJsp);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daotelefones.listar(beanCursoJsp.getId()));
			request.setAttribute("msg", "Salvo com sucesso");
			view.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

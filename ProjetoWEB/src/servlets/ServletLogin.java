package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

@WebServlet("/ServletLogin") /*Mapeamento que vem da Tela do Usuario do Form Action*/
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletLogin() {
    	
    }
	
    /*Recebe os dados pela url em parametros*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/*Recebe os dados enviados por um formulario*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("login"));
		System.out.println(request.getParameter("senha"));
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			if (modelLogin.getLogin().equalsIgnoreCase("admin")
					&& modelLogin.getSenha().equalsIgnoreCase("admin")) {
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				RequestDispatcher redirecionar = request.getRequestDispatcher("principal/principal.jsp");
				redirecionar.forward(request, response);
				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Login ou Senha incorreto!");
				redirecionar.forward(request, response);
			}
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o Login e Senha corretamente!");
			redirecionar.forward(request, response);
		}
		
	}

}

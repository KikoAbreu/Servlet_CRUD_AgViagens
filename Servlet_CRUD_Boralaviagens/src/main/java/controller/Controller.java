package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.DAO;

@WebServlet(urlPatterns = { "/Controller/", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Cliente cliente = new Cliente();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoCliente(request, response);
		} else if (action.equals("/select")) {
			editarContato(request, response);
		} else if (action.equals("/update")) {
			updateContato(request, response);
		} else if (action.equals("/delete")) {
			deleteContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// Listar Clientes
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = dao.readClientes();

		// encaminhar lista para o documento listaclientes.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listaclientes.jsp");
		rd.forward(request, response);
	}

	// NOVO Cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis da classe Cliente
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));

		// invocar o createCliente
		dao.createCliente(cliente);
		// redirecionar
		response.sendRedirect("main");
	}

	// Update
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idcli = request.getParameter("idcli");
		cliente.setIdcli(idcli);
		dao.atualizarContato(cliente);

		request.setAttribute("idcli", cliente.getIdcli());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("senha", cliente.getSenha());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void updateContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setIdcli(request.getParameter("idcli"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));

		// invocar o updateCliente
		dao.updateCliente(cliente);
		// redirecionar
		response.sendRedirect("main");
	}

	// DELETE
	protected void deleteContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcli = request.getParameter("idcli");

		cliente.setIdcli(idcli);
		dao.deletarCliente(cliente);
		response.sendRedirect("main");

	}

}

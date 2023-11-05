package controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import models.Cliente;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateController() {
        super();
       
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("nome"));
		cliente.setCpf(req.getParameter("cpf"));
		cliente.setRg(req.getParameter("rg"));
		cliente.setTelefone(req.getParameter("telefone"));
		

		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.createCliente(cliente);
			
			
			res.sendRedirect("ReadController");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
	


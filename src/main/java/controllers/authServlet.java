package controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import DAO.AgentDAO;
import DAO.ClientDAO;
import JPA.Agent;
import JPA.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class authServlet
 */
public class authServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String password = request.getParameter("mdp");
		String fonctinalite = request.getParameter("fonctinalite");
		
		if (fonctinalite.equals("client")) {
			
			ClientDAO cd = new ClientDAO();
			List<Client> c = cd.auth(mail,password);
			
			if (c.isEmpty()) {
				//response.sendRedirect(request.getContextPath() + "?error=true");
				request.setAttribute("error", true);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				Client client=c.get(0);
				request.setAttribute("client", client);
				request.getRequestDispatcher("/views/payment.jsp").forward(request, response);
			}
		}
		
		if (fonctinalite.equals("agent")) {
			System.out.println("agent");
			AgentDAO cd = new AgentDAO();
			List<Agent> c = cd.auth(mail,password);
			
			if (c.isEmpty()) {
				request.setAttribute("error", true);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				Agent agent=c.get(0);
				request.setAttribute("agent", agent);
				request.getRequestDispatcher("/agentServlet").forward(request, response);
			}
		}
		
	}

}

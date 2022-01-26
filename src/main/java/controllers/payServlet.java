package controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.ClientDAO;
import JPA.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class payServlet
 */
public class payServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payServlet() {
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
		String numCarte = request.getParameter("num-carte");
		String dateExp = request.getParameter("date-exp");
		int ccv = Integer.parseInt(request.getParameter("ccv"));
		
		System.out.println(request.getParameter("id"));
		
		if (numCarte.length() == 16) {
			
			try {
				Date dateE=new SimpleDateFormat("yyyy-MM-dd").parse(dateExp);
				if (dateE.after(new Date())) {
					if(ccv<=999 && ccv>=100) {
						ClientDAO cd = new ClientDAO();
						Client client = cd.get(Integer.parseInt(request.getParameter("id")));
						cd.aPayer(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("client", client);
						request.setAttribute("montant", request.getParameter("montant"));
						request.getRequestDispatcher("/views/succes.jsp").forward(request, response);
					} else {
						ClientDAO cd = new ClientDAO();
						Client client= cd.get(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("error", true);
						request.setAttribute("client", client);
						request.getRequestDispatcher("/views/payment.jsp").forward(request, response);
					}
				} else {
					ClientDAO cd = new ClientDAO();
					Client client= cd.get(Integer.parseInt(request.getParameter("id")));
					request.setAttribute("error", true);
					request.setAttribute("client", client);
					request.getRequestDispatcher("/views/payment.jsp").forward(request, response);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			ClientDAO cd = new ClientDAO();
			Client client= cd.get(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("error", true);
			request.setAttribute("client", client);
			request.getRequestDispatcher("/views/payment.jsp").forward(request, response);
		}
		
		

	}
	
}

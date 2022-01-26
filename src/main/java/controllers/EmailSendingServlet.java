package controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailSendingServlet
 */
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recepient");
        String subject ="Confirmation du payment";
        String content = "Votre a ete bien recu, vous pouvez imprimer votre recu sur site web"
        		+ ", Merci pour votre confiance ";
        String resultMessage = "";
 
        try {
        	
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "The e-mail was sent successfully";
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
			
        }
    }

}

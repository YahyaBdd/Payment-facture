package controllers;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;


public class recuServlet extends HttpServlet {

    private static final long serialVersionUID = 7609134248482865644L;

    
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    	
    	if (request.getParameter("button").equals("Deconnecter")) {
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			String masterPath = request.getServletContext().getRealPath( "/WEB-INF/payment-recu.pdf" );
	        response.setContentType( "application/pdf" );
	        
	        try ( PdfReader reader = new PdfReader( masterPath );
	              PdfWriter writer = new PdfWriter( response.getOutputStream() );
	              PdfDocument document = new PdfDocument( reader, writer ) ) {
	            
	            PdfPage page = document.getPage( 1 );
	            PdfCanvas canvas = new PdfCanvas( page );
	            
	            FontProgram fontProgram = FontProgramFactory.createFont();
	            PdfFont font = PdfFontFactory.createFont( fontProgram, "utf-8", true );
	            canvas.setFontAndSize( font, 12 );
	            
	            canvas.beginText();
	            
	            canvas.setTextMatrix( 100, 715 );
	            canvas.showText( request.getParameter("nom")+" "+request.getParameter("prenom") );
	            canvas.setTextMatrix( 100, 667 );
	            canvas.showText( request.getParameter("num") );
	            canvas.setTextMatrix( 100, 617 );
	            canvas.showText( request.getParameter("montant") + " MAD" );
				
	            canvas.endText();
	            
	        }
	 
		}

               
    }
    
}
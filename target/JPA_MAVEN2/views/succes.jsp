<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="internationalisation"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="card text-center">
	  <div class="card-header">
	    <fmt:message key="succes.valider" />
	  </div>
	  <div class="card-body">
	    <h5 class="card-title"><fmt:message key="succes.merci" /></h5>
	    <div class="btn-group btn-group-lg" role="group" aria-label="Basic example">
	    	<form action="recuServlet" method="post">
	    		<input type="hidden" name="nom" value="${client.getNom()}">
	    		<input type="hidden" name="prenom" value="${client.getPrenom()}"> 
	    		<input type="hidden" name="num" value="${client.getNum()}"> 
	    		<input type="hidden" name="montant" value="${montant}">  
	    		<input type="submit" name="button" value="Imprimer reçu" class="btn btn-primary button btn-lg">
		  		<input type="submit" name="button" value="Deconnecter" class="btn btn-primary button btn-lg" >
	    	</form>
	    	
			</div>
	  </div>
	</div>
	<form action="EmailSendingServlet" method="post">
	<h4>Recu par Mail</h2>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input name="recepient" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <button type="submit" class="btn btn-primary">OK</button>
</form>		
</div>

</body>
</html>
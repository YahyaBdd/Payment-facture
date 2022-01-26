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
<link href="<%= request.getContextPath() %>/css/payment.css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1><fmt:message key="agent.liste" /></h1> <br>
<p><fmt:message key="agent.bonjour" /> ${agent.getNom()} ${agent.getPrenom()}</p> <br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col"><fmt:message key="agent.nom" /></th>
      <th scope="col"><fmt:message key="agent.prenom" /></th>
      <th scope="col"><fmt:message key="agent.montant" /></th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${listClient}" var="client">
	<c:if test="${client.getMontant() == 0 }">
		<tr class="table-success">
	      <th scope="row">${client.getId() }</th>
	      <td>${client.getNom() }</td>
	      <td>${client.getPrenom() }</td>
	      <td>${client.getMontant() }</td>
	    </tr>	
	</c:if>
	<c:if test="${client.getMontant() > 0 }">
		<tr class="table-danger">
	      <th scope="row">${client.getId() }</th>
	      <td>${client.getNom() }</td>
	      <td>${client.getPrenom() }</td>
	      <td>${client.getMontant() }</td>
	    </tr>	
	</c:if>
	</c:forEach>  
  </tbody>
</table>
</div>
</body>
</html>
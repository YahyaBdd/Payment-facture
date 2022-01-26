<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="internationalisation"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payment</title>
<link href="<%= request.getContextPath() %>/css/payment.css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

<h1><fmt:message key="payment.titre" /></h1> <br>
<p><fmt:message key="payment.mr" />: ${client.getNom()} ${client.getPrenom()}</p> <br>
<p><fmt:message key="payment.num" />: ${client.getNum()}</p> <br>
<p><fmt:message key="payment.mon" />: ${client.getMontant()}</p> <br>
<form action="payServlet" method="POST">
    <div class="form-floating">
      <input type="text" name="num-carte" class="form-control" id="floatingInput">
      <label for="floatingInput">Numero de Carte</label>
      <c:if test="${error}">
    	<p style="color:red;">*Numéro de carte contient 16 chiffres</p>
    </c:if>
    </div>
    <div class="form-floating">
      <input type="date" name="date-exp" class="form-control" id="floatingPassword" >
      <label for="floatingPassword">Date d'Expiration</label>
      <c:if test="${error}">
    	<p style="color:red;">*La date doit être supérieure à la date courante.</p>
    </c:if>
    </div>
	<div class="form-floating">
      <input type="text" name="ccv" class="form-control" id="floatingPass" >
      <label for="floatingPass">Trois derniers chiffres</label>
      <c:if test="${error}">
    	<p style="color:red;">*Ne depasser pas trois chiffres.</p>
    </c:if>
    </div>
    <input type="hidden" name="id" value="${client.getId()}">
    <input type="hidden" name="montant" value="${client.getMontant()}">   
    <button class="w-100 btn btn-lg btn-primary mt-2" type="submit"><fmt:message key="payment.valider" /></button>
  </form>
</div>  
</body>
</html>
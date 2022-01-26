<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="fr"/>
<fmt:setBundle basename="internationalisation"/>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title><fmt:message key="index.auth" /></title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action="authServlet" method="POST">
    
    <h1 class="h3 mb-3 fw-normal"><fmt:message key="index.auth" /></h1>
    <c:if test="${error}">
    	<p style="color:red;">Verifier mot de passe / mail et ressayer</p>
    </c:if>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="mail">
      <label for="floatingInput"><fmt:message key="index.mail" /></label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="mdp">
      <label for="floatingPassword"><fmt:message key="index.mdp" /></label>
    </div>

    <select class="form-select" aria-label="Default select example" name="fonctinalite">
	  <option selected><fmt:message key="index.fonctionalite" /></option>
	  <option value="client"><fmt:message key="index.client" /></option>
	  <option value="agent"><fmt:message key="index.agent" /></option>
	</select>
    <button class="w-100 btn btn-lg btn-primary mt-2" type="submit"><fmt:message key="index.authButt" /></button>
  </form>
</main>
   
  </body>
</html>

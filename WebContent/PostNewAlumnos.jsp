<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Alumno"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registro completado - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">


    <style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        -ms-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	</style>
	<link href="Styles/floating-labels.css" rel="stylesheet">
	
	<% 
    	String nombre= (String)session.getAttribute("nombreRegistrado");
    %>
</head>
	


<body>	
	<form class = "form-signin" id="myForm" name="myForm" method="post">
			
		<div class="form-signin text-center mb-4">
			<div class="card">
						<div class="card-body">
					<img class="mb-4" src="pngs/login.png" height="150" width="150">
					<h1 class="h3 mb-3 font-weight-normal text-primary">FELICITACIONES</h1>
					<p><%=nombre%> te has logrado registrar, cuando tu solicitud sea verificadad te llegara una mail
					con el numero de <strong>legajo</strong> que tendras que usar en el sistema</p>
					<a href="Login.jsp" class="btn btn-lg btn-primary btn-block">Volver al Login</a>
				</div>
			</div>
		</div>
	 
		<div id="footer"></div>
	</form>
</body>
</html>
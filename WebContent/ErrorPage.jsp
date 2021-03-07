<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Alumno"%>
<%@page import="Logic.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Error - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/Error.png">

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
      
	<link href="Styles/NewAlumno.css" rel="stylesheet">
	
	<!-- Script para el Header -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
	$(function(){
	  $("#footer").load("Footer.jsp"); 
	});
	</script>
	<link href="Styles/floating-labels.css" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

	<% 
    	ErrorManager E = (ErrorManager)session.getAttribute("Error");
    %>
    
</head>
	


<body>
	<form class = "form-signin" id="myForm" name="myForm" method="post">
			
		<div class="form-signin text-center mb-4">
			<div class="card">
				<div class="card-body">
					<div class="icon-box">
					<img class="mb-4" src="pngs/Error.png" height="150" width="150">
				</div>
					<h1 class="h4 mb-3 font-weight-normal text-danger">Error - <%=E.getTitlle()%></h1>
					<p><%=E.getDescp()%></p>
					<a href="<%=E.getPage()%>" class="btn btn-lg btn-danger btn-block">Volver</a>
				</div>
			</div>
		</div>
	 
		<div id="footer"></div>
	</form>
</body>
</html>
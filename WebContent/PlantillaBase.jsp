<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Inicio - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">
	
	<!-- Icons -->
	<script src="https://kit.fontawesome.com/1baa4ceec0.js"></script>
	
	<!-- JS -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="JavaScripts/bootstrap.min.js"></script>
	
	<!-- Customs CSS -->
	<link href="Styles/NewAlumno.css" rel="stylesheet">
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
      	
	<!-- Script para el Header -->
	<script> 
	$(function(){
	  $("#header").load("Header.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>

	<!-- Entidades -->
    <% 
    	Alumno A= (Alumno)session.getAttribute("usuario");
    %>

</head>
	


<body>
	<div id="header"></div>
	<hr class="mb-4">
	
		
		
	<div id="footer"></div>
</body>
</html>
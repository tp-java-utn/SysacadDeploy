<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<%@page import="Entidades.EstadoAcademico.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lista de Materias - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

	<!-- Session -->
	<script src="JavaScripts/SessionTimeOut.js"></script>
	
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
      
      #row:hover{
    	background-color: #e0e0e0;
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
    	
    	DataMateria DM = new DataMateria();
    	ArrayList<Materia> Materias = DM.getAll();
    	
    	DataComision DC = new DataComision();
    	ArrayList<Comision> Comisiones = DC.getAll();
    	
    	DataInscripcion DI =  new DataInscripcion();
    	DataEstadoAcademico DEA = new DataEstadoAcademico();
    %>

</head>
	


<body>
	<div id="header"></div>

	<form class="needs-validation" action="InscripcionMateria" method="get">
		
		<div class="container">
		  	<div class="py-5 text-center">
		       	<h1 class="text-dark"><strong>Inscripcion Materias</strong></h1>
		  	</div>
		</div>
		
		<div class="table-responsive">
			<table class="table table-hover table-striped tableFixHead">
			  <colgroup span="3"></colgroup>
			  <thead>
			    <tr id="encabezado" align="center">
			      	<th scope="col"><p>ID</p></th>
			      	<th scope="col"><p>AÑO</p></th>
	
			      	<th scope="col"><p align="center">REGULARES</p></th>
			    	<th scope="col"><p align="center">APROBADAS</p></th>
			    	<th scope="col"><p align="center">PARA RENDIR</p></th>
			      	<th scope="col"><p>MATERIA</p></th>
			      	<th scope="col"><p>CURSADO</p></th>
			      	<th scope="col"><p>ACCIONES</p></th>
			    </tr>
			  </thead>
			  
	
			  
			  <tbody>
			  <% for (Materia MS:Materias) {%>
			  	<% if(DEA.getOne(A.getLegajo(), MS.getIdMateria()).getEstado().equals(estadosMateria.Libre.toString())){%>
				    <tr id="row">
				      <td align="center"><strong><%=MS.getIdMateria()%></strong></td>
				      <td align="center"><%=MS.getAño()%></td>
				      
				      <% if(MS.getCorrelativasRegulares()!=null) {%>
				      <td> <p align="center"><%=MS.getCorrelativasRegulares()%></p></td>
				      <%}else{ %>
				      <td> <p align="center">-</p></td>
				      <%}%>
				      
				      <% if(MS.getCorrelativasAprobadas()!=null) {%>
				      <td> <p align="center"><%=MS.getCorrelativasAprobadas()%></p></td>
				      <%}else{ %>
				      <td> <p align="center">-</p></td>
				      <%}%>
				      
				      <% if(MS.getCorrelativasRendir()!=null) {%>
				      <td> <p align="center"><%=MS.getCorrelativasRendir()%></p></td>
				      <%}else{ %>
				      <td> <p align="center">-</p></td>
				      <%}%>
				      
				      <td align="center"><%=MS.getNombre()%></td>
				      <td align="center"><%=MS.getcursado()%></td>
				      <td align="center">
				      	  <% if(MS.AlumnoPuedeCursar(A.getLegajo())){%>
					      <a type="submit" class="btn btn-primary" id="<%=MS.getIdMateria()%>" href="InscripcionMateria?action=seleccion&id=<%=MS.getIdMateria()%>"><i class="far fa-check-circle" style="padding-right: 10px;"></i>Inscribirse</a>
					      <%}else{%>
					      <button type="submit" class="btn btn-secondary disabled" id="<%=MS.getIdMateria()%>" disabled><i class="far fa-times-circle" style="padding-right: 10px;"></i>Inscribirse</button>
					      <%}%>
				      </td>
				    </tr>
			    <%}%>
			  <%}%>
			  </tbody>
			</table>    

		</div>

		<div class="row justify-content-center">
			<div class="col-3">
		    	<a class="btn btn-primary btn-lg btn-block" href="MainPage?action=volver">Volver al Menu</a>
		    </div>
	    </div>
    
    </form>
    
	<hr class="mb-4">
	<div id="footer"></div>
	
	
</body>
</html>
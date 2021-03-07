<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<%@page import="Entidades.Alumno.Carreras"%>
<%@page import="Entidades.Persona.EstadosPersona"%>
<%@page import="java.sql.Date"%>

<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Administrador - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/loginADM.png">
	
	<!-- Session -->
	<script src="JavaScripts/SessionTimeOutADM.js"></script>
	
    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">  
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<!-- Custom CSS -->
	<link href="Styles/NewAlumno.css" rel="stylesheet">
	<link href="Styles/Admin.css" rel="stylesheet">
	
	<!-- Script para el Header -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="JavaScripts/bootstrap.js"></script>
	<script src="JavaScripts/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/1baa4ceec0.js"></script>
	
	<script> 
	$(function(){
	  $("#header").load("HeaderAdmin.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>
	

    <% 	    
	    long now = System.currentTimeMillis();
		Date today = new Date(now);
    	
    	DataMesa DMesa = new DataMesa();
    	ArrayList<Mesa> Mesas = DMesa.getAll();	
    
    	DataMateria DM = new DataMateria();
		
    %>

</head>
	


<body>

	
	<div id="header"></div>
	<form name="myForm" action="MainPage" method="get">
	
		<div class="sidebar-container">
		
			<div class="sidebar-logo" >
			    UTN Administrador
			</div>
			  	<ul class="sidebar-navigation">
			    <li class="header">Personas</li>
			    <li>
			      <a href="MainPageAdm?action=Alumnos">
			        <i class="fas fa-user-alt"></i> Alumnos
			      </a>
			    </li>
			    <li>
			      <a href="MainPageAdm?action=Docentes">
			        <i class="fas fa-user-tie"></i> Docentes
			      </a>
			    </li>
			    <li>
			      <a href="MainPageAdm?action=Eliminados">
			        <i class="fas fa-trash"></i> Eliminados
			      </a>
			    </li>
			    <li class="header">Entidades</li>
			    <li>
			      <a href="MainPageAdm?action=Materias">
			         <i class="far fa-clipboard"></i> Materias
			      </a>
			    </li>
			    <li>
			      <a href="MainPageAdm?action=Comisiones">
			        <i class="fa fa-users"></i> Comisiones
			      </a>
			    </li>
			    <li>
			      <a href="MainPageAdm?action=Mesas">
			        <i class="fas fa-graduation-cap"></i> Mesas
			      </a>
			    </li>
		  	</ul>
		</div>
	</form>
	
	<form id="myForm" name="myForm" action="MainPageAdmMesas" method="get">	
	
		<div class="content-container">
		  	<div class="container-fluid">			  
				
				<div class="jumbotron" style="padding-bottom: 15px;padding-top: 15px;">
					<div class="row">
						<div class="col">
							<h1><Strong>Mesas</Strong></h1>
						</div>
						<div class="col">
							<a href="MainPageAdmMesas?action=Add" type="button" class="btn btn-success" style="float:right;margin-top: 11px;"><i class="fas fa-plus-circle"></i> Nueva Mesa</a>
						</div>
					</div>
    				
    				
			    </div>
			    
				<div class="table-responsive">
					<table class="table table-hover table-sm table-striped">
					  <colgroup span="3"></colgroup>
					  <thead class="thead-dark">
					    <tr id="encabezado" align="center">
					      	<th scope="col"><p>ID</p></th>
					      	<th scope="col"><p>MATERIA</p></th>
					      	<th scope="col"><p>SALON</p></th>
							<th scope="col"><p>HORARIO</p></th>
							<th scope="col"><p>FECHA</p></th>
							<th scope="col"><p>ACCIONES</p></th>
					    </tr>
					  </thead>
					  
			
					  
					  <tbody>
					  <% for (Mesa MS:Mesas) {%>
					  	<%if(MS.getFecha().after(today)){ %>
						    <tr id="row">
						      <td align="center"><strong><%=MS.getIdMesa() %></strong></td>
						      <td align="center"><%=DM.getOne(MS.getIdMateria()).getNombre() %></td>
							  <td align="center"><%=MS.getSalon() %></td>
						      <td align="center"><%=MS.getHorario()%>:00 hs</td>
						      <td align="center"><%=MS.getFecha()%></td>
						      
						      <td style="padding-left: 5%;">					
						    	<a href="MainPageAdmMesas?action=Editar&idMesa=<%=MS.getIdMesa()%>" type="button" class="btn btn-warning"><i class="fas fa-user-edit"></i> Editar</a>
						    	<a href="MainPageAdmMesas?action=Eliminar&idMesa=<%=MS.getIdMesa()%>" type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i> Eliminar</a>									    		
						      </td>
						    </tr>
						 <%}%>
					  <%}%>
					  </tbody>
					</table>    
		
				</div>
		  		
		  	</div>
		</div>
	
	</form>
	
	<hr class="mb-4">
	<div id="footer"></div>
</body>
</html>
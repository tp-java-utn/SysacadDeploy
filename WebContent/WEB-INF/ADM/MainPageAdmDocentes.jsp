<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<%@page import="Entidades.Alumno.Carreras"%>
<%@page import="Entidades.Persona.EstadosPersona"%>

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
    	DataAlumno DA = new DataAlumno();
		ArrayList<Alumno> Alumnos = DA.getAll();
		
		DataDocente DD = new DataDocente();
		ArrayList<Docente> Docentes = DD.getAll();
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
	
	<form id="myForm" name="myForm" action="MainPageAdmAlumno" method="get">	
	
		<div class="content-container">
		  	<div class="container-fluid">			  
				
				<div class="jumbotron" style="padding-bottom: 15px;padding-top: 15px;">
					<div class="row">
						<div class="col">
							<h1><Strong>Docentes</Strong></h1>
						</div>
						<div class="col">
							<a href="MainPageAdmDocentes?action=Add" type="button" class="btn btn-success" style="float:right;margin-top: 11px;"><i class="fas fa-user-plus"></i> Nuevo Docente</a>
						</div>
					</div>
    				
    				
			    </div>
			    
				<div class="table-responsive">
					<table class="table table-hover table-sm table-striped" >
				  		<thead class="thead-dark">
					    	<tr style="text-align:center;">
							    <th scope="col">Apellido y Nombre</th>
							    <th scope="col">Email</th>
							    <th scope="col">Telefono</th>
							    <th scope="col">Direccion</th>
							    <th scope="col">Estado</th>
							    <th scope="col" style="padding-left: 10%;">Acciones</th>
					    	</tr>
				  		</thead>
				  		<tbody>
				  		<%if(Docentes != null) {%>
						  	<% for (Docente D:Docentes) {%>
						  		<%if(!D.getEstadoPersona().equals("Eliminado")) {%>
						  		
						  		<tr>
								    <th scope="row"><%=D.getApellido()%> <%=D.getNombre()%></th>
								    <td><%=D.getEmail()%></td>
								    <td align="center"><%=D.getTelefono()%></td>
								    
								    <% if(D.getDireccion().getNumero() !=0) {%>
									    <% if(D.getDireccion().getDept()== null) {%>
									    <td align="center"><%=D.getDireccion().getCalle()%> <%=D.getDireccion().getNumero()%></td>
									    <% }else{%>
									    <td align="center"><%=D.getDireccion().getCalle()%> <%=D.getDireccion().getNumero()%>, <%=D.getDireccion().getPiso()%> <%=D.getDireccion().getDept()%></td>
									    <% }%>
								    <% }else{%>
								    	<td align="center">-</td>
								    <% }%>
								    
							    	<% if(EstadosPersona.valueOf(D.getEstadoPersona()).equals(EstadosPersona.Activo)){%>
								    <td class="text-primary" align="center"><span class="label label-default"><%=D.getEstadoPersona()%></span></td>
								    <% }else if(EstadosPersona.valueOf(D.getEstadoPersona()).equals(EstadosPersona.Pendiente)){%>
								    <td class="text-muted" align="center"><span class="label label-default"><%=D.getEstadoPersona()%></span></td>
								    <% }else{%>
								    <td class="text-danger" align="center"><span class="label label-default"><%=D.getEstadoPersona()%></span></td>
								    <% }%>
							    	
								    <td align="center" style="padding-left: 10%;">					
								    	<% if(!EstadosPersona.valueOf(D.getEstadoPersona()).equals(EstadosPersona.Eliminado)){%>
								    	<a href="MainPageAdmDocentes?action=Editar&id=<%=D.getIdDocente()%>" type="button" class="btn btn-warning"><i class="fas fa-user-edit"></i> Editar</a>
								    	<a href="MainPageAdmDocentes?action=Eliminar&id=<%=D.getIdDocente()%>" type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i> Eliminar</a>									    	
								    	<% }%>		
								    </td>			
								    
						  		</tr>
						  	   <% }%>
					  		<% }%>
				  		<% }else{%>
				  			<tr>
				  				<td align="center">No hay docentes eliminados</td>
				  			</tr>
				  		<% }%>
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
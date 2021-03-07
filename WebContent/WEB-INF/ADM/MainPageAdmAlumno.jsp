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
		
			    <!-- Main component for a primary marketing message or call to action -->
			    <div class="jumbotron" style="padding: 0">
			    	<table border="0" cellpadding="20">
			    		<tr>
			    			<td>
			    				<h1><Strong>Alumnos</Strong></h1>
			    			</td>
			    		</tr>
			    		<tr>
			    			<td>
			    				<p>Los <strong>Alumnos</strong>  pueden cursar las siguientes carreras:</p>
							      <ul>
									  <li class="text-info">Sistemas</li>
									  <li class="text-success">Quimica</li>
									  <li class="text-secondary">Mecanica</li>
									  <li class="text-danger">Civil</li>
									  <li class="text-primary">Electrica</li>
								  </ul> 
			    			</td>
			    			<td>
			    				<p>Los posibles estados que puede tener un <strong>Alumnos</strong> son:</p>
						      	  <ul>
									  <li class="text-primary">Activo </li>
									  <li class="text-muted">Pendiente</li>
									  <li class="text-danger">Eliminado</li>
									  <li style="visibility: hidden"></li>
									  <li style="visibility: hidden"></li>
								  </ul>
			    			</td>
			    		</tr>
			    	</table>
			      

			    </div>
			    
				<div class="table-responsive">
					<table class="table table-hover table-sm table-striped" >
				  		<thead class="thead-dark">
					    	<tr style="text-align:center;">
							    <th scope="col">Apellido y Nombre</th>
							    <th scope="col">Legajo</th>
							    <th scope="col">Email</th>
							    <th scope="col">Telefono</th>
							    <th scope="col">Direccion</th>
							    <th scope="col">Carrera</th>
							    <th scope="col">Estado</th>
							    <th scope="col" >Acciones</th>
					    	</tr>
				  		</thead>
			  		
				  		<tbody>
				  		<% for (Alumno Al:Alumnos) {%>
				  			<%if(!Al.getEstadoPersona().equals("Eliminado")) {%>
				  			<tr>
							    <th scope="row"><%=Al.getApellido()%> <%=Al.getNombre()%></th>
							    <td align="center"><%=Al.getLegajo()%></td>
							    <td><%=Al.getEmail()%></td>
							    <td align="center"><%=Al.getTelefono()%></td>
							    
							    <% if(Al.getDireccion().getPiso()==0) {%>
							    <td align="center"><%=Al.getDireccion().getCalle()%> <%=Al.getDireccion().getNumero()%></td>
							    <% }else{%>
							    <td align="center"><%=Al.getDireccion().getCalle()%> <%=Al.getDireccion().getNumero()%>, <%=Al.getDireccion().getPiso()%> <%=Al.getDireccion().getDept()%></td>
							    <% }%>
							    
							    <td align="center">
							    	<% if(Al.getCarrera().equals(Carreras.Sistemas)) {%>
							    		<svg width="10" height="12"><circle cx="5" cy="5" r="5"  fill="#5bc0de" /></svg>
							    	<% }else if(Al.getCarrera().equals(Carreras.Quimica)){%>
							    		<svg width="10" height="12"><circle cx="5" cy="5" r="5"  fill="#5cb85c" /></svg>
						    		<% }else if(Al.getCarrera().equals(Carreras.Civil)){%>
							    		<svg width="10" height="12"><circle cx="5" cy="5" r="5"  fill="#d9534f" /></svg>
							    	<% }else if(Al.getCarrera().equals(Carreras.Electrica)){%>
							    		<svg width="10" height="12"><circle cx="5" cy="5" r="5"  fill="#0275d8" /></svg>
							    	<% }else if(Al.getCarrera().equals(Carreras.Mecanica)){%>
							    		<svg width="10" height="12"><circle cx="5" cy="5" r="5"  fill="#868e96" /></svg>
							    	<% }%>	
							    	
							    	<%=Al.getCarrera()%>
							    </td>
							    
							    <% if(EstadosPersona.valueOf(Al.getEstadoPersona()).equals(EstadosPersona.Activo)){%>
							    <td class="text-primary" align="center"><span class="label label-default"><%=Al.getEstadoPersona()%></span></td>
							    <% }else if(EstadosPersona.valueOf(Al.getEstadoPersona()).equals(EstadosPersona.Pendiente)){%>
							    <td class="text-muted" align="center"><span class="label label-default"><%=Al.getEstadoPersona()%></span></td>
							    <% }else{%>
							    <td class="text-danger" align="center"><span class="label label-default"><%=Al.getEstadoPersona()%></span></td>
							    <% }%>		
							    					
							    <td align="center">					
							    	<% if(!EstadosPersona.valueOf(Al.getEstadoPersona()).equals(EstadosPersona.Eliminado)){%>
							    	
							    		<% if(!EstadosPersona.valueOf(Al.getEstadoPersona()).equals(EstadosPersona.Activo)){%>
								    	<a href="MainPageAdmAlumno?action=Activar&id=<%=Al.getLegajo()%>" type="button" class="btn btn-success" ><i class="fas fa-user-check"></i> Activar</a>
								    	<% }else {%>	
								    	<a href="MainPageAdmAlumno?action=Activar&id=<%=Al.getLegajo()%>" type="button" class="btn btn-secondary disabled" ><i class="fas fa-user-check"></i> Activar</a>
								    	<% }%>
								    	
								    	<a href="MainPageAdmAlumno?action=Editar&id=<%=Al.getLegajo()%>" type="button" class="btn btn-warning"><i class="fas fa-user-edit"></i> Editar</a>
								    	
							    	<% }%>
						    							    	
							    	<%if(!EstadosPersona.valueOf(Al.getEstadoPersona()).equals(EstadosPersona.Eliminado)){%>
							    	<a href="MainPageAdmAlumno?action=Eliminar&id=<%=Al.getLegajo()%>" type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i> Eliminar</a>
							    	<% }else{%>		
							    	<a href="MainPageAdmAlumno?action=Recuperar&id=<%=Al.getLegajo()%>" type="button" class="btn btn-dark"><i class="fas fa-user-plus"></i> Recuperar</a>			
									<% }%>
							    </td>
						    </tr>
						    <% }%>
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
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
    	DataComision DC = new DataComision();
   		ArrayList<Comision> Comisiones = DC.getAll();
		
		DataDocente DD = new DataDocente();
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
	
	<form id="myForm" name="myForm" action="MainPageAdmComisiones" method="get">	
	
		<div class="content-container">
		  	<div class="container-fluid">			  
				
				<div class="jumbotron" style="padding-bottom: 15px;padding-top: 15px;">
					<div class="row">
						<div class="col">
							<h1><Strong>Comisiones</Strong></h1>
						</div>
						<div class="col">
							<a href="MainPageAdmComisiones?action=Add" type="button" class="btn btn-success" style="float:right;margin-top: 11px;"><i class="fas fa-plus-circle"></i> Nueva Comision</a>
						</div>
					</div>
    				
    				
			    </div>
			    
				<div class="table-responsive">
					<table class="table table-hover table-sm table-striped" >
				  		<thead class="thead-dark">
					    	<tr style="text-align:center;">
							    <th scope="col">ID</th>
							    <th scope="col">Materia</th>
							    <th scope="col">Docente</th>
							    <th scope="col" >Turno</th>						    
							    <th scope="col">Cant Alumnos</th>
							    <th scope="col" style="padding-left: 10%;">Acciones</th>
					    	</tr>
				  		</thead>
				  		<tbody>
				  		<%if(Comisiones != null) {%>
						  	<% for (Comision C:Comisiones) {%>
						  		
						  		<tr>
								    <th scope="row"><%=C.getIdComision() %></th>
								    <td><%=DM.getOne(C.getIdMateria()).getNombre()%></td>
								    <td align="center"><%=DD.getOne(C.getIdDocente()).getNombre()%> <%=DD.getOne(C.getIdDocente()).getApellido()%></td>
									<th align="center" style="text-align: center;"><%=C.getTurno() %></th>
									
									<%if(C.getCantAlumnos() == C.getCantAlumnosMax()){ %>
									<th class="text-danger" align="center" style="text-align: center;"><%=C.getCantAlumnos() %>/<%=C.getCantAlumnosMax() %> FULL</th>
									<%}else if(C.getCantAlumnos() >= C.getCantAlumnosMax()/2){ %>
									<th class="text-warning" align="center" style="text-align: center;"><%=C.getCantAlumnos() %>/<%=C.getCantAlumnosMax() %></th>
									<%}else{ %>
									<th align="center" style="text-align: center;"><%=C.getCantAlumnos() %>/<%=C.getCantAlumnosMax() %></th>
									<%} %>
							    	
							    	
								    <td align="center" style="padding-left: 10%;">					
								    	<a href="MainPageAdmComisiones?action=Editar&idComision=<%=C.getIdComision()%>&idMateria=<%=C.getIdMateria()%>" type="button" class="btn btn-warning"><i class="fas fa-user-edit"></i> Editar</a>
								    	<a href="MainPageAdmComisiones?action=Eliminar&idComision=<%=C.getIdComision()%>&idMateria=<%=C.getIdMateria()%>" type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i> Eliminar</a>									    		
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
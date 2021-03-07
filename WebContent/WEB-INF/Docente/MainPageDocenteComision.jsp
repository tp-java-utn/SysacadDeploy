<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Docente - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/loginDocente.png">

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
	  $("#header").load("HeaderDocente.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>

	<!-- Entidades -->
    <% 
    	Comision C= (Comision)session.getAttribute("Comision");
    
    	DataMateria DM = new DataMateria();	
    	ArrayList<Materia> Materias = DM.getAll();
    	
    	DataComision DC = new DataComision();
    	ArrayList<Comision> Comisiones = DC.getAll();
    	
    	DataAlumno DA = new DataAlumno();
    	ArrayList<Alumno> Alumnos = DA.getAll();
    	
    	DataInscripcion DI = new DataInscripcion();

    	DataEstadoAcademico DEA = new DataEstadoAcademico();

    	boolean AlumnosComision = false;
    %>

</head>
	


<body>
	<div id="header"></div>


	<h2 style="color: #6c757d;padding: 25px;"><strong><%=DM.getOne(C.getIdMateria()).getNombre() %> - <%=C.getIdComision()%></strong></h2>
	
	<div class="table-responsive">
		<table class="table table-hover table-sm table-striped">
		  <colgroup span="3"></colgroup>
		  <thead class="thead-dark">
		    <tr id="encabezado" align="center">
		      	<th scope="col"><p>LEGAJO</p></th>
		      	<th scope="col"><p>NOMBRE</p></th>	
		      	<th scope="col"><p>MAIL</p></th>	
		      	<th scope="col"><p>ESTADO</p></th>	
		      	<th scope="col"><p>ACCIONES</p></th>	
		    </tr>
		  </thead>
		  

		  
		  <tbody style="color: #6c757d">
		  <% for (Alumno A:Alumnos) {%>
		  	<%if(DI.getOne(A.getLegajo(), C.getIdMateria(), C.getIdComision()).getIdComision() != 0 && !DEA.getOne(A.getLegajo(), C.getIdMateria()).getEstado().equalsIgnoreCase("Aprobada")){ %>
		  	<%AlumnosComision = true; %>
			    <tr id="row">
			      <td align="center"><strong><%=A.getLegajo() %></strong></td>
			      <td align="center"><%=A.getApellido() %> <%=A.getNombre() %></td>
			      <td align="center"><%=A.getEmail() %></td>
			     
			      
			      <td align="center">
				      <select name="EstadoAcademico" id="select<%=A.getLegajo()%>" class="custom-select d-block w-100" required onchange="location = this.value;">
				        <option value="MainPageDocenteComision?action=Estado&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&estate=Libre">Libre</option>
				        <option value="MainPageDocenteComision?action=Estado&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&estate=Cursando">Cursando</option>
				        <option value="MainPageDocenteComision?action=Estado&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&estate=Regular">Regular</option>
				        <option value="MainPageDocenteComision?action=Estado&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&estate=Aprobada">Aprobada</option>
			       	  </select>
			      </td>
			      
			      <td style="padding-left: 5%;">					
			    	<a href="MainPageDocenteComision?action=Examen&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&idComision=<%=C.getIdComision() %>" type="button" class="btn btn-info"><i class="fas fa-file-alt"></i> Examen</a>			    										    	
			      </td>
			    </tr>
		  	<%}%>
		  <%}%>
		  </tbody>
		</table>    
		<hr>
		
		<%if(!AlumnosComision){ %>
			<div class="my-3 p-3 bg-white rounded shadow-sm">						    				
			    <div class="media text-muted pt-3">        							    	
				    <div class="media-body pb-3 mb-1 small lh-125  border-gray">
				    	<span class="d-block" style="margin-left: 45%;">No hay Alumnos Inscriptos</span>
				    </div>
				</div>
			</div>
		<%} %>
		
	</div>
	
	<div id="footer"></div>

</body>

<script>
<% for (Alumno A:Alumnos) {%>
	$('#select<%=A.getLegajo()%> option[value="MainPageDocenteComision?action=Estado&idMateria=<%=C.getIdMateria() %>&legajo=<%=A.getLegajo() %>&estate=<%=DEA.getOne(A.getLegajo(),C.getIdMateria()).getEstado()%>"]').attr("selected",true);
<%}%>

</script>
</html>
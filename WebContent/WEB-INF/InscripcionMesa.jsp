<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<%@page import="java.sql.Date"%>

<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mesas - UTN</title>
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
	    long now = System.currentTimeMillis();
		Date today = new Date(now);
		
    	Alumno A= (Alumno)session.getAttribute("usuario");
    	String action=(String)request.getAttribute("action");
    	Materia M= (Materia)session.getAttribute("Materia");
    	
	    DataMateria DM = new DataMateria();
		ArrayList<Materia> Materias = new ArrayList<Materia>();
		Materias.add(M);
		
		DataMesa DMesas = new DataMesa();
		ArrayList<Mesa> Mesas = DMesas.getAll();

		DataComision DC = new DataComision();
		DataDocente DD = new DataDocente();
		ArrayList<Integer> DocentesIds = DC.getAllDocentePorMateria(M.getIdMateria());
    %>

</head>
	


<body>

	<div id="header"></div>
	
			    	
	<form class="form-signin" id="myForm" name="InscripcionMesa" action="InscripcionMesa" method="get">			
	<div role="main" class="container">	
  	
		<div class="my-3 p-3 bg-white rounded shadow-sm">
		<%if(DMesas.MateriaExist(M.getIdMateria())){%>
			<% for (Materia MS:Materias) {%>
				<h4 class="border-bottom border-gray pb-2 mb-0" style="margin-top: 50px;"><%=MS.getNombre()%></h4>
				<%for (Mesa Me:Mesas) {%>
					<%if(Me.getIdMateria()==MS.getIdMateria() && Me.getFecha().after(today)) {%>
					    				
					    <div class="media text-muted pt-3">
					    	<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#428bca"></rect></svg>
						    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
								    
								
								<div class="d-flex justify-content-between align-items-center w-100">
								    	<strong class="text-gray-dark">Mesa <%=Me.getIdMesa()%> - Final</strong>
								    	<a type="button" class="btn btn-primary" name="BtnInscribirse" id="<%=MS.getIdMateria()%>" style="margin-top: 10px;" href="InscripcionMesa?action=seleccion&idMateria=<%=M.getIdMateria()%>&idMesa=<%=Me.getIdMesa()%>&legajo=<%=A.getLegajo()%>"> <i class="far fa-check-circle" style="padding-right: 10px;"></i>Inscribirse</a>
								</div>
								
								<span class="d-block"><strong>Fecha:</strong> <%=Me.getFecha()%></span>
								<span class="d-block"><strong>Horario:</strong> <%=Me.getHorario()%>:00 hs</span>
								
								<span class="d-block"><strong>Docentes:</strong>
									<%for (Integer id:DocentesIds) {%>
									<div class="form-check form-check-inline">
									  <input class="form-check-input" type="radio" name="<%=Me.getIdMesa()%>" id="exampleRadios1" value="option1">
									  <label class="form-check-label" for="exampleRadios1">
									    <%=DD.getOne(id).getApellido()%>, <%=DD.getOne(id).getNombre()%>
									  </label>
									</div>
						            <%}%>
					            </span>
					            
							</div>
						</div>					   			   
				    <%}%>
				<%}%>
			<%}%>
		<%}else{%>
		<h4 class="border-bottom border-gray pb-2 mb-0" style="margin-top: 50px;"><%=M.getNombre()%></h4>
		<p>No hay Mesas disponilbes.</p>
		<%}%>
		</div>
    </div>

    
    <div class="row justify-content-center">
		<div class="col-2">
	    	<a class="btn btn-primary btn-lg btn-block" href="InscripcionMesa?action=volver">Volver</a>
	    </div>
    </div>
    
    </form>
    
	<hr class="mb-4">
	<div id="footer"></div>
</body>
</html>
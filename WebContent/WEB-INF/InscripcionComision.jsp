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
    <title>Comision - UTN</title>
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
    	String action=(String)request.getAttribute("action");
    	Materia M= (Materia)session.getAttribute("Materia");
    	
	    DataMateria DM = new DataMateria();
		ArrayList<Materia> Materias = new ArrayList<Materia>();
		Materias.add(M);
		
		DataComision DC = new DataComision();
		ArrayList<Comision> Comisiones = DC.getAll();
    %>

</head>
	


<body>

	<div id="header"></div>
	
			    	
	<form class="form-signin" id="myForm" name="myForm" action="" method="post">			
	<div role="main" class="container">	
  	
		<div class="my-3 p-3 bg-white rounded shadow-sm">
		<% for (Materia MS:Materias) {%>
			<h4 class="border-bottom border-gray pb-2 mb-0" style="margin-top: 50px;"><%=MS.getNombre()%></h4>
			<%for (Comision CS:Comisiones) {%>
				<%if(CS.getIdMateria()==MS.getIdMateria()) {%>
				    				
				    <div class="media text-muted pt-3">
				    	<%if(CS.getCantAlumnos()<CS.getCantAlumnosMax() && CS.getCantAlumnos()<CS.getCantAlumnosMax()/2) {%>
				    	<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#428bca"></rect></svg>
					    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
						    
						
						<div class="d-flex justify-content-between align-items-center w-100">
						    	<strong class="text-gray-dark">Comision <%=CS.getIdComision()%> - Turno <%=CS.getTurno()%></strong>
						    	<a type="button" class="btn btn-primary" name="BtnInscribirse" id="<%=MS.getIdMateria()%>" style="margin-top: 10px;" href="InscripcionComision?action=seleccion&idMateria=<%=M.getIdMateria()%>&idComision=<%=CS.getIdComision()%>&legajo=<%=A.getLegajo()%>"> <i class="far fa-check-circle" style="padding-right: 10px;"></i>Inscribirse</a>
						</div>
						
						<span class="d-block">Cupos disponibles: <%=CS.getCantAlumnosMax()-CS.getCantAlumnos()%></span>
						
						<div class="progress">
					    	<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: <%=100*((float)CS.getCantAlumnos()/(float)CS.getCantAlumnosMax())%>%;" aria-valuenow="<%=CS.getCantAlumnos()%>" aria-valuemin="0" aria-valuemax="<%=CS.getCantAlumnosMax()%>"><%=CS.getCantAlumnos()%>/<%=CS.getCantAlumnosMax()%></div>
					    </div>
					    
					    <%}else if(CS.getCantAlumnos()>=CS.getCantAlumnosMax()/2 && CS.getCantAlumnos()<CS.getCantAlumnosMax()){%>
					    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#f0ad4e"></rect></svg>
					    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					    
					    <div class="d-flex justify-content-between align-items-center w-100">
						    	<strong class="text-gray-dark">Comision <%=CS.getIdComision()%> - Turno <%=CS.getTurno()%></strong>
						    	<a type="button" class="btn btn-primary" name="BtnInscribirse" id="<%=MS.getIdMateria()%>" style="margin-top: 10px;" href="InscripcionComision?action=seleccion&idMateria=<%=M.getIdMateria()%>&idComision=<%=CS.getIdComision()%>&legajo=<%=A.getLegajo()%>"> <i class="far fa-check-circle" style="padding-right: 10px;"></i>Inscribirse</a>
						</div>
						
						<span class="d-block">Cupos disponibles: <%=CS.getCantAlumnosMax()-CS.getCantAlumnos()%></span>
						
						<div class="progress">
					    	<div class="progress-bar bg-warning progress-bar-striped progress-bar-animated" role="progressbar" style="width: <%=100*((float)CS.getCantAlumnos()/(float)CS.getCantAlumnosMax())%>%;" aria-valuenow="<%=CS.getCantAlumnos()%>" aria-valuemin="0" aria-valuemax="<%=CS.getCantAlumnosMax()%>"><%=CS.getCantAlumnos()%>/<%=CS.getCantAlumnosMax()%></div>
					    </div>
					    
					    <%}else if(CS.getCantAlumnos()==CS.getCantAlumnosMax()){%>
					    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#d9534f"></rect></svg>
					    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					    
					    <div class="d-flex justify-content-between align-items-center w-100">
						    	<strong class="text-gray-dark">Comision <%=CS.getIdComision()%> - Turno <%=CS.getTurno()%> </strong>
						    	<button type="button" class="btn btn-secondary  disabled" name="BtnInscribirse" id="<%=MS.getIdMateria()%>" style="margin-top: 10px;"  disabled><i class="fas fa-check-circle" style="padding-right: 10px;"></i> Inscribirse</button>
						</div>
						
					    <span class="d-block">Alumnos <%=CS.getCantAlumnos()%>/<%=CS.getCantAlumnosMax()%></span>
					    
					    <div class="progress">
					    	<div class="progress-bar bg-danger progress-bar-striped progress-bar-animated" role="progressbar" style="width: <%=100*(CS.getCantAlumnos()/CS.getCantAlumnosMax())%>%;" aria-valuenow="<%=CS.getCantAlumnos()%>" aria-valuemin="0" aria-valuemax="<%=CS.getCantAlumnosMax()%>">Cupo completo</div>
					    </div>
					    <%}%>
					    
					    
					    </div>
				    </div>
			   
			    <%}%>
			<%}%>
		<%}%>
		</div>
    </div>
    
    <div class="row justify-content-center">
		<div class="col-2">
	    	<a class="btn btn-primary btn-lg btn-block" href="InscripcionComision?action=volver">Volver</a>
	    </div>
    </div>
    
    </form>
    
	<hr class="mb-4">
	<div id="footer"></div>
</body>
</html>
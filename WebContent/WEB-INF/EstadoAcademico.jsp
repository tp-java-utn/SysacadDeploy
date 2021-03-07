<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.*"%>
<%@page import="Entidades.Alumno"%>
<%@page import="Entidades.EstadoAcademico"%>
<%@page import="Entidades.Materia"%>
<%@page import="Entidades.EstadoAcademico.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Estado Academico - UTN</title>
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
	
	<!-- Chart.js -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	
	
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
	
    	DataEstadoAcademico DEA = new DataEstadoAcademico();
    	ArrayList<EstadoAcademico> EstadosAcademicos = A.getEstadosAcedemicos(DEA.getAll());
    %>

</head>
	


<body>
	<div id="header"></div>
	
	
	<div class="container">
	  	<div class="py-5 text-center">
	       	<h1 class="text-dark"><strong>Estado Academico</strong></h1>
	  	</div>
	</div>

	<div class="card">
		<div class="container-fluid" style="padding: 50px;">
				<h3 class="text-center">Estado de la carrera de Ing <%=A.getCarrera()%></h3>
				<div class="row">
				
					<div class="col-xl-6">
					
					
						<p style="padding-top: 10px;">Libre</p>
						<div class="progress">
						  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" aria-valuenow="<%=A.catMateriasPorEstado(estadosMateria.Libre)%>" aria-valuemin="0" aria-valuemax="35" style="width: <%=100*((float)A.catMateriasPorEstado(estadosMateria.Libre)/(float)35)%>%;"><%=A.catMateriasPorEstado(estadosMateria.Libre)%>/35</div>
						</div> 
						
						<p style="padding-top: 10px;">Cursando</p>
						<div class="progress">
						  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="<%=A.catMateriasPorEstado(estadosMateria.Cursando)%>" aria-valuemin="0" aria-valuemax="35" style="width: <%=100*((float)A.catMateriasPorEstado(estadosMateria.Cursando)/(float)35)%>%;"><%=A.catMateriasPorEstado(estadosMateria.Cursando)%>/35</div>
						</div>
		
						<p style="padding-top: 10px;">Regulares</p>
						<div class="progress">
						  <div class="progress-bar progress-bar-striped progress-bar-animated bg-info" role="progressbar" aria-valuenow="<%=A.catMateriasPorEstado(estadosMateria.Regular)%>" aria-valuemin="0" aria-valuemax="35" style="width: <%=100*((float)A.catMateriasPorEstado(estadosMateria.Regular)/(float)35)%>%;"><%=A.catMateriasPorEstado(estadosMateria.Regular)%>/35</div>
						</div>
		
						<p style="padding-top: 10px;">Aprobadas</p>
						<div class="progress">
						  <div class="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" aria-valuenow="<%=A.catMateriasPorEstado(estadosMateria.Aprobada)%>" aria-valuemin="0" aria-valuemax="35" style="width: <%=100*((float)A.catMateriasPorEstado(estadosMateria.Aprobada)/(float)35)%>%;"><%=A.catMateriasPorEstado(estadosMateria.Aprobada)%>/35</div>
						</div>
						
						<p style="padding-top: 10px;">Promedio: 
						<%if(A.getPromedio()==0){%>
							-
						<%}else{%>
							<%=A.getPromedio()%>
						<%}%>
						</p>
	
					</div>
					
					<div class="col-xl-6">
					
						<div  style="height: 10%;">
						<canvas align="center" id="doughnutChart" ></canvas>
						</div>				
					</div>
					
				</div>
		</div>
	</div>	
	
	<div class="table-responsive">
		<table class="table table-striped table-hover tableFixHead">
			  <colgroup span="3"></colgroup>
			  <thead>
			    <tr id="encabezado" align="center">
			      	<th scope="col"><p>ID</p></th>
			      	<th scope="col"><p>MATERIA</p></th>
			      	<th scope="col"><p>ASISTENCIA</p></th>
			      	<th scope="col"><p>NOTA</p></th>
			      	<th scope="col"><p>ESTADO</p></th>
			    </tr>
			  </thead>
			  
	
			  
			  <tbody>
			  <% for (Materia M:Materias) {%>
			    <tr id="row">
					<td align="center"><strong><%=M.getIdMateria()%></strong></td>
			        <td><%=M.getNombre()%></td>
			        <% for (EstadoAcademico EAS:EstadosAcademicos) {%>
			        	<%if(EAS.getIdMateria()==M.getIdMateria()){%>
			        	
			        	<%if(EAS.getEstado().equals(estadosMateria.Aprobada.toString()) || EAS.getEstado().equals(estadosMateria.Regular.toString())){%>
			        		<td align="center"><%=EAS.getAsistencia()%>%</td>	        		
			        	<%}else{%>
			        		<td align="center">-</td>
			        	<%}%>
			        	
			        	<%if(EAS.getNota()>0){%>
			        		<td align="center"><%=EAS.getNota()%>/10</td>
			        	<%}else{%>
			        		<td align="center">-</td>
			        	<%}%>
			        	
			        	<td align="justify">
			        		<%if(EAS.getEstado().equals(estadosMateria.Cursando.toString())){%>
				        	<svg width="10" height="12">
						    	<circle cx="5" cy="5" r="5"  fill="#428bca" />
						    </svg>
						    <%}else if(EAS.getEstado().equals(estadosMateria.Libre.toString())){%>
						    <svg width="10" height="12">
						    	<circle cx="5" cy="5" r="5"  fill="#d9534f" />
						    </svg>
						    <%}else if(EAS.getEstado().equals(estadosMateria.Aprobada.toString())){%>
						    <svg width="10" height="12">
						    	<circle cx="5" cy="5" r="5"  fill="#5cb85c" />
						    </svg>
						    <%}else{%>
						    <svg width="10" height="12">
						    	<circle cx="5" cy="5" r="5"  fill="#5bc0de" />
						    </svg>
						    <%}%>
						    
			        	<%=EAS.getEstado()%>
			        	</td>
			        	
			        	<%}%>
			        <%}%>

			    </tr>
			  <%} %>
			  </tbody>
		</table>      
	</div>
	

	<div class="row justify-content-center">
		<div class="col-3">
	    	<a class="btn btn-primary btn-lg btn-block" href="MainPage?action=volver">Volver al Menu</a>
	    </div>
    </div>
		
	<hr class="mb-4">
	<div id="footer"></div>
	
	<script>
	//doughnut
	var ctxD = document.getElementById("doughnutChart").getContext('2d');
	var myLineChart = new Chart(ctxD, {
	type: 'doughnut',
	data: {
	labels: ["Cursando", "Libres", "Aprobadas", "Regulares"],
	datasets: [{
	data: [<%=A.catMateriasPorEstado(estadosMateria.Cursando)%>, <%=A.catMateriasPorEstado(estadosMateria.Libre)%>, <%=A.catMateriasPorEstado(estadosMateria.Aprobada)%>, <%=A.catMateriasPorEstado(estadosMateria.Regular)%>],
	backgroundColor: ["#428bca", "#d9534f", "#5cb85c", "#5bc0de"],
	hoverBackgroundColor: ["#0d47a1", "#CC0000", "#007E33", "#0099CC"],
	}]
	},
	options: {
	responsive: true
	}
	});
	</script>
</body>


</html>
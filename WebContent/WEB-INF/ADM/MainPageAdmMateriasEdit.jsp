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
    	Materia M = (Materia)session.getAttribute("Materia");
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
	
	<form id="myForm" name="myForm" action="MainPageAdmEditMateria" method="get">	
		<div class="content-container">
		  	<div class="container-fluid">
		
				
			    
			    <div class="col-md-12 order-md-1">
	  				<h1><Strong>Nueva Materia</Strong></h1>
	  			
		  			
	  				<div class="row">
	  				
			          	<div class="col-md-6 mb-3">
			          	<label for="Nombre">Nombre Materia</label>
				        <input name= "Nombre" type="text" class="form-control" id="Nombre" value="<%=M.getNombre() %>"  pattern="[A-Za-z ]{4,40}" required
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div>
					    
					    <div class="col-md-3 mb-3">
				        <label for="Cursado">Cursado</label>
				        <select name="Cursado" id="Cursado" class="custom-select d-block w-100" required>
				        <option value="">Elige...</option>
				        <option value="Anual">Anual</option>
				        <option value="cuatrimestre1">1° cuatrimestre</option>
				        <option value="cuatrimestre2">2° cuatrimestre</option>

				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione un tipo de Documento.
					        </div>
				        </div>   
					    
					    <div class="col-md-3 mb-3">
				        <label for="nivel">Año</label>
				        <select name="nivel" id="nivel" class="custom-select d-block w-100" required>
				        <option value="">Elige...</option>
				        <option value="1">1° año</option>
				        <option value="2">2° año</option>
				        <option value="3">3° año</option>
				        <option value="4">4° año</option>
				        <option value="5">5° año</option>
				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione un tipo de Documento.
					        </div>
				        </div>
				          	 
	
	          		</div>	        	
          		
          			<div class="row">
          				<div class="col-md-12 mb-3">
				      		<label for="Descripcion">Descripcion <span class="text-muted">(Opcional)</span></label>
					        <textarea  name="Descripcion" class="form-control" id="Descripcion"  rows="3" maxlength="1024"></textarea>
				        </div>
          			</div>
          			
          			<div class="row">
          				<%if(M.getCorrelativasRegulares()  != null){ %>
          				<div class="col-md-4 mb-3">
			      		<label for="CorrelativasRegulares">Correlativas Regulares</label>
		      	  		<input name= "CorrelativasRegulares" type="text" class="form-control" value="<%=M.getCorrelativasRegulares() %>" id="CorrelativasRegulares" placeholder="1-2-n" 
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div> 
					    <%}else{ %>
					    <div class="col-md-4 mb-3">
			      		<label for="CorrelativasRegulares">Correlativas Regulares</label>
		      	  		<input name= "CorrelativasRegulares" type="text" class="form-control" id="CorrelativasRegulares" placeholder="1-2-n" 
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div> 					    
					    <%} %>
					    
					    <%if(M.getCorrelativasAprobadas()  != null){ %>
					    <div class="col-md-4 mb-3">
			      		<label for="CorrelativasAprobadas">Correlativas Aprobadas</label>
		      	  		<input name= "CorrelativasAprobadas" type="text" class="form-control" value="<%=M.getCorrelativasAprobadas() %>" id="CorrelativasAprobadas"  placeholder="1-2-n"  
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div> 
					    <%}else{ %>
					    <div class="col-md-4 mb-3">
			      		<label for="CorrelativasAprobadas">Correlativas Aprobadas</label>
		      	  		<input name= "CorrelativasAprobadas" type="text" class="form-control" id="CorrelativasAprobadas"  placeholder="1-2-n"  
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div>
					    <%} %>
					    
					    <%if(M.getCorrelativasRendir()  != null){ %>
					    <div class="col-md-4 mb-3">
			      		<label for="CorrelativasRendir">Correlativas para Rendir</label>
		      	  		<input name= "CorrelativasRendir" type="text" class="form-control" value="<%=M.getCorrelativasRendir() %>" id="CorrelativasRendir"   placeholder="1-2-n" 
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div> 
					    <%}else{ %>
					    <div class="col-md-4 mb-3">
			      		<label for="CorrelativasRendir">Correlativas para Rendir</label>
		      	  		<input name= "CorrelativasRendir" type="text" class="form-control"  id="CorrelativasRendir"   placeholder="1-2-n" 
				        	title = "El Tamaño minimo es de 4 y el maximo de 20">
					    </div> 
					    <%} %>
					    
          			</div>
          			
          		</div>         				      
		        
	      		

		        
	 		</div>
  		
		 </div>
		
		<div class="row justify-content-center">
			<div class="col-3">
		    	<button class="btn btn-warning btn-lg btn-block" type="submit" ><i class="fas fa-save"></i> Guardar</button> 
		    </div>
    	</div>
    	
	</form>
	
	<hr class="mb-4">
	<div id="footer"></div>
	
	
	
</body>

<script>
	<%if(M.getcursado().equals("1° cuatrimestre")){%>
		$('select option[value="cuatrimestre1"]').attr("selected",true);
	<%}else if(M.getcursado().equals("2° cuatrimestre")){%>
		$('select option[value="cuatrimestre2"]').attr("selected",true);
	<%}else{%>
		$('select option[value="<%=M.getcursado() %>"]').attr("selected",true);
	<%}%>
	
	
	
	<%if(M.getAño().equals("1° año")){%>
		$('select option[value="1"]').attr("selected",true);
	<%}else if(M.getAño().equals("2° año")){%>
		$('select option[value="2"]').attr("selected",true);
	<%}else if(M.getAño().equals("3° año")){%>
		$('select option[value="3"]').attr("selected",true);
	<%}else if(M.getAño().equals("4° año")){%>
		$('select option[value="4"]').attr("selected",true);
	<%}else if(M.getAño().equals("5° año")){%>
		$('select option[value="5"]').attr("selected",true);
	<%}%>
	
	("#Descripcion").value = "<%=M.getdescripcion() %>"; 
</script>


</html>
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
   		Alumno A = (Alumno)session.getAttribute("Alumno");
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
	
	<form id="myForm" name="myForm" action="MainPageAdmEditAlumno" method="get">	
		<div class="content-container">
		  	<div class="container-fluid">
		
				
			    
			    <div class="col-md-12 order-md-1">
  				<h1><Strong>Edicion de <%=A.getNombre() %></Strong></h1>
  			
	  			
  				<div class="row">
  				
		          	<div class="col-md-6 mb-3">
		          	<label for="nombre">Nombre</label>
			        <input name= "nombre" type="text" class="form-control" id="nombre" value="<%=A.getNombre()%>" required pattern="[A-Za-z ]{4,20}" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				        	Tu nombre es necesario.
				        </div>
				    </div>
				    
				    <div class="col-md-6 mb-3">
		      		<label for="apellido">Apellido</label>
		      	  	<input name="apellido" type="text" class="form-control" id="apellido" value="<%=A.getApellido()%>" required pattern="[A-Za-z ]{4,20}" required
		      	  		title = "El Tamaño minimo es de 4 y el maximo de 20">	      	 
			          	<div class="invalid-feedback">
			            	Tu apellido es necesario.
			          	</div>
	          		</div>
	          			
          		</div>
          		
          		<div class="row">
			        <div class="col-md-4 mb-3">
		          		<div class="mb-4">
				        <label for="tipoDocumento">Tipo de Documento</label>
				        <select name="tipoDocumento" id="tipoDocumento" class="custom-select d-block w-100" required>
				        <option value="">Elige...</option>
				        <option value="DNI">Documento Nacional de Identidad</option>
				        <option value="Pasaporte">Pasaporte</option>
				        <option value="LibretaDeEnrolamiento">Libreta de Enrolamiento</option>
				        <option value="LibretaCivica">Libreta Civica</option>
				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione un tipo de Documento.
					        </div>
				        </div>
			        </div>
			        
		        	<div class="col-md-6 mb-3">
			      		<label for="documento">Nuemro de Documento</label>
				        <input  name="documento" type="text" class="form-control" id="documento" value="<%=A.getDocumento().getNumero()%>" required pattern="[0-9 ]{4,20}" required
				        	title = "El Tamaño minimo es de 4 y el maximo de 20 digitos">
					        <div class="invalid-feedback">
					        	Por favor ingrese un Numero de Documento valido.
					        </div>
			        </div>
		        </div>
		        
          		
		        

		        
	      		<div class="mb-3">
	      		<label for="email">Email</label>
		        <input name="email" type="email" class="form-control" id="email" value="<%=A.getEmail()%>" maxlength="30" required
		        	title = "El Tamaño minimo es de 10 y el maximo de 30">
			        <div class="invalid-feedback">
			        	Por favor ingrese un email valido.
			        </div>
		        </div>

       			<div class="mb-3">
	      		<label for="telefono">Telefono</label>
		        <input name="telefono" type="tel" class="form-control" id="telefono" value="<%=A.getTelefono()%>" required pattern="[0-9 ]{7,20}" required
		        	title = "El Tamaño minimo es de 7 y el maximo de 20 digitos">
			        <div class="invalid-feedback">
			            Por favor ingrese un telefono valido.
			        </div>
		        </div>
		        
		        <div class="mb-4" id="opCarrera">
		        <label for="carrera">Carrera</label>
		        <select name="Carrera" id="Carrera" class="custom-select d-block w-100" required>
			        <option value="">Elige...</option>
			        <option value="Mecanica">Ingenieria Mecanica</option>
			        <option value="Electrica">Ingenieria Electrica</option>
			        <option value="Sistemas">Ingenieria en Sistemas de Informacio</option>
			        <option value="Civil">Ingenieria Civil</option>
			        <option value="Quimica">Ingenieria Qumica</option>
		       	</select>
			        <div class="invalid-feedback">
			              Por favor seleccione una carrera.
			        </div>
		        </div>
		        
		        <hr class="mb-4">
		        
		        <div class="row">
		        	<%if(A.getDireccion().getCalle() != null){ %>
			        <div class="col-md-6 mb-3">
		      		<label for="direccion">Direccion</label>
			        <input name="direccion" type="text" class="form-control" id="direccion" value="<%=A.getDireccion().getCalle()%>" required pattern="[A-Za-z ]{4,20}" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				            Por favor ingrese una direccion valido.
				        </div>
			        </div>
			        <%}else{%>
			        <div class="col-md-6 mb-3">
		      		<label for="direccion">Direccion</label>
			        <input name="direccion" type="text" class="form-control" id="direccion"  required pattern="[A-Za-z ]{4,20}" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				            Por favor ingrese una direccion valido.
				        </div>
			        </div>
			        <%}%>
			        
			        <div class="col-md-3 mb-3">
		      		<label for="numero">Numero</label>
			        <input name="numero" type="number" class="form-control" id="numero" min="0" value="<%=A.getDireccion().getNumero()%>" maxlength="5" required
			        	title = "El Tamaño minimo es de 1 y el maximo de 5 digitos">
				        <div class="invalid-feedback">
				            Por favor ingrese un numero valido.
				        </div>
			        </div>
		        </div>
		        
		        <div class="row">
		        	<div class="col-md-3 mb-3"> 
		      		<label for="piso">Piso <span class="text-muted">(Opcional)</span></label>
			        <input name="piso" type="number" class="form-control" id="piso" min="0" maxlength="5" value="<%=A.getDireccion().getPiso()%>"
			        	title = "El Tamaño minimo es de 1 y el maximo de 5 digitos">
				        <div class="invalid-feedback">
				            Por favor ingrese un piso valido.
				        </div>
			        </div>
			        
			        <%if(A.getDireccion().getDept() == null){ %>
			        	<div class="col-md-3 mb-3"> 
			      		<label for="departamento">Depto <span class="text-muted">(Opcional)</span></label>
				        <input name="departamento" type="text" class="form-control" id="departamento" maxlength="3" placeholder="0"
				        	title = "El Tamaño minimo es de 1 y el maximo de 5">
					        <div class="invalid-feedback">
					            Por favor ingrese un departamento valido.
					        </div>
				        </div>
			        <%}else{%>
			        	<div class="col-md-3 mb-3"> 
			      		<label for="departamento">Depto <span class="text-muted">(Opcional)</span></label>
				        <input name="departamento" type="text" class="form-control" id="departamento" maxlength="3" value="<%=A.getDireccion().getDept()%>"
				        	title = "El Tamaño minimo es de 1 y el maximo de 5">
					        <div class="invalid-feedback">
					            Por favor ingrese un departamento valido.
					        </div>
				        </div>
			        <%}%>			     
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
$('select option[value="<%=A.getCarrera()%>"]').attr("selected",true);
$('select option[value="<%=A.getDocumento().getTipo()%>"]').attr("selected",true);
</script>

</html>
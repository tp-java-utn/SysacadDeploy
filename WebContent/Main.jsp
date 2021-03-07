

<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <title>Index - UTN</title>
	    <link rel="shortcut icon" type="image/png" href="pngs/login.png">
	    
	    
		<!-- Bootstrap core CSS -->
		<link href="Styles/bootstrap.min.css" rel="stylesheet">
		
		<!-- Icons -->
		<script src="https://kit.fontawesome.com/1baa4ceec0.js"></script>
		
		<!-- JS -->
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="JavaScripts/bootstrap.min.js"></script>
		
		<!-- Customs CSS -->
		<link href="Styles/floating-labels.css" rel="stylesheet">
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
	    <link href="Styles/floating-labels.css" rel="stylesheet">
	
		<style type="text/css">
			.row{
				padding-top: 10px;
				padding-bottom: 10px;			
			}
			.btn{
				width: 500px;
			}
		</style>
	
	   
		
	</head>
	
<body >
		<form class = "form-signin" id="myForm" name="myForm" action="Login" method="post">
			<div class="text-center mb-4">
				<img class="mb-4" src="pngs/login.png" height="150" width="150">
				<h1 class="h3 mb-3 font-weight-normal">Index UTN</h1>
				<p> Sistema de autogestión de la Universidad Tecnológica Nacional - Facultad Regional Rosario</p>
			</div>
			<div class="form-label-group">
				<div class="row justify-content-center"><a href="Login.jsp" type="button" class="btn btn-primary" ><i class="fas fa-user"></i> Alumno</a></div>
			</div>
			<div class="form-label-group">	
				<div class="row justify-content-center"><a href="LoginAdmin.jsp" type="button" class="btn btn-warning" style="color: white"><i class="fas fa-user-cog"></i> Administrador</a></div>
			</div>
			<div class="form-label-group">	
				<div class="row justify-content-center"><a href="LoginDocente.jsp" type="button" class="btn btn-info"><i class="fas fa-user-graduate"></i> Docente</a></div>	
			</div>
		</form>
			

</body>
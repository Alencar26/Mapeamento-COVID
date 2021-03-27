<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="com.covid.mapcovid.Model.Enums.Countries"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Mapeamento COVID-19</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
		<link rel="icon" href="https://www.flaticon.com/svg/vstatic/svg/3209/3209992.svg?token=exp=1616641725~hmac=6b84deccdba98ecc7a095b842f29204a">
	</head>
	<body class="bg-dark">
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand text-light fw-bold fs-3" href="#">Mapeamento COVID-19</a>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item ms-5">
		        	<form action="country" method="POST">
	    				<div class="row">
  							<div class="col-10">
			    				<select class="form-select" name="country">
								  <option value="Brazil" selected>Brasil</option>
								  <% 
								 	 for (Countries country : Countries.values()) { 
								  	%>
								  		<option value="<%= country %>"><%= country.getCountries() %></option>
								  	<%
								  	} %>
								</select>
							</div>
							<div class="col-2">
								<input type="submit" class="btn btn-secondary" value="Pesquisar">
							</div>
						</div>
	    			</form> 
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	    <div class="container-fluid p-3">
	    	<div class="row p-2">
	    		<div class="col-3">
	    			<div class="row row-cols-1 g-1">
					  <div class="col">
					    <div class="card bg-dark border-0">
					      <div class="row g-0">
						    <div class="col-md-2">
						      <img src="../img/virus.png" width="50px" class="m-3">
						    </div>
						    <div class="col-md-10">
						      <div class="card-body ms-2">
						        <h6 class="card-title text-light">Total de Infectados</h6>
						        <h5 class="card-text text-light">${totalCasos}</h5>
						      </div>
						    </div>
						  </div>
					      
					    </div>
					  </div>
					  <div class="col">
					  	 <div class="card bg-dark border-0">
					      <div class="row g-0">
						    <div class="col-md-2">
						      <img src="../img/virus_ativo.png" width="50px" class="m-3">
						    </div>
						    <div class="col-md-10">
						        <div class="card-body ms-2">
						        	<h6 class="card-title text-light">Total Casos Ativos</h6>
						        	<h5 class="card-text text-light">${totalAtivos}</h5>
						      	</div>
						    </div>
						  </div> 
					    </div>
					  </div>
					  <div class="col">
					  	<div class="card bg-dark border-0">
					      <div class="row g-0">
						    <div class="col-md-2">
						      <img src="../img/mortos.png" width="50px" class="m-3">
						    </div>
						    <div class="col-md-10">
						        <div class="card-body ms-2">
							        <h6 class="card-title text-light">Total de Óbitos</h6>
							        <h5 class="card-text text-light">${totalObitos}</h5>
						      	</div>
						    </div>
						  </div> 
					    </div>
					  </div>
					  <div class="col">
					  	<div class="card bg-dark border-0">
					      <div class="row g-0">
						    <div class="col-md-2">
						      <img src="../img/recuperados.png" width="50px" class="m-3">
						    </div>
						    <div class="col-md-10">
						        <div class="card-body ms-2">
							        <h6 class="card-title text-light">Total de Recuperados</h6>
							        <h5 class="card-text text-light">${totalRecuperados}</h5>
						      	</div>
						    </div>
						  </div> 
					    </div>
					  </div>
					 
					</div>
	    		</div>
	    		<div class="col-4">
	    			
	    		</div>
	    		<div class="col-5">
	    			<div class="row">
	    				<div class="col-12">
	    					<p class="text-light fs-1 fw-bold"> ${nomePais} <img src="${bandeira}" width="60px" height="40px" class="rounded ms-3 mb-1"></p>
	    				</div>
	    				<div class="col-5">
	    				  <div class="row row-cols-1 g-0">	    					
							  <div class="col">
							    <div class="card bg-dark border-0">
							      <div class="card-body" style="padding:0.5em 0em">
							        <h6 class="card-title text-light fs-5">População</h6>
							        <h5 class="card-text text-light text-center">${populacao}</h5>
							      </div>
							  	</div>    
							  </div>
							  <div class="col">
							    <div class="card bg-dark border-0">
							      <div class="card-body" style="padding:0.5em 0em">
							        <h6 class="card-title text-light fs-5">Ocup. Hospitalar</h6>
							        <h5 class="card-text text-light text-center">${totalCasos}</h5>
							      </div>
							  	</div>    
							  </div>
							  <div class="col">
							    <div class="card bg-dark border-0">
							      <div class="card-body" style="padding:0.5em 0em">
							        <h6 class="card-title text-light fs-5">Situação</h6>
							        <h5 class="card-text text-danger fw-bold text-center fs-4">Alta</h5>
							      </div>
							  	</div>    
							  </div>
							</div>
	    				</div>
	    			</div>
	    			<div class="row">
	    				<div class="col-12 mt-2">
	    					<div class="card bg-dark">
						      <div class="card-body">
						        <h6 class="card-title text-light fs-5">GRÁFICO</h6>
						      </div>
						  	</div>    
	    				</div>
	    			</div>
	    		</div>
	    	</div>
	    </div>
	</body>
</html>
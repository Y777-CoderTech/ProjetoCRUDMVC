<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body class="text-center">
<header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark text-light">
            <div class="container">
                <a class="navbar-brand" href="#"><img src="./icon/samurai.png"/ height="48px"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="./index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#aboutus">About Us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#gallery">Gallery</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#blog">Blog</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ReadController">Register</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link" href="#contactus">Contact Us</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<h1 class="mt-5">Customer List</h1>
	<div class="container mt-5">
	<a href="./cadastro.jsp" class="btn btn-primary mb-5">Create Now</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Cpf</th>
					<th>Rg</th>
					<th>Telephone</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.rg}</td>
						<td>${cliente.telefone}</td>
						<td>
							<a href="UpdateController?id=${cliente.id}" class="btn btn-success">Editar</a>
							<a href="DeleteController?id=${cliente.id}"
							class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	 
    <footer class="bg-dark text-light text-center py-3 fixed-bottom">
        &copy; 2023 TPerfect_Trip.  All rights reserved.
    </footer>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>
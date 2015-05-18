<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maquinaria</title>
	<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../lib/bootstrap/css/style.css" rel="stylesheet">
  
	<script type="text/javascript" src="../lib/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<c:forEach var = "item" items = "${machines}">
		<br>
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-3 column">
					<img alt="140x140" src="${item.imagen}" class="img-rounded">
				</div>
				<div class="col-md-6 column">
					<table class="table table-hover table-condensed">
						<tr class="active">
							<td><h4>${item.nombre}</h4></td>
						</tr>
						<tr>
							<td><h5>Precio: $${item.precio}</h5></td>
						</tr>
						<tr>
							<td><h6>Disponible: ${item.disponibilidad}</h6></td>
						</tr>
					</table>
				</div>
				<div class="col-md-3 column">
					 <button type="button" class="btn btn-success btn-block">Ver-Detalle</button>
				</div>
			</div>
		</div>
		<br>
		<hr style="display: block;border-style: inset;border-width: 1px;">
		</c:forEach>
	</div>
	<c:forEach var = "item" items = "${machines}">
		<!-- Modal -->
		<div class="modal fade" id="myModal-${item.idmaquina}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        	<span aria-hidden="true">&times;</span>
	        	</button>
		        <h4 class="modal-title" id="myModalLabel-${item.idmaquina}">${item.nombre}</h4>
		      </div>
		      <div class="modal-body">
		        <div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-3 column">
							<img alt="140x140" src="${item.imagen}" class="img-rounded">
						</div>
						<div class="col-md-9 column">
							<table class="table table-hover table-condensed">
								<tr class="active">
									<td><h5>${item.descripcion}</h5></td>
								</tr>
								<tr>
									<td><h5>Precio: $${item.precio}</h5></td>
								</tr>
								<tr>
									<td><h6>Disponible: ${item.disponibilidad}</h6></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-success btn-block" data-dismiss="modal">Close</button>
		        <!-- <button type="button" class="btn btn-success btn-block" data-dismiss="modal">Ver</button> -->
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</div>
</body>
</html>
<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					    
					    <c:set var="corsoInPagina" value="${visualizza_corso_attr}"></c:set> 
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9"><c:out value="${ corsoInPagina.nome }"></c:out></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Docente:</dt>
							  <dd class="col-sm-9"><c:out value="${ corsoInPagina.docente }"></c:out></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Numero iscritti:</dt>
							  <dd class="col-sm-9"><c:out value="${ corsoInPagina.numeroIscritti }"></c:out></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data inizio:</dt>
							  <dd class="col-sm-9"><c:out value="${ corsoInPagina.dataInizio }"></c:out></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data fine:</dt>
							  <dd class="col-sm-9"><c:out value="${ corsoInPagina.dataFine }"></c:out></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ListCorsiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>
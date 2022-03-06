<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca corso</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci dati per la ricerca</h5> 
				    </div>
				    <div class='card-body'>
				
							<form method="post" action="ExecuteSearchCorsoServlet" class="row g-3" novalidate="novalidate">
							
								<c:set var="corsoInPagina" value="${search_corso_attr}"></c:set>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome </label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="${corsoInPagina.nome}">
								</div>
								
								<div class="col-md-6">
									<label for="docente" class="form-label">Docente </label>
									<input type="text" name="docente" id="docente" class="form-control" placeholder="Inserire il docente"  
										value="${corsoInPagina.docente}">
								</div>
								
								<div class="col-md-6">
									<label for="numeroIscritti" class="form-label">Numero iscritti </label>
									<input type="number" class="form-control" name="numeroIscritti" id="numeroIscritti" placeholder="Inserire numero iscritti" 
									value="${corsoInPagina.numeroIscritti}">
								</div>
								
								<div class="col-md-3">
									<label for="dataInizio" class="form-label">Data inizio corso </label>
									<fmt:formatDate value="${corsoInPagina.dataInizio}" type="date" pattern="yyyy-MM-dd" var="theFormattedDate" />
									<input class="form-control"  name="dataInizio" id="dataInizio" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="${theFormattedDate}" required/>
								</div>
								
								<div class="col-md-3">
									<label for="dataFine" class="form-label">Data fine corso </label>
									<fmt:formatDate value="${corsoInPagina.dataFine}" type="date" pattern="yyyy-MM-dd" var="theFormattedDate" />
									<input class="form-control"  name="dataFine" id="dataFine" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="${theFormattedDate}" required/>
								</div>
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Cerca</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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
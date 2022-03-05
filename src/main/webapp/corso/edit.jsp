<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionecorso.model.Corso"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Aggiornamento corso</title>
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
				        <h5>Inserisci i dati per l'aggiornamento del corso</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteEditCorsoServlet" class="row g-3" novalidate="novalidate">
							
								<% Corso corsoInPagina = (Corso)request.getAttribute("CorsoCheSiVuoleAggiornare"); %>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="<%=corsoInPagina.getNome()!=null?corsoInPagina.getNome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="docente" class="form-label">Docente <span class="text-danger">*</span></label>
									<input type="text" name="docente" id="docente" class="form-control" placeholder="Inserire il docente"  
										value="<%=corsoInPagina.getDocente()!=null?corsoInPagina.getDocente():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="numeroIscritti" class="form-label">Numero iscritti <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="numeroIscritti" id="numeroIscritti" placeholder="Inserire numero iscritti" 
									value="<%=corsoInPagina.getNumeroIscritti()!=null?corsoInPagina.getNumeroIscritti():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataInizio" class="form-label">Data inizio corso <span class="text-danger">*</span></label>
									<input class="form-control"  name="dataInizio" id="dataInizio" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=corsoInPagina.getDataInizio()!=null? new SimpleDateFormat("yyyy-MM-dd").format(corsoInPagina.getDataInizio()):""  %>" required/>
								</div>
								
								<div class="col-md-3">
									<label for="dataFine" class="form-label">Data fine corso <span class="text-danger">*</span></label>
									<input class="form-control"  name="dataFine" id="dataFine" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=corsoInPagina.getDataFine()!=null? new SimpleDateFormat("yyyy-MM-dd").format(corsoInPagina.getDataFine()):""  %>" required/>
								</div>
								
							<div class="col-12">
								<input type="hidden" name="idCorso" value="<%= corsoInPagina.getId()%>">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Aggiorna</button>
								<a href="ListCorsiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
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
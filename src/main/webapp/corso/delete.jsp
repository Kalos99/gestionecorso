<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionecorso.model.Corso"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina corso</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  	<div class='card'>
					 <div class='card-header'>
					     <h5>Sei sicuro di voler eliminare questo corso?</h5>
					  </div>
					     <% Corso corsoInPagina = (Corso)request.getAttribute("CorsoCheSiVuoleEliminare"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9"><%=corsoInPagina.getNome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Docente:</dt>
							  <dd class="col-sm-9"><%=corsoInPagina.getDocente() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Numero iscritti:</dt>
							  <dd class="col-sm-9"><%=corsoInPagina.getNumeroIscritti() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data inizio:</dt>
							  <dd class="col-sm-9"><%=corsoInPagina.getDataInizio()!=null? new SimpleDateFormat("dd/MM/yyyy").format(corsoInPagina.getDataInizio()):"N.D."  %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data fine:</dt>
							  <dd class="col-sm-9"><%=corsoInPagina.getDataFine()!=null? new SimpleDateFormat("dd/MM/yyyy").format(corsoInPagina.getDataFine()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    <form method="post" action="ExecuteDeleteCorsoServlet" class="row g-3" novalidate="novalidate">
					     	<div class='card-footer'>
					        	<input type="hidden" name="idCorso" value="<%= corsoInPagina.getId()%>">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								<a href="ListCorsiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            	<i class='fa fa-chevron-left'></i> Back
					        	</a>
							
					  	  </div>
						<!-- end card -->			  
			    	</form>
			  <!-- end container -->  
			  </div>
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>
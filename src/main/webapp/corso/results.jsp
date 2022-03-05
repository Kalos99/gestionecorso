<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionecorso.model.Corso"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Lista Elementi</title>
	 </head>
	 
	<body class="d-flex flex-column h-100">
	 
		<!-- Fixed navbar -->
		<jsp:include page="../navbar.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
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
				        <h5>Lista dei risultati</h5> 
				    </div>
				    <div class='card-body'>
				    	<a class="btn btn-primary " href="PrepareInsertCorsoServlet">Add New</a>
				    
				        <div class='table-responsive'>
				            <table class='table table-striped ' >
				                <thead>
				                    <tr>
			                         	<th>Id</th>
				                        <th>Nome</th>
				                        <th>Docente</th>
				                        <th>Numero iscritti</th>
				                        <th>Data inizio</th>
				                        <th>Data fine</th>				                      
				                        <th>Azioni</th>
				                    </tr>
				                </thead>
				                <tbody>
				                	<% List<Corso> listaCorsi = (List<Corso>)request.getAttribute("listaCorsiAttribute");
				                		for(Corso item:listaCorsi){ %>
				                    <tr >
				                        <td><%=item.getId() %></td>
				                        <td><%=item.getNome() %></td>
				                        <td><%=item.getDocente() %></td>
				                        <td><%=item.getNumeroIscritti() %></td>
				                        <td><%=item.getDataInizio()!=null? new SimpleDateFormat("dd/MM/yyyy").format(item.getDataInizio()):"N.D."%></td>
				                        <td><%=item.getDataFine()!=null? new SimpleDateFormat("dd/MM/yyyy").format(item.getDataFine()):"N.D."%></td>				                    
				                        <td>
											<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaCorsoServlet?idCorso=<%=item.getId() %>">Visualizza</a>
											<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareEditServlet?idCorso=<%=item.getId() %>">Edit</a>
											<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteServlet?idCorso=<%=item.getId() %>">Delete</a>
										</td>
				                    </tr>
				                    <% } %>
				                    
				                </tbody>
				            </table>
				        </div>
				   
					<!-- end card-body -->			   
			    </div>
			<!-- end card -->
			</div>	
		 
		   
		 <!-- end container -->  
		  </div>
		  
		</main>
		
		<!-- Footer -->
		<jsp:include page="../footer.jsp" />
		
		<!-- Modal conferma delete -->
		<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="deleteModalLabel">Conferma Operazione</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        Continuare con l'operazione?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
		        <button type="button" class="btn btn-primary">Continua</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- End Modal conferma delete -->
		
	</body>
</html>
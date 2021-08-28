<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<base href="/AssignmentJAVA5/" />
<div class="container mt-2">
	<h2 style="font-family: impact; color: red; text-align: center">CATEGORY
		MANAGEMENT</h2>

	<div class="row">
		<div class="col">
		
		<c:if test="${not empty sessionScope.errorDelete }">
		<div class="alert alert-danger">${sessionScope.errorDelete }</div>
		</c:if>
		<c:remove var="errorDelete" scope="session" />
		
			<form action="/admin/category/" method="post">
		<!--  <input type="hidden" name="_method" value="put" /> -->	
				<div class="form-group">
					<label>ID:</label> <input type="text" readonly name="id" value="${category.id }"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Name:</label> <input type="text" name="name" value="${category.name }"
					class="form-control" />
				</div>
					
			
				<br />

				<div class="form-group">
					<button formaction="${ pageContext.request.contextPath }/admin/category/create" class="btn btn-primary">Create</button>
					<button formaction="${ pageContext.request.contextPath }/admin/category/update/${category.id}" class="btn btn-warning">Update</button>
					<button formaction="${ pageContext.request.contextPath }/admin/category/delete/${category.id}" class="btn btn-danger">Delete</button>
					<button formaction="${ pageContext.request.contextPath }/admin/category/reset" class="btn btn-secondary">Reset</button>
				</div>


			</form>
		</div>
	</div>
	<br />

	<div class="row">
		<div class="col">
			<table class="table table-stripe table-dark mt-2 col-10 offset-1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listCategory }">
						<tr>
							<td>${item.id }</td>
							<td>${item.name }</td>

						  	<td><a class="btn btn-info"
								href="${ pageContext.request.contextPath }/admin/category/edit/${item.id}">Edit</a>
							</td>
							<td>
								<form
									action="${ pageContext.request.contextPath }/admin/category/delete/${item.id}"
									method="POST">
									<button class="btn btn-danger">Delete</button>
								</form>
							</td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

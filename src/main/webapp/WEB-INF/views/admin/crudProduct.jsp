<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<base href="/AssignmentJAVA5/" />
<div class="container mt-2">
	<h2 style="font-family: impact; color: red; text-align: center">PRODUCT
		MANAGEMENT</h2>

	<div class="row">
		<div class="col">
			<form:form modelAttribute="product" action="/admin/product/" method="post" enctype="multipart/form-data" >
		<!--  <input type="hidden" name="_method" value="put" /> -->	
				<div class="form-group">
					<label>Name:</label> <input type="text"  name="name" value="${product.name }"
						class="form-control" />
				</div>
					
				<div class="form-group mt-3">
				<label for="imageFile">Image:</label>
			    <input type="file" class="form-control" id="imageFile" name="imageFile" value="${product.image }"   />
				</div>
				
				<div class="form-group">
					<label>Price:</label> <input type="text" name="price" value="${product.price }" 
					class="form-control" />
				</div>
				
				
				
				<div class="form-group">
					<label for="available">Available</label> <select name="available"
						id="available" class="form-control" required>
						<option selected disabled>Choose</option>
						<option value="1" ${product.available ==1? "selected":"" } >True</option>
						<option value="0" ${product.available ==0? "selected":"" }>False</option>
					</select> <small id="available_error" class="form-text text-danger"></small>
				</div>
				
				  <div class="form-group">
					<label for="category">Category</label> <select name="category"
						id="category" class="form-control" required>
						<option selected disabled>Choose</option>
						<c:forEach var="item" items="${danhmuc }">
						<option value="${item.id }" ${product.category.id == item.id ? "selected" :"" } >${item.name }</option>
						</c:forEach>
						
					</select> <small id="category_error" class="form-text text-danger"></small>
				</div>
			
				<br />

				<div class="form-group">
					<button formaction="${ pageContext.request.contextPath }/admin/product/create" class="btn btn-primary">Create</button>
					<button formaction="${ pageContext.request.contextPath }/admin/product/update/${product.id}" class="btn btn-warning">Update</button>
					<button formaction="${ pageContext.request.contextPath }/admin/product/delete/${product.id}" class="btn btn-danger">Delete</button>
					<button formaction="${ pageContext.request.contextPath }/admin/product/reset" class="btn btn-secondary">Reset</button>
				</div>


			</form:form>
		</div>
	</div>
	<br />
	
	<form method="post" action="${pageContext.request.contextPath }/admin/product"> 
	<div class="form-group">
<div class="row  justify-content-center">
<div class="col-5 ">
<input type="text" name="tensp" value="${tensp }" class="form-control" placeholder="Tên sản phẩm ...?" />
</div>
<button formaction="${ pageContext.request.contextPath }/admin/product" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i></button>	

</div>
</div>

	<div class="row">
		<div class="col">
			<table class="table table-stripe table-dark mt-2">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Image</th>
						<th>Price</th>
						<th>CreateDate</th>
						<th>Available</th>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listProduct.content }">
						<tr>
							<td>${item.id }</td>
							<td>${item.name }</td>
							<td><img src="images/${item.image }" width="120px" height="80px" /></td>
							<td>${item.price }</td>
							<td>${item.createdate }</td>
							<td>${item.available }</td>
							<td>${item.category.name }</td>

						  	<td><a class="btn btn-info"
								href="${ pageContext.request.contextPath }/admin/product/edit/${item.id}">Edit</a>
							</td>
							<td>
								<form
									action="${ pageContext.request.contextPath }/admin/product/delete/${item.id}"
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
	</form>
	
	<div style="text-align: center">
<a href="${pageContext.request.contextPath }/admin/product?p=0">First</a>
<a href="${pageContext.request.contextPath }/admin/product?p=${listProduct.number-1}">Previous</a>
<a href="${pageContext.request.contextPath }/admin/product?p=${listProduct.number+1}">Next</a>
<a href="${pageContext.request.contextPath }/admin/product?p=${listProduct.totalPages-1}">Last</a>
<br />
Number of page: ${listProduct.number +1} / ${listProduct.totalPages }
 </div>
 
 <script src="/js/main.js"></script>
</div>



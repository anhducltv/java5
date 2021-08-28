<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8">

<base href="/AssignmentJAVA5/" />
<div class="container mt-2">
	<h2 style="font-family: impact; color: red; text-align: center">USER
		MANAGEMENT</h2>

	<div class="row">
		<div class="col">
			<form action="/admin/users/" method="post">
		<!--  <input type="hidden" name="_method" value="put" /> -->	
				<div class="form-group">
					<label>Fullname:</label> <input type="text" readonly name="fullname" value="${acc.fullname }"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Email:</label> <input type="text"  readonly name="email" value="${acc.email }"
					class="form-control" />
				</div>
				
				<div class="form-group">
					<label>Password:</label> <input type="password"  readonly name="password" value="${acc.password }"
					class="form-control" />
				</div>
				
				<div class="form-group mt-3">
				<label for="photo">Image:</label>
			    <input type="file" value="${acc.photo }"  readonly class="form-control" id="photo" name="photo">
				</div>

				<div class="form-group">
					<label for="activated">Status</label> <select name="activated"
						id="activated" class="form-control" required>
						<option selected disabled>Choose</option>
						<option value="1" ${ acc.activated == 1 ? "selected" : "" }>Active</option>
						<option value="0" ${ acc.activated == 0 ? "selected" : "" }>Inactive</option>
					</select> <small id="activated_error" class="form-text text-danger"></small>
				</div>

					<div class="form-group">
					<label for="admin">Role</label> <select name="admin"
						id="admin" class="form-control" required>
						<option selected disabled>Choose</option>
						<option value="1" ${ acc.admin == 1 ? "selected" : "" }>Admin</option>
						<option value="0" ${ acc.admin == 0 ? "selected" : "" }>User</option>
					</select> <small id="admin_error" class="form-text text-danger"></small>
				</div>
			
				<br />

				<div class="form-group">
					<button formaction="${ pageContext.request.contextPath }/admin/users/update/${acc.id}" class="btn btn-primary">Update</button>
					<button formaction="${ pageContext.request.contextPath }/admin/users/delete/${acc.id}" class="btn btn-danger">Delete</button>
				</div>


			</form>
		</div>
	</div>


	<div class="row">
		<div class="col">
			<table class="table table-stripe table-dark mt-2">
				<thead>
					<tr>
						<th>ID</th>
						<th>Fullname</th>
						<th>Email</th>
						<th>Photo</th>
						<th>Activated</th>
						<th>Role</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listAccount }">
						<tr>
							<td>${item.id }</td>
							<td>${item.fullname }</td>
							<td>${item.email }</td>
							<td>${item.photo }</td>
							<td>${item.activated ==1? "Active": "InActive" }</td>
							<td>${item.admin ==1? "Admin": "User" }</td>

						  	<td><a class="btn btn-warning"
								href="${ pageContext.request.contextPath }/admin/users/edit/${item.id}">Edit</a>
							</td>
							<td>
								<form
									action="${ pageContext.request.contextPath }/admin/users/delete/${item.id}"
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


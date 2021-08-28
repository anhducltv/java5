<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<base href="/AssignmentJAVA5/" />
<div class="container mt-2">
	<h2 style="font-family: impact; color: red; text-align: center">LIST ORDER</h2>

	<div class="row">
		<div class="col">
			<table class="table table-stripe table-dark mt-2 col-10 offset-1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Account ID</th>
						<th>Create date</th>
						<th>Address</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${listOrder}">
					<tr>
					<td>${item.id }</td>
					<td>${item.account.id }</td>
					<td>${item.createdate }</td>
					<td>${item.address }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

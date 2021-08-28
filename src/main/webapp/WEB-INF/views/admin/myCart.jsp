<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="/AssignmentJAVA5/" />

<div class="container">

	<div class="container-custom">
		<div class="nav">
			<div class="nav-left">
				<h2 style="font-family: impact; color: red">My Cart</h2>
			</div>
		</div>
		<c:if test="${not empty sessionScope.messagePay }">
<div class="alert alert-success">${sessionScope.messagePay }</div>
</c:if>
<c:remove var="messagePay" scope="session" />
		<table class="table">
			<thead>
				<tr>
					<th style="color: black;" scope="col">Ảnh</th>
					<th style="color: black;" scope="col">Tên sản phẩm</th>
					<th style="color: black;" scope="col">Đơn giá</th>
					<th style="color: black;" scope="col">Số lượng</th>
					<th style="color: black;" scope="col">Thành tiền</th>
					<th style="color: black;" scope="col">Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listCart }">
					<tr>
						<th><img src="images/${item.product.image }" width="100"
							height="100" /></th>
							<th>${item.product.name }</th>
							<th>${item.product.price }</th>
							<th>${item.quantity }</th>
							<th>${item.quantity * item.product.price }</th>
							<th><a href="${ pageContext.request.contextPath }/member/delete/${item.id}" class="btn btn-danger">Delete</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/member/search-and-page" >Tiếp tục mua hàng</a>
		
		<h4 style="font-family: impact; color: blue; text-align: center">Total: ${tongtien} $  </h4>
		
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-outline-success"
				data-bs-toggle="modal" data-bs-target="#exampleModal">
				Thanh toán</button>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/AssignmentJAVA5/member/pay" method="POST">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Nhập địa chỉ</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<input name="address" type="text" class="form-control"
							placeholder="VD: Số 5 Lê Đức Thọ - Mỹ Đình - Hà Nội">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger"
							data-bs-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-outline-success">Tạo
							đơn hàng</button>
					</div>
				</form>


			</div>
		</div>
	</div>
</div>


<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container-fluid padding">
<div class="row welcome text-center">
<div class="col-12">
<h1>WELCOME </h1>
</div>

<div class="col-12">
</div>
</div>
</div>
<hr class="setHR">

<div id="content">
 <form method="post" action="${pageContext.request.contextPath }/member/search-and-page"> 
<div class="form-group">
<div class="row  justify-content-center">					
<div class="col-5 ">
<input type="text" name="keywords"  class="form-control" placeholder="Tên sản phẩm ...?" />
</div>
<button formaction="${ pageContext.request.contextPath }/member/search-and-page" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i></button>	

</div>
</div>
 </form> 
	<c:if test="${not empty sessionScope.messageCart }">
<div class="alert alert-success">${sessionScope.messageCart }</div>
</c:if>
<c:remove var="messageCart" scope="session" />



<div class="container-fluid padding ">
<div class="row padding">
  
<c:forEach var="item" items="${listProduct.content }" >
<div class="col-md-3">
<div class="card">
<img class="card-img-top" src="images/${item.image }" width="100px" height="200px" />
<div class="card-body">
<h4 class="card-title" >${item.name }</h4>
<h6 style="color:red" class="card-text" >${item.price } $</h6>

<a href="${pageContext.request.contextPath }/member/add/${item.id}" class="btn btn-outline-info" ><i class="fa fa-shopping-cart" aria-hidden="true"></i>  Buy</a>
<a href="${pageContext.request.contextPath }/member/viewdetail/${item.id}"  class="btn btn-outline-success"><i class="fa fa-info-circle" aria-hidden="true"></i>  View</a>
</div>
</div>
</div>

</c:forEach>


</div>
</div>

 
 <br />
 
 <div style="text-align: center">
<a href="${pageContext.request.contextPath }/member/search-and-page?p=0">First</a>
<a href="${pageContext.request.contextPath }/member/search-and-page?p=${listProduct.number-1}">Previous</a>
<a href="${pageContext.request.contextPath }/member/search-and-page?p=${listProduct.number+1}">Next</a>
<a href="${pageContext.request.contextPath }/member/search-and-page?p=${listProduct.totalPages-1}">Last</a>
<br />
Number of page: ${listProduct.number +1} / ${listProduct.totalPages }

 </div>
</div>


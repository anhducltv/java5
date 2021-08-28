<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container-fluid padding">
<div class="row welcome text-center">
<div class="col-12">
<h1>View Detail</h1>
</div>

</div>
</div>
<br />

<div class="container">
<img src="images/${infoProduct.image }" width="550px" height="450px" />
<h3 style="font-family: impact;color: green">${infoProduct.name }</h3>
<h5 style="font-family: impact">Price: ${infoProduct.price } $</h5>
<h5 style="font-family: impact">Available: ${infoProduct.available ==1? "Yes" :"No" }</h5>
<button class="btn btn-info">Buy</button>
</div>
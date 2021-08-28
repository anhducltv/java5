<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/AssignmentJAVA5/" />
  <!-- Bootstrap CSS -->

    <link rel="stylesheet" 
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
    crossorigin="anonymous">
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    
    <script src="https://use.fontawesome.com/036b4f2931.js"></script>
<title>Trang chủ</title>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
<div class="container-fluid">


<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarResponsive">
<ul class="navbar-nav ml-auto">

<c:if test="${isLogin }">
<li class="nav-item">
<a  class="nav-link"  href="#">Hello, ${fullname }</a>
</li>
</c:if>

<c:if test="${role==1 }">
<li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/admin/users/">User</a>
</li>

<li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/admin/category/">Category</a>
</li>

<li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/admin/product/">Product</a>
</li>

<li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/admin/order/">Order</a>
</li>
</c:if>

<c:if test="${role==0 }">
<li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/member/viewCart/">My Cart</a>
</li>
</c:if>

<c:if test="${isLogin }">
 <li class="nav-item">
<a  class="nav-link" href="/AssignmentJAVA5/logout">Logout</a>
</li>
 </c:if>
</ul>
</div>
</div>
</nav>

<hr class="setHR">

<tiles:insertAttribute name="body"/>

<hr class="setHR mt-3">

<div class="container-fluid padding mt-5">
<div class="row text-center padding">
<div class="col-12">
<h2 style="font-family: impact">CONTACT US</h2>
</div>
<div class="col-12 social padding">
<a href="#"><i class="fa fa-facebook-official" aria-hidden="true"></i></a>
<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
<a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
<a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
<a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
</div>
</div>
</div>
<br />
<footer>
<div class="container-fluid padding">
<div class="row text-center">
<div class="col-md-4">
<hr class="light">
<h5>Contact</h5>
<hr class="light">
<p>0979 - 018 - 834</p>
<p>ntdfashion@gmail.com</p>
<p>My Dinh Street, Ha Noi, VietNam</p>
</div>

<div class="col-md-4">
<hr class="light">
<h5>Working hours</h5>
<hr class="light">
<p>Monday - Friday: 8AM - 10PM</p>
<p>Weekend: 8AM - 5PM</p>
</div>

<div class="col-md-4">
<hr class="light">
<h5>Service</h5>
<hr class="light">
<p>Outsourcing</p>
<p>Website development</p>
<p>Mobile applications</p>
</div>

<div class="col-12">
<hr class="light-100">
<h5>&copy; NTD STORE</h5>
</div>

</div>
</div>
</footer>

<!--  -->
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous">
    </script>
</body>
</html>
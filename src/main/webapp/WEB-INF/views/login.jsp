<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<title>JAVA SERVER PAGE</title>
</head>
<body class="bodyLogin">

<div class="col-5 offset-1 mt-5">
<c:if test="${not empty sessionScope.error_message }">
<div class="alert alert-danger">${sessionScope.error_message }</div>
</c:if>
<c:remove var="error_message" scope="session" />
<form method="post" action="${pageContext.request.contextPath }/login">
<h3>LOGIN</h3>
<br />
<div>
<label>Email</label>
<input type="email" class="form-control" name="email" id="email"  />
</div>

<div> 
<br />
<label>Password</label>
<input type="password" class="form-control" name="password" id="password"  />
</div>
<div>
<br />
<button class="btn btn-primary">Login</button>
</div>
</form>
</div>


</body>

</html>
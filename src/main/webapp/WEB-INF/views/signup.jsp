<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>JAVA SERVER PAGE</title>
</head>
<body>

<div class="col-5 offset-1 mt-5">
<form method="post" action="${pageContext.request.contextPath }/signup">
<h3>SIGN UP</h3>
<br />
<div>
<label>Fullname</label>
<input type="text" class="form-control" name="fullname" id="fullname"  />
</div>

<div>
<label>Email</label>
<input type="email" class="form-control" name="email" id="email"  />
</div>
<div>
<label>Password</label>
<input type="password" class="form-control" name="password" id="password"  />
</div>

<div class="form-group mt-3">
				<label for=image>Photo:</label>
			    <input type="file" class="form-control" id="photo" name="photo" >
				</div>
<div>
<br />
<button class="btn btn-primary">Sign up</button>
</div>
</form>
<c:if test="${not empty sessionScope.message }">
<div class="alert alert-success">${sessionScope.message }</div>
</c:if>
<c:remove var="message" scope="session" />
</div>
</body>
</html>
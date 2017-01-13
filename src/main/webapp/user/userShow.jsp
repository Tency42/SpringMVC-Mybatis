<%--
  author Tency
  
  Date 2016/11
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Show</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div class="container">
		<h1>Show User</h1>
		<hr />

		<form action="userManage" method="get">
			<div class="form-group">
				<label for="id">UserId:</label> <input type="text"
					class="form-control" id="id" value="${user.id }" />
			</div>
			<div class="form-group">
				<label for="userName">UserName:</label> <input type="text"
					class="form-control" id="userName" value="${user.userName }" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="text"
					class="form-control" id="password" value="${user.passWord }" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-sm btn-success">Return</button>
			</div>
		</form>
	</div>

</body>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
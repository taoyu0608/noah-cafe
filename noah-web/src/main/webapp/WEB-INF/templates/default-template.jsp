<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:write property="title" /></title>
	
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	
	<link rel="stylesheet" href="${contextPath}/css/noah/main.css"  />
	<link rel="stylesheet" href="${contextPath}/css/bootstrap/css/bootstrap.min.css"  />
	<link rel="stylesheet" href="${contextPath}/font/font-awesome/css/font-awesome.min.css" />
	
	<script src="${contextPath}/js/angular/angular.min.js"></script>
	<script>
	var noahApp = angular.module("noahApp", []);
	</script>
	
	<sitemesh:write property="head" />
</head>
<body ng-app="noahApp">
<div style="position: relative;">
    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
		<a class="navbar-brand" href="#">NOAH</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">產品介紹</a></li>
			</ul>
		</div>
	</nav>

	<div style="margin: 10px; padding-top: 60px; padding-bottom: 20px;">
		<sitemesh:write property='body' />
	</div>

    <footer class="footer">
      <div style="text-align: center;"><span>NOAH手作咖啡烘焙</span></div>
    </footer>
</div>
</body>
</html>
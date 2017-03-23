<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>諾亞咖啡 - 商品一覽</title>
	
	<script>
	noahApp.controller("productController", function($scope, $http) {
		$http.get("${contextPath}/product/list").then(function(response) {
	        $scope.products = response.data;
    	});
	});
	</script>
</head>
<body>
    <div ng-controller="productController">
    	<ul>
    		<li ng-repeat="product in products">商品名稱：{{product.name}} / 商品價格：{{product.price}}</li>
    	</ul>
    </div>
</body>
</html>
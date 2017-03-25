<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>諾亞咖啡 - 商品一覽</title>
	
	<script>
	noahApp.controller("productController", function($scope, $http) {
		
		$scope.loadProducts = function() {
			alert("系統抓取後端的商品");
			$http.get("${contextPath}/product/list").then(function(response) {
		        $scope.products = response.data;
		        $scope.topProduct = $scope.products[0];
	    	});			
		};
		
		$scope.updateCoffee = function(product) {
			$http.post("${contextPath}/product/save", product).then(function(response) {
				alert("更新成功");
				$scope.loadProducts();
			});
		};
		
		$scope.loadProducts();
	});
	</script>
</head>
<body>
    <div ng-controller="productController">
    	<ul>
    		<li ng-repeat="product in products">商品名稱：{{product.displayName}} / 商品價格：{{product.price | currency}}</li>
    	</ul>
    	
    	
    	<div style="border: 1px solid gray; display: inline-block;">
    		從後端更改第一筆商品值：<br/>
    		商品：<input type="text" ng-model="topProduct.name" /> <br/>
    		價格：<input type="number" ng-model="topProduct.price" /> <br/>
    		<button ng-click="updateCoffee(topProduct)">送出</button>
    	</div>
    </div>
</body>
</html>
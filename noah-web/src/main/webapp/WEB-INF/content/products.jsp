<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>諾亞咖啡 - 商品一覽</title>
	
	<script>
	noahApp.controller("productController", function($scope, $http) {
		
		$scope.loadProducts = function() {
			$http.get("${contextPath}/product/list/1").then(function(response) {
		        $scope.packageProducts = response.data;
	    	});			
			
// 			$http.get("${contextPath}/product/list/2").then(function(response) {
// 		        $scope.beanProducts = response.data;
// 	    	});			
		};
		$scope.loadProducts();
	});
	</script>
</head>
<body>
    <div ng-controller="productController">
    	<section>
			<h4><span class="badge badge-pill badge-success">掛耳式咖啡</span></h4>
			
			<div class="container">
				<div class="row">
					<div class="col" ng-repeat="packageProduct in packageProducts">
						<div>
							<img width="100" alt="衣索比亞日曬耶珈雪啡" src="https://fsv.cmoney.tw/cmstatic/notes/capture/37180/20140911113225993.jpg" />
						</div>
						<div class="selectedMenu" style="width: 500px;">
							<table class="table">
								<tr>
									<th>ID</th>
									<th>選擇</th>
									<th>烘培方式</th>
									<th>數量（半磅為一單位）</th>
									<th>價格</th>
									<th>單項金額</th>
								</tr>
								<tr ng-repeat="cookType in packageProduct.cookTypes">
									<td ng-bind="packageProduct.id"></td>
									<td><div class="checkbox-inline"><input type="checkbox" /></div></td>
									<td>
										<div ng-if="cookType == 1">深培</div>
										<div ng-if="cookType == 2">中培</div>
										<div ng-if="cookType == 3">淺培</div>
									</td>
									<td>
										<button ng-click="minus()" class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
										<input ng-model="packageProduct.count" type="text" style="width: 40px" />
										<button ng-click="add()" class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
									</td>
									<td ng-bind="packageProduct.unitPrice"></td>
									<td>$待計算</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
    </div>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>諾亞咖啡 - 商品一覽</title>
	
	<style>
	.product-content {
		width: 100%;
	}
	
	.product-content-center {
		text-align: center;
	}
	
	.product-row-padding {
		padding: 10px;
	}
	
	.each-product {
		border: 1px solid gray;
		min-width: 400px;
		margin: 5px;
	}
	
	.next-step {
		background-color: #00AAFF !important;
	}
	
	.next-step:hover {
		cursor: pointer;
		background-color: #00CCFF !important;
	}
	</style>
	
	<script>
	noahApp.controller("productController", function($scope, $http) {
		
		$scope.buyAllTotal = 0;	// 購物總金額
		
		$scope.productCart = [];
		
		$scope.loadProducts = function() {
			$http.get("${contextPath}/product/list/1").then(function(response) {
		        $scope.packageProducts = response.data;
	    	});			
			
// 			$http.get("${contextPath}/product/list/2").then(function(response) {
// 		        $scope.beanProducts = response.data;
// 	    	});			
		};
		
		$scope.loadProducts();
			
		$scope.calculateTotal = function(packageProduct, index) {
			packageProduct.total[index] = packageProduct.buyUnit[index] * packageProduct.unitPrice;
			$scope.calculateBuyAllTotal();
		};
		
		$scope.calculateBuyAllTotal = function() {
			var summary = 0;
			angular.forEach($scope.packageProducts, function(packageProduct, key) {
				angular.forEach(packageProduct.roastTypes, function(roastType, key) {
					summary = summary + packageProduct.total[key];
				});
			});
			$scope.buyAllTotal = summary;
		};
		
		$scope.addCart = function(packageProduct, index){
			//每種產品各三種烘焙方式，所以判斷是否唯一則以productId+index(RoastType)判斷。
			var alreadyInList = false;
			angular.forEach($scope.productCart, function(product, key){			
				
			});
		}
		
		$scope.handleAmountChange = function(packageProduct,index){
			$scope.calculateTotal(packageProduct,index);
			$scope.addCart(packageProduct,index);
		};
		
		
		$scope.checkout = function(){
			var cart = [];
			angular.forEach($scope.packageProducts,function(packageProduct,index){
				var currentPid = packageProduct.id;
				angular.forEach(packageProduct.buyUnit, function(buyUnit, unitIndex){
					if(buyUnit > 0){
						cart.push({
							productId: currentPid,
							count: buyUnit,
							roastTypeId: packageProduct.roastTypes[unitIndex].roastTypeId
						});
					}
				});
			});
			
			$http({
				method:'POST',
				url:'${contextPath}/product/save',
				data:cart
			}).success(function(data, status, headers, config){
				console.log(data);
			}).error(function(response){
				
			}).finally(function(){
				
			});
		};
		
		
	});
	</script>
</head>
<body>
    <div ng-controller="productController">
    	<section>
    		<div>
    			<h4><span>目前購買總金額：{{ buyAllTotal | currency }}</span></h4>
			</div>
			
			<h4>
				<span class="badge badge-pill badge-success">掛耳式咖啡</span>
				<span style="float: right"><h4><span class="badge badge-success next-step" ng-click="checkout()">確定選購</span></h4></span>
			</h4>
			
			<div class="product-content">
				<div class="product-content-center">
					<div class="row product-row-padding">
						<div class="col each-product" ng-repeat="packageProduct in packageProducts">
							<div>
								<img width="300" height="300" alt="{{packageProduct.imageDisplayName}}" 
									src="${contextPath}/img/products/{{packageProduct.imageName}}.jpg" />
							</div>
							<div class="selectedMenu">
								<table class="table table-zimbra">
									<tr>
<!-- 										<th>ID</th> -->
										<th>烘培方式</th>
										<th>數量（半磅為一單位）</th>
										<th>價格</th>
										<th>單項金額</th>
									</tr>
									<tr ng-repeat="roastType in packageProduct.roastTypes track by $index">
<!-- 										<td ng-bind="packageProduct.id"></td> -->
										<td>{{ roastType.roastTypeName }}</td>
										<td>
											<input 
												ng-init="packageProduct.buyUnit[$index] = 0" 
												ng-model="packageProduct.buyUnit[$index]"
												ng-change="handleAmountChange(packageProduct, $index);" 
												type="number" 
												style="width: 80px" />
										</td>
										<td ng-bind="packageProduct.unitPrice"></td>
										<td ng-init="packageProduct.total[$index] = 0" ng-bind="packageProduct.total[$index]"></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
    </div>
</body>
</html>
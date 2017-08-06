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
	
	.summary-block {
		position: fixed;
		width: 400px;
		top: 10px;
		left: 35%;
		z-index: 3000;
	}
	
	.summary-block span {
		color: white;
		font-size: 25px;
	}
	</style>
	
	<script>
	noahApp.controller("productController", function($scope, $http) {
		
		$scope.buyAllTotal = 0;	// 購物總金額		
		$scope.productCart = [];// 勾選的產品陣列
		
		$scope.loadProducts = function() {
			$http.get("${contextPath}/product/list/category/1").then(function(response) {
		        $scope.packageProducts = response.data;
	    	});			
			
// 			$http.get("${contextPath}/product/list/2").then(function(response) {
// 		        $scope.beanProducts = response.data;
// 	    	});			
		};
		
		$scope.loadProducts();
			
		$scope.calculateTotal = function(packageProduct, index) {
			if ( packageProduct.qty[index] < 0 ) {
				packageProduct.qty[index] = 0;
			}
			packageProduct.total[index] = packageProduct.qty[index] * packageProduct.unitPrice;
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
		
		$scope.checkout = function(){
			var cart = [];
			angular.forEach($scope.packageProducts,function(packageProduct,index){
				var currentPid = packageProduct.id;
				angular.forEach(packageProduct.qty, function(qty, unitIndex){
					if(qty > 0){
						cart.push({
							productId: currentPid,
							count: qty,
							roastTypeId: packageProduct.roastTypes[unitIndex].roastTypeId
						});
					}
				});
			});
			
			var form = document.createElement('form');
			form.setAttribute('action','${contextPath}/product/save');
			form.setAttribute('method','post');
			form.setAttribute('hidden','true');
			form.setAttribute('modelAttribute','productFormWrapper');
			
			var itemsCount = cart.length;
			
			for(var i =0; i<itemsCount; i++){
				var pid = document.createElement('input');
				pid.setAttribute('type','text');
				pid.setAttribute('name', 'productForm['+i+'].productId');
				pid.setAttribute('value',cart[i].productId);
				
				form.appendChild(pid);
				
				var count = document.createElement('input');
				count.setAttribute('type','text');
				count.setAttribute('name', 'productForm['+i+'].count');
				count.setAttribute('value',cart[i].count);
				
				form.appendChild(count);
				
				var roastTypeId = document.createElement('input');
				roastTypeId.setAttribute('type','text');
				roastTypeId.setAttribute('name', 'productForm['+i+'].roastTypeId');
				roastTypeId.setAttribute('value',cart[i].roastTypeId);
				
				form.appendChild(roastTypeId);				
			}
			document.body.appendChild(form);
			form.submit();
		};
		
		
	});
	</script>
</head>
<body>
    <div ng-controller="productController">
    	<div ng-show="buyAllTotal > 0" class="summary-block">
			<span>目前購買總金額：{{ buyAllTotal | currency }}</span>
		</div>
    	<section>
			<h4>
				<span class="badge badge-pill badge-success">掛耳式咖啡</span>
				<span style="float: right"><h4><span class="badge badge-success next-step" ng-click="checkout()">確定選購</span></h4></span>
			</h4>
			
			<div class="product-content">
				<div class="product-content-center">
					<div class="row product-row-padding">
						<!-- 各產品 -->
						<div class="col each-product" ng-repeat="packageProduct in packageProducts">
							<div>
								<img width="300" height="300" alt="{{packageProduct.imageDisplayName}}" 
									src="${contextPath}/img/products/{{packageProduct.imageName}}.jpg" />
							</div>
							<div class="selectedMenu">
								<table class="table table-zimbra">
									<tr>
										<th>烘培方式</th>
										<th>數量（半磅為一單位）</th>
										<th>價格</th>
										<th>單項金額</th>
									</tr>
									
									<!-- 依列出每項產品有的烘焙方式 -->
									<tr ng-repeat="roastType in packageProduct.roastTypes track by $index">
										<td>{{ roastType.roastTypeName }}</td>
										<td>
											<input 
												ng-init="packageProduct.qty[$index] = 0" 
												ng-model="packageProduct.qty[$index]"
												ng-change="calculateTotal(packageProduct, $index)" 
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
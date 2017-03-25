<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>NOAH手作咖啡烘焙訂購單</title>
	
	<script>
	noahApp.controller("buyCoffeeController", function($scope) {

		$scope.count = 0;
		$scope.total = 0;
		
	    $scope.add = function() {
	    	$scope.count ++;
	    	$scope.total = $scope.count * 250;
	    };
	    
		$scope.minus = function() {
			$scope.count --;
			if ( $scope.count < 0 ) {
				$scope.count = 0;
			}
			$scope.total = $scope.count * 250;
	    };
	});
	</script>
</head>
<body>

<div ng-controller="buyCoffeeController">
	<section>
		<h4><span class="badge badge-pill badge-success">掛耳式咖啡</span></h4>
		
		<div class="container">
			<div class="row">
				<div class="col">
					<div>
						<img width="100" alt="衣索比亞日曬耶珈雪啡" src="https://fsv.cmoney.tw/cmstatic/notes/capture/37180/20140911113225993.jpg" />
					</div>
					<div class="selectedMenu" style="width: 500px;">
						<table class="table">
							<tr>
								<th>選擇</th>
								<th>烘培方式</th>
								<th>數量（半磅為一單位）</th>
								<th>價格</th>
								<th>單項金額</th>
							</tr>
							<tr>
								<td><div class="checkbox-inline"><input type="checkbox" /></div></td>
								<td>深培</td>
								<td>
									<button ng-click="minus()" class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input ng-model="count" type="text" style="width: 40px" />
									<button ng-click="add()" class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$<span ng-bind="total">{{total}}</span></td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>中培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>淺培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div class="col">
					<div>
						<img width="100" alt="瓜地馬拉法拉漢尼斯檸檬莊園" src="	https://wacowsf.com/wp-content/uploads/2016/12/dt_160310_coffee_cup_800x600.jpg" />
					</div>
					<div class="selectedMenu" style="width: 500px;">
						<table class="table">
							<tr>
								<th>選擇</th>
								<th>烘培方式</th>
								<th>數量（半磅為一單位）</th>
								<th>價格</th>
								<th>單項金額</th>
							</tr>
							<tr>
								<td><div class="checkbox-inline"><input type="checkbox" /></div></td>
								<td>深培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input ng-model="count" type="text" style="width: 40px" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$<span></span></td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>中培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>淺培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section>
		<h4><span class="badge badge-pill badge-success">咖啡豆/咖啡粉</span></h4>
		
		<div class="container">
			<div class="row">
				<div class="col">
					<div>
						<img width="100" alt="衣索比亞日曬耶珈雪啡" src="https://fsv.cmoney.tw/cmstatic/notes/capture/37180/20140911113225993.jpg" />
					</div>
					<div class="selectedMenu" style="width: 600px;">
						<table class="table">
							<tr>
								<th>選擇</th>
								<th>烘培方式</th>
								<th>咖啡豆/粉</th>
								<th>數量（半磅為一單位）</th>
								<th>價格</th>
								<th>單項金額</th>
							</tr>
							<tr>
								<td><div class="checkbox-inline"><input type="checkbox" /></div></td>
								<td>深培</td>
								<td>
									<select>
										<option>咖啡豆</option>
										<option>咖啡粉</option>
										<option>我兩個都要</option>
									</select>
								</td>
								<td>
									<button ng-click="minus()" class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input ng-model="count" type="text" style="width: 40px" />
									<button ng-click="add()" class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$<span ng-bind="total">{{total}}</span></td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>中培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>淺培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div class="col">
					<div>
						<img width="100" alt="瓜地馬拉法拉漢尼斯檸檬莊園" src="	https://wacowsf.com/wp-content/uploads/2016/12/dt_160310_coffee_cup_800x600.jpg" />
					</div>
					<div class="selectedMenu" style="width: 500px;">
						<table class="table">
							<tr>
								<th>選擇</th>
								<th>烘培方式</th>
								<th>數量（半磅為一單位）</th>
								<th>價格</th>
								<th>單項金額</th>
							</tr>
							<tr>
								<td><div class="checkbox-inline"><input type="checkbox" /></div></td>
								<td>深培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input ng-model="count" type="text" style="width: 40px" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$<span></span></td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>中培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>淺培</td>
								<td>
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-minus" aria-hidden="true"></i></button>
									<input type="text" style="width: 40px" value="0" />
									<button class="btn btn-outline-primary btn-sm"><i class="fa fa-plus"></i></button>
								</td>
								<td>$250</td>
								<td>$0</td>
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
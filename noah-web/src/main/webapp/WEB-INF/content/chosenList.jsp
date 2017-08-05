<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
	<meta charset="UTF-8">
	<style>
		.divTable {
	        display:  table;
	        width:100%;
	        background-color:#eee;
	        border:1px solid  #666666;
	        border-spacing:5px;/*cellspacing:poor IE support for  this*/
	       	margin-left:auto;
	       	margin-right:auto;
	    }
	
	    .divRow {
	       display:table-row;
	       width:auto;
	    }
	    
	    .divHeaderRow{
	    	background-color:blue;
	    	foreground-color:white;
	    }
	
	    .divCell {
	        float:left;/*fix for  buggy browsers*/
	        display:table-column;
	        width:200px;
	        background-color:white;
	    }
	</style>
</head>
<body>
	<div class="divTable">
		<div class="divHeaderRow">
			<div class="divCell" style="width:20%;">品名</div>
			<div class="divCell" style="width:20%;">單價</div>
			<div class="divCell" style="width:20%;">數量</div>
			<div class="divCell" style="width:20%;">烘焙方式</div>
			<div class="divCell" style="width:20%;">小計</div>
		</div>
		<c:set var="total" value="${0}" />
		<c:forEach items="${selectedFormList}" var="selectedForm">
			<div class="divRow">
				<div class="divCell" style="width:20%;">${selectedForm.productDomain.name}</div>
				<div class="divCell" style="width:20%;">${selectedForm.productDomain.unitPrice}</div>
				<div class="divCell" style="width:20%;">${selectedForm.count}</div>
				<div class="divCell" style="width:20%;">${selectedForm.roastTypeDomain.typeName}</div>
				<div class="divCell" style="width:20%;">${selectedForm.productDomain.unitPrice * selectedForm.count}</div>
			</div>
			<c:set var="total"
				value="${total + selectedForm.productDomain.unitPrice * selectedForm.count}" />
		</c:forEach>
	</div>

	<div class="divTable">
		<div class="divRow">
			<div class="divCell" style="width:20%;">總計</div>
			<div class="divCell" style="width:80%;text-align:right;">${total}</div>
		</div>
	</div>
</body>
</html>
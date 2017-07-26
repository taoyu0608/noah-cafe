<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<c:forEach items="${selectedProducts}" var="product">
		<div>${product.productId}</div>
		<div>${product.count}</div>
		<div>${product.roastTypeId}</div>
	</c:forEach>
</body>
</html>
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
	
	<sitemesh:write property="head" />
</head>
<body>
    <div style="margin: 10px;">
        <sitemesh:write property='body' />
    </div>

    <div class="footer">
        <div>NOAH 咖啡</div>
    </div>
</body>
</html>
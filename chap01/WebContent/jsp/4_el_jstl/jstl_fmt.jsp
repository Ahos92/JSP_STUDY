<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- import jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Format</title>
</head>
<body>

<h3>fmt:setLocale</h3>
<p>
	지역 설정을 변경한다.
</p>
<fmt:setLocale value="ja_jp"/> <!-- en_us, ko_kr -->

<hr />
<h3>fmt:formatNumber</h3>
<p>
	숫자 데이터를 표시할 때 필요한 기능들을 제공한다.
</p>

<c:set var="money" value="${15000 }"/>

<fmt:formatNumber value="${money }" type="number"/> <br />
<fmt:formatNumber value="${money }" type="currency"/> <br />
<fmt:formatNumber value="${money }" type="percent"/> <br />

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>
</head>
<body>

<!-- method="GET"은 doGet()으로 / method="POST"는 doPost()로 -->
<form action="/chap01/submit" method="POST"></form>

<form action="./pizzaSubmit.jsp" method="POST"></form>

<form action="/chap01/jsp/1_form/pizzaSubmit.jsp" method="POST">
<div class="container-lg">
<h3>Pizza Order</h3>
<br />
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">@</span> <input
			type="text" class="form-control" placeholder="Username"
			aria-label="Username" aria-describedby="basic-addon1"
			name="customer_name">
	</div>

	<!-- 피자 선택 -->
	<div class="form-check">
		<input class="form-check-input" id="cheese_pizza" type="radio" name="topping" value="cheese_pizza"> 
		<label class="form-check-label" for="cheese_pizza">치즈 피자</label>
	</div>
	<div class="form-check">
		<input class="form-check-input" id="pepperoni_pizza" type="radio" name="topping" value="pepperoni_pizza"> 
		<label class="form-check-label" for="pepperoni_pizza">페퍼로니 피자</label>
	</div>
	<div class="form-check">
		<input class="form-check-input" id="combi_pizza" type="radio" name="topping" value="combi_pizza"> 
		<label class="form-check-label" for="combi_pizza">콤비네이션 피자</label>
	</div>
	
	<hr />

	<!-- 사이드 메뉴 -->
	<div class="form-check">
		<input class="form-check-input" id="coke" type="checkbox" value="coke" name="side"> 
		<label class="form-check-label" for="coke"> 콜라 추가 </label>
	</div>
	<div class="form-check">
		<input class="form-check-input" id="pickle" type="checkbox" value="pickle" name="side"> 
		<label class="form-check-label" for="pickle"> 피클 추가 </label>
	</div>
	<div class="form-check">
		<input class="form-check-input" id="pasta" type="checkbox" value="pasta" name="side"> 
		<label class="form-check-label" for="pasta"> 파스타 추가 </label>
	</div>
	
	<hr />

	<div class="input-group">
		<span class="input-group-text">요청 사항</span>
		<textarea class="form-control" name="cs"></textarea>
	</div>

	<input type="submit" class="btn btn-primary mt-3" value="주문 요청하기"/>
</div>
</form>

</body>
</html>
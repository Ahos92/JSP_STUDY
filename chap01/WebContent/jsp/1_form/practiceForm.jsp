<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 연습</title>
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
	<form action="./practiceSubmit.jsp" method="POST"></form>

	<form action="/chap01/practice" method="GET">
		<div class="container-md m-20 p-20">
			<h3>신상 정보</h3>
			<br />
			<div class="row">
				<div class="col-2">
					<label for="inputName" class="form-label">이름</label> 
					<input type="text" class="form-control" id="inputName" name="name">
				</div>

				<div class="col-2">
					<label for="inputGender" class="form-label">성별</label> 
					<select id="inputGender" class="form-select" name="gender">
						<option selected>남</option>
						<option>여</option>
					</select>
				</div>
			</div>

			<hr />

			<div class="col-md-6">
				<label for="inputAddr" class="form-label">주소</label> 
				<input type="text" class="form-control" id="inputAddr" name="address"
						placeholder="recommed) xx시 yy구 zz동 000-00">
			</div>

			<hr />

			<div class="col-md-4">
				<label for="inputEducation" class="form-label">학력</label>
				<select id="inputEducation" class="form-select" name="edu">
					<option selected>선택</option>
					<option>중졸</option>
					<option>고졸</option>
					<option>대졸</option>
				</select>
			</div>

			<hr />

			<label for="inputHobby" class="form-label">취미</label>
			<div class="form-check">
				<input class="form-check-input" id="game" type="checkbox" value="게임" name="hobby"> 
				<label class="form-check-label" for="game"> 게임 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" id="Exercise" type="checkbox" value="운동" name="hobby"> 
				<label class="form-check-label" for="Exercise"> 운동 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" id="sleep" type="checkbox" value="수면" name="hobby"> 
				<label class="form-check-label" for="sleep"> 수면 </label>
			</div>

			<hr />

			<div class="col-12">
				<button type="submit" class="btn btn-primary">정보 보내기</button>
				<span class="badge bg-warning">주의!</span>
			</div>
		</div>
	</form>


</body>
</html>
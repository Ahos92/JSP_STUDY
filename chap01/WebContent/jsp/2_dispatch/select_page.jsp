<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 선택</title>
</head>
<body>

<h3>가고 싶은 페이지를 선택해보세요</h3>

<form id="form_get" action="/chap01/test/controltest" method="GET"></form>
<form id="form_post" action="/chap01/test/controltest" method="POST"></form>

<!-- 
	/chap01/controltest에
	
		GET방식으로 요청하는 사용자에게는 페이지를 고를 수 있는 폼을 보여주고
		
		POST방식으로 요청하는 사용자에게는 사용자가 고른 페이지를 포워드해주도록 서블릿을 만들어보세요
 -->

<input type="text" form="form_post" name="name" placeholder="이름을 입력해주세요"/>
<input type="text" form="form_post" name="character" placeholder="성격을 입력해주세요"/>
<input type="text" form="form_post" name="age" placeholder="나이를 입력해주세요"/>


<select name="page" form="form_post" id="page_selector">
	<option value="1">page1</option>
	<option value="2">page2</option>
	<option value="3">page3</option>
</select>

<hr />

<!-- <input type="submit" form="form_get" value="인풋 전송!"/> -->
<button id="form_submit_btn">전송!</button>

<script>
	const btn = document.getElementById("form_submit_btn");
	const select = document.getElementById("page_selector");
	
	btn.addEventListener("click", () =>{
		document.getElementById(select.getAttribute("form")).submit();
	});
</script>

</body>
</html>
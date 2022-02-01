<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="email">Username</label> <input type="text" name="username" class="form-control" placeholder="Enter Username" id="username">
		</div>

		<div class="form-group">
			<label for="pwd">Password</label> <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href="
https://kauth.kakao.com/oauth/authorize
?client_id=84d0b808b23f632f987e7ec4dd0bbf40
&redirect_uri=http://localhost:8000/auth/kakao/callback
&response_type=code">
<img height="40px"
			src="/image/kakao_login_button.png"></a>
	</form>
</div>
<!-- 로그인때 자바스크립트 사용 안할거임.
<script src="/js/user.js"></script> -->



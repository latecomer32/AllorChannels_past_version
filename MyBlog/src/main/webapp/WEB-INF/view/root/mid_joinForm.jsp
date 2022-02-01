<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>


.joinform{
margin-top:50px;
}


.form-floating>.form-control, .form-floating>.form-select {
	height: 80px;
	line-height: 1.25;
}

.form-control {
	border: 1px solid rgb(255, 242, 242);
	    border-radius: 0.35rem;
}

:root {
--bs-body-line-height: 0.5;
}
</style>

<div class="Display middeDisplay">
	<div class="container-sm">
		<form name="join" class="joinform">
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="joinUserId" placeholder="Id" name="joinUserId" required autofocus> <label for="floatingInput">ID</label>
			</div>
			<br />
			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="joinPassword" placeholder="Password" name="joinPassword" required> <label for="floatingPassword">Password</label>
			</div>
			<br />
			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="passwordCheck" placeholder="Password reconfirm" name="PasswordCheck" required> <label for="floatingPassword">Password reconfirm</label>
			</div>
			<br />
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="joinNickName" placeholder="Nickname" name="joinNickName" required> <label for="floatingPassword">Nick name</label>
			</div>
			<br />
		</form>
		<br>
		<br>
		<br>
	
		<button id="btn-save" class="btn btn-primary" name="SignUp" onclick="return joinCheck()">가입</button>
	</div>
</div>

<script src="/js/join.js"></script>
<script src="/js/user.js"></script>


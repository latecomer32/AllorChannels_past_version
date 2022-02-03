<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<style>
.nav {
	box-shadow: 0px 0px 4px 0.3px gray !important; //
	margin-bottom: 20px !important;
}

ul li a {
	line-height: 380%;
	color: black !important;
}
</style>




<!-- -------모달 창 ---------- -->

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" >
		<div class="modal-content">

			<form action="/auth/loginProc" method="POST">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">로그인</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="loginUserId" placeholder="Id" name="loginUserId" required autofocus> <label for="floatingInput">ID</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="loginPpassword" placeholder="Password" name="loginPpassword" required> <label for="floatingPassword">Password</label>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>

					<input type="submit" class="btn btn-primary" name="login" value="로그인"> <a href="/auth/joinForm" class="btn btn-secondary">회원가입</a>
				</div>
			</form>

		</div>
	</div>
</div>
<!-- -------<header> ---------- -->
<ul class="nav justify-content-center">

	<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">검색</a></li>
	<c:choose>
		<c:when test="${empty principal}">
			<li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal" href="/">로그인</a></li>
			<li class="nav-item"><a
				href="
https://kauth.kakao.com/oauth/authorize
?client_id=84d0b808b23f632f987e7ec4dd0bbf40
&redirect_uri=http://localhost:8000/auth/kakao/callback
&response_type=code"> <img height="40px"
					src="/image/kakao_login_button.png"></a></li>
			<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
		</c:when>
		<c:otherwise>
			<li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
			<li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
			<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>

</ul>
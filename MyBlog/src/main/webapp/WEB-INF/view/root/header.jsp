<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- layout에 설정하면 안 먹힘 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>



<style>
.header {
	box-shadow: 0px 0px 4px 0.3px gray !important; //
	margin-bottom: 20px !important;
}

ul li a {
	line-height: 380%;
	color: black !important;
}

.icon- {
	width: 150% !important;
	color: rgba(155, 155, 155, 0.3);
}
</style>




<!-- -------모달 창 ---------- -->

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
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
<div class=" header d-flex justify-content-start  ">
	<div class="leftDisplay">1</div>

	<div class="d-flex justify-content-between middleDisplay">
		<a class="marginTopBottomAuto NoUnderline" href="/">B</a> <span>
			<ul class="nav">
				<form class="d-flex flex-row" action="/">
					<li class="nav-item marginTopBottomAuto"><input type="text" name="q" value="${param.q}" onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}" /></li>
					<li class="nav-item marginTopBottomAuto"><input type="image" src="./image/search.svg" onclick="search_onclick_submit" class="submit icon-" /></li>
				</form>
			
				<c:choose>
					<c:when test="${empty principal}">
						<li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal" href="/">로그인</a></li>
						<li class="nav-item marginTopBottomAuto"><a
							href="
https://kauth.kakao.com/oauth/authorize
?client_id=84d0b808b23f632f987e7ec4dd0bbf40
&redirect_uri=http://localhost:8000/auth/kakao/callback
&response_type=code"> <img
								height="40px" src="/image/kakao_login_button.png"></a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/board/saveTheWritingForm">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/header/member">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/header/member">${principal.nickName}</a></li>
						<li class="nav-item"><a class="nav-link flex-row-reverse" href="/logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</span>
	</div>

	<div class="rightDisplay">3</div>
</div>
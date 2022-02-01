<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style>


.nav {
    box-shadow: 0px 0px 4px 0.3px gray!important;
    //margin-bottom: 20px!important;
    
}
ul li a {
	line-height: 380%;
	color:black!important;
}


</style>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>


<jsp:include page="modalLoginScreen.jsp" flush="false" />

<ul class="nav justify-content-center">
	<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">검색</a></li>
	<c:choose>
		<c:when test="${empty principal}">
			<li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo" href="/auth/loginForm">로그인</a></li>
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
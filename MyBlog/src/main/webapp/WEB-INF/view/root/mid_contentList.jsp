<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="Display middeDisplay">
	<style>
.emptyHeigt-- {
	
}

td {
	max-height: 30px !important;
}
</style>


	<div class="container-sm">
		<form>
			<div class="container">
				<div class="row justify-content-start">

					<select class="col-2" name="order">
						<option ${(param.order=="no")?"selected":"" } value="no">번호</option>
						<option ${(param.order=="title")?"selected":"" } value="title">제목</option>
						<option ${(param.order=="nickName")?"selected":"" } value="nickName">작성자</option>
						<option ${(param.order=="date")?"selected":"" } value="date">작성일</option>
						<option ${(param.order=="Account")?"selected":"" } value="Account">Account</option>

					</select> <select class="col-2" name="desc">
						<option ${(param.desc=="DESC")?"selected":"" } value="DESC">내림차순</option>
						<option ${(param.desc=="ASC")?"selected":"" } value="ASC">오름차순</option>
					</select>

					<div class="col-2">&nbsp;</div>

					<select class="col-1" name="r">
						<option ${(param.r=="15")?"selected":"" } value="15">15개</option>
						<option ${(param.r=="10")?"selected":"" } value="10">10개</option>
						<option ${(param.r=="20")?"selected":"" } value="20">20개</option>
						<option ${(param.r=="30")?"selected":"" } value="30">30개</option>
						<option ${(param.r=="50")?"selected":"" } value="50">50개</option>
						<option ${(param.r=="100")?"selected":"" } value="100">100개</option>
					</select> <select class="col-2" name="f">
						<option ${(param.f=="nickName")?"selected":"" } value="nickName">작성자</option>
						<option ${(param.f=="no")?"selected":"" } value="no">번호</option>
			
						<option ${(param.f=="Account")?"selected":"" } value="Account">Account</option>
						<option ${(param.f=="date")?"selected":"" } value="date">작성일</option>
					</select> <input class="col-2" type="text" name="q" value="${param.q}" />
					<button type="submit" class="btn btn-primary col-1">검색</button>
				</div>
			</div>
		</form>

		<form action="/DelMember" method="post">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="all" id="flexCheckDefault" name="del_member">
							</div>
						</th>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach var="getWritingList" items="${getWritingList}">
						<tr>
							<td>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="${getWritingList.no}" id="flexCheckDefault" name="del_member">
								</div>
							</td>
							<td scope="row">${getWritingList.no}</td>
							<a href="/board/detail">
							<td>${getWritingList.title}</td>
							</a>
							<td>${getWritingList.nickName}</td>
							<td>${getWritingList.date}</td>
							<td>${getWritingList.viewCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary col-1">계정 삭제</button>
		</form>

		<c:set var="row" value="${(empty param.r)?15:param.r}" />
		<c:set var="page" value="${(empty param.p)?1:param.p}" />
		<c:set var="startNum" value="${page-(page-1)%5}" />
		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/row),'.')}" />

		<div class="row justify-content-end">
			<div class="col-sm text-center"></div>
			<div class="col-sm text-center">

				<c:if test="${startNum>1 }">
					<a href="?p=${startNum-1}&f=${param.f }&q=${param.q}&r=${row}" class="btn">이전</a>
				</c:if>
				<c:if test="${startNum<=1}">
					<span class="btn" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>

				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i)<= lastNum}">
						<a class="-text-" style="${(page==(startNum+i))?'color:orange;':''}" href="?p=${startNum+i}&f=${param.f }&q=${param.q}&r=${row}&order=${param.order}&=desc=${param.desc}"> ${startNum+i}</a>
					</c:if>
				</c:forEach>

				<c:if test="${startNum+5<=lastNum}">
					<a href="?p=${startNum+5}&f=${param.f }&q=${param.q}&r=${row}" class="btn btn-next">다음</a>
				</c:if>
				<c:if test="${startNum+4>=lastNum }">
					<span class="btn" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
			</div>

			<div class="col-sm text-right">
				현재 페이지 <span>${(empty param.p)?1:param.p}</span> / ${lastNum} pages
			</div>

		</div>
	</div>
</div>
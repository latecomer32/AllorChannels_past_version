<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <div class="Display middeDisplay">
<style>
table{
min-height:650px!important;
}
</style>


<div class="container-sm">
		<form>
			<div class="container">
				<div class="row justify-content-start">

					<select class="col-2" name="order">
						<option ${(param.order=="JoinDate")?"selected":"" }
							value="JoinDate">JoinDate</option>
						<option ${(param.order=="No")?"selected":"" } value="No">No</option>
						<option ${(param.order=="Id")?"selected":"" } value="Id">Id</option>
						<option ${(param.order=="UserName")?"selected":"" }
							value="UserName">UserName</option>
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
						<option ${(param.f=="UserName")?"selected":"" } value="UserName">UserName</option>
						<option ${(param.f=="No")?"selected":"" } value="No">No</option>
						<option ${(param.f=="Id")?"selected":"" } value="Id">Id</option>
						<option ${(param.f=="Account")?"selected":"" } value="Account">Account</option>
						<option ${(param.f=="JoinDate")?"selected":"" } value="JoinDate">JoinDate</option>
					</select> <input class="col-2" type="text" name="q" value="${param.q}" />
					<button type="submit" class="btn btn-primary col-1">검색</button>
				</div>
			</div>
		</form>

<form action="/DelMember" method="post">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col"><div class="form-check">
							<input class="form-check-input" type="checkbox" value="all"
								id="flexCheckDefault" name="del_member"> 
						</div>
						</th>
					<th scope="col">No</th>
					<th scope="col">ID</th>
					<th scope="col">UserName</th>
					<th scope="col">Account</th>
					<th scope="col">JoinDate</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="n" items="${list}">
					<tr>
						<th>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="${n.id}"
								id="flexCheckDefault" name="del_member"> 
						</div>
						</th>
						<th scope="row">${n.no}</th>
						<td>${n.id}</td>
						<td>${n.userName}</td>
						<td>${n.grade}</td>
						<td>${n.joinDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="submit" class="btn btn-primary col-1">계정 삭제</button>
		</form>

		<c:set var="row" value="${(empty param.r)?15:param.r}" />
		<c:set var="page" value="${(empty param.p)?1:param.p}" />
		<c:set var="startNum" value="${page-(page-1)%5}" />
		<c:set var="lastNum"
			value="${fn:substringBefore(Math.ceil(count/row),'.')}" />

		<div class="row justify-content-end">
			<div class="col-sm text-center"></div>
			<div class="col-sm text-center">

				<c:if test="${startNum>1 }">
					<a href="?p=${startNum-1}&f=${param.f }&q=${param.q}&r=${row}"
						class="btn">이전</a>
				</c:if>
				<c:if test="${startNum<=1}">
					<span class="btn" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>

				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i)<= lastNum}">
						<a class="-text-"
							style="${(page==(startNum+i))?'color:orange;':''}"
							href="?p=${startNum+i}&f=${param.f }&q=${param.q}&r=${row}&order=${param.order}&=desc=${param.desc}">
							${startNum+i}</a>
					</c:if>
				</c:forEach>

				<c:if test="${startNum+5<=lastNum}">
					<a href="?p=${startNum+5}&f=${param.f }&q=${param.q}&r=${row}"
						class="btn btn-next">다음</a>
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
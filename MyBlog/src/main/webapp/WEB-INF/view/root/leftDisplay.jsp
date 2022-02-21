<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>


<style>
/* 3.2. 리스트를 구성할 스타일 시트 */
.itemBox {
	border: solid 1px black;
	width: 400px;
	height: 50px;
	padding: 10px;
	margin-bottom: 10px;
}

.itemBoxHighlight {
	border: solid 1px black;
	width: 400px;
	height: 50px;
	padding: 10px;
	margin-bottom: 10px;
	background-color: yellow;
}

.deleteBox {
	float: right;
	display: none;
	cursor: pointer;
}

.beginEmpty {
	min-height: 50px;
}
</style>

<c:if test="${Uri != '/index/channels'}">
	<div>

		<c:choose>
			<c:when test="${empty principal}">
			</c:when>
			<c:otherwise>
				<div class="card" style="width: 18rem;">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a class="nav-link ${(fn:contains(Uri, '/index/channels'))?'':'active'}" aria-current="page" href="/index/category"><b>MyBlog</b></a></li>
						<c:set var="List" value="${getCategoryList}"></c:set>
						<c:set var="saveCategoryURI" value='/category/saveCategoryName'></c:set>
						<c:set var="deleteCategoryURI" value='/category/deleteCategoryName'></c:set>

						<c:choose>
							<c:when test="${empty getChannelName}">
							</c:when>
							<c:when test="${fn:contains(Uri, '/index/channels')}">
								<li class="nav-item"><a class="nav-link ${(fn:contains(Uri, '/index/channels'))?'active':''}" href="/index/channels/${channelName}"> ${channelName}</a></li>
								<input type="hidden" id="title" value="${channelName}" />
								<c:set var="List" value="${getChannelCategoryList}"></c:set>
								<c:set var="saveCategoryURI" value='/channel/saveChannelCategoryName'></c:set>
								<c:set var="deleteCategoryURI" value='/channel/deleteChannelCategoryName'></c:set>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link " href="/index/channels/${getChannelName}"> ${getChannelName}</a></li>
							</c:otherwise>
						</c:choose>
					</ul>

					<input type="hidden" id="deleteCategoryURI" value='${deleteCategoryURI}' /> 
					<input type="hidden" id="saveCategoryURI" value='${saveCategoryURI}' /> 
					<div class="card-body">
						<ul class="list-group" id="sortable">

							<a class="NoUnderline" href="/index/category?c="><li class="ui-state-default list-group-item active"> 내가 작성한 글 전부 보기 </li></a>
							<a class="NoUnderline" href="/index/category?c=없음"><li class="ui-state-default list-group-item"> 카테고리 없는 글 보기 </li></a>
							<c:forEach var="List" items="${List}">
								<a class="NoUnderline" href="/index/category?c=${List.categoryName}"><li class="ui-state-default list-group-item active">
								<input type="checkbox" id="deleteCategory" name="deleteCategory" value="${List.no}" /> 
								${List.categoryName}</li></a>
							</c:forEach>
						</ul>


						<div>
							<div style="float: left; width: 100px;">카테고리 추가 :</div>
							<div style="clar: both;">
								<input type="button" id="addItem" value="추가" onclick="createItem();" /> <input type="button" id="btn_deleteCategory" name="btn_deleteCategory" value="삭제" onclick="btn_deleteCategory();" /> <input
									type="button" id="submitItem" value="확인" onclick="submitItem();" />
							</div>
						</div>
						<br />

						<div id="itemBoxWrap"></div>
					</div>


				</div>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>

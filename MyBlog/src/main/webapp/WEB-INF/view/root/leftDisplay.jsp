<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


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


<div>

	<div class="beginEmpty"></div>






	<c:choose>
		<c:when test="${empty principal}">
		</c:when>
		<c:otherwise>

			<div class="card" style="width: 18rem;">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="/index/category"><b>${principal.nickName}</b></a></li>
					<c:choose>
						<c:when test="${channelName eq getChannelName}">
							<li class="nav-item"><a class="nav-link" href="/index/${getChannelName}"> ${getChannelName}</a></li>
						</c:when>
						<c:when test="${channelName eq 'category'}">
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/index/${channelName}"> ${channelName}</a></li>
						</c:otherwise>
					</c:choose>
				</ul>



				<div class="card-body">
					<ul class="list-group" id="sortable">

						<li class="ui-state-default list-group-item active"><a href="/index/category?c="> 내가 작성한 글 전부 보기 </a></li>
						<li class="ui-state-default list-group-item"><a href="/index/category?c=없음"> 카테고리 없는 글 보기 </a></li>
						<c:forEach var="getCategoryList" items="${getCategoryList}">
							<li class="ui-state-default list-group-item active"><input type="checkbox" id="deleteCategory" name="deleteCategory" value="${getCategoryList.no}" /> <a
								href="/index/category?c=${getCategoryList.categoryName}"> <span class="ui-icon ui-icon-arrowthick-2-n-s"> </span>${getCategoryList.categoryName}</a></li>
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

<script src="/js/category.js"></script>
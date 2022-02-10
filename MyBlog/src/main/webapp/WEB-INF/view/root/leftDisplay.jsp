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
</style>


<div>
	1
	<c:choose>
		<c:when test="${empty principal}">
2
		</c:when>
		<c:otherwise>
			<div>${principal.nickName}카테고리목록</div>
			<ul class="list-group" id="sortable">
				<c:choose>
					<c:when test="${empty getCategoryList}">
						<li class="ui-state-default list-group-item active"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>카테고리 없음</li>

					</c:when>
					<c:otherwise>
						<c:forEach var="getCategoryList" items="${getCategoryList}">

							<li class="ui-state-default list-group-item active"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${getCategoryList.categoryName}</li>

						</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<div>

		<div style="float: left; width: 100px;">아이템 추가 :</div>

		<div style="clar: both;">

			<input type="button" id="addItem" value="추가" onclick="createItem();" /> <input type="button" id="submitItem" value="제출" onclick="submitItem();" />

		</div>
	</div>
	<br />

	<div id="itemBoxWrap"></div>

	</c:otherwise>
	</c:choose>
</div>

<script src="/js/category.js"></script>
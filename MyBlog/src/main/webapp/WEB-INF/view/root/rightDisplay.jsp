<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div>
3
<c:choose>
		<c:when test="${empty principal}">
2
		</c:when>
		<c:otherwise>
			<div>카테고리 목록</div>
			<c:forEach var="1" items="1">
			<div class="list-group">
  <button type="button" class="list-group-item list-group-item-action active" aria-current="true">
    The current button
  </button>
  <button type="button" class="list-group-item list-group-item-action">A second item</button>
  <button type="button" class="list-group-item list-group-item-action">A third button item</button>
  <button type="button" class="list-group-item list-group-item-action">A fourth button item</button>
  <button type="button" class="list-group-item list-group-item-action" disabled>A disabled button item</button>
</div>
			
			</c:forEach>
			<div>카테고리 없음</div>

		</c:otherwise>
	</c:choose>
</div>
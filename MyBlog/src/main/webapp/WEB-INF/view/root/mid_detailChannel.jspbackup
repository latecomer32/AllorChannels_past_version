<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
</style>


<div>
	<div scope="row">${board.no}</div>
	<div>${board.title}</div>
	<div>${board.nickName}</div>
	<div>
		<fmt:formatDate pattern="yy/MM/dd" value="${board.date}" var="date_year" />
		<fmt:formatDate pattern="hh:mm:ss" value="${board.date}" var="date_hour" />
		<c:choose>
			<c:when test="${date_year == today_str_year}">
				<c:out value="${date_hour}" />
			</c:when>
			<c:otherwise>
				<c:out value="${date_year}" />
			</c:otherwise>
		</c:choose>
	</div>
	<div>${board.viewCount}</div>
	<div>${board.content}</div>
</div>

<jsp:include page="mid_channerContentList.jsp" flush="true"/>


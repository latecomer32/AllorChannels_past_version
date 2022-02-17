<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
table.tmp_table tr {
	height: 53px;
	text-align: center;
	vertical-align: middle; /* tr 안에서 세로 정렬 방법 top, middle, bottom */
	border-bottom: 1px dotted rgb(218, 218, 218);
}

table.tmp_table th {
	
}

.grayFont_th {
	color: rgb(150, 150, 150);
	font-size: 0.8rem;
}

.grayFont_td {
	color: rgb(150, 150, 150);
	font-size: 0.9rem;
}

.titleFont_td {
	color: rgb(70, 70, 70) !important;
	font-size: 1rem;
}

.channelName {
	max-width: 120px;
	main-width: 50px;
	max-height: 37px;
	margin: 2px 3px;
}
</style>

<div class="flex-column">

<!-- /category 에서 채널목록은 출력하지 않도록 설정 -->
	<c:choose>
		<c:when test="${Uri=='/category'}">
			<!-- /category 주소에서 view 단에 채널 출력하지 않는 설정 -->
		</c:when>
		<c:otherwise>
			<!-- /category 주소에서 view 단에 채널 출력하는 설정 -->
			<div class="d-flex flex-column">
				<div class="d-flex justify-content-center">
					<c:set var="row" value="${(empty param.cr)?15:param.cr}" />
					<c:set var="channelPage" value="${(empty param.cp)?1:param.cp}" />
					<c:set var="channelstartNum" value="${page-(page-1)%5}" />
					<c:set var="channellastNum" value="${fn:substringBefore(Math.ceil(getWritingCount/row),'.')}" />



					<c:forEach var="getChannelList" items="${getChannelList}">
						<div class="card" style="width: 18rem;">
							<a href="/${getChannelList.title}" class="btn btn-primary channelName">${getChannelList.title}</a>
							<table class="tmp_table table table-hover table-borderless">
								<tr>
									<th class="grayFont_th" scope="col">제목</th>
									<th class="grayFont_th" scope="col">작성자</th>
									<th class="grayFont_th" scope="col">작성일</th>
								</tr>
								<div class="card-body">
									<c:forEach var="getChannelWritingList" items="${getChannelWritingList}">
										<c:if test="${getChannelList.title==getChannelWritingList.channelName}">
											<tbody>
												<tr>
													<td>${getChannelWritingList.title}</td>
													<td>${getChannelWritingList.nickName}</td>
													<td>${getChannelWritingList.date}</td>
												</tr>
											</tbody>
										</c:if>
									</c:forEach>
								</div>
							</table>
						</div>
					</c:forEach>



				</div>
				<div class="d-flex justify-content-center">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${(channelstartNum+i)<= channellastNum}">
							<a class="-text-" style="${(channelPage==(channelstartNum+i))?'color:orange;':''}" href="?cp=${channelstartNum+i}&cq=${param.cq}&cr=${param.cr}"> ${channelstartNum+i}</a>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


	<div class="ListHeight">

		<table class="tmp_table table table-hover table-borderless">
			<thead>
				<tr>
					<th scope="col">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="all" id="flexCheckDefault" name="del_member">
						</div>
					</th>
					<th class="grayFont_th" scope="col">번호</th>
					<th class="grayFont_th" scope="col">제목</th>
					<th class="grayFont_th" scope="col">작성자</th>
					<th class="grayFont_th" scope="col">작성일</th>
					<th class="grayFont_th" scope="col">조회수</th>
				</tr>
			</thead>

			<tbody>
				<form>
					<c:forEach var="getWritingList" items="${getWritingList}">

						<tr>
							<td>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="${getWritingList.no}" id="flexCheckDefault" name="del_member"> <input class="form-check-input" type="checkbox"
										value="${getWritingList.no}" id="no" name="no">
								</div>
							</td>
							<td class="grayFont_td" scope="row">${getWritingList.no}</td>

							<td><a class="titleFont_td NoUnderline" href="/board/detail/${getWritingList.no}">${getWritingList.title} </a></td>
							<td class="titleFont_td">${getWritingList.nickName}</td>
							<td class="grayFont_td">${getWritingList.date}</td>
							<td class="grayFont_td">${getWritingList.viewCount}</td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>


	</div>
	<div>
		<button id="btn-delete" class="btn btn-primary col-1">글 삭제</button>

		<c:set var="row" value="${(empty param.r)?15:param.r}" />
		<c:set var="page" value="${(empty param.p)?1:param.p}" />
		<c:set var="startNum" value="${page-(page-1)%5}" />
		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(getWritingCount/row),'.')}" />

		<div class="row justify-content-end">
			<div class="col-sm text-center"></div>
			<div class="col-sm text-center">

				<c:if test="${startNum>1}">
					<a href="?p=${startNum-1}&f=${param.f}&q=${param.q}&r=${row}" class="btn">이전</a>
				</c:if>
				<c:if test="${startNum<=1}">
					<span class="btn" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>

				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(startNum+i)<= lastNum}">
						<a class="-text-" style="${(page==(startNum+i))?'color:orange;':''}" href="?p=${startNum+i}&f=${param.f}&q=${param.q}&r=${row}&order=${param.order}&=desc=${param.desc}"> ${startNum+i}</a>
					</c:if>
				</c:forEach>

				<c:if test="${startNum+5<=lastNum}">
					<a href="?p=${startNum+5}&f=${param.f}&q=${param.q}&r=${row}" class="btn btn-next">다음</a>
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

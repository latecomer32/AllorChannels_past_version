<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    

<style>
.joinform {
	margin-top: 50px;
}

.form-floating>.form-control, .form-floating>.form-select {
	height: 80px;
	line-height: 1.25;
}

.form-control {
	border: 1px solid rgb(255, 242, 242);
	border-radius: 0.35rem;
}

:root { -
	-bs-body-line-height: 0.5;
}
</style>

<div class="Display middeDisplay">

	<div class="container">
		<form method="post" >
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Enter title" id="title">
			</div>

			<select id="category" name="category">
				<option value="없음" >카테고리 없음</option>
				<c:forEach var="categoryValue" items="${categoryValue}">
					<option value="${categoryValue}">${categoryValue}</option>
				</c:forEach>
			</select>

			
			
			
	
			<div class="form-group">
				<textarea id="summernote" name="editordata"></textarea>
			</div>

	
		</form>
		<button id="btn-saveTheWriting" class="btn btn-primary">글 저장</button>
	</div>
</div>

<!-- summer note -->
<script>
	$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
			height : 300, // 에디터 높이
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '최대 2048자까지 쓸 수 있습니다' //placeholder 설정

		});
	});
</script>
<script src="/js/board.js"></script>




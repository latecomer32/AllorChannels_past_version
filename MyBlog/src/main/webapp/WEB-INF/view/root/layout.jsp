<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>MyBlog</title>
<meta charset="UTF-8">

<!-- 제이쿼리 -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>


<!-- 부트 스트랩 -->
 <!-- 아래 3줄 쓰고 summernote도 부트스트랩쓰면 충돌 남-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"/>




<!-- summer note -->
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
 <!--부트스트랩과 충돌나는 부분
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 -->
    

<style>


.container-- {
	display:flex;
	font-family: 'Montserrat', sans-serif;
	overflow: hidden;
	min-height: 900px;
	background-color:rgba(228, 228, 228, 0.7);
}
.Display{
height: 100%;

}

.leftDisplay {
	flex-grow: 3;
}

.middeDisplay {
	flex-grow: 5;
	
	
}

.rightDisplay {
	flex-grow: 3;
	
}


</style>



</head>

<body>

	<!-- header 부분 -->


	<tiles:insertAttribute name="header" />

	<div class="container--">


		<!-- --------------------------- <leftDisplay> ---------------------------------------  -->


			<tiles:insertAttribute name="leftDisplay" />



		<!-- ------------------- <middleDisplay> --------------------------------------- -->

	
			<tiles:insertAttribute name="middleDisplay" />



		<!-- ------------------- <rightDisplay> --------------------------------------- -->

		
			<tiles:insertAttribute name="rightDisplay" />
		
	</div>
</body>

</html>
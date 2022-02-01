<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<title>MyBlog</title>
<meta charset="UTF-8">
<!-- 부트 스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- 제이쿼리 -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>

<!-- summer note -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

    
<script>
	
</script>
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
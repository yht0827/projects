<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입성공</title>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>

<div class="container" style="height: 1000px">

<div class="row">
<div class="col-sm-12 text-center">
	<p style="margin-top: 90px; margin-bottom: 90px"><img class="img-responsive" src="${pageContext.request.contextPath }/img/join_img.jpg"></p>
</div>
<div class="col-sm-12 text-center">
	<button class="btn btn-lg btn-warning" onclick="location.href='${pageContext.request.contextPath }/index.do'">메인으로</button>
	<button class="btn btn-lg btn-info" onclick="location.href='${pageContext.request.contextPath }/member/login.do'">로그인</button>
</div>
</div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
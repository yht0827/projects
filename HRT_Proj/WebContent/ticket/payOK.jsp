<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 완료</title>
<link href="${pageContext.request.contextPath }/css/myprogress.css?ver=1" rel="stylesheet"></link>
<style>
.btn_1 {
    padding: 14px 24px;
    border: 0 none;
    font-weight: 700;
    letter-spacing: 1px;
    text-transform: uppercase;
    background-color: transparent;
}
.btn-red-outline {
	border: 2px solid #f25454;
	color: #f25454;
}
.btn-red-outline:hover, .btn-red-outline:focus{
	color:white;
	background-color: #f26d6d;
	border-color: #f26d6d;
}
.btn-green-outline {
    border: 2px solid #00bf6f;
    color: #00bf6f;
}
.btn-green-outline:hover, .btn-green-outline:focus{
    color:white;
    border-color: #39bf87;
    background-color: #39bf87;
}
</style>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="container" style="height: 1000px;">
<div class="container" style="margin-bottom:50px">
<h1 id="re_title" style="color: rebeccapurple;">결제 완료</h1>
<div class="myprogress col-xs-12">
  <div class="circle done" id="c1">
    <span class="label">✓</span>
    <span class="title">조회</span>
  </div>
  <span class="bar done"></span>
  <div class="circle done" id="c2">
    <span class="label">✓</span>
    <span class="title">예약</span>
  </div>
  <span class="bar done"></span>
  <div class="circle done" id="c3">
    <span class="label">✓</span>
    <span class="title">결제</span>
  </div>
  <span class="bar done"></span>
  <div class="circle done" id="c4">
    <span class="label">✓</span>
    <span class="title">발권</span>
  </div>
</div>
</div>
<h3 style="text-align: center; margin-bottom: 50px;">발권이 완료 되었습니다!!!</h3>
<div class="col-sm-12 text-center">
	<button class="btn_1 btn-lg btn-green-outline" onclick="location.href='${pageContext.request.contextPath }/ticket/ticketcheck.do'">승차권 확인</button>
	<button class="btn_1 btn-lg btn-red-outline" onclick="location.href='${pageContext.request.contextPath }/index.do'">메인 화면</button>
</div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
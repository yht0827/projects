<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HR - HeeTae Railways</title>
<link href="./css/index.css?ver=2" rel="stylesheet">
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<!-- main -->
<div class="container-fluid" style="height: 950px;">
<div class="index_img">
<div id="carousel-generic" class="wp_down img-responsive carousel slide col-sm-3 col-sm-offset-3">
            <ol class="carousel-indicators">
              <li data-target="#carousel-generic" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-generic" data-slide-to="1" class=""></li>
              <li data-target="#carousel-generic" data-slide-to="2" class=""></li>
            </ol>
             <div class="carousel-inner">
                <div class="item active">
                  <a href="#"><img src="./img/carousel1.jpg" alt="First slide"></a> 
                </div>
                <div class="item">
                   <a href="#"><img src="./img/carousel2.jpg" alt="Second slide"></a>              
                </div>
                <div class="item">
                   <a href="#"><img src="./img/carousel3.jpg" alt="Third slide"></a>                 
                </div>
             </div>
              <a class="left carousel-control" href="#carousel-generic" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
              </a>
              <a class="right carousel-control" href="#carousel-generic" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right "></span>
              </a>
          </div>
</div>
<div class="notice">
	<div class="banner1 col-md-1 hidden-xs wp_down">
	<a href="https://www.shinhancard.com/conts/person/card_info/major/business/go/1393466_12910.jsp">
	<img src="./img/banner_01.jpg" />
	</a>
	</div>

	<div class="banner2 wp_up col-md-1 col-md-push-10 hidden-xs">
	<a href="#">
	<img src="./img/banner_03.jpg" />
	</a>
	</div>

<div class="article col-md-4 wp_left  col-md-offset-1 col-md-pull-1">
	<div class="article-new">
	<div class="col-xs-6">
	<img class="img-responsive" src="./img/txt_notice.png" alt="새소식">
	</div>
	<div class="col-xs-4 col-xs-offset-2">
	<a id="more" href="./notice/notice.do"></a>
	</div>
	<div class="col-xs-12">
		<ul class="last">
			<li class="fst">
			<a class="col-xs-9" href="#">SR 혁신 아이디어 공모전</a>
			<em class="col-xs-3">2018.10.11</em></li>
			<li>
			<a class="col-xs-9" href="#">2018년 3분기 SR회원 등급...</a> 
			<em class="col-xs-3">2018.10.08</em></li>
			<li>
			<a class="col-xs-9" href="#">명절 승차권 부당거래에 따른 피해...</a> 
			<em class="col-xs-3">2018.09.20</em></li>
			<li>
			<a class="col-xs-9" href="#">2018년 추석 역귀성 할인 시행...</a> 
			<em class="col-xs-3">2018.09.17</em></li>
			<li>
			<a class="col-xs-9" href="#">SRT승차권 예매방법 알아두세요!...</a>
			<em class="col-xs-3">2018.08.31</em></li>
		</ul>
	</div>
</div>
</div>

<div class="event wp_left col-md-4 col-md-offset-1 col-md-pull-1">
	<div class="events">
		<div class="col-xs-6">
		<img class="img-responsive" src="./img/txt_service.png" alt="정당승차권 이용문화">
		</div>
		<div class="col-xs-4 col-xs-offset-2"> 
		<a id="more" href="#" target="_blank"></a>
		</div>
		<div class="col-xs-12">
			<div class="screen">
				<a href="#" target="_blank"><img class="img-responsive" src="./img/event_03.jpg"/></a>
			</div>
		</div>
	</div>
</div>
<div class="wp_left col-md-12" id="icon">
 <div class="col-sm-offset-1 col-xs-2">
<ul class="quick">
<li class="ic_1"><a href="#">기차역 정보</a></li>
</ul>
</div>
<div class="col-xs-2">
<ul class="quick">
<c:choose>
<c:when test="${sessionScope.mid eq null }">
<li class="ic_2"><a href="./member/join.do">회원가입</a></li>
</c:when>
<c:otherwise>
<li class="ic_2"><a href="#" onclick="session_ck()">회원가입</a></li>
</c:otherwise>
</c:choose>
</ul>
</div>
<div class="col-xs-2">
<ul class="quick">
<li class="ic_3"><a href="https://ko-kr.facebook.com/SRtraveler/">FaceBook</a></li>
</ul>
</div>
<div class="col-xs-2">
<ul class="quick">
<li class="ic_4"><a href="#">고객의 소리</a></li>
</ul>
</div>
<div class="col-sm-offset-1 col-xs-4 hidden-xs">
<ul class="quick">
<li class="ic_5"><a href="#"></a></li>
</ul>
</div>
</div>
</div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script>
 	var a = '${update}';
 	if( a == 'ok'){
		alert('회원 수정이 완료 되었습니다.');
	}else if(a == 'del'){
		alert('회원 탈퇴가 완료 되었습니다.');
	}
</script>
</body>
</html>
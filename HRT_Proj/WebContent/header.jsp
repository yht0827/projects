<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css?ver=1" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.css" rel="stylesheet">
</head>
<body>
		<div class="menu">
		<div class="header">
		<div class="row" style="margin-right: 0px;">
		<div class="col-sm-6 col-sm-offset-2">
		<a href="${pageContext.request.contextPath }/index.do"><img src="${pageContext.request.contextPath }/img/logo.png" /></a>
		</div>
		<div class="col-sm-4">
		<ul class="top_menu">
		
		<c:choose>
		<c:when test="${sessionScope.mid eq null}">
		<li><a href="${pageContext.request.contextPath }/member/login.do">로그인</a></li>
		<li><a href="${pageContext.request.contextPath }/member/join.do">회원가입</a></li>
		<c:if test="${grade !=1 }">
		<li><a href="#">회사소개</a></li>
		</c:if>
		</c:when>
		<c:otherwise>
		<li style="color: white;"><strong>${sessionScope.name}</strong>님 환영합니다!</li>
		<li style="color: white;">잔액: <strong>${sessionScope.money_ch}원</strong></li>
		<li><a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></li>
		<c:if test="${grade !=1 }">
		<li><a href="#">회사소개</a></li>
		</c:if>
		</c:otherwise>
		</c:choose>
		
		</ul>
		</div>
		</div>
		</div>
		<nav class="navbar navbar-default" role="navigation">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse navbar-right navbar-collapse" style="
    margin-right: 0px; padding-right: 0px;">
        <ul class="nav navbar-nav" style="margin: 0px;">
            <c:choose>
            <c:when test="${grade != 1}">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">승차권 <b class="caret"></b></a>
            <ul class="dropdown-menu dropdown-menu-left">
              <li><a href="${pageContext.request.contextPath }/ticket/reserve.do">승차권 예약</a></li>
              <li><a href="${pageContext.request.contextPath }/ticket/ticketcheck.do">승차권 확인 및 취소</a></li>
            </ul>
          </li>
          
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">HRT 소개<b class="caret"></b></a>
            <ul class="dropdown-menu dropdown-menu-left">
              <li><a href="#">개요</a></li>
              <li><a href="#">서비스</a></li>
              <li><a href="#">운행 정보</a></li>
              <li><a href="#">열차 제원</a></li>
              <li><a href="#">오시는 길</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">이용안내<b class="caret"></b></a>
            <ul class="dropdown-menu dropdown-menu-left">
              <li><a href="${pageContext.request.contextPath }/notice/notice.do">공지 사항</a></li>
              <li><a href="#">승차권 이용 안내</a></li>
              <li><a href="#">역 정보</a></li>
              <li><a href="#">유실물 안내</a></li>
            </ul>
          </li>
          <li><a href="${pageContext.request.contextPath }/member/Mypage.do">마이 페이지</a></li>  
        </c:when>
        <c:otherwise>
       	 	<li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">관리자 페이지<b class="caret"></b></a>
      		 <ul class="dropdown-menu dropdown-menu-left">
              <li><a href="#">공지 사항</a></li>
              <li><a href="#">유실물 안내</a></li>
			  <li><a href="#">회원 관리</a></li>              
              <li><a href="#">승차권 관리</a></li>
            </ul>
            </li>
        </c:otherwise>
        </c:choose>
        </ul>
      </div>
    </nav>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:parseNumber var="now" type="number" value="${nyear}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Mypage.css?ver=2">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<title>마이 페이지</title>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="container" style=" height: 1000px">

	<ul class="nav nav-tabs nav-justified" id="nav_menu">
         <li class="active"><a data-toggle="tab" href="#change"><h3>정보 수정</h3></a></li>
         <li><a data-toggle="tab" href="#exit"><h3>회원 탈퇴</h3></a></li>
     </ul>
	
<div class="tab-content">
    <div id="change" class="tab-pane fade in active">
    <div class="container">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/member/UpdateMember.do">
			<div class="col-md-12">
        <div class="page-header" style="margin-top: 100px">
    	    <h1>정보 수정</h1>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">아이디</label>
        <div class="col-sm-6">
          <input class="form-control" name="Mid"  id="inputID" type="text" placeholder="아이디" readonly="readonly" value="${sessionScope.mid}">
        </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
        <div class="col-sm-6">
          <input required class="form-control" name="Pwd" id="inputPassword" type="password" placeholder="비밀번호" oninput="checkPwd()">
        </div>
        </div>
          <div class="form-group">
              <label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호 확인</label>
             <div class="col-sm-6">
              <input required class="form-control" id="inputPasswordCheck" type="password" placeholder="비밀번호 확인" oninput="checkPwd()">
             </div>
          </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">이름</label>
          <div class="col-sm-6">
            <input required class="form-control" name="Name" id="inputName" type="text" placeholder="이름"   value="${sessionScope.name}">
          </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">성별</label>
          <div class="col-sm-6">
          <div class="gender_input">
			<div class="btn-group" data-toggle="buttons" id="gender_bt">
				<label class="btn btn-success active">
				<input type="radio" name="Gender" autocomplete="off" value="남성" checked>남성
				</label>
				<label class="btn btn-success">
				<input type="radio" name="Gender" autocomplete="off" value="여성">여성
				</label>
				</div>
				</div>
          </div>
        </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">생년월일</label>
          	<div class="col-sm-6">
    <div class="birth_input">
	<select name="Year" id="year">
	<c:forEach begin="0" end="${now-1900}" var="i">
       <option value="${now-i}">${now-i}</option>
	</c:forEach>
     </select>년&nbsp;
     <select name="Month" id="month">
     <c:forEach begin="1" end="9" var="i">
       <option value="0${i}">0${i}</option>
	</c:forEach>
     <c:forEach begin="10" end="12" var="i">
       <option value="${i}">${i}</option>
	</c:forEach>
     </select>월&nbsp;
     <select name="Day" id="day">
     <c:forEach begin="1" end="9" var="i">
       <option value="0${i}">0${i}</option>
       </c:forEach>
     <c:forEach begin="10" end="31" var="i">
       <option value="${i}">${i}</option>
       </c:forEach>
     </select>일
     </div>
        	</div>
        	</div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
              <div class="col-sm-6">
                  <input required type="text" name="phone" pattern="010-\d{4}-\d{4}" class="form-control" id="inputNumber" placeholder="대시(-)를 포함 해 주세요">
              </div>
        </div>
          </div>
        <div class="form-group">
          <div class="col-sm-12 text-center">
            <button id="join_bt" class="btn btn-info" type="submit" disabled>정보 수정<i class="fa fa-check spaceLeft"></i></button>
          </div>
        </div>
        </form>
          <hr>
        </div>
    </div>
    
    <div id="exit" class="tab-pane fade">
    <div class="container">
        <form class="form-horizontal" id="del_form" method="post" action="${pageContext.request.contextPath }/member/DelMember.do">
			<div class="col-md-12">
        <div class="page-header" style="margin-top: 100px">
    	    <h1>회원 탈퇴</h1>
        </div>
        <div class="well well-md" style="background-color: snow;">
        <ul>
        <li><h4 style="color: blueviolet;">입력하신 회원정보 확인 후 회원탈퇴가 가능합니다.</h4></li>
		<li><h4 style="color: blueviolet;">제공된 본인확인 방법으로 본인확인이 불가능하신 경우 고객센터로 문의하시기 바랍니다.</h4></li>
		</ul>
		</div>
		<div class="col-md-12" style="margin-top: 50px">
			   	
		        <div class="form-group">
          <label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
        <div class="col-sm-6" style="height: 70px;">
          <input required class="form-control" name="Pwd" id="inputPW" type="password" placeholder="비밀번호">
        </div>
        </div>
		        <div class="form-group" style="margin-top: 50px">
          <div class="col-sm-12 text-center">
            <button id="del_button" class="btn btn-info" type="button" onclick="del_bt()">회원 탈퇴<i class="fa fa-check spaceLeft"></i></button>
          </div>
        </div>
        </div>
        </div>
	</form>
    </div>
    </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath }/js/Mypage.js?ver=13"></script>
</body>
</html>
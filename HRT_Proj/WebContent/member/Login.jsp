<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/Login.css" rel="stylesheet">
<title>로그인</title>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<!-- main -->
<div class="container" style="height: 1000px">
 <div class="row" id="pwd-container">
 	<div style="height: 50px">
 	</div>
 	<div class="Login" style="padding-left: 0px; padding-bottom: 0px;">
    <div class="col-md-4 col-md-offset-4">
    <img src="${pageContext.request.contextPath }/img/Login.png" />
    </div>
    <div class="col-md-4">
    </div>
	</div>
    <div class="col-md-4">
    </div>
    <div class="col-md-4" style="margin-top: 30px">
      <section class="login-form">
        <form method="post" action="${pageContext.request.contextPath }/member/LoginProc.do" role="login">
          <input type="text" name="mid" placeholder="아이디" required class="form-control input-lg" style="margin-bottom: 10px" value="${cookie.mid.value}" />
          <input type="password" name="pwd" class="form-control input-lg" id="password" placeholder="비밀번호" required="" />
          <div class="checkbox" style="padding-left: 0px; padding-right: 10px; padding-top: 10px; padding-bottom: 10px;">
         	<c:choose>
                	<c:when test="${cookie.mid.value ne null}">
                		 <label><input type="checkbox" name="rememberID" checked="checked" /><p>아이디 저장</p></label> 
                	</c:when>
                	<c:otherwise>
                		 <label><input type="checkbox" name="rememberID" /><p>아이디 저장</p></label> 
                	</c:otherwise>
                	</c:choose>
         <br>
         	<h5 style="color: crimson;">${errorMsg}</h5>
          </div>
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">로그인</button>
          <div style="padding-left: 0px ">
            <a href="join.do">회원가입</a> or <a href="#">비밀번호 찾기</a>
          </div>
        </form>
      </section>  
      </div>
      <div class="col-md-4"></div>
  </div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
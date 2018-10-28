<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>승차권 예약</title>
<link href="${pageContext.request.contextPath }/css/myprogress.css?ver=1" rel="stylesheet"></link>
<style type="text/css">
 #t_sub > th {
  text-align: center;
 }
 #t_data > td{
  text-align: center;
 }
</style>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="container" style="height: 1000px;">
<div class="container" style="margin-bottom:50px">
<h1 id="re_title" style="color: rebeccapurple;">승차권 예약</h1>
<div class="myprogress col-xs-12">
  <div class="circle done" id="c1">
    <span class="label">✓</span>
    <span class="title">조회</span>
  </div>
  <span class="bar done"></span>
  <div class="circle active" id="c2">
    <span class="label">2</span>
    <span class="title">예약</span>
  </div>
  <span class="bar"></span>
  <div class="circle" id="c3">
    <span class="label">3</span>
    <span class="title">결제</span>
  </div>
  <span class="bar"></span>
  <div class="circle" id="c4">
    <span class="label">4</span>
    <span class="title">발권</span>
  </div>
</div>
</div>
<table class="table table-bordered">
  <thead>
   <tr id="t_sub"  style="background-color: #eeebfe;">
     <th>승차일자 </th>
     <th>열차종류</th>
     <th>열차번호</th>
     <th>좌석번호</th>
     <th>출발역</th>
     <th>도착역</th>
     <th>출발시간</th>
     <th>도착시간</th>
   </tr>
   </thead>
   <tbody>
   <tr id="t_data">
     <td><h4>${sessionScope.date}</h4></td>
     <td><h4>HRT</h4></td>
     <td><h4>${sessionScope.tname}</h4></td>
     <td><h4>${sessionScope.seatcode}</h4></td>
     <td><h4>${sessionScope.startname}</h4></td>
     <td><h4>${sessionScope.endname}</h4></td>
     <td><h4 id="stime"></h4></td>
     <td><h4 id="etime"></h4></td>
   </tr>
 </tbody></table>

<div class="col-sm-12 text-center">
	<button class="btn btn-lg btn-danger" onclick="cash()">결제하기</button>
	<button class="btn btn-lg btn-warning" onclick="location.href='${pageContext.request.contextPath }/ticket/reserve.do'">취소</button>
</div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script>
	var stime = sessionStorage.getItem("stime");
	var etime = sessionStorage.getItem("etime");
	$('#stime').text(stime);
	$('#etime').text(etime);
	sessionStorage.clear();
	
	function cash(){
	     var $form = $('<form></form>');
	     $form.attr('action', '${pageContext.request.contextPath }/ticket/Pay.do');
	     $form.attr('method', 'post');
	     $form.appendTo('body');
	     var stime1 = $('<input type="hidden" value="'+stime+'" name="stime">');
	     var etime1 = $('<input type="hidden" value="'+etime+'" name="etime">');
	     $form.append(stime1).append(etime1);
	     $form.submit();
	};
</script>
</body>
</html>
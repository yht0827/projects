<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>승차권 결제</title>
<link href="./css/myprogress.css?ver=1" rel="stylesheet"></link>
<style type="text/css">
 #t_sub > th {
  text-align: center;
 }
 #t_data > td{
  text-align: center;
 }
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
.btn-green-outline:disabled{
    color:white;
    border-color: #39bf87;
    background-color: #39bf87;
	opacity: .5;
}
</style>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="container" style="height: 1000px;">
<div class="container" style="margin-bottom:50px">
<h1 id="re_title" style="color: rebeccapurple;">승차권 결제</h1>
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
  <div class="circle active" id="c3">
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
     <th>결제금액</th>
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
     <td><h4>${sessionScope.stime}</h4></td>
     <td><h4>${sessionScope.etime}</h4></td>
     <td><h4>10,000원</h4></td>
   </tr>
 </tbody></table>
<div class="jumbotron jumbotron-well" style="height: 170px; background-color: papayawhip;">
<div class="col-md-6 col-md-offset-3">
<table class="table table-bordered table-responsive">
  <thead>
  <tr>
  <th class="danger" style="vertical-align: middle;"><h4 style="text-align: center">포인트</h4></th>
  <th class="info"><h4><input type="text" id="money" readonly="readonly" value="0" style="text-align: right;">원 &nbsp;  
 <button class="btn btn-warning" onclick="pointcheck();">잔액 확인</button></h4></th>
  </tr>
  </thead>
  </table>
</div>
</div>
<div class="col-sm-12 text-center">
	<button class="btn_1 btn-lg btn-green-outline" id="realpay" onclick="location.href='./PayOK.do'" disabled>결제 및 발권</button>
	<button class="btn_1 btn-lg btn-red-outline" onclick="location.href='../index.do'">취소</button>
</div>
</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script>
function pointcheck(){
	var money = ${sessionScope.money};
	$('#money').val(money.toLocaleString());
	$('#realpay').prop('disabled',false);
};
</script>
</body>
</html>
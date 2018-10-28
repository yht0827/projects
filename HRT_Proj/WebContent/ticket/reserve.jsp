<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>승차권 조회</title>
</head>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/reserve.css?ver=61" rel="stylesheet"></link>
<link href="${pageContext.request.contextPath }/css/myprogress.css?ver=1" rel="stylesheet"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-material-datetimepicker.css?ver=6">
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>

<div class="container" id="main-con" style="height: 1000px;">
<div class="container" style="margin-bottom:50px;">

<h1 id="re_title">승차권 조회</h1>
<div class="myprogress col-xs-12">
  <div class="circle active" id="c1">
    <span class="label">1</span>
    <span class="title">조회</span>
  </div>
  <span class="bar"></span>
  <div class="circle" id="c2">
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
<div class="container" style="margin-bottom:50px">
<div class="jumbotron jumbotron-well" id="jumbo" style="height: 400px; background-color: #eeebfe;">
<div class="form-group">
		<div class="col-md-9">
        <div class="col-xs-4" id="source">
          <input class="form-control" name="start" id="start" type="text" value="수서" readonly="readonly" style="background-color: white;"> 
        </div>
		<div class="col-xs-1" id="sorc_marker">
          <a href="" data-toggle="modal" onclick="modalfix('start'); return false;"><img src="${pageContext.request.contextPath }/img/btn_map.png"></a>
        </div>
        <div class="col-xs-1 hidden-xs" id="ch_mark" onclick="ch_mark(); return false;">
          <a href=""><img src="${pageContext.request.contextPath }/img/btn_order_change.png"></a>
        </div>
        <div class="col-xs-4" id="des">
          <input class="form-control" name="dest" id="dest" type="text" value="부산" readonly="readonly" style="background-color: white;">
        </div>
        <div class="col-xs-1" id="des_marker">
          <a href="" data-toggle="modal"  onclick="modalfix('end'); return false;"><img src="${pageContext.request.contextPath }/img/btn_map.png"></a>
        </div>
		<div class="col-xs-10" id="date_sel">
		<input class="form-control" type="text" name="Date" id="date_box" value="${c_date}" style="background-color: white;" readonly="readonly">
      	</div>
      	<div class="col-xs-1 si">
      	<a href="" id="date" onclick="return false;"><img src="${pageContext.request.contextPath }/img/ic_calendar.png"></a>
      	</div>
      	<div class="col-xs-10" id="time_sel">
      	<select class="form-control" name="Time" id="time" >
      	<option value="05">05</option>
      	<option value="06">06</option>      	
      	<option value="07">07</option>
      	<option value="08">08</option>
      	</select>
      	</div>
      	<div class="col-xs-1 si">
      	<h3>시</h3>
      	</div>
		<div class="col-xs-10" style="margin-top: 20px; padding-right: 0px; padding-left: 0px;">
		<select class="form-control" name="people" id="people">
       <option value="1">1</option>      	
      	</select>
		</div>
		<div class="col-xs-1 si">
      	<h3>명</h3>
      	</div>
      	<div class="col-xs-offset-3 col-xs-8" style="margin-top:60px; padding-left: 0px;">
      	<button type="button" onclick="search_seat()" class= "btn_1 btn-red-outline btn-lg">조  회</button>
      	</div>
      	</div>
      	</div>
</div>

<div class="container" id="tb_con" style="padding-left: 0px; padding-right: 30px; margin-right: 0px;">
</div>
</div>
</div>

<div class="modal fade" id="showmap" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cancelmarker()"><span aria-hidden="true">x</span></button>
        <h4 class="modal-title" id="myModalLabel" style="text-align: center;">노선 선택</h4>
      </div>
       <div class="modal-footer" style="height: 690px;">
      <div class="col-sm-10">
      <img src="${pageContext.request.contextPath }/img/bg_map.png">
      <ul style="list-style: none;" class="map">
      <li><a href="#" class="map01" id="map01" onclick="map_select(0,'map01','수서'); return false;">
      </a></li>
      <li><a href="#" class="map02" id="map02" onclick="map_select(1,'map02','동탄'); return false;">
      </a></li>
      <li><a href="#" class="map03" id="map03" onclick="map_select(2,'map03','지제'); return false;">
      </a></li>
      <li><a href="#" class="map04" id="map04" onclick="map_select(3,'map04','오송'); return false;">
      </a></li>
      <li><a href="#" class="map05" id="map05" onclick="map_select(4,'map05','대전'); return false;">
      </a></li>
      <li><a href="#" class="map06" id="map06" onclick="map_select(5,'map06','동대구'); return false;">
      </a></li>
      <li><a href="#" class="map07" id="map07" onclick="map_select(6,'map07','부산'); return false;">
      </a></li>
      <li><a href="#" class="map08" id="map08" onclick="map_select(7,'map08','광주송정'); return false;">
      </a></li>
      <li><a href="#" class="map09" id="map09" onclick="map_select(8,'map09','목포'); return false;">
      </a></li>
      </ul> 
      </div>
      <div class="col-xs-4 col-xs-push-8">
      <button class="btn_1 btn-pink-outline btn-lg" id="select_bt" onclick="locchoice()" hidden>선  택</button>
      </div>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="selectseat" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="height: 640px;">
      <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cancelmarker()"><span aria-hidden="true">x</span></button>
      <h4 class="modal-title" id="myModalLabel" style="text-align: center;">좌석 선택</h4>
      </div>
      	 <div class="modal-footer" id="mo1" style="height: 500px; margin-left: 10px;">
     </div> </div></div></div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript" src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath }/js/bootstrap-material-datetimepicker.js?ver=77"></script>
<script src="${pageContext.request.contextPath }/js/reserve.js?ver=152"></script>
</body>
</html>
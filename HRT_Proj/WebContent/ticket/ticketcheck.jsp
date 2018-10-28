<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>승차권 확인 및 취소</title>
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
tbody > tr:nth-child(1){
	background-color:#f5f5f5;	
}
tbody > tr:nth-child(2){
	background-color: #fcf8e3;
}
tbody > tr:nth-child(3){
	background-color: #d9edf7;
}
tbody > tr:nth-child(4){
	background-color: #f2dede;
}
tbody > tr:nth-child(5){
	background-color: #dff0d8;
}

</style>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="container" style="height: 1000px;">

<h1 style="text-align: center;margin-bottom: 40px;color: rebeccapurple;">승차권 확인 및 취소</h1>

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
     <th>취소/반환</th>
   </tr>
   </thead>
   <tbody style="text-align: center;">
<c:choose>
<c:when test="${empty list}">
<tr><td colspan="9" style="text-align: center;">예약된 내용이 없습니다.</td></tr>
</c:when>
<c:otherwise>
   <c:forEach var="l" items="${list}">
   <tr>
     <td><h4>${l.getDate()}</h4></td>
     <td><h4>HRT</h4></td>
     <td><h4>${l.getTrainnum()}</h4></td>
     <td><h4>${l.getSeatnum()}</h4></td>
     <td><h4>${l.getSname()}</h4></td>
     <td><h4>${l.getEname()}</h4></td>
     <td><h4>${l.getStime()}</h4></td>
     <td><h4>${l.getEtime()}</h4></td>
     <td><h4><button class="btn_1 btn-red-outline" onclick="deleteticket('${l.getDate()}','${l.getTrainnum()}','${l.getSeatnum()}','${l.getStart()}','${l.getEnd()}')">취소</button></h4></td>
   </tr>
     </c:forEach>
     </c:otherwise>
     </c:choose>
 </tbody>
 </table>

	<div class="col-xs-5 col-xs-offset-5">
		<ul class="pagination">
		<c:if test="${sPage != 1 }">
			<li><a href="ticketcheck.do?pg=${sPage-1}">«</a></li>
		</c:if>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${sPage+i<=finalPage}">
			<c:choose>
				<c:when test="${pg == sPage+i}">
			<li class="active"><a href="#">${sPage+i}</a></li>
				</c:when>
			<c:otherwise>
		<li><a href="ticketcheck.do?pg=${sPage+i}">${sPage+i}</a></li>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		<c:if test="${sPage+5 <=finalPage}">
		<li><a href="ticketcheck.do?pg=${sPage+5}">»</a></li>
		</c:if>
		</ul>
	</div>

</div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script>
function deleteticket(date,trainnum,seatnum,start,end){
	if(confirm("정말 삭제하시겠습니까??")== true){
		$.ajax({
			url : '${pageContext.request.contextPath}/ticket/deleteticket.do',
			type : 'POST',
	        data : {
	            "date":date,
	            "trainnum":trainnum,
	            "seatnum":seatnum,
	            "start":start,
	            "end":end
	        },
	        dataType: 'json',
	        success : function(result) {
	        	if(result == '1'){
					alert('승차권 취소 완료');
				window.location.href='${pageContext.request.contextPath }/ticket/ticketcheck.do';
	        	}else{
	        		alert('승차권 취소 실패');
	        	}
	        }
		});	
	}else{
		return;
	}
};
</script>
</body>
</html>
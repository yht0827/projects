<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:parseNumber var="now" type="number" value="${nyear}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Join.css?ver=6">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<title>회원 가입</title>
</head>
<body>
<!-- header -->
<jsp:include page="/header.jsp"></jsp:include>

		<div class="container" style="height: 1000px">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/member/joinProc.do">
			<div class="col-md-12">
        <div class="page-header">
    	    <h1>회원가입 </h1>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">아이디</label>
        <div class="col-sm-6">
          <input required class="form-control" name="Mid"  id="inputID" type="text" placeholder="아이디" oninput="checkId()">
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
            <input required class="form-control" name="Name" id="inputName" type="text" placeholder="이름">
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
          <div class="form-group">
              <label class="col-sm-3 control-label" for="inputAgree">약관 동의</label>
            <div class="col-sm-6" data-toggle="buttons">
              <label class="btn btn-warning" id="check_agree" style="background-color: #ec971f; border-color: #d58512; opacity: 100;"  disabled>
                <input id="agree" type="checkbox">
                  <span class="fa fa-check"></span>
              </label>
              <a href="#ag_term" data-toggle="modal">이용약관</a> 에 동의 합니다.
            </div>
          </div>
          </div>
        <div class="form-group">
          <div class="col-sm-12 text-center">
            <button id="join_bt" class="btn btn-primary" type="submit" onclick="submit_bt()" disabled>회원가입<i class="fa fa-check spaceLeft"></i></button>
            <button class="btn btn-danger" type="button" onclick="location.href='${pageContext.request.contextPath }/index.do'">가입취소<i class="fa fa-times spaceLeft"></i></button>
          </div>
        </div>
        </form>
          <hr>
        </div>
  <div class="modal fade" id="ag_term" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel" style="text-align: center">HRT 이용안내 </h4>
      </div>
      <div class="modal-body" style="text-align: center">
      <textarea class="scroll1" rows="20" cols="55" readonly="readonly" style="max-width: 100%; resize:none;">
제 1 조(목적)
[ 제 1 장 총칙 ]
제 1 조 ( 목적 )
본 약관은 HRT(이하 "회사"라 한다.)가 제공하는 사이트의 모든 서비스(이하 "서비스"라 한다)에 대한 이용조건 및 절차에 관한 기본적인 사항을 규정함을 목적으로 합니다.
제 2 조 ( 약관의 효력 및 변경 )
1. 본 약관은 사이트에 게시하거나 전자우편 등 기타의 방법으로 회원에게 통지함으로써 효력을 발생합니다.
2. 본 약관은 회사의 합리적이 사유가 발생하는 경우 사전 고지 없이 변경될 수 있으며, 변경된 약관은 제 1 항과 같은 방법으로 공지함으로써 효력을 발생합니다.
3. 회원은 변경된 약관에 동의하지 않을 경우 서비스 이용을 중단하고 회원 탈퇴를 할 수 있으며, 변경된 약관의 효력 발생일 이후의 계속적인 서비스 이용은 약관의 변경 사항에 동의한 것으로 간주됩니다.
제 3 조 ( 약관 외 준칙 )
본 약관에 명시되지 않은 사항에 전기통신기본법, 전기통신사업법, 전자상거래법률 및 기타 관련 법령의 규정에 따르며, 개별 서비스에 대한 세부적인 사항은 해당 서비스의 이용안내 및 공지에 따릅니다.
[ 제 2 장 회원가입 ]
제 4 조 ( 회원가입의 성립 )
1. 이용자가 약관을 읽고 "동의함" 버튼을 누르고 다음 각호의 사항을 기재한 후 "가입" 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.
1) ID
2) 비밀번호
3) 성명
4) 주소
5) 전화번호
6) 전자우편
7) 직업
2. 이용계약은 이용회원의 이용신청에 대하여 회사가 회원처리를 함으로써 성립합니다.
단, 이하 각호에 해당하는 이용신청에 대하여는 회원처리를 하지 않을 수 있습니다.
1) 등록내용에 허위, 기재누락, 오기가 있는경우
2) 신용정보의 이용과 보호에 관한 법률에 의한 PC 통신, 인터넷 서비스에 신용불량자로 등록되어 있는 경우
3) 기타 회원으로 등록하는 것이 회사의 기술상 또는 업무 수행상 지장이 있다고 판단하는 경우
3. 이용계약은 회원 ID 단위로 체결하며, 체결단위는 일인의 회원당 하나의 이용자 ID를 기준으로 합니다.
제 5 조 ( 회원 탈퇴 및 자격의 상실 )
1. 탈퇴는 회사가 정한 절차에 따라 회원 본인이 온라인으로 회사에 탈퇴신청을 하여야 합니다.
2. 회사는 회원이 다음 각호에 해당하는 경우, 사전통지 없이 회원자격을 박탈하거나 일정기간 서비스 이용을 중지할 수 있습니다.
1) 등록신청시 허위 사실을 기재한 경우
2) 회사의 정상적인 서비스를 방해하는 경우
3) 타인의 ID 및 비밀번호를 도용한 경우
4) 가입한 이름이 실명이 아닌 경우
5) 동일 사용자가 다른 ID로 이중등록을 한 경우
6) 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실해하는 경우
7) 타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우
8) 서비스의 안정적 운영을 방해할 목적으로 다량의 정보나 광고성 정보를 유포하는 경우
9) 정보통신설비의 오작동이나 정보 등의 파괴를 유발하는 컴퓨터 바이러스 프로그램 등을 유포하는 경우
10) 회사, 다른 회원 또는 제 3 자의 지적재산권을 침해하는 경우
11) 회사의 서비스 정보를 이용하여 얻은 정보를 회사의 사전 승낙없이 복제 또는 유통시키거나 상업적으로 이용하는 경우
12) 본 약관을 포함하여 기타 회사가 정한 이용조건을 위반한 경우 및 회원으로서 자격을 지속 시키는 것이 부적절 한 경우
[ 제 3 장 개인정보의 보호 ]
제 6 조 ( 개인정보 보호 정책 )
1. 회사는 회원의 프라이버시를 존중하고 보호합니다.
2. 회사가 수집하는 개인 정보의 범위는 이름, 전자우편 주소, 생일, 성별, 우편번호, 직업, 직종 및 개인적인 관심분야 등을 포함하며, 회원의 개인 정보는 본 서비스 제공을 위한 목적으로 이용합니다.
3. 회사는 서비스 제공과 관련하여 취득한 회원의 신상정보를 본인의 승낙 없이 제 3 자에게 누설 또는 배포할 수 없으며, 상업적 목적으로 사용 할 수 없습니다. 단 다음 각호의 경우에는 예외로 합니다.
-전기통신기본법 등 관계법령에 의하여 국가기관 등의 요구가 있는 경우
-범죄에 대한 수사상의 목적이 있거나 정보통신윤리위원회의 요청이 있는 경우
-배송 업무상 배송 업체에 고객의 정보를 알려주는 경우
-정보통신서비스의 제공에 따른 요금 정산을 위한 경우
-특정인을 식별할 수 없는 통계작성, 홍보자료, 학술연구 또는 시장조사등을 위해 가공하여 제공하는 경우
4. 회사가 개인 정보를 수집하는 궁극적인 목적은 바로 회사의 회원들에게 맞춤 서비스를 제공하기 위한 것이며 그 범위는 컨텐츠 서비스,커뮤니케이션 서비스, 온라인 쇼핑 서비스 및 기타 서비스를 포함합니다. 이러한 각종 맞춤 서비스 제공을 위해 회사는 기본적인 신상정보 외에 설문조사를 비정기적으로 행하기도 합니다. 개인정보는 또한 개인의 특성과 관련있는 광고의 집행, 즉 동일한 인구학적 특성을 지닌 사용자 집단을 향한 타겟팅 광고에 사용됩니다. 
이는 회사가 보다 양질의 서비스를 제공하기 위한 것으로 이 때 광고주는 결코 개개인의 신상정보를 볼 수 없습니다.
5. 회사의 개인정보 수집은 구체적으로 다음과 같은 목적에서 이루어집니다.
-온라인 쇼핑 및 유료 서비스 이용에 따른 결재 또는 배송
-사용자 편의 제공과 서비스 개선을 위한 연구와 통계자료 작성
-개개인별 특성과 취향에 따른 맞춤 서비스 제공
-타겟팅 광고 집행
-회원 다수의 요구에 부합되는 새로운 서비스 개발
6. 개인의 신상정보는 회원자격이 유지되는 한 지속적으로 보관됩니다. 즉, 개인이 회원 탈퇴 시나 회원 자격 박탈 시, 서비스 이용 계약이 해지됨과 동시에 회사가 보유한 해당 개인의 모든 신상정보 역시 삭제됩니다. 이 때, 회원정보의 삭제가 이루어지는 시점은 회원의 탈퇴 요구 등이 받아들여지는 시점입니다.
7. 제 4 항의 범위 내에서, 회사는 업무와 관련하여 회원 전체 또는 일부의 개인정보에 관한 통계 자료를 작성하여 이를 사용할 수 있고 서비스를 통하여 회원의 컴퓨터에 쿠키를 전송할 수 있습니다. 이 경우 회원은 쿠키의 수신을 거부하거나 쿠키의 수신에 대하여 경고하도록 사용하는 컴퓨터의 브라우저의 설정을 변경할 수 있습니다. 보안 시스템의 관리소홀로 인한 개인 신용 정보 누출 사고 발생시 모든 책임은 회사에 있습니다.
8. 회사사이트내의 게시판, Email 또는 링크된 타사이트를 통해 회원이 자발적으로 제공하는 개인정보에 대해서는 보호되지 않습니다. 또한, 개인정보가 회사에 전송되기 전에 발생되는 개인정보의 유출에 대해서는 회사가 책임을 지지 않으므로 온라인상에 접속해 있을 때에는 각별히 주의를 하시기 바랍니다. [ 제 4 장 계약 당사자의 의무 ]
제 7 조 ( 회사의 의무 )
1. 회사는 특별한 사정이 없는 한 회원이 신청한 서비스 제공 개시일에 서비스를 이용할 수 있도록 노력합니다.
2. 회사는 이 약관에서 정한 바에 따라 계속적이고 안정적인 서비스의 제공을 위하여 지속적으로 노력하며, 설비에 장애가 생기거나 멸실된 때에는 지체없이 이를 수리 복구하여야 합니다. 다만, 천재지변, 비상사태 또는 그 밖에 부득이한 경우에는 그 서비스를 일시 중단하거나 중지할 수 있습니다.
3. 회사는 회원으로부터 소정의 절차에 의해 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 적절한 절차에 따라 처리하여야 합니다. 처리시 일정기간이 소요될 경우 회원에게 그 사유와 처리일정을 통보하여야 합니다.
4. 회사는 회원의 프라이버시 보호와 관련하여 제 6 조에 제시된 내용을 지킵니다.
5. 회사는 이용계약의 체결, 계약사항의 변경 및 해지 등 이용고객과의 계약 관련 절차 및 내용 등에 있어 이용고객에게 편의를 제공하도록 노력합니다.
제 8 조 ( 회원의 의무 )
1. 회원은 주소 및 연락처 등 이용 계약 사항이 변경된 경우에는 이를 회사에 즉시 알려야 합니다.
2. 회원은 관계법령, 본 약관의 규정, 이용안내 및 주의사항 등 회사가 공지하는 사항을 준수하여야 하며, 기타 회사의 업무에 방해되는 행위를 하여서는 안됩니다.
3. 아이디(ID)와 비밀번호에 관한 모든 관리책임은 회원에게 있습니다. 
회원에게 부여된 아이디(ID)와 비밀번호의 관리 소홀, 부정 사용에 의하여 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.
4. 회원은 회사의 사전승낙 없이는 서비스를 이용하여 영업활동을 할 수 없으며, 그 영업활동의 결과와 회원이 약관에 위반한 영업활동을 이용하여 발생한 결과에 대하여 회사는 책임을 지지 않습니다. 회원은 이와 같은 영업활 동에 대하여 회사에 대하여 손해배상의무를 집니다.
5. 회원은 서비스의 이용권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.
6. 회원은 서비스 이용과 관련하여 다음 각 호의 행위를 하지 않아야 합니다.
-다른 회원의 ID, 비밀번호 등을 도용하는 행위
-서비스에서 얻은 정보를 회사의 사전승낙 없이 회원의 이용이외 목적으로 복제하거나 이를 출판 및 방송 등에 사용하거나 제 3자에게 제공하는 행위
-회사의 저작권, 제 3 자의 저작권 등 기타 권리를 침해하는 행위
-공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위
-범죄와 결부된다고 객관적으로 판단되는 행위
-기타 관계법령에 위배되는 행위
[ 제 5 장 서비스의 이용 ]
제 9 조 ( 서비스 이용시간 )
1. 서비스의 이용은 연중무휴, 1일 24시간을 원칙으로 합니다. 단, 회사가 업무 또는 기술상의 사유로 서비스를 일시 중지하거나, 운영상 목적으로 일시 중지 할 수 있습니다. 운영상의 목적인 경우 회사는 사전에 이를 서비스의 공지사항을 통해 이용자에게 공지합니다.
제 10 조 ( 서비스 이용책임 )
1. 회원이 서비스를 이용하여 게시 또는 전송한 자료의 내용에 관하여 발생되는 책임은 회원에게 있습니다.
2. 회원은 내용별로 회사가 서비스 공지사항에 게시하거나 별도로 공지한 이용 제한 사항을 준수하여야 합니다.
제 11 조 ( 서비스의 제한 및 중지 )
1. 회사는 다음 각 호에 해당하는 경우 서비스 제공을 중지할 수 있습니다.
1) 서비스용 설비의 보수 등 공사로 인한 부득이한 경우
2) 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지했을 경우.
2. 회사는 국가비상상태, 정전, 서비스 설비의 장애 또는 서비스 이용의 폭주등으로 정상적인 서비스 이용에 지장이 있는 때에는 서비스의 전부 또는 일부를 제한하거나 중지할 수 있습니다.
3. 회사는 전항 규정에 의하여 서비스의 이용을 제한하거나 정지한 때에는 그 사유 및 제한기간 등을 지체없이 이용회원에게 공지하여야 합니다.
(1) 회사는 상기 항들의 사유로 서비스 제공이 일시적으로 중단됨으로 인하여 회원 또는 제 3 자가 입은 손해에 대하여는 배상하지 아니합니다.
[ 제 6 장 계약 해지 및 이용 제한 ]
제 12 조 ( 계약의 해지 )
1. 회원이 이용 계약을 해지하고자 하는 경우에는 회원 본인이 회사가 정한 절차에 따라 해지 하고자 하는 날의 1일전까지(단, 해지일이 법정 공휴일인 경우 공휴일 개시 2일전까지) 온라인을 통해 회사에 신청하여야 합니다.
2. 회사는 제 1 항의 규정에 의하여 해지신청이 접수되면 익일부터 서비스의 이용을 제한합니다.
3. 회사는 회원이 다음 각 호에 해당하는 행위를 하였을 경우 사전통지없이 이용계약을 해지하거나 또는 기간을 정하여 서비스 이용을 중지할 수 있습니다.
-타인의 서비스 ID 및 비밀번호를 도용한 경우
-서비스 운영을 고의로 방해한 경우
-가입한 이름이 실명이 아닌 경우
-같은 사용자가 다른 ID로 이중등록을 한 경우
-공공질서 및 미풍양속에 저해되는 내용을 고의로 유포시킨 경우
-회원이 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행하는 경우
-타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우
-서비스의 안정적 운영을 방해할 목적으로 다량의 정보를 전송하거나 광고성 정보를 전송하는 경우
-정보통신설비의 오작동이나 정보의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우
-회사, 다른 회원 또는 제 3자의 지적재산권을 침해하는 경우
-정보통신윤리위원회 등 외부기관의 시정요구가 있거나 불법선거운동과 관련하여 선거관리위원회의 유권해석을 받은 경우
-타인의 개인정보, 이용자ID 및 비밀번호를 부정하게 사용하는 경우
-회사의 서비스 정보를 이용하여 얻은 정보를 회사의 사전 승낙없이 복제 또는 유통시키거나 상업적으로 이용하는 경우
-본 약관을 포함하여 기타 회사가 정한 이용 조건에 위반한 경우
제 13 조 ( 면책조항 )
회사는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.
회사는 이용자의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지않습니다.
회사는 이용자가 서비스를 이용하여 기대하는 손익이나 서비스를 통하여 얻은자료로 인한 손해에 관하여 책임을 지지 않습니다. 회사는 이용자가 서비스에게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지않습니다.
[ 제 8 장 지적재산권 ]
제 14 조 ( 지적재산권 )
1. 회사가 게재하는 모든 기사, 사진, 그림, 동영상, 영화파일 등의 컨텐츠에 대한 지적재산권은 회사에 귀속합니다.
2. 회사의 승낙 없이 회사의 컨텐츠를 사용할 수 없습니다
[ 제 9 장 손해배상 등 ]
제 19 조 ( 면책조항 )
1. 회사는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.
2. 회사는 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.
3. 회사는 회원이 서비스를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며 그밖에 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않습니다.
4. 회사는 회원이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지 않습니다.
5. 회사는 이용회원간 또는 이용회원과 제 3 자 상호간에 서비스를 매개로 하여 물품거래 등을 한 경우에는 책임이 면제됩니다.
제 20 조 ( 손해배상 )
회사는 사용자가 "제 8 조 ( 회원의 의무 )"항에 반하는 행위를 하여 회사에 손해가 발생할 경우 이에 대해 사용자에게 손해액 전부를 손해배상 청구 할 수 있습니다.
제 21 조 ( 관할법원 )
요금 등 서비스 이용으로 발생한 분쟁에 대해 소송이 제기될 경우 회사의 본사 소재지를 관할하는 법원을 전속 관할법원으로 합니다.
[ 부칙 ]
1. 이 약관은 2018년 10월 14일부터 시행합니다.
      </textarea>
      </div>
      <div class="modal-footer">
        <button type="button" id="agree_bt" class="btn btn-danger" data-dismiss="modal" disabled onclick="ag_ok()">동의</button>
      </div>
    </div> <!-- 모달 콘텐츠 -->
  </div> <!-- 모달 다이얼로그 -->
  </div>
<!-- footer -->
<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/Join.js?ver=38"></script>
</body>
</html>
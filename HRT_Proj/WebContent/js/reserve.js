var start=false;
var end=false;
var select= new Array();
var start_name="수서";
var end_name="부산";
var start_first=0;
var end_first=0;
$(document).ready(function(){

	var loading = $('<div id="loading" class="loading"></div><img id="loading_img" alt="loading" src="../img/ajax-loader.gif" />').appendTo(document.body).hide();
	
	$(window).ajaxStart(function(){
		loading.show();
	}).ajaxStop(function(){
		loading.hide();
	});
});
function ch_mark(){
	var st = $('#start').val();
	var end = $('#dest').val();
	$('#start').val(end);
	$('#dest').val(st);
	start_name=end;
	end_name=st;
};
function modalfix(first){
	if(first == "start"){
		start_first=1;
	}else if(first =="end"){
		end_first=1;
	}
	$('#showmap').modal({backdrop: 'static'});
};

function calfix(){
	$('#cal').modal({backdrop: 'static'});
}

function map_select(loc_code,name,loc){
	var arv = $('<mk class="arv"></mk>');
	var dpt = $('<mk class="dpt"></mk>');	
		
	if(start_first==1){
		if(start == false){//출발
		$('.'+name).prepend(arv);
		start = true;
		select[loc_code]= 1;
		start_name=loc;
		$('#select_bt').prop('hidden',false); 
	}else if(start == true && end == false){//도착
		if(select[loc_code] == 1){//출발 선택 후 다시 같은 곳 눌렀을 때
			$('.arv').remove();
			start=false;
			select[loc_code]=null;
			start_name="";
			$('#select_bt').prop('hidden',true); 	
		}
		else{
		$('.'+name).prepend(dpt);
		end = true;
		select[loc_code]=1;
		end_name=loc;
		}
	}else if(start == true && end == true){//출발 도착 다 선택 후 출발 클릭 시
		if(select[loc_code] == 1 && end_name == loc){//도착지 클릭시
			$('.arv').remove();
			$('.dpt').remove();
			$('.'+name).prepend(arv);
			end= false;
			start_name=loc;
			end_name="";
			select.length=0;//배열초기화
			select[loc_code] = 1;
		}else if(select[loc_code] == 1 && start_name == loc){//출발지 클릭시
			$('.dpt').remove();
			$('.arv').remove();
			start=false;
			end=false;
			start_name="";
			end_name="";
			select.length=0;
			$('#select_bt').prop('hidden',true); 
		}else if(select[loc_code] == null){
			$('.dpt').remove();
			$('.arv').remove();
			$('.'+name).prepend(arv);
			start=true;
			end=false;
			start_name=loc;
			end_name="";
			select.length=0;
			select[loc_code] = 1;
		}
	}
	}else if(end_first==1){
		if(end == false){//도착
			$('.'+name).prepend(dpt);
			end = true;
			select[loc_code]= 1;
			end_name=loc;
			$('#select_bt').prop('hidden',false); 
		}else if(end == true && start == false){//출발
			if(select[loc_code] == 1){//도착 선택 후 다시 같은 곳 눌렀을 때
				$('.dpt').remove();
				end=false;
				end_name="";
				select[loc_code]=null;
				$('#select_bt').prop('hidden',true); 
			}
			else{
			$('.'+name).prepend(arv);
			start = true;
			select[loc_code]=1;
			start_name=loc;
			}
		}else if(end == true && start == true){//출발 도착 다 선택 후 출발 클릭 시
			if(select[loc_code] == 1 && start_name == loc){//출발지 클릭시
				$('.dpt').remove();
				$('.arv').remove();
				$('.'+name).prepend(dpt);
				start= false;
				end_name=loc;
				start_name="";
				select.length=0;//배열초기화
				select[loc_code] = 1;
			}else if(select[loc_code] == 1 && end_name == loc){//도착지 클릭시
				$('.arv').remove();
				$('.dpt').remove();
				end=false;
				start=false;
				end_name="";
				start_name="";
				select.length=0;
				$('#select_bt').prop('hidden',true); 
			}else if(select[loc_code] == null){
				$('.arv').remove();
				$('.dpt').remove();
				$('.'+name).prepend(dpt);
				end=true;
				start=false;
				start_name="";
				end_name=loc;
				select.length=0;
				select[loc_code] = 1;
			}
	}
	}
};

function cancelmarker(){
	$('.arv').remove();
	$('.dpt').remove();
	start=false;
	$('#select_bt').prop('hidden',true); 
	end=false;
	select.length=0;
	start_name="";
	end_name="";
	start_first=0;
	end_first=0;
	
	$('#'+cu_seat).css('background-image','url(${pageContext.request.contextPath }/img/ic_seat.png)');
	$('#'+cu_seat).css('color','#337ab7');
	$('#seat_po').html("");

	for(var i=0;i<4;i++){
		for(var j=0;j<5;j++){
			checker_seat[i][j]=0;
			}
		}
	flag=0;
};

function locchoice(){
	
	if(start_name==""){
		$('#dest').val(end_name);
		cancelmarker();
		$('#showmap').modal('hide');
	}else if(end_name==""){
		$('#start').val(start_name);
		cancelmarker();
		$('#showmap').modal('hide');
	}else{
		$('#start').val(start_name);
		$('#dest').val(end_name);
		cancelmarker();
		$('#showmap').modal('hide');
	}
};


$('#date').bootstrapMaterialDatePicker
({
	time: false,
	format: 'YYYY/MM/DD',
	lang: 'ko',
	minDate: moment(),
	maxDate: moment().add(31,'days'),
	okText: "확인",
	cancelText: "취소"
});

function search_seat(){
	
	$('#tb_con').empty();
	var start = $('#start').val();	
	var end = $('#dest').val();
	var date = $('#date_box').val();
	var time = $('#time').val();
	
	if(start == end){
		alert('출발과 도착이 동일한 역입니다.');
	}
	else{
		$.ajax({
			url : './search.do',
			type : 'POST',
	        data : {
	        	'start':start,
	        	'end':end,
	            'date':date,
	            'time':time
	        },
	        dataType: 'json',
	        success : function(result) {

	        var html="";
	        html += "<div class=\"table-responsive\">";
	        html += "<table class=\"table table-hover table-bordered table-striped\">";
	        html += "<thead>";
	        html += "<tr class=\"title_tab\">";
	        html += "<th>구분</th>";
	        html +=	"<th>열차 종류</th>";
	        html += "<th>열차 번호</th>";
	        html += "<th>출발 역</th>";
	        html += "<th>도착 역</th>";
	        html += "<th>좌 석</th>";
	        html += "<th>출발시간</th>";
	        html += "<th>도착시간</th>";
	        html += "<th>소요시간</th>";
	        html += "</tr>";
	        html += "</thead>";
	        html += "<tbody id=\"seat_tbody\">";
	        for(var i=0;i<result.length;i++){
	        html +="<tr><td>직통</td>"; 
	      	html +="<td>HRT</td>";
	        html +="<td>"+result[i].trainnum+"</td>";
	        html +="<td>"+start+"</td>";
	        html +="<td>"+end+"</td>";
	        if(result[i].count == 20){
	        	html +="<td><button class=\"btn btn-danger btn-sm\" data-toggle=\"modal\"return false;\">매 &nbsp; &nbsp; &nbsp;&nbsp;진</button></td>";
	        }
	        else{
	        	html +="<td><button class=\"btn btn-primary btn-sm\" data-toggle=\"modal\" onclick=\"seat_choice('"+result[i].trainnum+"','"+result[i].date+"','"+start+"','"+end+"','"+result[i].start_time+"','"+result[i].end_time+"');return false;\">좌석 선택</button></td>";
	        }
	        html += "<td>"+result[i].start_time+"</td>";
	        html += "<td>"+result[i].end_time+"</td>";
	        html += "<td>"+result[i].leadtime+"</td></tr>";	
	        }
	        html +=" </tbody></table></div>";
/*	        html +=" <div class=\"col-sm-8 col-sm-offset-4\">";
	        html +=" <ul class=\"pagination\">";
	        html +="<li class=\"disabled\"><a href=\"#\">«</a></li>";
	        html +="<li class=\"active\"><a href=\"#\">1</a></li>";
	        html +="<li><a href=\"#\">2</a></li>";
	        html +="<li><a href=\"#\">3</a></li>";
	        html +="<li><a href=\"#\">4</a></li>";
	        html +="<li><a href=\"#\">5</a></li>";
	        html +="<li><a href=\"#\">»</a></li></ul></div>";*/  
	        $('#tb_con').append(html);
	        }	
	});
}
};

function seat_choice(tn,date,start,end,starttime,endtime){

	sessionStorage.removeItem("stime");
	sessionStorage.removeItem("etime");
	$('#mo1').empty();
	$('#seat_ar_dst').empty();
	$('#arr_h').empty();
	$('#dst_h').empty();
	var html="";
	sessionStorage.setItem("stime",starttime);
	sessionStorage.setItem("etime",endtime);
	$.ajax({
		url : './Seatcheck.do',
		type : 'POST',
        data : {
            "tname":tn
        },
        dataType: 'json',
        success : function(result) {
        	
        	$('#selectseat').modal({backdrop: 'static'});
        	
        	html += "<div><ul style=\"text-align: left;\">";
        	html += "<li>요청하신 승객의 원하시는 좌석을 선택하여 주십시오.</li>";
 			html += "<li>발매가 가능한 좌석을 선택하실 수 있습니다.</li>";
 			html +="<li>원하시는 좌석을 선택후 [선택]버튼을 클릭하시면 예약이 완료됩니다.</li>";
 			html +="<li>원하지 않는 좌석이 선택된 경우에는 좌석을 한번 더 클릭하시면 취소됩니다.</li>";
 			html +="</ul></div>";
 			html +="<div class=\"col-xs-12\" style=\"margin-top: 20px; margin-bottom: 20px;\">";
 			html +="<div class=\"col-xs-8\">";
 			html +="<img style=\"width: 500px; position: absolute; margin-top:20px;top: -30px;left: 0px;\" src=\"../img/bg_scar.png\"></div>";
 			html +="<div class=\"col-xs-11\" id=\"seat_ar_dst\">";
 			html +="<h5 style=\"text-align: center;\">HRT "+tn+" <span style=\"color: rebeccapurple;\"> "+start+" ▶ "+end+" </span> 좌석 정보</h5>";
 			html +="</div></div><div class=\"col-xs-12\">";
 			html +="<ul style=\"list-style: none;\">";
 			if(result[0]>0){
 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>1A</span></li>";	
 			}else{
 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"1A\" onclick=\"seat_select('1A',0,0); return false;\">1A</a></li>";	
 			}
 			if(result[1]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>2A</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"2A\" onclick=\"seat_select('2A',0,1); return false;\">2A</a></li>";	
 	 			}
 			if(result[2]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>3A</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"3A\" onclick=\"seat_select('3A',0,2); return false;\">3A</a></li>";	
 	 			}
 			if(result[3]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>4A</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"4A\" onclick=\"seat_select('4A',0,3); return false;\">4A</a></li>";	
 	 			}
 			if(result[4]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>5A</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"5A\" onclick=\"seat_select('5A',0,4); return false;\">5A</a></li>";	
 	 			}
 				html+="</ul><ul style=\"list-style: none;\">";
 			if(result[5]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>1B</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"1B\" onclick=\"seat_select('1B',1,0); return false;\">1B</a></li>";	
 	 			}
 			if(result[6]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>2B</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"2B\" onclick=\"seat_select('2B',1,1); return false;\">2B</a></li>";	
 	 			}
 			if(result[7]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>3B</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"3B\" onclick=\"seat_select('3B',1,2); return false;\">3B</a></li>";	
 	 			}
 			if(result[8]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>4B</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"4B\" onclick=\"seat_select('4B',1,3); return false;\">4B</a></li>";	
 	 			}
 			if(result[9]>0){
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>5B</span></li>";	
 	 			}else{
 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"5B\" onclick=\"seat_select('5B',1,4); return false;\">5B</a></li>";	
 	 			}
 				html +="</ul><div class=\"col-xs-2\" style=\"text-align: left; padding-right: 0px; margin-left: -20px; color: rebeccapurple;\" id=\"arr_h\">";
 				html +="<h4 style=\"margin-top: 0px;\" >"+start+"</h4></div><div class=\"col-xs-8\">";
 				html +="<img src=\"../img/bg_dir.png\" style=\"width: 352px;\"></div>";
 				html +="<div class=\"col-xs-2\" style=\"text-align: right; margin-left: 20px; color: rebeccapurple;\" id=\"dst_h\">";
 				html +="<h4 style=\"margin-top: 0px;\">"+end+"</h4></div>";
 				html +="<ul style=\"list-style: none;\">";
 			if(result[10]>0){
 	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>1C</span></li>";	
 	 	 			}else{
 	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"1C\" onclick=\"seat_select('1C',2,0); return false;\">1C</a></li>";	
 	 	 			}
 			if(result[11]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>2C</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"2C\" onclick=\"seat_select('2C',2,1); return false;\">2C</a></li>";	
	 	 			}
 			if(result[12]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>3C</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"3C\" onclick=\"seat_select('3C',2,2); return false;\">3C</a></li>";	
	 	 			}
 			if(result[13]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>4C</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"4C\" onclick=\"seat_select('4C',2,3); return false;\">4C</a></li>";	
	 	 			}
 			if(result[14]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>5C</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"5C\" onclick=\"seat_select('5C',2,4); return false;\">5C</a></li>";	
	 	 			}
 					html+="</ul><ul style=\"list-style: none;\">";
 			if(result[15]>0){
 		 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>1D</span></li>";	
 		 	 			}else{
 		 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"1D\" onclick=\"seat_select('1D',3,0); return false;\">1D</a></li>";	
 		 	 			}
 			if(result[16]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>2D</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"2D\" onclick=\"seat_select('2D',3,1); return false;\">2D</a></li>";	
	 	 			}	
 			if(result[17]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>3D</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"3D\" onclick=\"seat_select('3D',3,2); return false;\">3D</a></li>";	
	 	 			}	
 			if(result[18]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>4D</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"4D\" onclick=\"seat_select('4D',3,3); return false;\">4D</a></li>";	
	 	 			}	
 			if(result[19]>0){
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><span>5D</span></li>";	
	 	 			}else{
	 	 			html +="<li class=\"seat_set\" style=\"width: 8.33333%;\"><a href=\"#none\" id=\"5D\" onclick=\"seat_select('5D',3,4); return false;\">5D</a></li>";	
	 	 			}
 			html+="</ul></div><div class=\"col-xs-12\"><div class=\"col-xs-4\">";
 			html+="<h5 style=\"text-align: left;\">선택좌석 : &nbsp;<span id=\"seat_po\" style=\"color: rebeccapurple;\"></span></h5>";
 			html+="</div><div class=\"col-xs-4 col-xs-push-4\"><button class=\"btn_1 btn-pink-outline btn-lg\" id=\"select_bt1\" onclick=\"selchoice("+tn+")\" hidden>선  택</button></div>";
 			html+="</div>";
 			$('#mo1').append(html);
        }
	});//ajax

	
};

var checker_seat = [[0,0,0,0,0],
                    [0,0,0,0,0],
                    [0,0,0,0,0],
                    [0,0,0,0,0]];
var cu_seat;
var seat_cnt=0;
function seat_select(seat,a,b){
	
	var flag=0;
	cu_seat=seat;
	
	for(var i=0;i<4;i++){
		for(var j=0;j<5;j++){
			if(checker_seat[i][j]==1){
				flag=1;
			}
		}
	}
	if(flag==1){
		if(checker_seat[a][b] ==1){
			checker_seat[a][b]=0;
			$('#'+seat).css('background-image','url(../img/ic_seat.png)');
			$('#'+seat).css('color','#337ab7');
			$('#seat_po').html("");
			$('#select_bt1').prop('hidden',true);
			flag=0;
		}else{
			alert('요청하신 승객수 1명을 초과하였습니다.');
		}
	}else{
	if(checker_seat[a][b]== 0){
		seat_cnt=1;
		checker_seat[a][b]=1;
		$('#'+seat).css('background-image','url(../img/ic_seat_on.png)');
		$('#'+seat).css('color','white');
		$('#seat_po').html(seat);
		$('#select_bt1').prop('hidden',false); 
	}else{
		checker_seat[a][b]=0;
		seat_cnt=0;
		$('#'+seat).css('background-image','url(../img/ic_seat.png)');
		$('#'+seat).css('color','#337ab7');
		$('#seat_po').html("");
		$('#select_bt1').prop('hidden',true);
	}
	}
};

function selchoice(tname){
	   var seat = $('#seat_po').text();
	   var $form = $('<form></form>');
	     $form.attr('action', './ReserveOk.do');
	     $form.attr('method', 'post');
	     $form.appendTo('body');
     var tn = $('<input type="hidden" value="'+tname+'" name="tname">');
     var seatcode = $('<input type="hidden" value="'+seat+'" name="seatcode">');
     $form.append(tn).append(seatcode);
     $form.submit();
};
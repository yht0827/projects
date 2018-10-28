function checkPwd(){
	
	var inputed = $('#inputPassword').val();
    var reinputed = $('#inputPasswordCheck').val();	
	
    if(inputed== "" && reinputed== ""){
    	$("#inputPasswordCheck").css("background-color", "transparent");
    	$('#join_bt').prop('disabled',true); 
    }
    else if(reinputed=="" && (inputed != reinputed)){ //비번확인칸이 빈칸일 때
    	$("#inputPasswordCheck").css("background-color", "transparent");
        $('#join_bt').prop('disabled',true); 
    }
    else if (inputed == reinputed) { //같을 때
        $("#inputPasswordCheck").css("background-color", "#B0F6AC");
        $('#join_bt').prop('disabled',false); 
    } else if (inputed != reinputed) {//다를 때
        $("#inputPasswordCheck").css("background-color", "#FFCECE");
        $('#join_bt').prop('disabled',true); 
    }  
};

function del_bt(){
	
	var pwd = $('#inputPW').val();	
	
	$.ajax({
		url : './CheckPwd.do',
		type : 'POST',
        data : {
            'pwd':pwd
        },
        datatype: 'JSON',
        success : function(data) {
        	if( data == '1'){ //비밀번호 일치 시
        		$('#del_form').submit();
        	}else if(data == '0'){
        		$("#del_warn").remove();
        		$('#inputPW').after("<h5 id=\"del_warn\" style=\"color: crimson;\">비밀번호가 틀렸습니다.</h5>");
        		return false;
        	}
        }
    });
};






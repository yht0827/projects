	var idCheck = 0;
    var pwdCheck = 0;
    var ck = false;
    
    function checkId(){
		
	var mid = $('#inputID').val();	
	
	$.ajax({
		url : './CheckId.do',
		type : 'POST',
        data : {
            'mid':mid
        },
        datatype: 'JSON',
        success : function(data) {
        	if(mid==""){
        	$("#inputID").css("background-color", "transparent");
        	$('#join_bt').prop('disabled',true); 
        		idCheck = 0;
        	}
        	else if(mid=="" && data=='0') {
                $("#inputID").css("background-color", "#FFCECE");
                $('#join_bt').prop('disabled',true); 
                idCheck = 0;
            } else if (data == '0') {
                $("#inputID").css("background-color", "#B0F6AC");
                idCheck = 1;
                if(idCheck==1 && pwdCheck==1 && ck == true){
                	$('#join_bt').prop('disabled',false); 
                }
            } else if (data == '1') {
                $("#inputID").css("background-color", "#FFCECE");
                $('#join_bt').prop('disabled',true); 
                idCheck = 0;
            } 
        }
    });
};
	function checkPwd() {
    var inputed = $('#inputPassword').val();
    var reinputed = $('#inputPasswordCheck').val();
    if(inputed== "" && reinputed== ""){
    	$("#inputPasswordCheck").css("background-color", "transparent");
    	$('#join_bt').prop('disabled',true); 
    	pwdCheck = 0;
    }
    else if(reinputed=="" && (inputed != reinputed)){ //비번확인칸이 빈칸일 때
    	$("#inputPasswordCheck").css("background-color", "transparent");
        $('#join_bt').prop('disabled',true); 
        pwdCheck = 0;
    }
    else if (inputed == reinputed) { //같을 때
        $("#inputPasswordCheck").css("background-color", "#B0F6AC");
        pwdCheck = 1;
        if(idCheck==1 && pwdCheck==1 && ck == true){
        	$('#join_bt').prop('disabled',false); 
        }
    } else if (inputed != reinputed) {//다를 때
        $("#inputPasswordCheck").css("background-color", "#FFCECE");
        $('#join_bt').prop('disabled',true); 
        pwdCheck = 0;
    }
};	
			$(".scroll1").scroll(function(){
			    if((this.scrollTop+this.clientHeight) == this.scrollHeight)
			       $("#agree_bt").prop('disabled',false);
			});
			
			function ag_ok(){
				$(".scroll1").scrollTop(0);
				$("#check_agree").addClass('active');
				ck=true;
				if( ck == true && pwdCheck === 1 && idCheck === 1 ){
					$('#join_bt').prop('disabled',false); 
				}
				else{
					$('#join_bt').prop('disabled',true); 
				}
			}
			
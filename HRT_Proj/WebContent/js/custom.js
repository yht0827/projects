function session_ck(){
	alert('로그인 후에는 이용할 수 없습니다.');
};

$(".top").click(
function(){
	return $("html, body").animate(
			{scrollTop:0},900),!1
	}
);
      $('.carousel').carousel();
      $('.wp_left').waypoint(function() {
    	    $('.wp_left').addClass('animated fadeInLeft');
    	  }, {
    	    offset: '75%'
    	  });
      $('.wp_up').waypoint(function() {
          $('.wp_up').addClass('animated fadeInUp');
        }, {
          offset: '75%'
        }); 
      $('.wp_down').waypoint(function() {
          $('.wp_down').addClass('animated fadeInDown');
        }, {
          offset: '75%'
        });
        $('.wp_right').waypoint(function() {
          $('.wp_right').addClass('animated fadeInRight');
        }, {
          offset: '75%'
        });
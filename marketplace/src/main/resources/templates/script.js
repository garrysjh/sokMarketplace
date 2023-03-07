$(window).scroll(function() {
	var $centerImg = $('#center > img')
    , hT = $centerImg.offset().top
    , hH = $centerImg.outerHeight()
    , wH = $(window).height()
    , dH = $(document).height()
    , wS = $(this).scrollTop();
  
  if (wS > (hT+hH-wH)){
    $centerImg.addClass("parallaxin");
  } else {
    $centerImg.removeClass("parallaxin");
    $centerImg.css({
     'transform': 'translate(0,0)'
    });
  }
  
  $('#hero-text').css({
    'transform': 'translate(0, '+ -wS * 0.5 +'px)'
	});
  
  $('.parallaxin').css({
    'transform': 'translate(0, -'+ (wS + 1000 - dH)/4 +'%)'
	});
});
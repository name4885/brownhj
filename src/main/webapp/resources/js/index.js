$('.r1_img').slick({
    
    autoplay : true,

    dots: true,

    speed : 300 /* 이미지가 슬라이딩시 걸리는 시간 */,

    infinite: true,

    autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,

    arrows: true,

    slidesToShow: 1,

    slidesToScroll: 1,

    fade: false

});




$('.row2').each(function(){
    let $ls = $('.localSelect ul'),
        $lsPoint = $ls.find('li'),
        $lb=  $(this).find('.lhBox')
    $ls.on('click','li',function(event){
        event.preventDefault();
        
        if($(this).hasClass('active')){
            return false;
        }

        $lsPoint.removeClass('active');
        $(this).addClass('active');
        $lb.hide()
        $($(this).find('a').attr('href')).show()
    })
    $lsPoint.eq(0).trigger('click')
})




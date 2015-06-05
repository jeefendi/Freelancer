(function($){
    $('.title').mouseover(function(){
        $('.list-'+$(this).attr('list')).addClass('list-hover');
    });
    $('.title').mouseout(function(){
        $('.list-'+$(this).attr('list')).removeClass('list-hover');
    });
    $('.map-place-button').click(function(e){
        var popup = $(this).parent().find('.map-place-popup');
        $('.map-place-button').removeClass('active');
        $(this).addClass('active');
        $('.map-place-popup:visible').fadeOut();
        $(popup).stop().fadeIn();
        e.preventDefault();
        e.stopPropagation();
        return false;        
    });
    $('.popup-close').click(function(){
        $(this).parents('.map-place-popup').fadeOut(400, function(){
            $('.map-place-button').removeClass('active');        
        });
    });
    $('body').click(function(){
        if($('.map-place-popup:visible .popup-close').css('display') != 'none'){
            $('.map-place-popup:visible').fadeOut(400, function(){
                $('.map-place-button.active').removeClass('active');
            });
        }
    });
    $('.testimonial .play-button').click(function(){
        var testimonial = $(this).parents('.testimonial');
        $('.video-container .video iframe').attr('src', $('.video-container .video iframe').attr('embedurl') + $(this).attr('youtubeid') + '?autoplay=1&wmode=transparent&showinfo=0&rel=0&modestbranding=1&color=white');
        $('.video-container .logo').html($(testimonial).find('.image-holder').html());
        $('.video-container .video-title').html($(testimonial).find('.title').html());
        $('.video-container .video-content').html($(testimonial).find('.content').html());
        $.colorbox({ inline:true,
                     href: '.video-container',
                     onCleanup: function(){
                         $('.video-container .video iframe').attr('src', '');
                     }
        });
    });
    
    $('.dropdown-arrow').click(function(){
        if($(this).hasClass('animating'))
            return true;
        $(this).addClass('animating');
        var thiselement = $(this);
        var target = $(this).attr('target');
        if(target == 'parent')
            target = $(this).parents('section').find('.section-content');
        if(!$(this).hasClass('down')){
            $(target).slideUp(400, function(){
                $(thiselement).addClass('down');
                $(thiselement).removeClass('animating');
            });
        }else{
            $(target).slideDown(400, function(){
                $(thiselement).removeClass('down');
                $(thiselement).removeClass('animating');                
            });
        }
    });
    $('.dropdown-toggle').dropdownHover().dropdown();
    var contactheight = 0;
    $('.contact-email hgroup').each(function(){
        if($(this).height() > contactheight)
            contactheight = $(this).height();
    });
    $('.contact-email hgroup').css('height', contactheight + 'px');
    $('.dropdown-toggle').click(function(e){
        window.location.href = $(this).attr('href');
    });
})(jQuery);
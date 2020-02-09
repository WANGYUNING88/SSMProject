function loading_start() {

    var h = $(document).height();

    $(".overlay").css({"height": h});

    $(".overlay").css({'display': 'block', 'opacity': '0.8'});

    $(".showbox").stop(true).animate({'margin-top': '300px', 'opacity': '1'}, 200);

}

function loading_end() {
    setTimeout(function () {
        $(".showbox").stop(true).animate({'margin-top': '250px', 'opacity': '0'}, 400);

        $(".overlay").css({'display': 'none', 'opacity': '0'});
    },1000);

}

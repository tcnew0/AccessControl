/**
 * Created by guanzhenxing on 2014-06-23.
 */
$(function(){
    $(".table tr:gt(0)").each(function(){
        $(this).hover(function(){
            $(this).addClass("active");
        },function(){
            $(this).removeClass("active");
        });
    });
});
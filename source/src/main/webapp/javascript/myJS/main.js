/**
 * Created by guanzhenxing on 2014-06-11.
 */
$(function(){

    /**
     * 菜单页面跳转
     */
    $(".menu a").click(function(){
        // 移除active 样式
        $(this).parent().siblings().each(function(){
            $(this).removeClass("active");
        });

        // 当前添加active样式
        $(this).parent().addClass("active");

        // 刷新 iframe
        var url = $(this).attr('rel');
        $("#content").attr('src',url);
    });
});
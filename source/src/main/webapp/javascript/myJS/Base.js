/**
 * Created by guanzhenxing on 2014-06-23.
 */
$(function(){
    // js 控制隔行换色
//    $(".table tr:gt(0)").each(function(){
//        $(this).hover(function(){
//            $(this).addClass("active");
//        },function(){
//            $(this).removeClass("active");
//        });
//    });

    // 滚动条回到头部
    $("html body").animate({scrollTop:0},200);

});

/**
 * 判断是否为空
 * @param str
 */
function checkIsNull(str){
    var temp = $.trim(str);
    if(temp == ''){
        return true;
    }

    return false;
}
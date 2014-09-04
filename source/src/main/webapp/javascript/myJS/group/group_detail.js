/**
 * Created by guanzhenxing on 2014-08-11.
 */
/**
 * Created by guanzhenxing on 2014-06-21.
 */
$(function(){

//    // 弹出框初始化
//    $(".table tbody tr td a[data-toggle='popover']").each(function(){
//        $(this).popover({
//            placement : 'left',
//            html : true
//        });
//    });

    // table tr 离开事件
//    $(".table tbody tr").mouseleave(function(){
//        $(this).find("td a[data-toggle='popover']").each(function(){
//            $(this).popover("hide");
//        });
//    });

    /**
     * 修改
     */
    $("a[op-type='modify']").click(function(){
        var mdata = $(this).attr("mdata");
        parent.showModal(mdata,"modify");
    });

    /**
     * 查看
     */
    $("a[op-type='view']").click(function(){
        var mdata = $(this).attr("mdata");
        parent.showModal(mdata,"view");
    });
});
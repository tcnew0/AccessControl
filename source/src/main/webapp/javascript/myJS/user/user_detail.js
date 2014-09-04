/**
 * Created by guanzhenxing on 2014-08-22.
 */
$(function(){

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
/**
 * Created by guanzhenxing on 2014-09-10.
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
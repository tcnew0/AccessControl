/**
 * Created by guanzhenxing on 2014-09-10.
 */
$(function(){

    // 初始化弹出框
    $('#op_delete_btn').popover({
            placement: 'bottom',
            content: function(){
                // 获取选择checkbox
                var arr = $("#op_frame")[0].contentWindow.chk_arr();
                //var arr = op_frame.window.chk_arr();
                if(arr.length < 1 || arr == undefined){
                    return '<font color="#4169e1">请至少选择一条记录！</font>';
                }else if(arr.length >= 1){

                    $.ajax({
                        type: 'POST',
                        url: '/op/delete',
                        data: {ids:""+arr,_method:'delete'},//'ids='+arr+'&_method=delete',
                        success: function(data){
                            $("#op_search_btn").click();
                            $("#op_delete_btn").blur();
                        },
                        error: function(data){

                        }
                    });
                }
                return;
            },
            trigger: 'focus',
            html: true }
    );

    // 搜索
    $("#op_search_btn").click(function(){
        var opNum = $("#search_num").val();
        var opName = $("#search_name").val();
        $("#op_frame").attr("src","/op/searchJson?opNum="+opNum+"&opName="+opName);
    });

});

/**
 * 显示、修改角色弹出层
 * @param data
 */
function showModal (data,flag) {
    var mdata = data;

    //var con = eval("("+mdata+")");
    var con = $.parseJSON(mdata);

    // 设置表单值
    if("modify" == flag){
        $("#opModifyId").val(con.id);

        $("#opModifyNum").val(con.opNum);
        $("#opModifyNum").prop("readonly",true);
        $("#opModifyName").val(con.opName);
        $("#modifyDescription").val(con.description);

        // 显示
        $("#opModifyModal").modal("show");
    }else if("view" == flag){

        $("#opViewNum").val(con.opNum);
        $("#opViewName").val(con.opName);
        $("#viewDescription").val(con.description);

        // 显示
        $("#opViewModal").modal("show");
    }
}
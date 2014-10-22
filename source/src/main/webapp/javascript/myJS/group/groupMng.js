/**
 * Created by guanzhenxing on 2014-06-21.
 */
$(function () {

    // init z_tree end

    $('#group_delete_btn').popover({
            placement: 'bottom',
            content: function () {
                // 获取选择checkbox
                var arr = $("#group_frame")[0].contentWindow.chk_arr();
                //var arr = group_frame.window.chk_arr();
                if (arr.length < 1 || arr == undefined) {
                    return '<font color="#4169e1">请至少选择一条记录！</font>';
                } else if (arr.length >= 1) {

//                    $.post('/group/delete',{ids:""+arr,_method:'delete'},function(data){
//                        alert(11);
//                    });

                    $.ajax({
                        type: 'POST',
                        url: '/group/delete',
                        data: {ids: "" + arr, _method: 'delete'},//'ids='+arr+'&_method=delete',
                        success: function (data) {
                            $("#grp_search_btn").click();
                            $("#group_delete_btn").blur();
                            //$('#grp_search_btn').focus();
                        },
                        error: function (data) {

                        }
                    });
                }
                return;
            },
            trigger: 'focus',
            html: true }
    );

    // 隐藏
    //$('#group_delete_btn').popover('hide');

    // 搜索
    $("#grp_search_btn").click(function () {
        var groupNum = $("#search_num").val();
        var groupName = $("#search_name").val();
        $("#group_frame").attr("src", "/group/searchJson?groupNum=" + groupNum + "&groupName=" + groupName);
    });

//    $("a[op-type='modify']").click(function(){
//        var mdata = $(this).attr("mdata");
//        //var con = eval("("+mdata+")");
//        var con = $.parseJSON(mdata);
//
//        // 设置表单值
//        $("#grpModifyId").val(con.id);
//
//        $("#grpModifyNum").val(con.groupNum);
//        $("#grpModifyNum").prop("readonly",true);
//        $("#grpModifyName").val(con.groupName);
//        $("#modifyDescription").val(con.description);
//
//        // 显示
//        $("#grpModifyModal").modal("show");
//    });

});

/**
 * 显示、修改部门弹出层
 * @param data
 */
function showModal(data, flag) {
    var mdata = data;
    //var con = eval("("+mdata+")");
    var con = $.parseJSON(mdata);

    // 设置表单值
    if ("modify" == flag) {
        $("#grpModifyId").val(con.id);

        $("#grpModifyNum").val(con.groupNum);
        $("#grpModifyNum").prop("readonly", true);
        $("#grpModifyName").val(con.groupName);
        $("#modifyDescription").val(con.description);

        // 显示
        $("#grpModifyModal").modal("show");
    } else if ("view" == flag) {

        $("#grpViewNum").val(con.groupNum);
        $("#grpViewName").val(con.groupName);
        $("#viewDescription").val(con.description);

        // 显示
        $("#grpViewModal").modal("show");
    }
}
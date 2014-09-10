/**
 * Created by guanzhenxing on 2014-09-10.
 */
$(function(){

    // 初始化弹出框
    $('#role_delete_btn').popover({
            placement: 'bottom',
            content: function(){
                // 获取选择checkbox
                var arr = $("#role_frame")[0].contentWindow.chk_arr();
                //var arr = role_frame.window.chk_arr();
                if(arr.length < 1 || arr == undefined){
                    return '<font color="#4169e1">请至少选择一条记录！</font>';
                }else if(arr.length >= 1){

                    $.ajax({
                        type: 'POST',
                        url: '/role/delete',
                        data: {ids:""+arr,_method:'delete'},//'ids='+arr+'&_method=delete',
                        success: function(data){
                            $("#role_search_btn").click();
                            $("#role_delete_btn").blur();
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
    $("#role_search_btn").click(function(){
        var roleNum = $("#search_num").val();
        var roleName = $("#search_name").val();
        $("#role_frame").attr("src","/role/searchJson?roleNum="+roleNum+"&roleName="+roleName);
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
        $("#roleModifyId").val(con.id);

        $("#roleModifyNum").val(con.roleNum);
        $("#roleModifyNum").prop("readonly",true);
        $("#roleModifyName").val(con.roleName);
        $("#modifyDescription").val(con.description);

        // 显示
        $("#roleModifyModal").modal("show");
    }else if("view" == flag){

        $("#roleViewNum").val(con.roleNum);
        $("#roleViewName").val(con.roleName);
        $("#viewDescription").val(con.description);

        // 显示
        $("#roleViewModal").modal("show");
    }
}
/**
 * Created by guanzhenxing on 2014-09-10.
 */
$(function(){

    // 初始化弹出框
    $('#menu_delete_btn').popover({
            placement: 'bottom',
            content: function(){
                // 获取选择checkbox
                var arr = $("#menu_frame")[0].contentWindow.chk_arr();
                //var arr = menu_frame.window.chk_arr();
                if(arr.length < 1 || arr == undefined){
                    return '<font color="#4169e1">请至少选择一条记录！</font>';
                }else if(arr.length >= 1){

                    $.ajax({
                        type: 'POST',
                        url: '/menu/delete',
                        data: {ids:""+arr,_method:'delete'},//'ids='+arr+'&_method=delete',
                        success: function(data){
                            $("#menu_search_btn").click();
                            $("#menu_delete_btn").blur();
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
    $("#menu_search_btn").click(function(){
        var menuNum = $("#search_num").val();
        var menuName = $("#search_name").val();
        $("#menu_frame").attr("src","/menu/searchJson?menuNum="+menuNum+"&menuName="+menuName);
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
        $("#menuModifyId").val(con.id);

        $("#menuModifyNum").val(con.menuNum);
        $("#menuModifyNum").prop("readonly",true);
        $("#menuModifyName").val(con.menuName);
        $("#modifyDescription").val(con.description);

        // 显示
        $("#menuModifyModal").modal("show");
    }else if("view" == flag){

        $("#menuViewNum").val(con.menuNum);
        $("#menuViewName").val(con.menuName);
        $("#viewDescription").val(con.description);

        // 显示
        $("#menuViewModal").modal("show");
    }
}
/**
 * Created by guanzhenxing on 2014-08-22.
 */
$(function(){

    // 初始化弹出框
    $('#user_delete_btn').popover({
            placement: 'bottom',
            content: function(){
                // 获取选择checkbox
                var arr = $("#user_frame")[0].contentWindow.chk_arr();
                //var arr = group_frame.window.chk_arr();
                if(arr.length < 1 || arr == undefined){
                    return '<font color="#4169e1">请至少选择一条记录！</font>';
                }else if(arr.length >= 1){

                    $.ajax({
                        type: 'POST',
                        url: '/user/delete',
                        data: {ids:""+arr,_method:'delete'},//'ids='+arr+'&_method=delete',
                        success: function(data){
                            $("#user_delete_btn").blur();
                            $("#user_search_btn").click();
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
    $("#user_search_btn").click(function(){
        var login = $("#search_login").val();
        var name = $("#search_name").val();
        $("#user_frame").attr("src","/user/searchJson?login="+login+"&name="+name);
    });
});

/**
 * 显示、修改人员弹出层
 * @param data
 */
function showModal (data,flag) {
    var mdata = data;
    //var con = eval("("+mdata+")");
    var con = $.parseJSON(mdata);

    // 设置表单值
    if("modify" == flag){
        $("#userModifyId").val(con.id);

        $("#userModifyLoginName").val(con.loginName);
        $("#userModifyName").val(con.name);
        $("#userModifyBirthday").val(toLocalDate(con.birthday));
        $("#userModifySex").val(con.sex);
        $("#userModifyMail").val(con.mail);
        $("#userModifyAddress").val(con.address);
        $("#userModifyPhone").val(con.phone);

        // 显示
        $("#userModifyModal").modal("show");
    }else if("view" == flag){

        // 性别
        var sex = '';
        if(con.sex == 'm'){
            sex = '男';
        }else if(con.sex == 'f'){
            sex = '女';
        }

        $("#userViewLoginName").val(con.loginName);
        $("#userViewName").val(con.name);
        $("#userViewBirthday").val(toLocalDate(con.birthday));
        $("#userViewSex").val(sex);
        $("#userViewMail").val(con.mail);
        $("#userViewAddress").val(con.address);
        $("#userViewPhone").val(con.phone);

        // 显示
        $("#userViewModal").modal("show");
    }
}
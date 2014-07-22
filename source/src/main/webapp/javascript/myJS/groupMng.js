/**
 * Created by guanzhenxing on 2014-06-21.
 */
$(function(){

    // tips 提示初始化
    //$("#tt").tooltip();
//    $("a[data-placement]").each(function(){
//        $(this).tooltip();
//    });

    // 弹出框初始化
    $(".table tbody tr td a[data-toggle='popover']").each(function(){
        $(this).popover({
            placement : 'left',
            html : true
        });
    });

    // table tr 离开事件
    $(".table tbody tr").mouseleave(function(){
        $(this).find("td a[data-toggle='popover']").each(function(){
            $(this).popover("hide");
        });
    });

    // checkbox event
    $("#chk_all").click(function(){

        var checked = $(this).prop('checked');
        if(checked){
            $(".table tr td input[type='checkbox']").each(function(){
                $(this).prop('checked',checked);
            });
        }else{
            $(".table").find("tr td input[type='checkbox']").each(function(){
                $(this).prop('checked',checked);
            });
        }
    });

    $("a[op-type='modify']").click(function(){
        $("#grpModal").modal("show");
    });

    // 搜索
    $("#grp_search_btn").click(function(){
        var test = $("#search_key").val();

    });


    // 提交请求
//    $("#group_submit_btn").click(function(){
//        var checked = true;
//        // 验证
//        $(".modal-body form[name='group_add_form']").find("[required]").each(function(){
//            if(checkIsNull($(this).html())){
//                $(this).parent().parent().addClass("has-error");
//                checked = false;
//            }else{
//                $(this).parent().parent().removeClass("has-error");
//            }
//        });

        // 通过
//        if(checked){
//            // submit
//
//            // hide modal
//            $("#grpModal").modal("hide");
//        }
//    });
});
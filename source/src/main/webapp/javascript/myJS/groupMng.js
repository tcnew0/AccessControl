/**
 * Created by guanzhenxing on 2014-06-21.
 */
$(function(){
    $("#group_add_view").dialog({
        autoOpen : false,
        height : 400,
        width : 600,
        modal : true,
        buttons :[{
            text : '确认',
            click : function(){
                //
                alert('test');
            }
        },{
            text : '取消',
            click : function(){
                $(this).dialog('close');
            }
        }]
    });

    // button to open dialog
    $("#group_add_btn").click(function () {
        $("#group_add_view").dialog("open");
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
});
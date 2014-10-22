/**
 * Created by guanzhenxing on 2014-06-23.
 */
$(function () {

    // 滚动条回到头部
    $("html body").animate({scrollTop: 0}, 200);

    // checkbox event
    $(".chk_all").click(function () {

        var checked = $(this).prop('checked');
        if (checked) {
            $(".table tr td input[type='checkbox']").each(function () {
                $(this).prop('checked', checked);
            });
        } else {
            $(".table").find("tr td input[type='checkbox']").each(function () {
                $(this).prop('checked', checked);
            });
        }
    });

    // 获取浏览器语言编码
    var lang = $.i18n.browserLang();
    lang = lang.replace('-', '_');// 解决：资源文件命名方式与浏览器上报的语言区域编码不一致

    // 初始化前段国际化资源文件
    $.i18n.properties({
        name: 'jspMessage',
        path: '/plug/i18n/',
        mode: 'map',
        language: lang,
        cache: true,
        encoding: 'UTF-8',
        callback: function () {
        }
    });
});

/**
 * 判断是否为空
 * @param str
 */
function checkIsNull(str) {
    var temp = $.trim(str);
    if (temp == '') {
        return true;
    }

    return false;
}


/**
 * 获取checkbox 数组
 */
function chk_arr() {
    var arr = [];
    $(".table tr td input[type='checkbox']").each(function () {
        var checked = $(this).prop("checked")
        if (checked) {
            arr[arr.length] = $(this).attr("data");
        }
    });

    return arr;
}

/**
 * to index: 暂时未考虑sesseion问题
 */
function toIndex() {
    window.top.location = '/login/login';
}

/**
 * 刷新
 */
function refresh() {
    window.location.reload();
}

/**
 *
 * @param num 从1970 年 1 月 1 日以来的时间秒
 * @returns {string} yyyy-MM-dd
 */
function toLocalDate(num) {
    var d = '';
    if (num != null) {
        var t = new Date();
        t.setTime(num);
        var year = t.getFullYear();
        var month = t.getMonth() + 1;
        var day = t.getDay() + 1;

        d = year + '-' + fillZeroForDateTime(month) + '-' + fillZeroForDateTime(day);
    }

    return d;
}

/**
 *
 * @param num 从1970 年 1 月 1 日以来的时间秒
 * @returns {string} yyyy-MM-dd hh:mm:ss
 */
function toLocalTime(num) {
    var d = '';
    if (num != null) {
        var t = new Date();
        t.setTime(num);
        var year = t.getFullYear();
        var month = t.getMonth() + 1;
        var day = t.getDay() + 1;
        var hour = t.getHours();
        var minute = t.getMinutes();
        var second = t.getSeconds();

        d = year + '-' + fillZeroForDateTime(month) + '-' + fillZeroForDateTime(day)
            + ' ' + fillZeroForDateTime(hour) + ':' + fillZeroForDateTime(minute) + ':' + fillZeroForDateTime(second);
    }

    return d;
}

/**
 * fill Zero For Date Time
 * @param val
 * @returns {string}
 */
function fillZeroForDateTime(val) {

    if (val == null || val == undefined) {
        return '';
    }

    return val < 10 ? '0' + val : val;
}

/**
 * 封装ztree
 * @constructor
 */
function M_Ztree(options) {

    var empty = {};
    var defaults = {
        treeId : '',// need
        inputId : '',// need
        divId : '',// need
        check: {
            enable: true,
            chkboxType: {"Y": "", "N": ""}
        },
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: this.beforeClick,
            onCheck: onCheck
        }
    };

    /* settings */
    this.settings = $.extend(empty, defaults, options);

    /* for ztree at 20140930 begin */
    M_Ztree.prototype.beforeClick = function (treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    M_Ztree.prototype.onCheck = function (e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId),
            nodes = zTree.getCheckedNodes(true),
            v = "";
        for (var i = 0, l = nodes.length; i < l; i++) {
            v += nodes[i].name + ",";
        }
        if (v.length > 0) v = v.substring(0, v.length - 1);
        var cityObj = $("#"+this.settings.inputId);
        cityObj.attr("value", v);
    }

    M_Ztree.prototype.showMenu = function () {
        var cityObj = $("#"+this.settings.inputId);
        var cityOffset = $("#"+this.settings.inputId).offset();
        $("#"+this.settings.divId).css({left: 15 + "px", top: 30 + "px"}).slideDown("fast");

        $("body").bind("mousedown", this.onBodyDown);
    }

    M_Ztree.prototype.hideMenu = function () {
        $("#"+this.settings.divId).fadeOut("fast");
        $("body").unbind("mousedown", this.onBodyDown);
    }

    M_Ztree.prototype.onBodyDown = function (event) {
        if (!( event.target.id == this.settings.inputId || event.target.id == this.settings.divId || $(event.target).parents("#"+this.settings.divId).length > 0)) {
            this.hideMenu();
        }
    }
    /* for ztree at 20140930 end */
}
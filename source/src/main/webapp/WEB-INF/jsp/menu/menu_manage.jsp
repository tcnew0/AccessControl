<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-09-10
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../index/header.jsp" %>
<html>
<head>
    <title>菜单管理</title>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/menu/menuMng.js"></script>
</head>
<body>
<!-- 添加菜单 -->
<div class="modal fade" id="menuAddModal" tabindex="-1" role="dialog" aria-labelledby="menuModalAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="menuModalAddLabel"><strong>新建菜单</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="menu_add_form" action="/menu/add" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="menuAddNum" class="col-sm-2 control-label">菜单编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="menuAddNum" name="menuNum" placeholder="菜单编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="menuAddName" class="col-sm-2 control-label">菜单名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="menuAddName" name="menuName" placeholder="菜单名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addDescription" class="col-sm-2 control-label">菜单描述</label>

                        <div class="col-sm-10">
                            <textarea id="addDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="菜单描述"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 修改菜单 -->
<div class="modal fade" id="menuModifyModal" tabindex="-1" role="dialog" aria-labelledby="menuModalModifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="menuModalModifyLabel"><strong>修改菜单</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="menu_modify_form" action="/menu/modify" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>
                    <input type="hidden" name="_method" value="put" />
                    <input type="hidden" id="menuModifyId" name="id" value=""/>

                    <div class="form-group">
                        <label for="menuModifyNum" class="col-sm-2 control-label">菜单编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="menuModifyNum" name="menuNum" placeholder="菜单编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="menuModifyName" class="col-sm-2 control-label">菜单名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="menuModifyName" name="menuName" placeholder="菜单名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modifyDescription" class="col-sm-2 control-label">菜单描述</label>

                        <div class="col-sm-10">
                            <textarea id="modifyDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="菜单描述"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 查看菜单 -->
<div class="modal fade" id="menuViewModal" tabindex="-1" role="dialog" aria-labelledby="menuModalViewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="menuModalViewLabel"><strong>菜单信息</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="menu_View_form" action="">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="menuViewNum" class="col-sm-2 control-label">菜单编号</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="menuViewNum" name="menuNum" placeholder="菜单编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="menuViewName" class="col-sm-2 control-label">菜单名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="menuViewName" name="menuName" placeholder="菜单名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="viewDescription" class="col-sm-2 control-label">菜单描述</label>

                        <div class="col-sm-10">
                            <textarea id="viewDescription" readonly style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="菜单描述"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div>
    <div class="page-header">
        <h1>菜单管理</h1>
        <%--<small>&nbsp;菜单信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default " id="menu_add_btn"
                    data-toggle="modal" data-target="#menuAddModal">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>

            <button type="button" class="btn btn-default " id="menu_delete_btn"
                    data-container="body" data-toggle="popover">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            菜单信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：菜单管理主要是对菜单信息进行维护，增加、修改、删除等。</p>

            <div class="well well-lg">
                ${message}
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="菜单编号" name="search_num" id="search_num"/>
                <input type="text" class="form-control" placeholder="菜单名称" name="search_name" id="search_name"/>
            </div>
            <button  type="button" class="btn btn-default" id="menu_search_btn" >搜索</button>
        </form>

        <iframe id="menu_frame" name="menu_frame" src="/menu/searchJson" width="100%" height="357px" frameborder="0" scrolling="no"/>
    </div>

</div>

</body>
</html>

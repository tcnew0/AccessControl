<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-06-10
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../index/header.jsp" %>
<html>
<head>
    <title>角色管理</title>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/role/roleMng.js"></script>
</head>
<body>
<!-- 添加角色 -->
<div class="modal fade" id="roleAddModal" tabindex="-1" role="dialog" aria-labelledby="roleModalAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="roleModalAddLabel"><strong>新建角色</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="role_add_form" action="/role/add" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="roleAddNum" class="col-sm-2 control-label">角色编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="roleAddNum" name="roleNum" placeholder="角色编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roleAddName" class="col-sm-2 control-label">角色名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="roleAddName" name="roleName" placeholder="角色名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addDescription" class="col-sm-2 control-label">角色描述</label>

                        <div class="col-sm-10">
                            <textarea id="addDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="角色描述"></textarea>
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

<!-- 修改角色 -->
<div class="modal fade" id="roleModifyModal" tabindex="-1" role="dialog" aria-labelledby="roleModalModifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="roleModalModifyLabel"><strong>修改角色</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="role_modify_form" action="/role/modify" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>
                    <input type="hidden" name="_method" value="put" />
                    <input type="hidden" id="roleModifyId" name="id" value=""/>

                    <div class="form-group">
                        <label for="roleModifyNum" class="col-sm-2 control-label">角色编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="roleModifyNum" name="groupNum" placeholder="角色编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roleModifyName" class="col-sm-2 control-label">角色名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="roleModifyName" name="groupName" placeholder="角色名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modifyDescription" class="col-sm-2 control-label">角色描述</label>

                        <div class="col-sm-10">
                            <textarea id="modifyDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="角色描述"></textarea>
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

<!-- 查看角色 -->
<div class="modal fade" id="roleViewModal" tabindex="-1" role="dialog" aria-labelledby="roleModalViewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="roleModalViewLabel"><strong>角色信息</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="role_View_form" action="">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="roleViewNum" class="col-sm-2 control-label">角色编号</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="roleViewNum" name="roleNum" placeholder="角色编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roleViewName" class="col-sm-2 control-label">角色名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="roleViewName" name="roleName" placeholder="角色名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="viewDescription" class="col-sm-2 control-label">角色描述</label>

                        <div class="col-sm-10">
                            <textarea id="viewDescription" readonly style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="角色描述"></textarea>
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
        <h1>角色管理</h1>
        <%--<small>&nbsp;角色信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default " id="role_add_btn"
                    data-toggle="modal" data-target="#roleAddModal">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>

            <button type="button" class="btn btn-default " id="role_delete_btn"
                    data-container="body" data-toggle="popover">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            角色信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：角色管理主要是对角色信息进行维护，增加、修改、删除等。</p>

            <div class="well well-lg">
                ${message}
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="角色编号" name="search_num" id="search_num"/>
                <input type="text" class="form-control" placeholder="角色名称" name="search_name" id="search_name"/>
            </div>
            <button  type="button" class="btn btn-default" id="role_search_btn" >搜索</button>
        </form>

        <iframe id="role_frame" name="role_frame" src="/role/searchJson" width="100%" height="357px" frameborder="0" scrolling="no"/>
    </div>

</div>

</body>
</html>

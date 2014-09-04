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
    <title>部门管理</title>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/group/groupMng.js"></script>
</head>
<body>
<!-- 添加部门 -->
<div class="modal fade" id="grpAddModal" tabindex="-1" role="dialog" aria-labelledby="grpModalAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="grpModalAddLabel"><strong>新建部门</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="group_add_form" action="/group/add" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="grpAddNum" class="col-sm-2 control-label">部门编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="grpAddNum" name="grpNum" placeholder="部门编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="grpAddName" class="col-sm-2 control-label">部门名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="grpAddName" name="grpName" placeholder="部门名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addDescription" class="col-sm-2 control-label">部门描述</label>

                        <div class="col-sm-10">
                            <textarea id="addDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="部门描述"></textarea>
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

<!-- 修改部门 -->
<div class="modal fade" id="grpModifyModal" tabindex="-1" role="dialog" aria-labelledby="grpModalModifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="grpModalModifyLabel"><strong>修改部门</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="group_modify_form" action="/group/modify" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>
                    <input type="hidden" name="_method" value="put" />
                    <input type="hidden" id="grpModifyId" name="id" value=""/>

                    <div class="form-group">
                        <label for="grpModifyNum" class="col-sm-2 control-label">部门编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="grpModifyNum" name="groupNum" placeholder="部门编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="grpModifyName" class="col-sm-2 control-label">部门名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="grpModifyName" name="groupName" placeholder="部门名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modifyDescription" class="col-sm-2 control-label">部门描述</label>

                        <div class="col-sm-10">
                            <textarea id="modifyDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="部门描述"></textarea>
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

<!-- 查看部门 -->
<div class="modal fade" id="grpViewModal" tabindex="-1" role="dialog" aria-labelledby="grpModalViewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="grpModalViewLabel"><strong>部门信息</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="group_View_form" action="">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="grpViewNum" class="col-sm-2 control-label">部门编号</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="grpViewNum" name="grpNum" placeholder="部门编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="grpViewName" class="col-sm-2 control-label">部门名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="grpViewName" name="grpName" placeholder="部门名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="viewDescription" class="col-sm-2 control-label">部门描述</label>

                        <div class="col-sm-10">
                            <textarea id="viewDescription" readonly style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="部门描述"></textarea>
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
        <h1>部门管理</h1>
        <%--<small>&nbsp;部门信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default " id="group_add_btn"
                    data-toggle="modal" data-target="#grpAddModal">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>
            <%--<button type="button" class="btn btn-default " id="group_delete_btn" onclick="del_group();">--%>
                <%--<span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除--%>
            <%--</button>--%>
            <button type="button" class="btn btn-default " id="group_delete_btn"
                    data-container="body" data-toggle="popover">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            部门信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：部门管理主要是对部门信息进行维护，增加、修改、删除等。</p>

            <div class="well well-lg">
                ${message}
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="部门编号" name="search_num" id="search_num"/>
                <input type="text" class="form-control" placeholder="部门名称" name="search_name" id="search_name"/>
            </div>
            <button  type="button" class="btn btn-default" id="grp_search_btn" >搜索</button>
        </form>

        <iframe id="group_frame" name="group_frame" src="/group/searchJson" width="100%" height="357px" frameborder="0" scrolling="no"/>
    </div>

</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-09-10
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../index/header.jsp" %>
<html>
<head>
    <title>操作管理</title>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/operator/operatorMng.js"></script>
</head>
<body>
<!-- 添加操作 -->
<div class="modal fade" id="opAddModal" tabindex="-1" role="dialog" aria-labelledby="opModalAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="opModalAddLabel"><strong>新建操作</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="op_add_form" action="/op/add" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="opAddNum" class="col-sm-2 control-label">操作编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="opAddNum" name="opNum" placeholder="操作编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="opAddName" class="col-sm-2 control-label">操作名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="opAddName" name="opName" placeholder="操作名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addDescription" class="col-sm-2 control-label">操作描述</label>

                        <div class="col-sm-10">
                            <textarea id="addDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="操作描述"></textarea>
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

<!-- 修改操作 -->
<div class="modal fade" id="opModifyModal" tabindex="-1" role="dialog" aria-labelledby="opModalModifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="opModalModifyLabel"><strong>修改操作</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="op_modify_form" action="/op/modify" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>
                    <input type="hidden" name="_method" value="put" />
                    <input type="hidden" id="opModifyId" name="id" value=""/>

                    <div class="form-group">
                        <label for="opModifyNum" class="col-sm-2 control-label">操作编号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="opModifyNum" name="opNum" placeholder="操作编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="opModifyName" class="col-sm-2 control-label">操作名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="opModifyName" name="opName" placeholder="操作名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modifyDescription" class="col-sm-2 control-label">操作描述</label>

                        <div class="col-sm-10">
                            <textarea id="modifyDescription" style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="操作描述"></textarea>
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

<!-- 查看操作 -->
<div class="modal fade" id="opViewModal" tabindex="-1" role="dialog" aria-labelledby="opModalViewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="opModalViewLabel"><strong>操作信息</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="op_View_form" action="">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="opViewNum" class="col-sm-2 control-label">操作编号</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="opViewNum" name="opNum" placeholder="操作编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="opViewName" class="col-sm-2 control-label">操作名称<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="opViewName" name="opName" placeholder="操作名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="viewDescription" class="col-sm-2 control-label">操作描述</label>

                        <div class="col-sm-10">
                            <textarea id="viewDescription" readonly style="resize: none;" name="description" class="form-control"
                                      rows="3" placeholder="操作描述"></textarea>
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
        <h1>操作管理</h1>
        <%--<small>&nbsp;操作信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default " id="op_add_btn"
                    data-toggle="modal" data-target="#opAddModal">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>

            <button type="button" class="btn btn-default " id="op_delete_btn"
                    data-container="body" data-toggle="popover">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            操作信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：操作管理主要是对操作信息进行维护，增加、修改、删除等。</p>

            <div class="well well-lg">
                ${message}
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="操作编号" name="search_num" id="search_num"/>
                <input type="text" class="form-control" placeholder="操作名称" name="search_name" id="search_name"/>
            </div>
            <button  type="button" class="btn btn-default" id="op_search_btn" >搜索</button>
        </form>

        <iframe id="op_frame" name="op_frame" src="/op/searchJson" width="100%" height="357px" frameborder="0" scrolling="no"/>
    </div>

</div>

</body>
</html>

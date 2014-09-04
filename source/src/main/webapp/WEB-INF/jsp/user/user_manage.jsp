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
    <title>人员管理</title>
    <script src="${contextPath}/javascript/myJS/user/userMng.js"></script>
</head>
<body>
<!-- 添加人员 -->
<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="userModalAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="userModalAddLabel"><strong>新建人员</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="group_add_form" action="/user/add" method="post">
                <div class="modal-body">

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="userAddLoginName" class="col-sm-2 control-label">账号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="userAddLoginName" name="loginName" placeholder="账号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddName" class="col-sm-2 control-label">姓名<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="userAddName" name="name" placeholder="姓名">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddPsw" class="col-sm-2 control-label">密码<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="password" class="form-control" required id="userAddPsw" name="password" placeholder="密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddBirthday" class="col-sm-2 control-label">出生日期<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input size="16" type="date" class="form-control" id="userAddBirthday" required placeholder="出生日期" name="birthday">
                        </div>
                        <%--<div class="col-sm-10 input-group form_datetime date" id="userAddBirthday" style="margin-left:110px;width:463px;">--%>
                            <%--<input size="16" type="date" class="form-control" placeholder="出生日期" name="birthday">--%>
                            <%--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>--%>
                            <%--<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>--%>
                        <%--</div>--%>
                    </div>

                    <div class="form-group">
                        <label for="userAddSex" class="col-sm-2 control-label">性别</label>

                        <div class="col-sm-10">
                            <%--<input type="text" class="form-control" required id="userAddSex" name="sex" placeholder="性别">--%>
                            <select class="form-control" id="userAddSex" name="sex">
                                <option value="o"></option>
                                <option value="m">男</option>
                                <option value="f">女</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddMail" class="col-sm-2 control-label">邮件</label>

                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="userAddMail" name="mail" placeholder="邮件">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddAddress" class="col-sm-2 control-label">地址</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userAddAddress" name="address" placeholder="地址">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userAddPhone" class="col-sm-2 control-label">电话</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userAddPhone" name="phone" placeholder="电话">
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<label for="addDescription" class="col-sm-2 control-label">人员描述</label>--%>

                        <%--<div class="col-sm-10">--%>
                            <%--<textarea id="addDescription" style="resize: none;" name="description" class="form-control"--%>
                                      <%--rows="3" placeholder="人员描述"></textarea>--%>
                        <%--</div>--%>
                    <%--</div>--%>
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

<!-- 修改人员 -->
<div class="modal fade" id="userModifyModal" tabindex="-1" role="dialog" aria-labelledby="userModalModifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="userModalModifyLabel"><strong>修改人员</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="group_modify_form" action="/user/modify" method="post">
                <div class="modal-body">
                    <input type="hidden" name="_method" value="put" />
                    <input type="hidden" id="userModifyId" name="id" value=""/>

                    <p class="validateTips">带*选项必填。</p>

                    <div class="form-group">
                        <label for="userModifyLoginName" class="col-sm-2 control-label">账号<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="" id="userModifyLoginName" name="loginName" placeholder="账号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userModifyName" class="col-sm-2 control-label">姓名<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" required id="userModifyName" name="name" placeholder="姓名">
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<label for="userModifyPsw" class="col-sm-2 control-label">密码<font color="red">*</font></label>--%>

                        <%--<div class="col-sm-10">--%>
                            <%--<input type="password" class="form-control" required id="userModifyPsw" name="password" placeholder="密码">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <div class="form-group">
                        <label for="userModifyBirthday" class="col-sm-2 control-label">出生日期<font color="red">*</font></label>

                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="userModifyBirthday" required placeholder="出生日期" name="birthday">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userModifySex" class="col-sm-2 control-label">性别</label>

                        <div class="col-sm-10">
                            <%--<input type="text" class="form-control" required id="userModifySex" name="sex" placeholder="性别">--%>
                            <select class="form-control" id="userModifySex" name="sex">
                                <option value="o"></option>
                                <option value="m">男</option>
                                <option value="f">女</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userModifyMail" class="col-sm-2 control-label">邮件</label>

                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="userModifyMail" name="mail" placeholder="邮件">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userModifyAddress" class="col-sm-2 control-label">地址</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userModifyAddress" name="address" placeholder="地址">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userModifyPhone" class="col-sm-2 control-label">电话</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userModifyPhone" name="phone" placeholder="电话">
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

<!-- 查看人员 -->
<div class="modal fade" id="userViewModal" tabindex="-1" role="dialog" aria-labelledby="userModalViewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 100px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="userModalViewLabel"><strong>人员信息</strong></h4>
            </div>

            <form class="form-horizontal" role="form" name="user_View_form" action="">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="userViewLoginName" class="col-sm-2 control-label">账号</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userViewLoginName" name="loginName" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewName" class="col-sm-2 control-label">姓名</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="userViewName" name="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewBirthday" class="col-sm-2 control-label">出生日期</label>

                        <div class="col-sm-10">
                            <input size="16" type="text"  id="userViewBirthday" class="form-control" name="birthday" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewSex" class="col-sm-2 control-label">性别</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userViewSex" name="sex" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewMail" class="col-sm-2 control-label">邮件</label>

                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="userViewMail" name="mail" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewAddress" class="col-sm-2 control-label">地址</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userViewAddress" name="address" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userViewPhone" class="col-sm-2 control-label">电话</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userViewPhone" name="phone" readonly>
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
        <h1>人员管理</h1>

        <div class="text-right">
            <button type="button" class="btn btn-default " id="user_add_btn"
                    data-toggle="modal" data-target="#userAddModal">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>

            <button type="button" class="btn btn-default " id="user_delete_btn"
                    data-container="body" data-toggle="popover">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            人员信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：人员管理主要是对人员信息进行维护，增加、修改、删除等。</p>

            <div class="well well-lg">
                ${message}
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="账号" name="search_login" id="search_login"/>
                <input type="text" class="form-control" placeholder="名称" name="search_name" id="search_name"/>
            </div>
            <button  type="button" class="btn btn-default" id="user_search_btn" >搜索</button>

        </form>

        <iframe id="user_frame" name="user_frame" src="/user/searchJson" width="100%" height="357px" frameborder="0" scrolling="no"/>
    </div>

</div>
</body>
</html>
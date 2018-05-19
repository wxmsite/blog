<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <meta HTTP-EQUIV="pragma" CONTENT="no-cache">

    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate">

    <meta HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">

    <meta HTTP-EQUIV="expires" CONTENT="0">


    <title>用户列表</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">返回主页</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/Person/logOut">退出</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>所有用户管理</h1>
        </div>
    </div>

    <!-- 表格  -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>id</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>权限</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${pageInfo.list }" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName }</td>
                        <td>${user.password }</td>
                        <td>${user.userPrivilege.privilege}</td>
                        <!-- <td><a  class="edit">编辑</a> <a
                             class="delete">删除</a></td> -->
                        <td>
                            <a type="button" href="${path}/user/getUser?id=${user.id}" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑</a>
                            <a type="button" href="${path}/user/delUser?id=${user.id}"
                               class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <hr style="height:1px;border:none;border-top:1px solid #ccc;"/>
    <!-- 分页导航栏 -->

    <!-- 分页信息 -->
    <div class="row">
        <!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
        <div class="col-md-5">
            当前第：${pageInfo.pageNum}页，总共：${pageInfo.pages}页，总共：${pageInfo.total}条记录
        </div>

        <!-- 分页条 -->
        <div class="col-md-7">
            <nav aria-label="Page navigation">
                <ul class="pagination" >
                    <li><a href="${path}/user/userInfo?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li >
                            <a style="margin-left: 20px" href="${path}/user/userInfo?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">

                            <li><a style="margin-left: 20px" href="${path}/user/userInfo?pn=${ page_Num}">${ page_Num}</a></li>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li>
                            <a style="margin-left: 20px" href="${path}/user/userInfo?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a style="margin-left: 20px" href="${path}/user/userInfo?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script type="text/javascript">

</script>
<script type="text/javascript" src="${path}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>

</body>
</html>
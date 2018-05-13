<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">

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
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <a class="btn btn-primary" href="${path}/user/toAddUser">新增</a>
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
                <c:forEach items="${pageInfo.list }" var="userInfo">
                    <tr>
                        <td>${userInfo.id}</td>
                        <td>${userInfo.username }</td>
                        <td>${userInfo.password }</td>
                        <td>${userInfo.userPrivilege.privilege}</td>
                        <!-- <td><a  class="edit">编辑</a> <a
                             class="delete">删除</a></td> -->
                        <td>
                            <a type="button" href="${path}/user/getUser?id=${userInfo.id}" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑</a>
                            <a type="button" href="${path}/user/delUser?id=${userInfo.id}"
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
        <div class="col-md-6">
            当前第：${pageInfo.pageNum}页，总共：${pageInfo.pages}页，总共：${pageInfo.total}条记录
        </div>

        <!-- 分页条 -->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${path}/user/userInfo?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li>
                            <a href="${path}/user/userInfo?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="#">${ page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${path}/user/userInfo?pn=${ page_Num}">${ page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li>
                            <a href="${path}/user/userInfo?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${path}/user/userInfo?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();

%>
<!DOCTYPE html>
<head>
    <link href="/css/bootstrap3.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">返回主页</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </div>
</nav>

<h6 style="margin-top: 300px;margin-left: 300px">普通用户不具有访问后台的权限，如果需要查看后台数据，请向管理员申请权限(联系我）</h6>


</body>

</html>

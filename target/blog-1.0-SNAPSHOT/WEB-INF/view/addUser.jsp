<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>
<form action="" name="userForm">
    昵称：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="button" value="添加"
           onclick="addUser()">
</form>

<script type="text/javascript">
    function addUser() {
        var form = document.forms[0];
        form.action = "<%=basePath %>user/addUser";
        form.method = "post";
        form.submit();
    }
</script>
</body>
</html>


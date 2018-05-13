
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑用户</title>

</head>
<body>
<h1>编辑用户</h1>
<form action="" name="userForm">
    <input type="hidden" name="id" value="${user.id }" />昵称：
    <input type="text" name="username" value="${user.username }" /> 密码：
    <input type="text" name="password" value="${user.password }" />
    <input type="hidden"name="userPrivilege.id" value="${user.id}">
    <!--name属性值为userPrivilege对象中的privilege属性-->
    <select name="userPrivilege.privilege">
        <!--value值为privilege值-->
        <option value="请选择用户权限" >请选择用户权限</option>
        <option value="Admin" >Admin</option>
        <option value="commonUser" >commonUser</option>
    </select>
    <input type="button" value="编辑" onclick="updateUser()" />
</form>
</body>
<script type="text/javascript">
    function updateUser() {
        var form = document.forms[0];
        form.action = "<%=basePath %>user/updateUser";
        form.method = "post";
        form.submit();
    }

</script>

</html>

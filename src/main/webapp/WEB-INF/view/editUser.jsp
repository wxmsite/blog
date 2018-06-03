<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<script src="/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<html>
<head>
    <title>编辑用户</title>

</head>
<body>
<h1>编辑用户</h1>
<form action="" name="userForm">
    <input type="hidden" name="id" value="${user.id }"/>昵称：
    <input type="text" name="userName" value="${user.userName }"/> 密码：
    <input type="text" name="password" value="${user.password }"/>
    <input type="hidden" name="userPrivilege.id" value="${user.id}">
    <!--name属性值为userPrivilege对象中的privilege属性-->
    <select name="userPrivilege.privilege" id="selector">
        <!--value值为privilege值-->
        <option value="${user.userPrivilege.privilege}" selected="selected">${user.userPrivilege.privilege}</option>


    </select>
    <input type="button" value="编辑" onclick="updateUser()"/>
</form>
</body>
<script type="text/javascript">
    var option =$("#selector").find("option:selected").text();

    alert(option);
    if (option === "Admin") {
        document.getElementById("selector").add(new Option("CommonUser", "CommonUser"));
    }
    else
        document.getElementById("selector").add(new Option("Admin", "Admin"));

    function updateUser() {
        var form = document.forms[0];
        form.action = "<%=basePath %>user/updateUser";
        form.method = "post";
        form.submit();
    }

</script>

</html>

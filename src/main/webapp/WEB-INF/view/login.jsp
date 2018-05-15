<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";


%>

<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Hello</title>

    <!-- Bootstrap Core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign in</h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="loginform">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="username" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <input type="button" value="Sign in" class="btn btn-lg btn-success btn-block" onclick="login()">
                        </fieldset>

                    </form>
                    <p class="mt-3">
                        New to here?
                        <a  href="/Person/register">Create an account</a>.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function login() {
        $.ajax({
            type: "get",//方法类型
            url: "/Person/login",//请求地址
            dataType: 'json',//数据类型
            data: $("#loginform").serialize(),//请求到接口的对象
            success: callback,//请求成功处理函数
            error: error
        });

//返回函数
        function callback(result) {
            if (result.data == "1")
                window.location.replace("/user/userInfo");
            else if(result.data=="2")
                window.location.replace("/Person/CommonUser");
            else
                alert("密码错误");
        }
        function error(result) {
            alert(result.status+"请求失败");
        }
    }
</script>
</body>
</html>
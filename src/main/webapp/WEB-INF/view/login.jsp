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
    <link href="/css/bootstrap3.min.css" rel="stylesheet">
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>

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
                    <div class="index-header">

                        <h6 class="subtitle">
                            <p hidden id="url">${success}</p>
                            ${msg}

                        </h6>
                    </div>
                    <form role="form" id="loginform" method="post">
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
                            <input type="submit" value="Sign in" class="btn btn-lg btn-success btn-block"
                                   onclick="form=document.getElementById('loginform');form.action='/Person/login/'">
                        </fieldset>

                    </form>
                    <p class="mt-3">
                        New to here?
                        <a href="/Person/registerPage">Create an account</a>.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
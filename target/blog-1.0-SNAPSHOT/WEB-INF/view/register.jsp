<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();


%>
<!DOCTYPE html >

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Hello</title>

    <!-- Bootstrap Core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign up</h3>
                </div>
                <div class="panel-body">
                    <div class="index-header">
                        <h6 class="subtitle">
                            ${msg}
                        </h6>
                    </div>
                    <form role="form" id="signUpForm" method="post" >
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Pick a username" name="username" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Create a password" name="password" type="password" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="can be empty" name="email" type="email" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <input type="submit" value="sign up" class="btn btn-lg btn-success btn-block "
                                   onclick="form=document.getElementById('signUpForm');form.action='/Person/register'">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>
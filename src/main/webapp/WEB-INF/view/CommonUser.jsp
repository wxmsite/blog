<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();

%>
<!DOCTYPE html>
<head>
    <link href="/css/bootstrap4.min.css" rel="stylesheet">
    <link href="/css/blog-home.css" rel="stylesheet">
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

<div class="container">
    <div class="row">
        <div>
            <h2 class="text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="seckill-box"> </span>
            </h2>
        </div>
    </div>
</div>

<script src="/js/seckill.js" type="text/javascript"></script>
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script type="text/javascript">
    //使用EL表达式传入参数
    seckill.detail.init({
        seckillTime:${seckillTime}
    });
</script>
</body>

</html>

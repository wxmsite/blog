<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>blog Home - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/blog-home.css" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/github.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
   <style type="text/css">
       .row-click-able { cursor: pointer; }
   </style>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item" id="sign">
                    <svg height="36" class=" nav-link octicon octicon-mark-github " version="1.1"
                         width="36"
                         viewBox="0 0 16 16"
                         aria-hidden="true"
                         href="javasrcipt:void(0)" onclick="init()" id="signSvg">
                        <path fill-rule="evenodd"
                              d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z"></path>
                    </svg>


                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <!-- blog Entries Column -->
        <div class="col-md-8">


            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tbody>
                        <c:forEach items="${allBlog.list }" var="allBlog">
                            <tr class="row-click-able" data-href="${allBlog.blogUrl}">
                                <td>${allBlog.name}</td>
                                <td>${allBlog.place }</td>
                                <td>${allBlog.work }</td>
                                <td>${allBlog.readNum}</td>
                                <td>${allBlog.articleNum}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <hr style="height:1px;border:none;border-top:1px solid #ccc;"/>
            <!-- 分页导航栏 -->

            <!-- 分页信息 -->
            <div class="row">
                <!-- 分页文字信息，其中分页信息都封装在allBlog中 -->
                <div class="col-md-6">
                    当前第：${allBlog.pageNum}页，总共：${allBlog.pages}页，总共：${allBlog.total}条记录
                </div>

                <!-- 分页条 -->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li style="margin-left: 20px"><a href="${path}/?pn=1">首页</a></li>

                            <c:if test="${allBlog.hasPreviousPage }">
                                <li>
                                    <a style="margin-left: 20px" href="${path}/?pn=${allBlog.pageNum-1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach items="${allBlog.navigatepageNums }" var="page_Num">
                                <c:if test="${page_Num == allBlog.pageNum }">
                                    <li style="margin-left: 20px" class="active"><a
                                            href="${path}/?pn=${ page_Num}">${ page_Num}</a></li>
                                </c:if>
                                <c:if test="${page_Num != allBlog.pageNum }">
                                    <li><a style="margin-left: 20px" href="${path}/?pn=${ page_Num}">${ page_Num}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${allBlog.hasNextPage }">
                                <li>
                                    <a style="margin-left: 20px" href="${path}/?pn=${allBlog.pageNum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <li style="margin-left: 20px"><a href="${path}/?pn=${allBlog.pages}">末页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Search Widget -->
            <div class="card my-4">
                <h5 class="card-header">Search</h5>
                <div class="card-body">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span>
                        <button class="btn btn-secondary" type="button">Go!</button>
                        </span>
                    </div>
                </div>
            </div>

            <!-- Categories Widget -->
            <div class="card my-4">
                <h5 class="card-header">Categories</h5>
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="#">Web Design</a>
                                </li>
                                <li>
                                    <a href="#">HTML</a>
                                </li>
                                <li>
                                    <a href="#">Freebies</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="#">JavaScript</a>
                                </li>
                                <li>
                                    <a href="#">CSS</a>
                                </li>
                                <li>
                                    <a href="#">Tutorials</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Side Widget -->
            <div class="card my-4">
                <h5 class="card-header">Side Widget</h5>
                <div class="card-body">
                    You can put anything you want inside of these side widgets. They are easy to use, and feature the
                    new Bootstrap 4 card containers!
                </div>
            </div>

        </div>

    </div>
    <!-- /.row -->

</div>
<!-- Footer -->
<footer class="py-5 bg-dark">
    <!-- /.container -->
    <div class="container">
        <ul class="list-inline text-center">
            <li>
                <a target="_blank" href="https://www.zhihu.com/people/chong-dou-zhi">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa  fa-stack-1x fa-inverse">知</i>
                            </span>
                </a>
                <a target="_blank" href="http://music.163.com/#/user/home?id=120193134">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-music fa-stack-1x fa-inverse"></i>
                            </span>
                </a>

                <a target="_blank" href="https://github.com/qaz123456789">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                            </span>
                </a>

            </li>
        </ul>
        <p class="m-0 text-center text-white">网站访问量:${count}</p>

    </div>
    <!-- /.container -->
</footer>

<script type="text/javascript">
    $(document).ready(function ($) {
        $(".row-click-able").click(function () {
            window.document.location = $(this).data("href");
        });
    });


    function init() {
        window.location.href = "/Person/user";
    }

    function openBlog(url) {
        alert(true);
        window.open(url);

    }
</script>


</body>

</html>



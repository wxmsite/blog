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
    <link href="${pageContext.request.contextPath}/css/bootstrap4.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/blog-home.css" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <style type="text/css">
        .row-click-able {
            cursor: pointer;
        }
    </style>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">Ming blog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ">
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

                    <svg t="1528124280666" class="icon" viewBox="0 0 1024 1024" version="1.1"
                         xmlns="http://www.w3.org/2000/svg"
                         width="36" height="36"
                         href="javasrcipt:void(0)" onclick="init()" id="signSvg">
                        <path d="M512 832a318.432 318.432 0 0 1-215.648-84.256C351.264 729.984 443.008 704 509.952 704c68.064 0 162.048 26.976 216.608 44.704A318.24 318.24 0 0 1 512 832z m-160-324.672v-91.264A160.224 160.224 0 0 1 512 256c88.224 0 160 71.808 160 160.064v95.104c0 10.24-1.184 20.192-3.008 29.888l-0.928 4.576a159.296 159.296 0 0 1-22.528 53.28l-1.984 2.944a163.2 163.2 0 0 1-41.056 40.96l-2.016 1.376a159.136 159.136 0 0 1-88.48 26.816 159.232 159.232 0 0 1-88.672-26.88l-1.792-1.248a162.144 162.144 0 0 1-41.12-41.024l-2.048-3.04a159.264 159.264 0 0 1-22.432-53.184l-0.928-4.608a160.896 160.896 0 0 1-3.008-29.856v-3.84zM512 128C300.256 128 128 300.256 128 512s172.256 384 384 384 384-172.256 384-384S723.744 128 512 128z"
                        ></path>
                    </svg>
                    <%--<svg version="1.1"
                         width="32" height="32" href="javasrcipt:void(0)" onclick="init()" id="signSvg">
                        <defs>
                            <style type="text/css"></style>
                        </defs>
                        <path d="M896 448h-128a32 32 0 0 0 0 64h128a32 32 0 0 0 0-64M896 320h-128a32 32 0 0 0 0 64h128a32 32 0 0 0 0-64M768 256h128a32 32 0 0 0 0-64h-128a32 32 0 0 0 0 64"
                              p-id="2766"></path>
                        <path d="M781.76 640c-5.12-2.272-97.216-42.56-198.72-62.752 11.808-9.632 22.144-20.928 31.104-33.248a174.88 174.88 0 0 0 33.792-103.2v-104.768A176.32 176.32 0 0 0 576 194.336 174.368 174.368 0 0 0 472.192 160c-96.928 0-175.776 78.976-175.776 176.032v104.768c0 56.544 26.88 106.816 68.384 139.072-96.48 20.832-181.344 57.824-185.536 59.712C150.016 651.328 128 684.192 128 716v131.712l1.728 5.024c9.504 27.904 35.136 46.624 63.776 46.624h572.992c33.28 0 60.832-24.864 64.96-56.96l0.544-126.4c0-15.232-5.184-30.72-13.664-44-9.088-14.272-21.952-26.016-36.576-32"
                              p-id="2767"></path>
                    </svg>--%>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">
    <div class="row">

        <div class="col-md-8">
            <%-- <div class="row">
                 <form action="/" id="original">
                     <label style="margin-top: 15px"> <input type="checkbox" name="value" value="1"
                                                             onchange="document.getElementById('original').submit()">只看个人博客
                     </label>
                 </form>
             </div>
            <hr style="height:1px;border:none;border-top:1px solid #ccc;"/>--%>
            <div class="row">

                <c:forEach items="${allBlog.list}" var="blog">
                    <div style="width: 100%">
                        <div>
                            <h5>
                                <c:if test="${keyword==null}">
                                    <a href="/blog/detail/${blog.blogUrl}" target="_blank">${blog.title}</a>
                                </c:if>
                                <c:if test="${keyword!=null}">
                                    <a href="/blog/detail/${blog.blogUrl}" target="_blank">${blog.title}</a>
                                </c:if>
                            </h5>
                        </div>

                        <div>
                            <p style="float: left ;margin-left:10px">${blog.date}</p>
                            <p style="float: left ;margin-left: 10px"> 阅读量:${blog.readNum}</p>
                            <p style="float: left; margin-left: 10px"> 评论量:${blog.commentNum}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <hr style="height:1px;border:none;border-top:1px solid #d9d9d9;"/>

            <c:if test="${keyword==null}">
                <c:if test="${allBlog.pages>1}">
                    <div class="row">
                        <div class="col-md-3">
                                ${count}条记录，${allBlog.pages}页
                        </div>
                        <div class="col-md-9">
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <c:if test="${allBlog.hasPreviousPage}">
                                        <li style="margin-left: 20px">
                                            <a href="${path}/?pn=${allBlog.currentPage-1}">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:forEach items="${allBlog.navigatepageNums }" var="page_Num">
                                        <c:if test="${page_Num == allBlog.currentPage }">
                                            <li style="margin-left: 20px">
                                                <a href="${path}/?pn=${ page_Num}">${ page_Num}</a>
                                            </li>
                                        </c:if>

                                        <c:if test="${page_Num != allBlog.currentPage }">
                                            <li>
                                                <a style="margin-left: 20px"
                                                   href="${path}/?pn=${ page_Num}">${ page_Num}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${allBlog.hasNextPage}">
                                        <li style="margin-left: 20px;">
                                            <a href="${path}/?pn=${allBlog.currentPage+1}">下一页</a>
                                        </li>
                                    </c:if>

                                </ul>
                            </nav>
                        </div>
                    </div>
                </c:if>
            </c:if>


            <c:if test="${keyword!=null}">
                <c:if test="${allBlog.pages>1}">
                    <div class="row">
                        <div class="col-md-3">
                                ${count}条记录，${allBlog.pages}页
                        </div>
                        <div class="col-md-9">
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <c:if test="${allBlog.hasPreviousPage}">
                                        <li style="margin-left: 20px">
                                            <a href="${path}/search?keyword=${keyword}&pn=${allBlog.currentPage-1}">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:forEach items="${allBlog.navigatepageNums }" var="page_Num">
                                        <c:if test="${page_Num == allBlog.currentPage }">
                                            <li style="margin-left: 20px">
                                                <a href="${path}/search?keyword=${keyword}&pn=${ page_Num}">${ page_Num}</a>
                                            </li>
                                        </c:if>

                                        <c:if test="${page_Num != allBlog.currentPage }">
                                            <li>
                                                <a style="margin-left: 20px"
                                                   href="${path}/search?keyword=${keyword}&pn=${ page_Num}">${ page_Num}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${allBlog.hasNextPage}">
                                        <li style="margin-left: 20px;">
                                            <a href="${path}/search?keyword=${keyword}&pn=${allBlog.currentPage+1}">下一页</a>
                                        </li>
                                    </c:if>

                                </ul>
                            </nav>
                        </div>
                    </div>
                </c:if>
            </c:if>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">
            <!-- Search Widget -->
            <div class="card my-4 ">
                <h5 class="card-header">Search</h5>
                <div class="card-body">
                    <div class="input-group">
                        <form role="form" id="searchForm" style=" " class="">
                            <div class="form-inline">
                                <input type="text" class="form-control" name="keyword" placeholder="Search for...">
                                <input class="btn btn-secondary " type="submit"
                                       onclick="form=document.getElementById('searchForm');form.action='/search'"
                                       value="Search">
                                </input>
                            </div>

                        </form>
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
                                    <a href="#">后端</a>
                                </li>
                                <li>
                                    <a href="#">Python</a>
                                </li>
                                <li>
                                    <a href="#">Android</a>
                                </li>
                                <li>
                                    <a href="#">C++</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="#">算法</a>
                                </li>
                                <li>
                                    <a href="#">数据库</a>
                                </li>
                                <li>
                                    <a href="#">架构</a>
                                </li>
                                <li>
                                    <a href="#">运维</a>
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
                    Welcome to my blog! If you have any questions,please contact me!
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

                <a target="_blank" href="https://github.com/wxmsite">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                            </span>
                </a>
            </li>
        </ul>
        <p class="m-0 text-center text-white">网站访问量:${countPv}</p>

    </div>
    <!-- /.container -->
</footer>
<%--设置可点击跳转--%>
<script type="text/javascript">
    $(document).ready(function ($) {
        $(".row-click-able").click(function () {
            window.document.location = $(this).data("href");
        });
    });

    function init() {
        window.location.href = "/Person/user";
    }
</script>
</body>
</html>



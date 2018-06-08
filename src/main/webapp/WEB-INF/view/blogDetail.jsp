<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2018/6/2
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/comment.css" rel="stylesheet">
    <title>${blog.title}</title></head>
<link href="/css/bootstrap3.min.css" rel="stylesheet">
<link href="/css/docs.min.css" rel="stylesheet">
<body>
<div class="bs-docs-header" id="content" tabindex="-1">
    <div class="container">
        <h1>${blog.title}</h1>

    </div>
</div>

<div class="container bs-docs-container">

    <div class="row">
        <div class="col-md-9" role="main">
            <div class="bs-docs-section">
                <h4>${blog.content}</h4>
            </div>
        </div>
        <div class="col-md-3" role="complementary">
            <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm">
                <ul class="nav bs-docs-sidenav">
                    <li></li>
                    <li></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="row">
        <form role="form" id="commentForm" method="post">
            <div class="form-group">
                <textarea   rows="3" cols="160"></textarea>
            </div>
            <div class="form-group">
                <input   type="submit" value="提交评论"
                       onclick="form=document.getElementById('commentForm');form.action='#'">
            </div>
        </form>

    </div>
</div>

<footer class="bs-docs-footer">
    <div class="container">
        <ul class="bs-docs-footer-links">
            <li><a href="#">更多</a></li>
            <li><a href="#">关于</a></li>
        </ul>
    </div>
</footer>
</body>
</html>

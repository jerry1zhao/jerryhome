<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>${post.title}</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/post.css" rel="stylesheet">
<link href="../css/navbar.css" rel="stylesheet">
</head>
<body>
    <#include "../common/header.ftl">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8 col-md-offset-2">
                        <article class="post">
                            <img src="../${post.postImage}" class="post-head-image">
                            <h1 class="title">${post.title}</h1>
                            <div class="author">
                                <a>${post.createUser.name}</a> <span>${post.createDate}</span>
                            </div>
                            <div class="content">${post.htmlContent}</div>
                        </article>
                        <div class="tags">
                            <#list postTags as tag>
                            <h4>
                                <span class="label label-default"><a href="#">#
                                        ${tag}</a></span>
                            </h4>
                            </#list>
                        </div>
                        <hr>
                        <div class="interact">
                            <a><span class="like-img"></span><span>喜欢</span></a>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.ftl">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../js/index.js"></script>
</body>
</html>

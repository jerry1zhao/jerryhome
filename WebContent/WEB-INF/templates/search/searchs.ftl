<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>搜索结果</title>
<!-- Bootstrap -->
<link href="amazeui/css/amazeui.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">
</head>
<body>
    <#include "../common/header.ftl">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8">
                        <ul id="searchTab" class="nav nav-tabs">
                            <li class="active"><a href="#article" data-toggle="tab">文章</a></li>
                            <li><a id="searchAuthors" href="#author" data-toggle="tab">作者</a></li>
                        </ul>
                        <div id="searchTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="article">
                                <#if searchResultNotEmpty>
                                <div class="posts">
                                    <#list searchResultPosts as post>
                                    <article class="post">
                                        <div class="post-head">
                                            <h3>
                                                <a href="post/${post.id?c}">${post.title}</a>
                                            </h3>
                                        </div>
                                        <div class="post-context">
                                            <h5>${post.description}</h5>
                                        </div>
                                        <footer class="post-footer">
                                            <div class="interacts">
                                                <span> <img src="images/post/like-icon.png"
                                                    alt="like"> <span>5</span>
                                                </span> <span> <img src="images/post/comment-icon.png"
                                                    alt="comment"> <span>20</span>
                                                </span>
                                            </div>
                                            <div class="sign">
                                                <time>${post.createDate?date}</time>
                                                <p class="author">${post.createUser.name}</p>
                                            </div>
                                        </footer>
                                    </article>
                                    </#list>
                                </div>
                                <a id="loadMoerBySearch" href="javascript:;"
                                    class="btn btn-default btn-lg btn-load-Moer col-md-12">加载更多</a>
                                <#else>
                                <h5>噢~没有找到你想要的...</h5>
                                </#if>
                            </div>
                            <div class="tab-pane fade" id="author">
                                <div class="authors">
                                    <ul class="list-group list-authors"></ul>
                                </div>
                                <a id="loadMoerSearchUsers" href="javascript:;"
                                    class="btn btn-default btn-lg btn-load-Moer col-md-12">加载更多</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.ftl">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="amazeui/js/amazeui.min.js"></script>
    <script src="js/search.js"></script>
</body>
</html>

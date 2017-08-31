<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Jerry Home</title>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="amazeui/css/amazeui.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
</head>
<body>
    <#include "common/header.ftl">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8 posts">
                        <div class="post-list">
                            <#list posts as post>
                            <article class="post">
                                <div class="post-media col-md-12">
                                    <a href="post/${post.id?c}"><img class="post-image"
                                        src="${post.postImage}"></a>
                                </div>
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
                                        <span> <img src="images/post/like-icon.png" alt="like">
                                            <span>5</span>
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
                        <button id="loadMoer" type="button" class="btn btn-default btn-lg btn-load-Moer col-md-12">加载更多</button>
                    </div>
                    <aside class="aside col-md-4">
                        <div>
                            <h5>热门文章</h5>
                            <#list hotPosts as hotPost>
                            <div>
                                <p>
                                    <a href="post/${hotPost.postId?c}">${hotPost.postTitle}</a>
                                </p>
                            </div>
                            </#list>
                        </div>
                        <div>
                            <h5>推荐专题</h5>
                            <div class="div-writing">
                                <p>
                                    <a href="post/editor"><img class="img-writing"
                                        src="http://orzrxu448.bkt.clouddn.com/3334f629049e88ce5be21e9b.jpeg"></a>
                                </p>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
        </div>
    </div>
    <#include "common/footer.ftl">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="amazeui/js/amazeui.min.js"></script>
    <script src="js/index.js"></script>
    <script src="js/search.js"></script>
</body>
</html>

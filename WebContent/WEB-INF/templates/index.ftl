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
                               	<div class="post-user-card">
                                     <div class="sign">
                                        <h5>
                                            <a class="username"> <img
                                                src="${post.createUser.photo}"
                                                class="img-circle user-avatar">
                                                ${post.createUser.name}
                                             </a> 发布了文章 -
                                             <time> <#if (post.createDate)?string("yyyy") == .now?string("yyyy")> ${post.createDate?string("MM月dd日")}
                                                    <#else> ${post.createDate?string("yyyy年MM月dd日")} </#if> </time>
                                        </h5>
                                     </div>
                                </div>
                                <div class="post-media col-md-12">
                                    <#if post.postImage??> <a href="post/${post.id?c}"><img
                                        class="post-image" src="${post.postImage}"></a> </#if>
                                </div>
                                <div class="post-head">
                                    <h3>
                                        <a href="post/${post.id?c}">${post.title}</a>
                                    </h3>
                                </div>
                                <div class="post-context">
                                    <#if post.description?length lt 120>
                                    <h5>${post.description}</h5>
                                    <#else>
                                    <h5>${post.description?substring(0,120)}...</h5>
                                    </#if>
                                </div>
                                <footer class="post-footer">
                                    <div class="interacts">
                                        <span> <img src="images/post/like-icon.png" alt="like">
                                            <span>${post.postLikeCount}</span>
                                        </span> <span> <img src="images/post/comment-icon.png"
                                            alt="comment"> <span>0</span>
                                        </span>
                                    </div>
                                </footer>
                            </article>
                            </#list>
                        </div>
                        <a id="loadMoerByIndex" href="javascript:;"
                            class="btn btn-default btn-lg btn-load-Moer col-md-12">加载更多</a>
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
                                    <a id="writingWindow" href="javascript: void(0)"><img
                                        class="img-writing"
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

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>${currentUser.name} - Jerry Home</title>
<!-- Bootstrap -->
<link href="../amazeui/css/amazeui.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/common/global.css" rel="stylesheet">
</head>
<body>
    <#include "../common/header.ftl">
    <div class="main user-homepage">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="page-header">
                        <img src="${currentUser.photo}" alt="头像"
                            class="user-avatar-img img-rounded">
                        <div class="user-info">
                            <h3>${currentUser.name}</h3>
                            <h5>
                                <span>文章 </span><span>喜欢 </span>
                            </h5>
                        </div>
                    </div>
                    <div>
                        <ul id="userHomepageTab" class="nav nav-tabs">
                            <li class="active"><a href="#personalArticles"
                                data-toggle="tab">发布的文章</a></li>
                            <li><a id="" href="#favoriteArticles" data-toggle="tab">喜欢的文章</a></li>
                        </ul>
                    </div>
                    <div id="userHomepageTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="personalArticles">
                            <div class="col-md-9">
                                <#list posts as post>
                                <article class="post">
                                    <div class="post-user-card">
                                        <div class="sign">
                                            <h5>
                                                <a class="username"> <img src="${post.createUser.photo}"
                                                    class="img-circle user-avatar"> ${post.createUser.name}
                                                </a> 发布了文章 -
                                                <time> <#if (post.createDate)?string("yyyy") ==
                                                    .now?string("yyyy")> ${post.createDate?string("MM月dd日")}
                                                    <#else> ${post.createDate?string("yyyy年MM月dd日")} </#if> </time>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="post-head">
                                        <h3>
                                            <a href="../post/${post.id?c}">${post.title}</a>
                                        </h3>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="post-context">
                                            <#if post.description?length lt 110>
                                            <h5>${post.description}</h5>
                                            <#else>
                                            <h5>${post.description?substring(0,110)}...</h5>
                                            </#if>
                                        </div>
                                    </div>
                                    <#if post.postImage??>
                                    <div class="post-media col-md-4">
                                        <a href="../post/${post.id?c}"><img class="post-image"
                                            src="${post.postImage}"></a>
                                    </div>
                                    </#if>
                                    <footer class="post-footer col-md-12">
                                        <div class="interacts">
                                            <span> <img src="../images/post/like-icon.png"
                                                alt="like"> <span>5</span>
                                            </span> <span> <img src="../images/post/comment-icon.png"
                                                alt="comment"> <span>20</span>
                                            </span>
                                        </div>
                                    </footer>
                                </article>
                                </#list>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="favoriteArticles">
                            <div class="col-md-8 col-md-offset-2"></div>
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
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../amazeui/js/amazeui.min.js"></script>
    <script src="../js/search.js"></script>
</body>
</html>

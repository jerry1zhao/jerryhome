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
                        <#list posts as post>
                        <article class="post">
                            <div class="post-media col-md-12">
                                <a href="post/${post.id?c}"><img class="post-image" src="${post.postImage}"></a>
                            </div>
                            <div class="post-head">
                                <h3><a href="post/${post.id?c}">${post.title}</a></h3>
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
                                    <time datetime="2015-11-12">11月12日</time>
                                    <p class="author">${post.createUser.name}</p>
                                </div>

                            </footer>
                        </article>
                        </#list>
                    </div>
                    <aside class="aside col-md-4">
                        <div>
                            <h5>精选</h5>
                            <div>
                                <h5>聚合实用 Workflow 动作的中文分享站：Workflow Gallery by sspai</h5>
                                <p>Jerry</p>
                            </div>
                            <div>
                                <h5>利用金字塔原理写出好文章</h5>
                                <p>Jerry</p>
                            </div>
                            <div>
                                <h5>为了解救各位灵魂画手，Google 推出了这款简单的 Web App</h5>
                                <p>Jerry</p>
                            </div>
                            <div>
                                <h5>PANOLS，更优雅地分享和管理全景照片丨App+1</h5>
                                <p>Jerry</p>
                            </div>
                            <div>
                                <h5>「降低透明度」让旧设备更流畅 | 一日一技</h5>
                                <p>Jerry</p>
                            </div>
                        </div>
                        <div>
                            <h5>推荐专题</h5>
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
</body>
</html>

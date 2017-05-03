<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Quick</title>
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
    <header>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-collapse">
                        <span class="sr-only"></span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                    <a href="https://www.baidu.com" class="logo"></a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right pull-right">
                        <li>
                            <div class="input-group navbar-search">
                                <input type="text" class="form-control navbar-search-text" /> <span
                                    class="input-group-addon navbar-search-img"> <span
                                    class="glyphicon glyphicon-search"></span></span>
                            </div>
                        </li>
                        <li><a href="#">Jerry</a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                            data-toggle="dropdown" role="button" aria-haspopup="true"
                            aria-expanded="false">注册 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-11">
                    <div class="col-md-8 posts">
                        <#list posts as post>
                        <article class="post">
                            <div class="post-media col-md-12">
                                <img class="post-image" src="${post.postHeaderImage}"
                                    alt="spacex">
                            </div>
                            <div class="post-head">
                                <h3>${post.title}</h3>
                            </div>
                            <div class="post-context">
                                <h5>${post.content}</h5>
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
    <footer>
        <div class="container">
            <p>1</p>
            <div class="icp">© Quick Software 2017</div>
        </div>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>

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
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="page-header">
                        <img src="${currentUser.photo}" alt="头像"
                            class="user-avatar-img img-rounded">
                        <div class="user-info">
                            <h3>
                                ${currentUser.name}
                            </h3>
                            <h5><span>文章 </span><span>喜欢 </span></h5>
                        </div>
                    </div>
                    <div>
                        <ul id="userHomepageTab" class="nav nav-tabs">
                            <li class="active"><a href="#personalArticles" data-toggle="tab">发布的文章</a></li>
                            <li><a id="" href="#favoriteArticles"
                                data-toggle="tab">喜欢的文章</a></li>
                        </ul>
                    </div>
                    <div id="userHomepageTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="personalArticles">
                            <div class="col-md-8 col-md-offset-2">

                            </div>
                        </div>
                        <div class="tab-pane fade" id="favoriteArticles">
                            <div class="col-md-8 col-md-offset-2">

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
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../amazeui/js/amazeui.min.js"></script>
    <script src="../js/search.js"></script>
</body>
</html>

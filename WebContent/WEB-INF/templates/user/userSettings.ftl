<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>账号设置</title>
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
                <div class="col-md-12">
                    <div class="col-md-8">
                        <ul id="userSettingTab" class="nav nav-tabs">
                            <li class="basicInfo"><a href="#basicInfo" data-toggle="tab">基本资料</a></li>
                            <li><a id="accountPassword" href="accountPassword" data-toggle="tab">账号与密码</a></li>
                        </ul>
                        <div id="userSettingTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="#basicInfo">

                            </div>
                            <div class="tab-pane fade" id="accountPassword">

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

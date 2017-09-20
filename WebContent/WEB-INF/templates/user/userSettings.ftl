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
                <div class="col-md-10 col-md-offset-1">
                    <ul id="userSettingTab" class="nav nav-tabs">
                        <li class="active"><a href="#basicInfo" data-toggle="tab">基本资料</a></li>
                        <li><a id="setAccountPassword" href="#accountPassword"
                            data-toggle="tab">账号与密码</a></li>
                    </ul>
                    <div id="userSettingTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="basicInfo">
                            <div class="col-md-10 col-md-offset-1">
                                <form class="am-form">
                                    <fieldset>
                                        <div class="am-form-group">
                                            <img
                                                src="${currentUser.photo}"
                                                alt="头像" class="user-avatar-img img-thumbnail">
                                            <div class="am-form-group am-form-file upload-avatar-div">
                                                <button type="button"
                                                    class="am-btn am-btn-secondary am-btn-sm">
                                                    <i class="am-icon-cloud-upload"></i> 修改头像
                                                </button>
                                                <input type="file" id="upload-avatar-input">
                                            </div>
                                        </div>
                                        <div class="am-form-group">
                                            <label for="name">昵称</label> <input type="text" class=""
                                                id="name" value="${currentUser.name}" placeholder="输入新昵称">
                                        </div>
                                        <div class="am-form-group">
                                            <label for="email">邮箱</label> <input type="email" class=""
                                                id="email" value="${currentUser.email}" placeholder="设置新邮箱">
                                        </div>
                                        <div class="am-form-group">
                                            <label for="introduce">个人介绍</label>
                                            <textarea class="" rows="5" id="introduce"></textarea>
                                        </div>
                                        <div class="div-form-commit">
                                            <input type="submit" class="am-btn am-btn-success am-radius"
                                                value="提交">
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="accountPassword">
                            <div class="col-md-8 col-md-offset-2">
                                <form class="am-form">
                                    <fieldset>
                                        <div class="am-form-group">
                                            <label for="oldPassword">输入旧密码</label> <input type="password"
                                                class="" id="oldPassword" placeholder="旧密码">
                                        </div>
                                        <div class="am-form-group">
                                            <label for="newPassword">新密码</label> <input type="password"
                                                class="" id="newPassword" placeholder="新密码"> <input
                                                type="password" class="" id="newPasswordAgain" placeholder="再次输入新密码">
                                        </div>
                                        <div class="div-form-commit">
                                            <input type="submit" class="am-btn am-btn-success am-radius"
                                                value="提交">
                                        </div>
                                    </fieldset>
                                </form>
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

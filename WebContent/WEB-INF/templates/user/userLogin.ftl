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
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="login-main center-block">
                        <div class="title">登录</div>
                        <div class="login-contarner">
                            <form id="new_session" action="/sessions" accept-charset="UTF-8" method="post">

                                <!-- 正常登录登录名输入框 -->
                                <div class="input-prepend restyle js-normal">
                                    <input placeholder="手机号或邮箱" type="text"
                                        name="session[email_or_mobile_number]"
                                        id="session_email_or_mobile_number"> <i
                                        class="iconfont ic-user"></i>
                                </div>

                                <!-- 海外登录登录名输入框 -->

                                <div class="input-prepend">
                                    <input placeholder="密码" type="password"
                                        name="session[password]" id="session_password"> <i
                                        class="iconfont ic-password"></i>
                                </div>
                                <div class="remember-btn">
                                    <input type="checkbox" value="true" checked="checked"
                                        name="session[remember_me]" id="session_remember_me"><span>记住我</span>
                                </div>
                                <div class="forget-btn">
                                    <a class="" data-toggle="dropdown" href="">登录遇到问题?</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/users/password/mobile_reset">用手机号重置密码</a></li>
                                        <li><a href="/users/password/email_reset">用邮箱重置密码</a></li>
                                        <li><a target="_blank" href="/p/9058d0b8711d">无法用海外手机号登录</a></li>
                                        <li><a target="_blank" href="/p/498a9fa7da08">无法用
                                                Google 帐号登录</a></li>
                                    </ul>
                                </div>
                                <input type="submit" name="commit" value="登录"
                                    class="sign-in-button">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--<div id="loginModal" class="modal show">
                     <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="text-center text-primary">登录</h1>
                            </div>
                            <div class="modal-body">
                                <form action="" class="form col-md-12 center-block">
                                    <div class="form-group">
                                        <input type="text" class="form-control input-lg"
                                            placeholder="电子邮件">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control input-lg"
                                            placeholder="登录密码">
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-success btn-lg btn-block">立刻登录</button>
                                        <span><a href="#">找回密码</a></span> <span><a href="#"
                                            class="pull-right">注册</a></span>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer"></div>
                        </div>
                    </div>
                </div>-->
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

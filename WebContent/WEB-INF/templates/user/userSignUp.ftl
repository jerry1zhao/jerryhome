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
<link href="css/login.css" rel="stylesheet">
</head>
<body>
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <div class="login-window center-block col-md-4">
                        <div class="col-md-12 login-window-container">
                            <div class="head-logo">
                                <div class="logo center-block" aria-label="Jerry Home"></div>
                            </div>
                            <div class="title">
                                <h4>Jerry Home</h4>
                            </div>
                            <div class="login-contarner signup-contarner">
                                <form id="signupFrom" accept-charset="UTF-8">
                                    <div class="input-groups">
                                        <div class="input-group input-group-name">
                                            <span class="glyphicon glyphicon-user input-group-addon"></span>
                                            <input placeholder="昵称" type="text" id="username"
                                               name="name" class="form-control">
                                        </div>
                                        <div id="nameAlert" class="alert-box">
                                            <div class="alert-message">用户名为4-12位，可为中文、字母、数字、下划线。</div>
                                        </div>

                                        <div class="input-group input-group-password">
                                            <span class="glyphicon glyphicon-lock input-group-addon"></span>
                                            <input placeholder="密码" type="password" id="password"
                                               name="password"  class="form-control">
                                        </div>
                                        <div id="passwordAlert" class="alert-box">
                                            <div class="alert-message">密码为6-18位，可为字母、数字、~、!、@、#、$、%、*、=、+、-。</div>
                                        </div>

                                        <div class="input-group input-group-email">
                                            <span class="glyphicon glyphicon-envelope input-group-addon"></span>
                                            <input placeholder="你的邮箱" type="text"
                                               name="email" id="email"  class="form-control">
                                            <span class="input-group-btn">
                                                <input type="button" class="btn btn-default" id="sendCaptcha" value="Send" type="button"/>
                                            </span>
                                        </div>
                                        <div id="emaildAlert" class="alert-box">
                                            <div class="alert-message">邮箱格式不正确</div>
                                        </div>

                                        <div class="input-group input-group-authcode">
                                            <span class="glyphicon glyphicon-send input-group-addon"></span>
                                            <input placeholder="邮箱验证码" type="text"
                                               name="captcha" id="captcha" class="form-control">
                                        </div>
                                        <div id="captchaAlert" class="alert-box">
                                            <div class="alert-message">验证码为6位，字母与数字混合组成</div>
                                        </div>
                                    </div>
                                    <input type="button" id="register" name="commit" value="注册"
                                        class="btn btn-primary center-block btn-login-commit"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script src="js/login.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

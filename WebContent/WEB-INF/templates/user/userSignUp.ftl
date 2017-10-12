<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>注册Jerry Home</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="remodal/css/remodal.css">
<link rel="stylesheet" href="remodal/css/remodal-default-theme.css">
<link rel="stylesheet" href="css/login.css">
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
                                <form id="signupForm" accept-charset="UTF-8">
                                    <div class="input-groups">
                                        <div class="input-group input-group-name">
                                            <span class="glyphicon glyphicon-user input-group-addon"></span>
                                            <input placeholder="昵称" type="text" id="username" name="name"
                                                class="form-control">
                                        </div>
                                        <div id="nameAlert" class="alert-box">
                                            <div class="alert-message">用户名为4-12位，可为中文、字母、数字、下划线</div>
                                        </div>
                                        <div id="nameExistedAlert" class="alert-box">
                                            <div class="alert-message">昵称已被注册</div>
                                        </div>

                                        <div class="input-group input-group-password">
                                            <span class="glyphicon glyphicon-lock input-group-addon"></span>
                                            <input placeholder="密码" type="password" id="password"
                                                name="password" class="form-control">
                                        </div>
                                        <div id="passwordAlert" class="alert-box">
                                            <div class="alert-message">密码6-18位，可为字母、数字、~、!、@、#、$、%、*、=、+、-</div>
                                        </div>

                                        <div class="input-group input-group-email">
                                            <span class="glyphicon glyphicon-envelope input-group-addon"></span>
                                            <input placeholder="你的邮箱" type="text" name="email" id="email"
                                                class="form-control"> <span class="input-group-btn">
                                                <input type="button" class="btn btn-default"
                                                id="sendCaptcha" value="发送" type="button" />
                                            </span>
                                        </div>
                                        <div id="emaildAlert" class="alert-box">
                                            <div class="alert-message">邮箱格式不正确</div>
                                        </div>
                                        <div id="emailExistedAlert" class="alert-box">
                                            <div class="alert-message">
                                                                                                邮箱已经注册，点<a href="login">这里</a>登录
                                            </div>
                                        </div>
                                        <div id="wait1minAlert" class="alert-box">
                                            <div class="alert-message">你刷新了页面或进行了其他奇怪的操作，请等待1分钟再试</div>
                                        </div>
                                        <div id="emailExceptionAlert" class="alert-box">
                                            <div class="alert-message">请检查你的邮箱地址是否正确</div>
                                        </div>

                                        <div class="input-group input-group-authcode">
                                            <span class="glyphicon glyphicon-send input-group-addon"></span>
                                            <input placeholder="邮箱验证码" type="text" name="captcha"
                                                id="captcha" class="form-control">
                                        </div>
                                        <div id="captchaAlert" class="alert-box">
                                            <div class="alert-message">验证码为6位，字母与数字混合组成</div>
                                        </div>
                                        <div id="captchaValidityAlert" class="alert-box">
                                            <div class="alert-message">验证码或者邮箱填写错误，请查看邮箱重新输入</div>
                                        </div>
                                    </div>
                                    <input type="button" id="register" name="commit" value="注册"
                                        class="btn btn-primary center-block btn-login-commit" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="remodal" data-remodal-id="modal">
        <h1>Welcome you!</h1>
        <p>正在进入...</p>
        <br>
        <button data-remodal-action="confirm" class="remodal-confirm">GO
            NOW</button>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/login.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="remodal/js/remodal.min.js"></script>
</body>
</html>

<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录到Jerry Home</title>
<!-- Bootstrap -->
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
                                <h4>登录到 Jerry Home</h4>
                            </div>
                            <div class="login-contarner">
                                <form id="loginForm" accept-charset="UTF-8">

                                    <div id="accountErrorAlert" class="alert-box">
                                        <div class="alert-message">邮箱或密码不正确</div>
                                    </div>
                                    <div class="input-group">
                                        <span class="glyphicon glyphicon-user input-group-addon"></span>
                                        <input placeholder="你的邮箱" type="text" id="email" name="email"
                                            onblur="checkEmail()" class="form-control">
                                    </div>
                                    <div id="emaildAlert" class="alert-box">
                                        <div class="alert-message">邮箱格式不正确</div>
                                    </div>
                                    <div class="input-group">
                                        <span class="glyphicon glyphicon-lock input-group-addon"></span>
                                        <input placeholder="密码" type="password" id="password"
                                            name="password" onblur="checkPassword()" class="form-control">
                                    </div>
                                    <div id="passwordAlert" class="alert-box">
                                        <div class="alert-message">密码为6-18位，由字母、数字、~、!、@、#、$、%、*、=、+、-组成。</div>
                                    </div>
                                    <div class="aux-fun">
                                        <div class="other-btn">
                                            <a class="pull-left" href="signin">没有账号？注册</a>
                                        </div>
                                        <div class="forget-btn">
                                            <a class="pull-right" href="">忘记密码?</a>
                                        </div>
                                    </div>
                                    <input type="button" id="login" name="commit" value="登录"
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
        <h1>正在进入...</h1>
        <p>JUST DO IT.</p>
        <br>
        <button data-remodal-action="confirm" class="remodal-confirm">GO NOW</button>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script src="js/login.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="remodal/js/remodal.min.js"></script>
</body>
</html>

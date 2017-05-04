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
                            <div class="login-contarner signin-contarner">
                                <form id="" action="/signin" accept-charset="UTF-8" method="post">
                                    <div class="input-groups">
                                    <div class="input-group input-group-name">
                                        <span class="glyphicon glyphicon-user input-group-addon"></span>
                                        <input placeholder="昵称" type="text"
                                            name="session[email_or_mobile_number]"
                                            id="session_email_or_mobile_number" class="form-control">
                                    </div>

                                    <div class="input-group input-group-password">
                                        <span class="glyphicon glyphicon-lock input-group-addon"></span>
                                        <input placeholder="密码" type="password"
                                            name="session[password]" id="session_password" class="form-control">
                                    </div>
                                    <div class="input-group input-group-email">
                                        <span class="glyphicon glyphicon-envelope input-group-addon"></span>
                                        <input placeholder="手机号或邮箱" type="text"
                                            name="session[email_or_mobile_number]"
                                            id="session_email_or_mobile_number" class="form-control">
                                         <span class="input-group-btn">
                                           <button class="btn btn-default" type="button">Send</button>
                                         </span>
                                    </div>

                                    <div class="input-group input-group-authcode">
                                        <span class="glyphicon glyphicon-send input-group-addon"></span>
                                        <input placeholder="邮箱验证码" type="text"
                                            name="session[email_or_mobile_number]"
                                            id="session_email_or_mobile_number" class="form-control">
                                    </div>
                                    </div>
                                    <input type="submit" name="commit" value="注册"
                                        class="btn btn-primary center-block btn-login-commit" />
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
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

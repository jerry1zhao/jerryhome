$(function() {
    $("#username").blur(function() {
        checkUser();
    });
    $("#password").blur(function() {
        checkPassword();
    });
    $("#email").blur(function() {
        checkEmail();
    });
    $("#email").click(function() {
        $('#emaildAlert').hide();
        $('#emailExistedAlert').hide();
        $('#emailExceptionAlert').hide();
    });
    $("#captcha").blur(function() {
        checkCpatcha();
    });
    $("#register").click(function() {
        register();
    });
    $("#login").click(function(){
        login();
    });
    $("#sendCaptcha").click(function() {
        waitSend();
    });
    $("body").keydown(function(){
        if(document.location.pathname == '/jerryhome/logon')
            if(event.keyCode == '13'){
                login();
            }
    });

    $(document).on('opened', '.remodal', function () {
        console.log('Modal is opened');
        setTimeout(function(){gotoIndex()}, 1000);
    });

    $(document).on('closed', '.remodal', function (e) {
        console.log('Modal is closed');
        gotoIndex();
    });

    $(document).on('confirmation', '.remodal', function () {
        console.log('Confirmation button is clicked');
        gotoIndex();
    });
});

function gotoIndex(){
    window.location.href = "posts";
}

function login(){
    if(checkLoginForm()){
        $.post("handleUserLogin", $("#loginForm").serialize(), function(result){
            if(result == "success"){
                var inst = $('[data-remodal-id=modal]').remodal();
                inst.open();
            } else {
                checkAccount();
            }
        })
    }
}


function register() {
    if(checkSignUpForm()){
        var captcha = document.getElementById('captcha').value;
        $.post("handleUserSignin", { captcha : captcha } + '&' + $("#signupForm").serialize(), function(result) {
            if (result == "success") {
                var inst = $('[data-remodal-id=modal]').remodal();
                inst.open();
            } else if (result == "captchaError") {
                checkcaptchaValidity();
            } else if (result == "userExisted") {
                document.getElementById('nameExistedAlert').style.display = "inline";
            } else if (result == "emailExisted") {
                document.getElementById('emailExistedAlert').style.display = "inline";
            } else if (result == "fail") {
                checkSignUpForm();
            }
        })
    }
}

function checkAccount() {
    document.getElementById('accountErrorAlert').style.display = "inline";
    return false;
}

function checkcaptchaValidity() {
    document.getElementById('captchaValidityAlert').style.display = "inline";
    return false;
}

function checkUser() {
    var reg = /^[\u0391-\uFFE5_0-9a-zA-z]{4,12}$/;
    var username = document.getElementById('username').value;
    if (reg.test(username)) {
        document.getElementById('nameAlert').style.display = "none";
        $.get("userNameCheck",{name : username},function(result){
            if(result == "existed"){
                document.getElementById('nameExistedAlert').style.display = "inline";
                return false;
            } else {
                document.getElementById('nameExistedAlert').style.display = "none";
                return true;
            }
        })
    } else {
        document.getElementById('nameAlert').style.display = "inline";
        document.getElementById('nameExistedAlert').style.display = "none";
        return false;
    }
}

function checkUserIsNull() {
    var reg = /^[\u0391-\uFFE5_0-9a-zA-z]{4,12}$/;
    var username = document.getElementById('username').value;
    if (reg.test(username)) {
        document.getElementById('nameAlert').style.display = "none";
        return true;
    } else {
        document.getElementById('nameAlert').style.display = "inline";
        return false;
    }
}

function checkPassword() {
    var reg = /^([A-Z]|[a-z]|[0-9]|[~!@#$%*=+-]){6,18}$/;
    var password = document.getElementById('password').value;
    if (reg.test(password)) {
        document.getElementById('passwordAlert').style.display = "none";
        return true;
    } else {
        document.getElementById('passwordAlert').style.display = "inline";
        return false;
    }
}

function checkEmail() {
    var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
    var email = document.getElementById('email').value;
    if (reg.test(email)) {
        document.getElementById('emaildAlert').style.display = "none";
        return true;
    } else {
        document.getElementById('emaildAlert').style.display = "inline";
        return false;
    }
}

function checkEmailIsExisted() {
    var email = document.getElementById('email').value;
    $.get("emailCheck",{email : email},function(result){
        if (result == "existed") {
            document.getElementById('emailExistedAlert').style.display = "inline";
            return false;
        } else {
            document.getElementById('emailExistedAlert').style.display = "none";
            return true;
        }
    });
}

function checkCpatcha() {
    var reg = /^([A-Z]|[a-z]|[0-9]){6}$/;
    var captcha = document.getElementById('captcha').value;
    if (reg.test(captcha)) {
        document.getElementById('captchaAlert').style.display = "none";
        return true;
    } else {
        document.getElementById('captchaAlert').style.display = "inline";
        return false;
    }
}

function checkSignUpForm() {
    if (checkUserIsNull() == true && checkPassword() == true && checkEmail() == true
            && checkCpatcha() == true) {
        return true;
    } else {
        return false;
    }
}
function checkLoginForm() {
    if (checkEmail() == true && checkPassword() == true) {
        return true;
    } else {
        return false;
    }
}

function waitSend() {
    if (checkEmail() == false) {
        return;
    } else {
        sendCaptcha();
    }
}

var validCode=true;
function disabled() {
    var time=60;
    var sendBtn=$('#sendCaptcha');
    if (validCode) {
        validCode=false;
        sendBtn.attr("disabled",true);
        var t=setInterval(function  () {
            time--;
            sendBtn.val(time + "秒");
            if (time==0) {
                sendBtn.attr("disabled",false);
                clearInterval(t);
                sendBtn.val("重新获取");
                validCode=true;
            }
        },1000)
    }
}

function sendCaptcha() {
    var userName = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    $.get("sendCaptcha", { email : email, userName : userName}, function(result){
        if(result == "wait"){
            document.getElementById('wait1minAlert').style.display = "inline";
        } else if (result == "emailExisted") {
            document.getElementById('emailExistedAlert').style.display = "inline";
        } else if (result == "emailException") {
            document.getElementById('emailExceptionAlert').style.display = "inline";
        } else if(result == "success"){
            document.getElementById('wait1minAlert').style.display = "none";
            document.getElementById('emailExistedAlert').style.display = "none";
            disabled();
        }
    });
}

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
    })
});

function login(){
    if(checkLoginForm()){
        $.post("handleUserLogin", $("#loginFrom").serialize(), function(result){
            if(result == "success"){
                window.location.href = "index";
            } else {
                checkAccount();
            }
        })
    }
}


function register() {
    if (checkSignUpForm()) {
        var captcha = document.getElementById('captcha').value;
        $.post("handleUserSignin", {captcha:captcha}+'&'+$("#signupFrom").serialize(), function(
                result) {
            if (result == "success") {
                window.location.href = "index";
            } else if (result == "captchaError") {
                checkcaptchaValidity();
            } else if (result == "fail"){
                 checkSignUpForm();
            }
        })
    } else {
        checkSignUpForm();
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

        return true;
    } else {
        document.getElementById('nameAlert').style.display = "inline";
        return false;
    }
}

function checkPassword() {
    var reg = /^([A-Z]|[a-z]|[0-9]|[~!@#getElement%*=+-]){6,18}$/;
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
    if (checkUser() == true && checkPassword() == true && checkEmail() == true
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
    if (!checkEmail() == true) {
        return;
    }
    sendCaptcha();
    disabled();
}

var waitTime = 60;
function disabled() {
    var sendBtn = document.getElementById('sendCaptcha');
    if (waitTime == 0) {
        sendBtn.removeAttribute("disabled");
        sendBtn.value = "Send";
        waitTime = 60;
        return;
    } else {
        sendBtn.setAttribute("disabled", true);
        sendBtn.value = "Send(" + waitTime + ")";
        waitTime--;
    }
    setTimeout(function() {
        disabled()
    }, 1000)
}

function sendCaptcha() {
    var email = document.getElementById('email').value;
    $.get("sendCaptcha", {
        email : email
    });
}

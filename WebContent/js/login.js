function $(elementId){
    return document.getElementById(elementId);
}

function checkUser() {
    var reg = /^[\u0391-\uFFE5_0-9a-zA-z]{4,12}$/;
    var username = $('username').value;
    if (reg.test(username)) {
        $('nameAlert').style.display="none";

        return true;
    } else {
        $('nameAlert').style.display="inline";
        return false;
    }
}

function checkPassword() {
    var reg = /^([A-Z]|[a-z]|[0-9]|[~!@#$%*=+-]){6,18}$/;
    var password = $('password').value;
    if (reg.test(password)) {
        $('passwordAlert').style.display="none";
        return true;
    } else {
        $('passwordAlert').style.display="inline";
        return false;
    }
}

function checkEmail() {
    var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
    var email = $('email').value;
    if (reg.test(email)) {
        $('emaildAlert').style.display="none";
        return true;
    } else {
        $('emaildAlert').style.display="inline";
        return false;
    }
}

function checkCpatcha() {
    var reg = /^([A-Z]|[a-z]|[0-9]){6}$/;
    var captcha = $('captcha').value;
    if (reg.test(captcha)) {
        $('captchaAlert').style.display="none";
        return true;
    } else {
        $('captchaAlert').style.display="inline";
        return false;
    }
}

function checkForm() {
    if (checkUser() == true && checkPassword() == true && checkEmail() == true
            && checkCpatcha() == true) {
        return true;
    } else {
        return false;
    }
}

var waitTime=60;
function waitSend(obj){
    if(!checkEmail() == true){
        return;
    }
    if(waitTime == 0){
        obj.removeAttribute("disabled");
        obj.value="Send";
        waitTime = 60;
        return;
    } else {
        obj.setAttribute("disabled", true);
        obj.value="Send(" + waitTime + ")";
        waitTime--;
    }
    setTimeout(function() {
        waitSend(obj) }
        ,1000)
}

